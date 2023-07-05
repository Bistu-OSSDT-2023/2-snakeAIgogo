package UI;

import javax.swing.*;
import java.awt.*;

public class ExtraJFrame extends JFrame{

    JTextField AiFunction1 = new JTextField("AIFunction:使用L键开启AI");
    JTextField AiFunction2 = new JTextField("(关于AI功能:你可以按下↑↓←→或者WASD来接替AI去控制贪吃蛇)");
    JTextField StopFunction = new JTextField("StopFunction:按下空格键来暂停游戏");

    public ExtraJFrame(){
        initJFrame();
        setText();
    }

    public void initJFrame(){
        //设置游戏提示界面的代码
        this.setTitle("SnakeAI 快捷键");
        this.setLocation(1035,150);
        this.setSize(400,150);//外框大小
        this.setLocationRelativeTo(null);//居中
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//关闭窗口
        this.setLayout(new GridLayout(3,1));//设置三行一列的网格布局以便于文本框的放置
        this.setVisible(true);//设置可见

    }
    public void setText(){
        AiFunction1.setEditable(false);
        AiFunction2.setEditable(false);
        StopFunction.setEditable(false);
        this.getContentPane().add(AiFunction1);
        this.getContentPane().add(AiFunction2);
        this.getContentPane().add(StopFunction);
    }
}
