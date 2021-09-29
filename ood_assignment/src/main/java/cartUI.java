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
    
  
    
    JPanel pl_Top_Label = new JPanel();
    JPanel pl_Middle_ItemList = new JPanel();
    JPanel pl_Bottom_TotalPrice = new JPanel();
   
    JButton addButton = new JButton("Add");
    
    JLabel lb_TotalPrice = new JLabel("Price =");
    JLabel lb_ItemList = new JLabel("Item list:");
    
    String[] columnNames = {"Item Name" , "Item Quantity"};
    String row[][] = {{"test","test2", "test3"}};
    String column[] = {"Name","Quantity", "Total Price"};
    JTable table = new JTable(new DefaultTableModel(new Object[]{"Column1", "Column2"}));
    
    public cartUI(){
        
        setSize(500,400);
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        addButton.addActionListener(this);
      
        pl_Top_Label.add(addButton);
        pl_Top_Label.add(lb_ItemList);
        
        add("North",pl_Top_Label);
        
        pl_Middle_ItemList.setLayout(new BoxLayout(pl_Middle_ItemList, BoxLayout.Y_AXIS));
        pl_Middle_ItemList.add(lb_ItemList);
        add("Center",pl_Middle_ItemList);
        
        
        
        pl_Bottom_TotalPrice.add(lb_TotalPrice);
        add("South",pl_Bottom_TotalPrice);
         setVisible(true);
    }
    
      public void actionPerformed(ActionEvent e){
          cart1.addItem("test1", 10, 5);
          pl_Middle_ItemList.add(table);
           
          pl_Middle_ItemList.add(new JButton("Delete"));
          
          
          
          lb_TotalPrice.setText(cart1.calculateTotal());
         
          validate();
      }
      
      public void updateArray(){
            //for(int i=0; i < cart1.cartItemArray.size() )
             
         }
        }
      
      //public void generateItem(){
         
          


