package utils;
import Missle.*;
import cn.tedu.subMarine.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class GameUtils {

    public static Image explodeImg, battleshipImg,bombImg,gameoverImg,mineImg,minesubmImg,
            obsersubmImg,seaImg,startImg,torpedoImg,torpesubmImg;
    static{
        explodeImg = Toolkit.getDefaultToolkit().getImage("img/explode/e6.gif");
        battleshipImg = Toolkit.getDefaultToolkit().getImage("img/battleship.png");
        bombImg = Toolkit.getDefaultToolkit().getImage("img/bomb.png");
        gameoverImg = Toolkit.getDefaultToolkit().getImage("img/gameover.png");
        mineImg = Toolkit.getDefaultToolkit().getImage("img/mine.png");
        minesubmImg = Toolkit.getDefaultToolkit().getImage("img/minesubm.png");
        obsersubmImg = Toolkit.getDefaultToolkit().getImage("img/obsersubm.png");
        seaImg = Toolkit.getDefaultToolkit().getImage("img/sea.png");
        startImg = Toolkit.getDefaultToolkit().getImage("img/start.png");
        torpedoImg = Toolkit.getDefaultToolkit().getImage("img/torpedo.png");
        torpesubmImg = Toolkit.getDefaultToolkit().getImage("img/torpesubm.png");
    }
    public static List <GameObject>gameObjectList = new ArrayList<>();
    public static List <MineSubmarine>mineSubmarineList = new ArrayList<>();
    public static List <ObserverSubmarine>observerSubmarineList = new ArrayList<>();
    public static List <TorpedoSubmarine>torpedoSubmarineList = new ArrayList<>();
    public static List <Bomb>bombList = new ArrayList<>();
    public static List <Mine>mineList = new ArrayList<>();
    public static List <Torpedo>torpedoList = new ArrayList<>();
    public static List <Explode>explodeList = new ArrayList<>();
    public static List <GameObject>removeList = new ArrayList<>();

    public static void drawWord(Graphics gImage,String str, Color color,int size,int x, int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }
}
