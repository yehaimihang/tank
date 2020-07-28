package com.example.tank;

public class Main {
  public static void main(String[] arg) throws InterruptedException {
    TankFrame tf = new TankFrame();

    while (true) {
      Thread.sleep(100);
      tf.repaint();
    }
  }
}
