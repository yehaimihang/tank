package com.example.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
  private int x, y;
  private Dir dir = Dir.DOWN;
  private static final int SPFED = 5;

  private boolean moving = false;

  private TankFrame tf;

  public Tank(int x, int y, Dir dir, TankFrame tf) {
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

  public boolean isMoving() {
    return moving;
  }

  public void setMoving(boolean moving) {
    this.moving = moving;
  }

  public void paint(Graphics g) {
    Color c = g.getColor();
    g.setColor(Color.YELLOW);
    g.fillRect(x, y,50,50);
    g.setColor(c);

    move();
  }

  private void move() {
    if (!moving) return;
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

  public void fire() {
    tf.bullets.add(new Bullet(this.x, this.y, this.dir, tf));
  }
}
