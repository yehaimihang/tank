package com.example.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

  int x = 200, y = 200;

  public TankFrame() {
    setSize(800, 600);
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

  @Override
  public void paint(Graphics g) {
    System.out.println("pd");
    g.fillRect(x, y,50,50);
  }

  class MykKeyListtener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
      x += 20;
      //repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
      System.out.println("released");
    }
  }

}
