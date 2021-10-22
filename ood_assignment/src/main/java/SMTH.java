import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

class SMTH extends JFrame
{
JButton b1;
JLabel l1;
BufferedImage img;
	public SMTH()
	{
	setTitle("Background Color for JFrame");
	setSize(400,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
        setLayout(new BorderLayout());
        File f = new File("LoginBackground");
        File[] af = f.listFiles();
        String ab = f.getAbsolutePath();
        
        setContentPane(new JLabel(new ImageIcon(ab)));
        
        
       
        setLayout(new FlowLayout());
        l1=new JLabel("Here is a button");
        b1=new JButton("I am a button");
        add(l1);
        add(b1);
        }
        public static void main(String args[])
	{
            new SMTH();
	}
}