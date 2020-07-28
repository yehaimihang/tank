package com.example.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

  Tank myTank = new Tank(200, 200, Dir.DOWN, this);
  List<Bullet> bullets = new ArrayList<>();
  static final int GAME_WIFTH = 800, GAME_HEGHT = 600;

  public TankFrame() {
    setSize(GAME_WIFTH, GAME_HEGHT);
    setResizable(false);
    setTitle("tank war");
    setVisible(true);

    addKeyListener(new MykKeyListtener());

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

  }

  Image offScreenImage = null;
  @Override
  public void update(Graphics g) {
    if (offScreenImage == null) {
      offScreenImage = this.createImage(GAME_WIFTH, GAME_HEGHT);
    }
    Graphics gOffScreen = offScreenImage.getGraphics();
    Color c = gOffScreen.getColor();
    gOffScreen.setColor(Color.BLACK);
    gOffScreen.fillRect(0, 0, GAME_WIFTH, GAME_HEGHT);
    gOffScreen.setColor(c);
    paint(gOffScreen);
    g.drawImage(offScreenImage, 0, 0, null);
  }

  @Override
  public void paint(Graphics g) {
    Color c = g.getColor();
    g.setColor(Color.WHITE);
    g.drawString("子弹数量：" + bullets.size(), 10, 60);
    g.setColor(c);
    myTank.paint(g);
    /*for (Bullet b : bullets) {
      b.paint(g);
    }*/
    for (int i=0; i<bullets.size();i++) {
      bullets.get(i).paint(g);
    }
  }

  class MykKeyListtener extends KeyAdapter {

    boolean bL = false;
    boolean bU = false;
    boolean bR = false;
    boolean bD = false;

    @Override
    public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      switch (key) {
        case KeyEvent.VK_LEFT:
          bL = true;break;
        case KeyEvent.VK_UP:
          bU = true;break;
        case KeyEvent.VK_RIGHT:
          bR = true;break;
        case KeyEvent.VK_DOWN:
          bD = true;break;
          default:
            break;
      }
      setMainTainDir();
    }

    @Override
    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      switch (key) {
        case KeyEvent.VK_LEFT:
          bL = false;break;
        case KeyEvent.VK_UP:
          bU = false;break;
        case KeyEvent.VK_RIGHT:
          bR = false;break;
        case KeyEvent.VK_DOWN:
          bD = false;break;

        case KeyEvent.VK_CONTROL:
          myTank.fire();
          break;

        default:
          break;
      }
      setMainTainDir();
    }

    private void setMainTainDir() {
      if (!bL && !bU && !bR && !bD)
        myTank.setMoving(false);
      else {
        myTank.setMoving(true);
        if (bL)
          myTank.setDir(Dir.LEFT);
        if (bU)
          myTank.setDir(Dir.UP);
        if (bR)
          myTank.setDir(Dir.RIGHT);
        if (bD)
          myTank.setDir(Dir.DOWN);
      }
    }

  }

}
