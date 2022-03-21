package utils;
import cn.tedu.subMarine.*;
import Missle.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import javax.swing.*;



public class GameWin extends JFrame {
    /**
     * 游戏状态 0 未开始，1进行中中，2游戏暂停，3游戏结束
     * 双缓存
     * 游戏重绘次数
     * 敌人数量
     * 游戏的分
     * 生命值
     * */

    Image offScreenImage = null;
    public static int state = 0;
    public static int score = 0 ;
    public static int life = 2;
    int width = 600;
    int height = 470;
    int count = 1;
    int enemyCount = 0;


    public Sea sea = new Sea(GameUtils.seaImg,0,0);
    public Battleship battleship = new Battleship(GameUtils.battleshipImg,330,127,60,20,12,this);
    public void launch(){
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setTitle("深海杀手");
        this.setVisible(true);
        this.setIconImage(GameUtils.seaImg);
        GameUtils.gameObjectList.add(sea);
        GameUtils.gameObjectList.add(battleship);
        /**
         * 鼠标键盘事件
         * */

        this.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked (MouseEvent e){
                if(e.getButton() == 1 && state == 0){
                    state = 1;
                    repaint();
                }

            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            //空格暂停
              if(e.getKeyChar() == KeyEvent.VK_SPACE){
                  switch (state){
                      case 1 :
                          state = 2;
                          break;
                      case 2 :
                          state = 1;
                          break;
                      case 3 :
                          life = 2;
                          state = 1;
                          offScreenImage = null;
                          break;
                  }
              }

            }
        });

        while(true){
            if(state == 1){
                createObject();
                repaint();
            }
            try{
                Thread.sleep(25);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        if(offScreenImage == null){}
        offScreenImage = createImage(width,height);
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);
        if(state == 0){
            gImage.drawImage(GameUtils.startImg,0,0,null);
            gImage.drawImage(GameUtils.explodeImg,220,350,null);
            GameUtils.drawWord(gImage,"点击开始游戏",Color.yellow,40,280,400);
        }
        if(state == 1){
            GameUtils.gameObjectList.addAll(GameUtils.explodeList);

            for(int i = 0;i < GameUtils.gameObjectList.size();i++){

                GameUtils.gameObjectList.get(i).paintSelf(gImage);

            }
            GameUtils.drawWord(gImage,score+" 分",Color.ORANGE,20,30,80);
            GameUtils.drawWord(gImage,"生命："+life,Color.red,20,500,80);
            GameUtils.gameObjectList.removeAll(GameUtils.removeList);

        }
        if(state == 3){
            gImage.drawImage(GameUtils.explodeImg,battleship.getX()+30,battleship.getY(),null);
            gImage.drawImage(GameUtils.gameoverImg,0,0,null);
        }

        g.drawImage(offScreenImage,0,0,null);
        count++;
        System.out.println(GameUtils.gameObjectList.size());

    }
    void createObject(){
        /**
         * 生成敌方单位
         * */
        if(count % 40 == 0){
            GameUtils.mineSubmarineList.add(new MineSubmarine(GameUtils.minesubmImg,-80,(int)(Math.random()*13*20)+155,
                    63,19,(int)(Math.random()*5+2),this));
            GameUtils.gameObjectList.add(GameUtils.mineSubmarineList.get(GameUtils.mineSubmarineList.size()-1));
            /**
             * 敌方子弹
             * */
            GameUtils.mineList.add(new Mine(GameUtils.mineImg,
                    GameUtils.mineSubmarineList.get((int)(GameUtils.mineSubmarineList.size()*(1-0.2*Math.random()))).getX()+30,
                    GameUtils.mineSubmarineList.get((int)(GameUtils.mineSubmarineList.size()*(1-0.2*Math.random()))).getY()-16,
                    5,18,5,this));
            GameUtils.gameObjectList.add(GameUtils.mineList.get(GameUtils.mineList.size()-1));

            enemyCount++;
        }
        if(count % 60 == 0){
            GameUtils.observerSubmarineList.add(new ObserverSubmarine(GameUtils.obsersubmImg,-80,(int)(Math.random()*13*20)+155,
                    63,19,(int)(Math.random()*5+2),this));
            GameUtils.gameObjectList.add(GameUtils.observerSubmarineList.get(GameUtils.observerSubmarineList.size()-1));

            enemyCount++;
        }

        if(count % 35 == 0){

            GameUtils.torpedoSubmarineList.add(new TorpedoSubmarine(GameUtils.torpesubmImg,-80,(int)(Math.random()*13*20)+155,
                    63,19,(int)(Math.random()*5+2),this));
            GameUtils.gameObjectList.add(GameUtils.torpedoSubmarineList.get(GameUtils.torpedoSubmarineList.size()-1));

            GameUtils.torpedoList.add(new Torpedo(GameUtils.torpedoImg,
                    GameUtils.torpedoSubmarineList.get((int)(GameUtils.torpedoSubmarineList.size()*(1-0.2*Math.random()))).getX()+30,
                    GameUtils.torpedoSubmarineList.get((int)(GameUtils.torpedoSubmarineList.size()*(1-0.2*Math.random()))).getY()-16,
                    5,18,5,this));
            GameUtils.gameObjectList.add(GameUtils.torpedoList.get(GameUtils.torpedoList.size()-1));
            enemyCount++;
        }


        if(count % 15 == 0){
            GameUtils.bombList.add(new Bomb(GameUtils.bombImg,
                    battleship.getX() + 30,
                    battleship.getY() + 16,
                    9, 12, 5,
                    null));
            GameUtils.gameObjectList.add(GameUtils.bombList.get(GameUtils.bombList.size()-1));

        }

    }

    public static void main(String[] args) {
//        Timer timer = new Timer();
//        ShootMine shootMine = new ShootMine();
//        timer.schedule(shootMine,5000,800);
//        ShootTorpedo shootTorpedo = new ShootTorpedo();
//        timer.schedule(shootTorpedo,5000,500);
        GameWin gameWin = new GameWin();
        gameWin.launch();

    }
}
