package com.example.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
  private static final int SPFED = 10;
  private static int WIDEH = 20, HEIGHT = 20;

  private int x, y;
  private Dir dir;

  public Bullet(int x, int y, Dir dir) {
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
  }
}
