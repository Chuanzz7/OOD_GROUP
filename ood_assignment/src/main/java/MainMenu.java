import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
/*
 * @author Alex Cheow
 */
public class MainMenu {
    static private JFrame frame;
    static private JButton Product_Btn, Service_Btn, Exit_Btn, Checkout_Btn;
    static private JTextField Text;
    static private GridBagConstraints Grid; 
    private JTable Table;
    DefaultTableModel dtm;
    double[] Service_Price;
    double[] Product_Price;
    double Total_Price;
    double Service_Price_1, Service_Price_2;
    double Product_Price_1, Product_Price_2;

    private JSpinner[] Service_Spinner;
    static private JLabel[] Service_Label;
    static private JLabel[] Service_Image;
    private String[] Service_files;
    
    private JSpinner[] Product_Spinner;
    static private JLabel[] Product_Label;
    static private JLabel[] Product_Image;
    private String[] Product_files;
    
    //Make it only available within the class and does not allow the variable to be changed
    private static final int Services = 2;
    private static final int Products = 2;
    double Sum = 0;
    double Product_Sum_1, Product_Sum_2;
    double Service_Sum_1, Service_Sum_2;
    
    double Total_Product_Price;
    double Total_Service_Price;
    
    void GUI()
    {
        frame = new JFrame("Main Menu");
        frame.setBounds(100,100,750,550);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        
        Product_Btn = new JButton();
        Service_Btn = new JButton();
        Table = new JTable();
        Exit_Btn = new JButton();
        Checkout_Btn = new JButton();
        dtm = new DefaultTableModel(0,0);
        final String header[] = new String[] 
        {
            "Item", "Quantity", "Price", "Spinner"
        };
        dtm.setColumnIdentifiers(header);
        dtm.addRow(header);
        
        //Create Table
        Table = new JTable();
	Table.setModel(dtm);
        
        // int x, int y, int width, int height
	Table.setBounds(475, 31, 1, 1); 
        
        // width,height
	Table.setSize(245, 300); 
	Table.getColumnModel().getColumn(0).setPreferredWidth(80);
	Table.getColumnModel().getColumn(1).setPreferredWidth(30);
	Table.getColumnModel().getColumn(2).setPreferredWidth(30);
        
        // hide spinner
	Table.getColumnModel().getColumn(3).setMinWidth(0); 
        Table.getColumnModel().getColumn(3).setMaxWidth(0); 
        
        // remove cell boarder
        Table.setShowGrid(false); 
        
        //add table to GUI
        frame.getContentPane().add(Table);
        JLabel Total = new JLabel("Total: RM");
        Total.setBounds(585, 340, 86, 20);
        Text = new JTextField();
	Text.setBounds(585, 340, 86, 20);
	frame.getContentPane().add(Text);
	Text.setColumns(12);
        Checkout_Btn = new JButton("Checkout");
        Checkout_Btn.setBounds(500, 385, 89, 23);
        frame.getContentPane().add(Checkout_Btn);
        Exit_Btn = new JButton("Exit");
	Exit_Btn.setBounds(610, 385, 89, 23);
	frame.getContentPane().add(Exit_Btn);
        
        JPanel Category = new JPanel();
        Category.setBackground(Color.BLACK);
        Category.setBounds(0,0,45,388);
        Category.setSize(45,500);
        frame.getContentPane().add(Category);
        Category.setLayout(null);
        
        
	frame.setVisible(true);
    }

    
}
