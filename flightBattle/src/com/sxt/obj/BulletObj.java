package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class BulletObj extends GameObj{
    public BulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //敌方子弹与我方飞机碰撞
        if(this.frame.bossObj != null && this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state =3;
        }
        if(y > 600){
            //子弹，飞机，移动的丢弃的坐标不能重复，否则会产生碰撞检测
            // 错误
            this.y = -300;
            this.x = -300;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
