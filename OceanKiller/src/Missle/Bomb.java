package Missle;

import cn.tedu.subMarine.GameObject;
import cn.tedu.subMarine.ObserverSubmarine;
import utils.GameUtils;
import utils.GameWin;

import java.awt.*;

public class Bomb extends GameObject {

    public Bomb(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if(y> 470){
            this.x = -100;
            this.y = -100;
            GameUtils.removeList.add(this);
        }
        for(ObserverSubmarine observerSubmarine:GameUtils.observerSubmarineList){
            if(this.getRec().intersects(observerSubmarine.getRec())){
//                GameWin.life++;
            }
        }

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }
}
