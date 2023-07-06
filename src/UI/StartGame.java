package UI;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;

public class StartGame {

	JFrame frame = new JFrame();
	static UI.SnakePanel panel = new UI.SnakePanel();
	/*
	���ڿ��ƽ�����һ��ʧ�ܵ���
	��δ�ҵ��������ε���������Դͷ
	 */
	static boolean FailedJFrameIsOpen = false;

	/**
	 * ����
	 */
	public static void main(String[] args) {
		new ExtraJFrame();
		new StartGame();
	}

	public StartGame() {
		initJFrame();
	}

	//��Ϸ��ʼ��
	private void initJFrame() {
		frame.setTitle("̰����AI");
		frame.setResizable(false);//ÿ���϶������ػ����Թ̶�
		Thread game = new Thread(panel);
		game.start();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setBounds(500, 150,535,555);//����С
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	//����ֹͣ��Ⱦ
	public static void stopGameRender(){
		panel.stopRendering();
		//����ʧ�ܵ���
		if(!FailedJFrameIsOpen){
			new FailedJFrame();
			FailedJFrameIsOpen = true;
		}
	}
}
