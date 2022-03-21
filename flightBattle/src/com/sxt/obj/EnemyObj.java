package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj{


    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //与我方飞机碰撞检测
        if(this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state = 3;
        }
        //遍历shellList，检测碰撞
        if(y > 600){
            this.x = -200;
            this.y = -200;
            GameUtils.removeList.add(this);
        }
        for(ShellObj shellObj: GameUtils.shellObjList ){
            if(this.getRec().intersects(shellObj.getRec())){
//              System.out.println("碰撞了"); 创建爆炸类
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(-100);
                this.x = -200;
                this.y = -200;
                GameUtils.removeList.add(shellObj);
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
