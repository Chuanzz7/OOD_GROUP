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
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;
        
public class cartUI {
    //array to hold object item
    ArrayList<cartItem> cartItemArray  = new ArrayList<>();
     
    Panel frame = new Panel();
    JLabel lb_TotalPrice = new JLabel("Total Price: RM ");
    JLabel lb_ItemList = new JLabel("Item list:");
    JTextField TextTotalP = new JTextField(10);
    
    JTable table = new JTable();
    
    DefaultTableModel model = new DefaultTableModel()
        {
            //make the table uneditable except the delete button
        @Override
        public boolean isCellEditable(int row, int column)
        {
         switch (column) {
         case 4:
             return true;
         default:
             return false;
      }
        }
           
    };
    
    Font font1 = new Font("SansSerif", Font.BOLD, 30);
    Font font2 = new Font("SansSerif", Font.BOLD, 20);
    private final Object[] columns = {"Name","Quantity","Unit Price", "Price", "Button"};
    protected Object[] row = new Object[5];
    
    JScrollPane panel = new JScrollPane(table);
    
    public cartUI(){
      
        frame.setLayout(new FlowLayout());
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        
        frame.setSize(1000,800);
        TextTotalP.setEditable(false);
        lb_TotalPrice.setFont(font2);
        TextTotalP.setFont(font1);
        TextTotalP.setHorizontalAlignment(JTextField.RIGHT);

        frame.add(panel);
        frame.add(lb_TotalPrice);
        frame.add(TextTotalP);
        frame.setSize(900,400);
        frame.setVisible(true);
        table.setRowHeight(40);
         setJTableColumnsWidth(table, 480, 35, 15, 15, 15 ,20);
          ButtonColumn buttonColumn = new ButtonColumn(table, delete, 4);
        }
    
    //Set the table row and columns size by percentage
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
        double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (tablePreferredWidth * (percentages[i] / total)));
        }
    }
     
 //delete button
    Action delete = new AbstractAction()
   {
       @Override
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
    TextTotalP.setText(String.valueOf(total));
  }
  
  //export all the item from table into object and pass it to checkout
  public ArrayList exportTabletoArray(){
      int tableRowsNum = table.getRowCount();
      cartItemArray.clear();
      
       for(int i = 0 ; i < tableRowsNum ; i++){
            cartItemArray.add(new cartItem(table.getValueAt(i, 0).toString() ,Integer.parseInt(table.getValueAt(i, 1).toString()), Double.parseDouble(table.getValueAt(i, 2).toString()),  Double.parseDouble(table.getValueAt(i, 3).toString())));            
            }   
    return cartItemArray;
  }
    
 }
    
     


 
      

         
          


