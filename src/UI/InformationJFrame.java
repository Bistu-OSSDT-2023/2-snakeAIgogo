package UI;

import javax.swing.*;

public class InformationJFrame extends JFrame{

    JTextField AiFunction = new JTextField("AIFunction:ʹ��L������AI");
    public InformationJFrame(){
        initJFrame();
        setText();
    }
    public void initJFrame(){
        //������Ϸ��ʾ����Ĵ���
        this.setTitle("SnakeAI ��ݼ�");
        this.setLocation(1100,200);
        this.setSize(400,400);//����С
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//�رմ���
        this.setVisible(true);//���ÿɼ�

    }
    public void setText(){
        AiFunction.setBounds(0,0,10,10);
        AiFunction.setEditable(false);
        this.getContentPane().add(AiFunction);
    }
}
