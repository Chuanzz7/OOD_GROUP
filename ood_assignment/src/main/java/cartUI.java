/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chngk
 */


import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;

public class cartUI{
    
    int time = 0;
    JFrame frame = new JFrame();
    JButton addButton = new JButton("Add");
    JButton delButton = new JButton("Delete");
    JLabel lb_TotalPrice = new JLabel("Price ");
    JLabel lb_ItemList = new JLabel("Item list:");
    
   
 
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    Object[] columns = {"Name","Quantity", "Price", "Button"};
    Object[] row = new Object[4];
    
    JScrollPane panel = new  JScrollPane(table);
    
     
    
    public cartUI(){
       
        frame.setLayout(new FlowLayout());
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        
        frame.setSize(1000,800);
        frame.setTitle("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
       
        addButton.setPreferredSize(new Dimension(100, 100));
    
        frame.add(addButton);
        frame.add(panel);
        frame.add(lb_TotalPrice);
        frame.setSize(900,400);
        frame.setVisible(true);
        
         addButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             time++;
                row[0] = "test"+time;
                row[1] = "test";
                row[2] = "test";
                row[3] = "delete";
                
                // add row to the model
                model.addRow(row);
            }
            });
         
          ButtonColumn buttonColumn = new ButtonColumn(table, delete, 3);

        }
    

 Action delete = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
        JTable table = (JTable)e.getSource();
        int modelRow = Integer.valueOf( e.getActionCommand() );
        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
    }
}; 

    
  

  
 }
    
     


 
      

         
          


