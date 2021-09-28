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
    cart cart1 = new cart();
    JPanel panelList = new JPanel();
    JButton addButton = new JButton("Add");
    public cartUI(){
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
          cart1.addItem("test1", 10, 5);
          panelList.add(new JLabel(cart1.cartItemArray.toString()));
          panelList.add(new JLabel(cart1.calculateTotal()));
          panelList.add(new JButton("Delete"));
          validate();}
          
}

