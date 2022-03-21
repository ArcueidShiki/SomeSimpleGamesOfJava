package cn.tedu.subMarine;

import Missle.Bomb;
import utils.GameUtils;
import utils.GameWin;

import java.awt.*;

public class ObserverSubmarine extends Enemy {

    public ObserverSubmarine(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        for(Bomb bomb:GameUtils.bombList){
            if(this.getRec().intersects(bomb.getRec())){
                bomb.setY(-100);
                bomb.setX(-100);
                GameUtils.removeList.add(bomb);
                GameWin.life++;
            }
        }

    }

    @Override
    public Rectangle getRec() {

        return super.getRec();

    }
}
