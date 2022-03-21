package cn.tedu.subMarine;

import Missle.Bomb;
import utils.GameUtils;
import utils.GameWin;

import java.awt.*;

public class MineSubmarine extends Enemy {
    public MineSubmarine(Image img, int width, int height, double speed, GameWin frame) {
        super(img,width, height, speed, frame);
    }
    public MineSubmarine(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
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
