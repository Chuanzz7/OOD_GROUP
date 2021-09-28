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
    JPanel pl_ItemList = new JPanel();
    JPanel pl_TotalPrice = new JPanel();
    JButton addButton = new JButton("Add");
    
    JLabel lb_TotalPrice = new JLabel("");
    JLabel lb_ItemList = new JLabel("Item list:");
    
    public cartUI(){
        setLayout (new BorderLayout());
        setSize(500,200);
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(pl_ItemList);
        add(addButton);
       
        
        
        pl_ItemList.add(lb_ItemList, BorderLayout.NORTH);
        
        pl_TotalPrice.add(lb_TotalPrice, BorderLayout.SOUTH);
        
        add(pl_TotalPrice);
        addButton.addActionListener(this);
    }
    
      public void actionPerformed(ActionEvent e){
          cart1.addItem("test1", 10, 5);
          pl_ItemList.add(new JLabel(cart1.cartItemArray.toString()));
          pl_ItemList.add(new JButton("Delete"));
          
          
          lb_TotalPrice.setText(cart1.calculateTotal());
          validate();
      }
          
}

