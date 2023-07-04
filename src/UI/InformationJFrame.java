package UI;

import javax.swing.*;

public class InformationJFrame extends JFrame{

    JTextField AiFunction = new JTextField("AIFunction:使用L键开启AI");
    public InformationJFrame(){
        initJFrame();
        setText();
    }
    public void initJFrame(){
        //设置游戏提示界面的代码
        this.setTitle("SnakeAI 快捷键");
        this.setLocation(1100,200);
        this.setSize(400,400);//外框大小
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口
        this.setVisible(true);//设置可见

    }
    public void setText(){
        AiFunction.setBounds(0,0,10,10);
        AiFunction.setEditable(false);
        this.getContentPane().add(AiFunction);
    }
}
