package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //游戏状态 0未开始，1游戏中 2暂停 3 通关失败 4 通关成功

    public static int state = 0;
    /**
     * 双缓存
     * 使用缓存来解决闪动
     * 1.重新创建一个空的图片，把所有组件都先绘制在空的图片上面
     * 2.把绘制好的图片一次性绘制的主窗口中
     * */
    Image offScreenImage = null;
    int width = 600;
    int height = 600;
    //游戏的重绘次数
    int count = 1;
    // 统计敌机数量到100时才出现boss
    int enemyCount = 0;
    //游戏得分
    public static int score =0;

    //获取背景类的对象
    BgObj bgObj = new BgObj(GameUtils.bgImg,0,-2000,2);
    //创建我方飞机对象
    public PlaneObj planeObj = new PlaneObj(GameUtils.planeImg,290,550,20,30,0,this);
    //创建敌方boss对象,开始等于null，100之后再出现
    public BossObj bossObj = null;
    //创建启动方法
    public void launch(){
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(width,height);
        //设置窗口位置
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("飞机大战");
        /**
         * 将所有要绘制的游戏物体添加到gameObjLsit中
         * */

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);

        //鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 鼠标点击左键且游戏未开始
                if(e.getButton() == 1 && state == 0){
                    //更改游戏状态
                    state = 1;
                    //调用repaint方法
                    repaint();
                }
            }
        });
        // 添加键盘监听事件，空格暂停
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //空格键代号为32
                if(e.getKeyCode() == 32){
                    switch(state){
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                    }
                }
            }
        });

        //背景移动需要不断调用paint方法
        while(true){
            if(state ==1){
                createObj();
                repaint();
            }

            //间隔25ms repaint一次， 1s 40次
            try{
                Thread.sleep(25);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint(Graphics g){
        if(offScreenImage == null){
            offScreenImage = createImage(width,height);
        }
        //获取offScreenImage的画笔对象
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);
        /* 用画笔g绘制背景图片 */
        if(state == 0){
            gImage.drawImage(GameUtils.bgImg,0,0,null);
            gImage.drawImage(GameUtils.bossImg,220,120,null);
            gImage.drawImage(GameUtils.explodeImg,270,350,null);
            GameUtils.drawWord(gImage,"点击游戏开始",Color.yellow,40,180,300);
        }
        if(state == 1){
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
            //遍历gameObjList
            for (int i = 0; i < GameUtils.gameObjList.size() ; i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            //在下一次绘制之前，已消耗的元素从gameObjList中删除
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if(state == 3){
            //游戏失败
            gImage.drawImage(GameUtils.explodeImg,planeObj.getX()-35,planeObj.getY()-50,null);
//            gImage.drawImage(GameUtils.bossImg,220,120,null);
//            gImage.drawImage(GameUtils.explodeImg,270,350,null);
            GameUtils.drawWord(gImage,"Game Over",Color.red,50,180,300);
        }
        if(state == 4){
            gImage.drawImage(GameUtils.explodeImg,bossObj.getX()-77,bossObj.getY()-50,null);
            GameUtils.drawWord(gImage,"游戏通关",Color.ORANGE,50,180,300);
        }
        //计分面板
        GameUtils.drawWord(gImage,score+" 分",Color.green,40,30,100);

        //把新图片一次性绘制到主窗口中
        g.drawImage(offScreenImage,0,0,null);
        count ++;
        System.out.println(GameUtils.gameObjList.size());
    }
    //批量创建子弹和敌机的方法
    void createObj(){
        /**
         * 0.没repaint 15次后绘制一颗子弹，添加条件
         * 1.创建我方子弹对象,子弹的坐标和飞机的坐标相关联，但稍有偏移
         * 2.通过匿名类的方式创建子弹对象，并添加到shellList中
         * 3.通过索引获取shellObjList的最后一个元素，将其添加到gameObjList中
         */
        if(count % 10 ==0){
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg,planeObj.getX()+3,planeObj.getY()-16,
                    14,29,5,this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size()-1));
        }
        /**
         * 敌机生成速度
         * */
        if(count % 15 ==0){
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*12*50),0,
                    49,36,5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
            enemyCount++;
        }
        /**
         * 敌方boss添加子弹
         * */
        if(count % 15 ==0 && bossObj != null) {
            GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletImg, bossObj.getX() + 76, bossObj.getY() + 150,
                    15, 25, 5, this));
            GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size() - 1));
        }
        if(enemyCount > 100 && bossObj == null){
            bossObj = new BossObj(GameUtils.bossImg,250,0,155,100,5,this);
            GameUtils.gameObjList.add(bossObj);
        }
    }
    public static void main(String[] args){
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }

}
