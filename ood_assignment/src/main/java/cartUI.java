/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chngk
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class cartUI extends JFrame implements ActionListener {
   
    JPanel panelList = new JPanel();
    public cartUI(){
        setSize(500,200);
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
   public void updateUI(){
     panelList.add(new JLabel(""));
    }
    
    
    
      public void actionPerformed(ActionEvent e){;}
          
}

