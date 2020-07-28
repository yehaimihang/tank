# 坦克大战

##### 基础知识点

1. 内部类好处：A class只有 B class调用，不想让其他class看到（不暴露出去）

2. 

##### 代码

1. 如何定义主站坦克的方向

   a. Enum Dir

2. 根据按键改变坦克的移动

   a. setMainTankDir()

3. 根据方向进行坦克的移动

4. 怎么处理坦克静止状态

   a. moving = false;

5. 想象如何给出更多的坦克，以及子弹

   a. 将坦克封装成类，理解面向对象设计中 “封装” 的思想

6. 利用双缓冲解决闪烁问题

7. 打出一颗子弹

8. 打出一串子弹

   ```java
   tf.bullets.add(new Bullet(this.x, this.y, this.dir));
   
   /*for (Bullet b : bullets) {
         b.paint(g);
   }*/
   //上边遍历方式过程中不能删除操作
   for (int i=0; i<bullets.size();i++) {
         bullets.get(i).paint(g);
   }
   ```

   