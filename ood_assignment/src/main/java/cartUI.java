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
    JButton addButton = new JButton("Add");
    public cartUI( ArrayList<cartItem> _cartItemArray){
        setLayout (new FlowLayout());
        setSize(500,200);
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(addButton);
        add(panelList);
        addButton.addActionListener(this);
    }
    
      public void actionPerformed(ActionEvent e){
          panelList.add(new JLabel("Test"));
          validate();}
          
}

