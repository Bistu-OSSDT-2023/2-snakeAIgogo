package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;


public class StartGame {

	private JFrame frame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGame window = new StartGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartGame() {
		initialize();
		initInformationJFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame.setTitle("贪吃蛇AI");
		frame.setResizable(false);//每次拖动都会重绘所以固定
		UI.SnakePanel panel = new UI.SnakePanel();
		Thread game = new Thread(panel);
		game.start();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setSize(535,555);//外框大小
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initInformationJFrame(){
		new InformationJFrame();
	}
}
