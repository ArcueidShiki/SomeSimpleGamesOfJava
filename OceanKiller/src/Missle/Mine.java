package Missle;

import cn.tedu.subMarine.GameObject;
import cn.tedu.subMarine.MineSubmarine;
import utils.GameUtils;
import utils.GameWin;

import java.awt.*;

public class Mine extends GameObject {

    public Mine(Image img,int x, int y, int width, int height, double speed,GameWin frame) {
        super(img,x,y,width, height,speed,frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);

        y -= speed;
        if(this.getRec().intersects(this.frame.battleship.getRec())){
            GameUtils.removeList.add(this);
            GameWin.life--;
        }
        if(GameWin.life <= 0){
            GameWin.state = 3;
        }
        if(y < -13){
            this.y = -100;
            this.x = -100;
            GameUtils.removeList.add(this);
        }

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
