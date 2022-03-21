package cn.tedu.subMarine;

import utils.GameWin;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Battleship extends GameObject{

    public Battleship(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        //键盘移动事件
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
                int key = e.getKeyCode() ;
                switch(key){
                    case KeyEvent.VK_RIGHT:
                        Battleship.super.x += speed;
                        break;
                    case KeyEvent.VK_LEFT:
                        Battleship.super.x -= speed;
                        break;
                }if(Battleship.super.x > 550){
                    Battleship.super.x = 550;
                }else if(Battleship.super.x < 0){
                    Battleship.super.x = 0;
                }
            }
        });
    }

    @Override
    public Image getImg() {
        return super.getImg();
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
