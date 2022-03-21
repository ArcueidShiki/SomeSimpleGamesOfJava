package cn.tedu.subMarine;
import utils.GameWin;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Rectangle;
public class GameObject {
    public Image img;
    public int x,y;
    public int width,height;
    public double speed;
    public int life;
    public GameWin frame;
    public GameObject(Image img,int x,int y,double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.img = img;
    }
    public GameObject(Image img,int x,int y){
        this.img =img;
        this.x = x;
        this.y = y;
    }
    public GameObject(int x,int y){
        this.x = x;
        this.y = y;
    }
    public GameObject(Image img,int width,int height,double speed,GameWin frame){
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.img = img;
        this.frame = frame;
    }
    public GameObject(Image img,int x,int y,int width,int height,double speed){
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject(Image img, int x, int y, int width, int height) {
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }

    public GameObject(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }
    public void paintSelf(Graphics gImage){
        gImage.drawImage(img,x,y,null);
    }
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height); //返回一个对象，可以套用方法
    }
}
