package UI;

import javax.swing.*;
import java.awt.*;

public class ExtraJFrame extends JFrame{

    JTextField AiFunction1 = new JTextField("AIFunction:ʹ��L������AI");
    JTextField AiFunction2 = new JTextField("(����AI����:����԰��¡�����������WASD������AIȥ����̰����)");
    JTextField StopFunction = new JTextField("StopFunction:���¿ո������ͣ��Ϸ");
    JTextField SpeedUp = new JTextField("SpeedUp:����M����ʹ̰���߼���");
    JTextField SpeedDown = new JTextField("SpeedUp:����N����ʹ̰���߼���");

    public ExtraJFrame(){
        initJFrame();
        setText();
    }

    public void initJFrame(){
        //������Ϸ��ʾ����Ĵ���
        this.setTitle("SnakeAI ��ݼ�");
        this.setLocation(1022,150);
        this.setSize(400,150);//����С
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//�رմ���
        this.setLayout(new GridLayout(5,1));//��������һ�е����񲼾��Ա����ı���ķ���
        this.setVisible(true);//���ÿɼ�

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
