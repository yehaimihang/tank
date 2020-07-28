package com.example.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
  private static final int SPFED = 8;
  private static int WIDEH = 20, HEIGHT = 20;

  private int x, y;
  private Dir dir;
  TankFrame tf = null;

  private boolean live = true;

  public Bullet(int x, int y, Dir dir, TankFrame tf) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.tf = tf;
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

  public Dir getDir() {
    return dir;
  }

  public void setDir(Dir dir) {
    this.dir = dir;
  }

  public void paint(Graphics g) {
    if (!live) {
      tf.bullets.remove(this);
    }

    Color c = g.getColor();
    g.setColor(Color.RED);
    g.fillOval(x, y, WIDEH, HEIGHT);
    g.setColor(c);
    move();
  }

  private void move() {
    switch (dir) {
      case LEFT:
        x -= SPFED;break;
      case UP:
        y -= SPFED;break;
      case RIGHT:
        x += SPFED;break;
      case DOWN:
        y += SPFED;break;
      default:
        break;
    }

    if (x<0 || y<0 || x>TankFrame.GAME_WIFTH || y>TankFrame.GAME_HEGHT)
      live = false;
  }
}
