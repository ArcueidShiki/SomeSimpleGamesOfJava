package com.sxt.obj;

import java.awt.*;

public class ExplodeObj extends GameObj{
    //爆炸动态效果
    static Image[] pic = new Image[16];
    //每个爆炸图只显示一次
    int explodeCount = 0;

    static{
        for (int i = 0; i < pic.length; i++) {
            pic[i] = Toolkit.getDefaultToolkit().getImage("imgs/explode/e"+(i+1)+".gif");
        }
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(explodeCount < 16){
            img = pic[explodeCount];
            super.paintSelf(gImage);
            explodeCount++;
        }
    }

    public ExplodeObj(int x, int y) {
        super(x, y);
    }
}
