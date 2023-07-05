package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import AI.SnakeAi;
import Mode.Node;
import Mode.Snake;

public class SnakePanel extends JPanel implements Runnable, KeyListener {

	SnakeAi ai;
	Snake snake;
	int flag = 0;

	int speeds = 0;

	int dir =-1;

	volatile boolean isRendering = true;

	/**
	 * Create the panel.
	 */
	public SnakePanel() {
		snake=new Snake();
		Node n=new Node(250,260);//蛇的初始位置
		snake.getS().add(n);
		snake.setFirst(n);
		snake.setLast(n);
		snake.setTail(new Node(0,10));//last的后一个节点
		snake.setFood(new Node(80,80));//食物初始位置
		setFocusable(true); // 设置组件可以获得焦点
		requestFocus(); // 请求焦点听
		addKeyListener(this); // 添加键盘事件监器
		addFocusListener(focusListener);
		ai=new SnakeAi();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.orange);
		g.drawRect(10, 10, Snake.map_size, Snake.map_size);//地图范围

		g.setColor(Color.white);
		paintSnake(g,snake);

		g.setColor(Color.white);
		paintFood(g, snake.getFood());
		if(flag == 0) {
			dir = this.snake.getDir();
		}else {
			dir = ai.play2(snake, snake.getFood());//选择策略：play,play1,play2
		}
		if(dir == -1){
			this.snake.move(dir);

		}
		else{
			this.snake.move(dir);
		}

	}

	/**
	 * 画蛇
	 * @param g
	 * @param snake
	 */
	public void paintSnake(Graphics g,Snake snake){
		for(Node n:snake.getS()){
			if(n.toString().equals(snake.getFirst().toString())){
				g.setColor(Color.ORANGE);//为了方便看蛇头为绿色
			}
			if(n.toString().equals(snake.getLast().toString())&&!snake.getFirst().toString().equals(snake.getLast().toString())){
				g.setColor(Color.CYAN);//蛇尾蓝色
			}
			g.fillRect(n.getX(),n.getY(),Snake.size, Snake.size);
			g.setColor(Color.white);//蛇身白色
		}
	}
	/**
	 * 画食物
	 * @param g
	 * @param food
	 */
	public void paintFood(Graphics g,Node food){
		g.setColor(Color.RED);
		g.fillOval(food.getX(), food.getY(), snake.size, snake.size);
	}

	@Override
	public void run() {
		while (isRendering) {
			// TODO Auto-generated method stub
			try {
				snake.setSpeed(100 - snake.getLen()+speeds);
				Thread.sleep(snake.Speed);//延迟速度
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopRendering() {
		isRendering = false;
	}
	public void resumeRendering() {
		isRendering = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_M) {
			// 执行字母键 'M' 按下的逻辑   加速
			if(snake.Speed >20) speeds -= 20;
		}

		if (e.getKeyCode() == KeyEvent.VK_N) {
			// 执行字母键 'N' 按下的逻辑 减速
			if(snake.Speed <=180) speeds += 20;
		}

		//切换人工智能AI
		if (e.getKeyCode() == KeyEvent.VK_L) {
			// 执行字母键 'L' 按下的逻辑
			flag = 1;
		}

		//空格
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// 执行空格键按下的逻辑
			flag = 0;
			snake.setDir(-1);
		}

		//上
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP ){
			flag = 0;
			snake.setDir(8);

		}
		//下
		else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
			flag = 0;
			snake.setDir(2);
		}
		//左
		else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
			flag = 0;
			snake.setDir(4);
		}
		//右
		else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
			flag = 0;
			snake.setDir(6);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	FocusListener focusListener = new FocusListener() {
		@Override
		public void focusGained(FocusEvent e) {
			// 当窗口获得焦点时，游戏继续渲染
			resumeRendering();
		}

		@Override
		public void focusLost(FocusEvent e) {
			// 当窗口失去焦点时，暂停游戏
			flag = 0;
			snake.setDir(-1);
		}
	};
}
