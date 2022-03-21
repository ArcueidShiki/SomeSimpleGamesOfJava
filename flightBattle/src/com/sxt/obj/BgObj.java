package com.sxt.obj;
import java.awt.Graphics;
import java.awt.Image;
public class BgObj extends GameObj{
    //重写需要的构造方法和 Image,paintSelf方法 Methods

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if( y>= 0){
            y = -2000;
        }
    }
}
