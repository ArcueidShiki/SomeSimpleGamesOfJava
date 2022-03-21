package com.sxt.utils;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

import com.sxt.obj.*;

public class GameUtils {
    /**
     * 获取图片资源 常用Staic 声明的变量只有一份，可以被该类的全体对象共享的一份变量，。只需加载一次。节约存储空间
     * 静态变量属于类，使用类名访问。
     * 每用到一个类：
     * 1.创建对象时，2.访问静态属性时，3.执行静态方法时 4.静态代码块会自动加载类。 将对应的字节码加载到方法去区
     * 字节码文件只加载一次。
     */
    public static Image bgImg,bossImg,explodeImg,planeImg,shellImg,enemyImg,bulletImg;
    //静态代码块语法---声明的是静态变量，图片资源，也可以用下方静态集合的写法
    static{
        bgImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
        bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
        explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
        planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
        shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
        enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
        bulletImg = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");
        }

    /**
     * 静态集合
     *
     * */
    //创建所有游戏物体的集合
    public static List<GameObj>gameObjList = new ArrayList<>();
    //创建我方子弹集合
    public static List<ShellObj>shellObjList = new ArrayList<>();
    //敌方子弹集合
    public static List<BulletObj>bulletObjList = new ArrayList<>();
    //创建敌方战斗机集合
    public static List<EnemyObj>enemyObjList = new ArrayList<>();
    //碰撞后，小敌机和子弹两者都消失
    public static List<GameObj>removeList = new ArrayList<>();
    //爆炸效果集合
    public static List<ExplodeObj>explodeObjList = new ArrayList<>();

    /**
     * 静态方法：属于类的方法，通过类直接访问
     * 方法中未使用对象属性时，可以定义为静态方法，方法中的参数都是手动传进去的。
     * 如果使用了对象属性就不能定义为静态方法
     * 无隐含局部变量this
     * 1.不能使用实例变量(对象属性-非静态区)
     * 2.
     * */
    //绘制文字工具类                       gIamge 是图像画笔
    public static void drawWord(Graphics gImage, String str,Color color, int size,int x, int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }
}
