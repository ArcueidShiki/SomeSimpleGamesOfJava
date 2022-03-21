//package utils;
//
//import Missle.Mine;
//import Missle.Torpedo;
//
//import java.util.Timer;
//import java.util.TimerTask;
//public class TimerDemo {
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        ShootMine shootMine = new ShootMine();
//        timer.schedule(shootMine,8000,90000);
//        ShootTorpedo shootTorpedo = new ShootTorpedo();
//        timer.schedule(shootTorpedo,6000,30000);
//
//    }
//}
//class ShootMine extends TimerTask{
//    public void run(){
//        GameUtils.mineList.add(new Mine(GameUtils.mineImg,
//                GameUtils.mineSubmarineList.get(GameUtils.mineSubmarineList.size()-1).getX()+30,
//                GameUtils.mineSubmarineList.get(GameUtils.mineSubmarineList.size()-1).getY()-16,
//                5,18,5));
//        GameUtils.gameObjectList.add(GameUtils.mineList.get(GameUtils.mineList.size()-1));
//
//    }
//}
//class ShootTorpedo extends TimerTask{
//    public void run(){
//
//        GameUtils.torpedoList.add(new Torpedo(GameUtils.torpedoImg,
//                GameUtils.torpedoSubmarineList.get(GameUtils.torpedoSubmarineList.size()-1).getX()+30,
//                GameUtils.torpedoSubmarineList.get(GameUtils.torpedoSubmarineList.size()-1).getY()-16,
//                5,18,5));
//        GameUtils.gameObjectList.add(GameUtils.torpedoList.get(GameUtils.torpedoList.size()-1));
//    }
//}