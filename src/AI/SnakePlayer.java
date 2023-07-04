package AI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Mode.Node;
import Mode.Snake;

import javax.swing.*;


public class SnakePlayer extends JFrame {

    public SnakePlayer(){

    }

    //游戏暂停按钮
    JButton jtb1 = new JButton("暂停");

    Snake snake;

    public void player(){
        snake =new Snake();
        Node n=new Node(10,10);//蛇的初始位置
        snake.getS().add(n);
        snake.setFirst(n);
        snake.setLast(n);
        snake.setTail(new Node(10,0));//last的后一个节点
        snake.setFood(new Node(80,80));//食物初始位置\
        snake.move();
    }



}
