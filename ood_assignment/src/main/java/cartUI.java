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
    
    JLabel lb_TotalPrice = new JLabel("Price =");
    JLabel lb_ItemList = new JLabel("Item list:");
    
    public cartUI(){
        
        setSize(500,400);
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(addButton);
        addButton.addActionListener(this);
      
        
        
        pl_ItemList.add(lb_ItemList);
        add(pl_ItemList);
        
        
        pl_TotalPrice.add(lb_TotalPrice);
        add(pl_TotalPrice);
        
    }
    
      public void actionPerformed(ActionEvent e){
          cart1.addItem("test1", 10, 5);
          pl_ItemList.add(new JLabel(cart1.cartItemArray.toString()));
          pl_ItemList.add(new JButton("Delete"));
          
          
          lb_TotalPrice.setText(cart1.calculateTotal());
          validate();
      }
          
}

