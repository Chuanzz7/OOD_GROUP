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
import java.util.ArrayList;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;

public class cartUI {
    ArrayList<cartItem> cartItemArray  = new ArrayList<>();
     
    int time = 0;
    Panel frame = new Panel();
    JLabel lb_TotalPrice = new JLabel("Price ");
    JLabel lb_ItemList = new JLabel("Item list:");
    
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel()
        {
        public boolean isCellEditable(int row, int column)
        {
         switch (column) {
         case 0:
         case 4:
             return true;
         default:
             return false;
      }
        }
           
    };
    
    
    Object[] columns = {"Name","Quantity","Unit Price", "Price", "Button"};
    Object[] row = new Object[5];
    
    JScrollPane panel = new  JScrollPane(table);
    
    public cartUI(){
      
        frame.setLayout(new FlowLayout());
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        
        frame.setSize(1000,800);
       
        frame.add(panel);
        frame.add(lb_TotalPrice);
        frame.setSize(900,400);
        frame.setVisible(true);
     
        //put tis in main menu
         /*addButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) { 
                int tableRowsNum = table.getRowCount();
                row[0] = "test1";
                row[1] = 2;
                row[2] = "1";
                row[3] = "2";
                row[4] = "delete";
                
                //if item is already in cart
                for(int i = 0 ; i < tableRowsNum ; i++){
                    if("test1"  == table.getValueAt(i, 0).toString()){ 
                    int quantity = Integer.parseInt(table.getValueAt(i, 1).toString());
                    table.setValueAt(quantity+1,i,1);
                    table.setValueAt(Double.parseDouble(table.getValueAt(i, 1).toString()) * Double.parseDouble(table.getValueAt(i, 2).toString()),i,3);
                    findTotal();
                    break;
                    }

                    // add row to the model
                    else if(i == tableRowsNum-1){
                    model.addRow(row); 
                    findTotal();
                    break;
                    }
                }
            }
            });*/
         
          ButtonColumn buttonColumn = new ButtonColumn(table, delete, 4);
        }
     
 //delete button
 Action delete = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {

        JTable table1 = (JTable)e.getSource();
        int modelRow = Integer.valueOf( e.getActionCommand() );
        int quantity = Integer.parseInt(table1.getValueAt(modelRow, 1).toString());
        if(quantity == 1){
        ((DefaultTableModel)table1.getModel()).removeRow(modelRow);
        findTotal();
        }
        else {
        table.setValueAt(quantity-1,modelRow,1);
        table.setValueAt(Double.parseDouble(table.getValueAt(modelRow, 1).toString()) * Double.parseDouble(table.getValueAt(modelRow, 2).toString()),modelRow,3);
        findTotal();
        }
    }
};
 
 //update grant total
  public void findTotal(){
    int tableRowsNum = table.getRowCount();
    double total = 0;
    for(int i = 0 ; i < tableRowsNum ; i++){
       total += Double.parseDouble(table.getValueAt(i, 3).toString());
    }
    lb_TotalPrice.setText(String.valueOf(total));
    }
    
 }
    
     


 
      

         
          


