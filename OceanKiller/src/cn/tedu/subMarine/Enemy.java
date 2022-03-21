package cn.tedu.subMarine;

import Missle.Bomb;
import utils.GameUtils;
import utils.GameWin;

import java.awt.*;

public class Enemy extends GameObject{
    public Enemy(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public Enemy(Image img, int x, int y) {
        super(img, x, y);
    }

    public Enemy(int x, int y) {
        super(x, y);
    }

    public Enemy(Image img, int x, int y, int width, int height) {
        super(img, x, y, width, height);
    }

    public Enemy(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }
    public Enemy(Image img, int width, int height, double speed, GameWin frame) {
        super(img,width, height,speed,frame);
    }
    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        x += speed;
        if(x > 550){
            this.x = -200;
            this.y = -200;
            GameUtils.removeList.add(this);
        }
        for(Bomb bomb: GameUtils.bombList){
            if(this.getRec().intersects(bomb.getRec())){
//                System.out.println("碰撞了");
                Explode explode = new Explode(x,y);
                GameUtils.explodeList.add(explode);
                GameUtils.removeList.add(explode);
                bomb.setX(-100);
                bomb.setY(-100);
                this.x = -200;
                this.y = -200;
                GameUtils.removeList.add(bomb);
//                System.out.println(GameUtils.removeList.toString());
                GameUtils.removeList.add(this);
                GameWin.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

}
