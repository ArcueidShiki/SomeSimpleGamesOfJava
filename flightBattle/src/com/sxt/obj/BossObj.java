package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;
import jdk.nashorn.tools.Shell;

import java.awt.*;

public class BossObj extends GameObj{
    int life = 10;
    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(x > 550 || x <-50){
            speed = -speed;
        }
        x += speed;
        if(this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state = 3;
        }
        for(ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())){
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                life--;
            }
            if(life <= 0){
                GameWin.state = 4;
            }
        }
        //boss血条
        gImage.setColor(Color.white);
        //白色
        gImage.fillRect(20,40,100,10);
        //红色
        gImage.setColor(Color.red);
        gImage.fillRect(20,40,life*100/10,10);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
