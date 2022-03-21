//package cn.tedu.subMarine;
//
//import Missle.Bomb;
//import Missle.Mine;
//import Missle.Torpedo;
//import utils.GameWin;
//
///**
// * 运行或测试游戏
// * */
//public class GameWorld {
//    Battleship ship;
//    Bomb b1,b2;
//
//    Torpedo t1,t2;
//    Mine m1,m2;
//
//    ObserverSubmarine os1,os2;
//    TorpedoSubmarine ts1,ts2;
//    MineSubmarine ms1,ms2;
//    void action(){
//        System.out.println("action启动，开始创建对象....");
//        ship = new Battleship();
//        ship.x = 150;
//        ship.y = 100;
//        ship.width =40;
//        ship.height = 80;
//        ship.speed = 20;
//        ship.step();
//        os1 = new ObserverSubmarine();
//        os2 = new ObserverSubmarine();
//
//        t1 = new Torpedo();
//        t2 = new Torpedo();
//    }
//    public static void main(String[] args){
//        GameWorld gameWorld = new GameWorld();
//        gameWorld.action();
//
//    }
//}
