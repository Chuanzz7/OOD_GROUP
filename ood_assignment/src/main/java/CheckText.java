import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CheckText extends JFrame implements ActionListener{

    JTextField myTxt = new JTextField(10);
    JCheckBox myChBx  = new JCheckBox("Try checking it");

    public static void main(String[] args) {
      CheckText jf=new CheckText();
       
    }
    
    public CheckText()
    {
        setLayout(new FlowLayout());
        setSize(600, 120);
        setTitle("Check Box Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(myTxt);
        add(myChBx);
        myChBx.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        myTxt.setText("you did it!");

    }
}