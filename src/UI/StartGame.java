package UI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;


public class StartGame {

	JFrame frame = new JFrame();
	static UI.SnakePanel panel = new UI.SnakePanel();

	static boolean FailedJFrameIsOpen = false;

	/**
	 * 运行
	 */
	public static void main(String[] args) {
		new StartGame();
	}

	public StartGame() {
		initJFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initJFrame() {
		frame.setTitle("贪吃蛇AI");
		frame.setResizable(false);//每次拖动都会重绘所以固定
		Thread game = new Thread(panel);
		game.start();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setBounds(500, 150,535,555);//外框大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	//用于停止渲染
	public static void stopGameRender(){
		panel.stopRendering();
		//生成失败弹窗
		if(!FailedJFrameIsOpen){
			new FailedJFrame();
			FailedJFrameIsOpen = true;
		}
	}
}
