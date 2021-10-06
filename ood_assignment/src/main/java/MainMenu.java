import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.SpinnerNumberModel;
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
    double[] Total_Price;
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
        //frame.setBounds(100,100,750,550);
        frame.setSize(1920,1080);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        
        Product_Btn = new JButton();
        Service_Btn = new JButton();
        //Table = new JTable();
        Exit_Btn = new JButton();
        //Checkout_Btn = new JButton();
        //dtm = new DefaultTableModel(0,0);
        //final String header[] = new String[] 
        //{
            //"Item", "Quantity", "Price", "Spinner"
        //};
        //dtm.setColumnIdentifiers(header);
        //dtm.addRow(header);
        
        //Create Table
        //Table = new JTable();
	//Table.setModel(dtm);
        
        // int x, int y, int width, int height
	//Table.setBounds(1485, 75, 100, 25); 
        
        // width,height
	//Table.setSize(245, 300); 
	//Table.getColumnModel().getColumn(0).setPreferredWidth(80);
	//Table.getColumnModel().getColumn(1).setPreferredWidth(30);
	//Table.getColumnModel().getColumn(2).setPreferredWidth(30);
        
        // hide spinner
	//Table.getColumnModel().getColumn(3).setMinWidth(0); 
        //Table.getColumnModel().getColumn(3).setMaxWidth(0); 
        
        // remove cell boarder
        //Table.setShowGrid(false); 
        
        //add table to GUI
        //frame.getContentPane().add(Table);
        //JLabel Total = new JLabel("Total: RM");
        //Total.setBounds(1350, 700, 100, 25);
        //Text = new JTextField();
	//Text.setBounds(1400, 700, 100, 25);
	//frame.getContentPane().add(Text);
	//Text.setColumns(12);
        //Checkout_Btn = new JButton("Checkout");
        //Checkout_Btn.setBounds(1455, 770, 100, 25);
       // frame.getContentPane().add(Checkout_Btn);
        
        
        JPanel Category = new JPanel();
        Category.setBackground(Color.BLACK);
        Category.setBounds(0,0,200,1080);
        //Category.setSize(45,500);
        frame.getContentPane().add(Category);
        
        
        
        Category.setLayout(null);
        
        //Create Buttons
        Product_Btn = new JButton("Product");
        Product_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 24));
        Product_Btn.setForeground(Color.WHITE);
        Product_Btn.setBackground(Color.BLACK);
        Product_Btn.setBounds(30, 235, 160, 50);     
        Service_Btn = new JButton("Service");
        Category.add(Product_Btn);
        Product_Btn.setVisible(true);
        
        Service_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 24));
        Service_Btn.setForeground(Color.WHITE);
        Service_Btn.setBackground(Color.BLACK);
        Service_Btn.setBounds(30, 420, 160, 50);
        Category.add(Service_Btn);
        Service_Btn.setVisible(true);
        
        
        
        Exit_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 24));
        Exit_Btn = new JButton("Exit");
        Exit_Btn.setForeground(Color.WHITE);
        Exit_Btn.setBackground(Color.BLACK);
	Exit_Btn.setBounds(30, 600, 160, 50);
        Category.add(Exit_Btn);
        Exit_Btn.setVisible(true);
	
        Exit_Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
        
                    Login First_Page = new Login();
                    //First_Page.main(header);
                    First_Page.setVisible(true);
                    frame.dispose();
             
            }
        });
        //JPanel Mainpanel = new JPanel(new GridBagLayout());
        //Mainpanel.setBounds(300, 120,1000,800);
        //Mainpanel.setBackground(Color.GREEN);
        //Mainpanel.setVisible(true);
        //frame.add(Mainpanel);
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.yellow);
        panel_1.setBounds(300, 120,1000,800);
        panel_1.setVisible(false);
        //GridBagConstraints gbc = new GridBagConstraints();
        
        frame.add(panel_1);
     Service_Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
        
                try {
                    Service_Page(panel_1);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                    
             
            }
        });
	frame.setVisible(true);
    }
    
    
    void Service_Page(JPanel panel_1) throws IOException{
    {
        panel_1.setVisible(true);
        //JPanel panel_1 = new JPanel();
        //panel_1.setBackground(Color.yellow);
        //panel_1.setBounds(300, 120,1000,800);
        //GridBagConstraints gbc = new GridBagConstraints();
        
        //frame.add(panel_1);
        //panel_1.setVisible(true);
        //JOptionPane.showMessageDialog(null, "Can Function");
        //frame.validate();
        //gbc.insets = new Insets(10, 0, 0, 0);
        //Service_Image = new JLabel[Services];
        //Service_Label = new JLabel[Services];
        //Service_Spinner = new JSpinner[Services];
        //Service_files = new String[Services];
        //Total_Price = new double[Services];
        
        
        //Service_files[0] = ("../Short_Hair.jpg");
        //Service_files[1] = ("../Short_Hair2.jpg");
        //Service_Label[0] = new JLabel("Testing_1");
        //Service_Label[1] = new JLabel("Testing_2");
        //Total_Price[0] = 5.50;
        //Total_Price[1] = 10.90;
        
        
        
        //for(int i = 0; i < Services; i++)
        //{
            //System.out.println(Service_files[i]);
            //try
            //{
                //Image Test_Image = ImageIO.read(this.getClass().getResource(Service_files[i]));
                //Image ImageScaled = Test_Image.getScaledInstance(80,95,Image.SCALE_SMOOTH);
                
                //ImageIcon imageicon_test = new ImageIcon(ImageScaled);     
                //SpinnerNumberModel Num_Model_Test = new SpinnerNumberModel(0,0,10,1);
                //Service_Spinner[i] = new JSpinner(Num_Model_Test);
                //Service_Spinner[i] = new JSpinner();
                //Service_Image[i] = new JLabel(imageicon_test);
            //}catch(Exception e)
            //{
                //System.out.println(e);
            //}
        //}
        
        //gbc.gridx = 0;
        //for(int i = 0; i < Services; i++)
        //{
            //if(i % 3 == 0)
            //{
                //gbc.gridx += 2;
                //gbc.gridy = 0;
            //}
            //panel.add(Service_Image[i], gbc);
            //gbc.gridy++;
            //panel.add(Service_Label[i], gbc);
            //gbc.gridy--;
            //gbc.gridx++;
            //panel.add(Service_Spinner[i], gbc);
	    //gbc.gridx++;
            //Mainpanel.add(panel);
        //}
    }
    }

    
}
