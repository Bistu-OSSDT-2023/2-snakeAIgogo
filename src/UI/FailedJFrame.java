package UI;

import javax.swing.*;
import java.awt.*;

public class FailedJFrame extends JFrame {
    //JLabel label = new JLabel(new ImageIcon("..\\img\\gameover.png"));
    JLabel label = new JLabel(new ImageIcon("../img/gameover.png"));
    public FailedJFrame(){
        initJFrame();
        //生成图片
        initImage();
    }

    public void initJFrame(){
        //设置失败弹窗的代码
        this.setSize(550,200);
        this.setTitle("SnakeAI V1.0");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
    }

    public void initImage(){
        label.setBounds(0,0,475,125);
        this.getContentPane().add(label);
    }
}
