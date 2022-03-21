package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj {
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        //鼠标移动事件
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //鼠标光标的横/纵坐标-飞机宽高的一半
                PlaneObj.super.x = e.getX()-11;
                PlaneObj.super.y = e.getY()-16;
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
