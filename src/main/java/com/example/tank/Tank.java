package com.example.tank;

import java.awt.Graphics;

public class Tank {
  private int x, y;
  private Dir dir = Dir.DOWN;
  private static final int SPFED = 10;

  public Tank(int x, int y, Dir dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
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
    g.fillRect(x, y,50,50);
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
  }
}
