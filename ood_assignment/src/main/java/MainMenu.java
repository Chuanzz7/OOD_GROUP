import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
/*
 * @author Alex Cheow
 */
public class MainMenu {
    static private JFrame frame;
    static private JButton Product_Btn, Service_Btn, Back_Btn, Order_Btn;
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }

    
}
