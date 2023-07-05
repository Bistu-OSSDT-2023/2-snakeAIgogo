package UI;

import javax.swing.*;
import java.awt.*;

public class ExtraJFrame extends JFrame{

    JTextField AiFunction1 = new JTextField("AIFunction:使用L键开启AI");
    JTextField AiFunction2 = new JTextField("(关于AI功能:你可以按下↑↓←→或者WASD来接替AI去控制贪吃蛇)");
    JTextField StopFunction = new JTextField("StopFunction:按下空格键来暂停游戏");
    JTextField SpeedUp = new JTextField("SpeedUp:按下M键来使贪吃蛇加速");
    JTextField SpeedDown = new JTextField("SpeedUp:按下N键来使贪吃蛇减速");

    public ExtraJFrame(){
        initJFrame();
        setText();
    }

    public void initJFrame(){
        //设置游戏提示界面的代码
        this.setTitle("SnakeAI 快捷键");
        this.setLocation(1022,150);
        this.setSize(400,150);//外框大小
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//关闭窗口
        this.setLayout(new GridLayout(5,1));//设置三行一列的网格布局以便于文本框的放置
        this.setVisible(true);//设置可见

    }
    public void setText(){
        AiFunction1.setEditable(false);
        AiFunction2.setEditable(false);
        StopFunction.setEditable(false);
        SpeedUp.setEditable(false);
        SpeedDown.setEditable(false);
        this.getContentPane().add(AiFunction1);
        this.getContentPane().add(AiFunction2);
        this.getContentPane().add(StopFunction);
        this.getContentPane().add(SpeedUp);
        this.getContentPane().add(SpeedDown);
    }
}
