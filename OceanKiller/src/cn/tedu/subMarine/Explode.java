package cn.tedu.subMarine;


import java.awt.*;

public class Explode extends GameObject{
    static Image[] pic = new Image[16];
    int explodeCount = 0;
    static{
        for(int i = 0; i< pic.length;i++){
            pic[i] = Toolkit.getDefaultToolkit().getImage("img/explode/e"+(i+1)+".gif");
        }
    }
    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(explodeCount < 15){
            img = pic[explodeCount];
            super.paintSelf(gImage);
            explodeCount++;
        }else if(explodeCount == 15){
            img = null;
            super.paintSelf(gImage);
        }
    }
    public Explode(int x,int y){
        super(x,y);
    }
}
