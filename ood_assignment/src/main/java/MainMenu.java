import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;

/*
 * @author Alex Cheow
 */
public class MainMenu{
    cartUI cart1 = new cartUI();
    
    BufferedImage [] allImages;
    BufferedImage [] allImages2;
    static private JFrame frame;
    static private JButton Product_Btn, Service_Btn, Exit_Btn;
    static private JLabel NavTitle, NavTitle1, NavTitle2;
    //static private JTextField Text;
    //static private GridBagConstraints Grid; 
    //private JTable Table;
    DefaultTableModel dtm;
    double[] Service_Price;
    double[] Product_Price;
    double[] Total_Price;
    double Service_Price_1, Service_Price_2;
    double Product_Price_1, Product_Price_2;
    
    
    private JSpinner[] Service_Spinner;
    static private JLabel[] Service_Label;
    static private JButton[] ServiceButton;
    
    private JSpinner[] Product_Spinner;
    static private JLabel[] Product_Label;
    static private JButton[] ProductButton;
    
    //Make it only available within the class and does not allow the variable to be changed
    private static final int Services = 4;
    private static final int Products = 4;
    double Sum = 0;
    double Product_Sum_1, Product_Sum_2;
    double Service_Sum_1, Service_Sum_2;
    
    double Total_Product_Price;
    double Total_Service_Price;
    
    private JButton button_Checkout;
    private JButton button_EmptyCart;
        

    public void GUI()
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
        Exit_Btn = new JButton();
        
        cart1.frame.setBounds(1400, 100, 500, 500);
        
        JPanel Category = new JPanel();
        Category.setBackground(Color.BLACK);
        Category.setBounds(0,0,200,1080);
        
        
        frame.getContentPane().add(Category);
        
        
        
        Category.setLayout(null);

        NavTitle = new JLabel("WAVY");
        NavTitle1 = new JLabel("HAIR");
        NavTitle2 = new JLabel("SALOON");
        
        NavTitle.setFont(new Font("AR ESSENCE", Font.PLAIN, 35));
        NavTitle1.setFont(new Font("AR ESSENCE", Font.PLAIN, 35));
        NavTitle2.setFont(new Font("AR ESSENCE", Font.PLAIN, 35));
        
        NavTitle.setForeground(Color.WHITE);
        NavTitle1.setForeground(Color.WHITE);
        NavTitle2.setForeground(Color.WHITE);
        
      
        NavTitle.setBounds(50, 50, 160, 50);
        NavTitle1.setBounds(60, 80, 160, 50);
        NavTitle2.setBounds(25, 110, 160, 50);
        
        Category.add(NavTitle);
        Category.add(NavTitle1);
        Category.add(NavTitle2);
        
        //Create Buttons and Add It Into Navigation Bar
        Product_Btn = new JButton("Product");
        Product_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 26));
        Product_Btn.setForeground(Color.WHITE);
        Product_Btn.setBackground(Color.BLACK);
        Product_Btn.setBounds(28, 320, 160, 50);     
        Service_Btn = new JButton("Service");
        Category.add(Product_Btn);
        Product_Btn.setVisible(true);
        
        Service_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 26));
        Service_Btn.setForeground(Color.WHITE);
        Service_Btn.setBackground(Color.BLACK);
        Service_Btn.setBounds(28, 580, 160, 50);
        Category.add(Service_Btn);
        Service_Btn.setVisible(true);
        
        
        Exit_Btn = new JButton("Exit");
        Exit_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 26));
        Exit_Btn.setForeground(Color.WHITE);
        Exit_Btn.setBackground(Color.BLACK);
	Exit_Btn.setBounds(28, 980, 160, 50);
        Category.add(Exit_Btn);
        Exit_Btn.setVisible(true);
	
        Exit_Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                    //If the user click Exit Button, it will back to Login Page.
                    Login First_Page = new Login();
                    //First_Page.main(header);
                    First_Page.setVisible(true);
                    frame.dispose();
             
            }
        });
        
        button_EmptyCart = new JButton("Empty Cart");
        button_EmptyCart.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        button_EmptyCart.setBounds(1600, 800, 185,70);
        button_EmptyCart.setVisible(true);
        frame.add(button_EmptyCart);
        button_EmptyCart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            cart1.model.setRowCount(0);
            cart1.findTotal();
            }
        });
        
        
        button_Checkout = new JButton("Checkout");
        button_Checkout.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        button_Checkout.setBounds(1600, 900, 185,70);
        frame.add(button_Checkout);
        button_Checkout.setVisible(true);
        
        button_Checkout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                
                String total_Price = cart1.TextTotalP.getText();
                
                    Checkout ck = new Checkout();
                    ck.Checkout(total_Price , cart1.exportTabletoArray());
                    frame.dispose();

            }
    });
        
        
        //Create Services 
        JPanel panel_1 = new JPanel(new GridBagLayout());
        panel_1.setBackground(Color.yellow);
        panel_1.setBounds(300, 120,1000,800);
        
        //Hide the Panel
        panel_1.setVisible(false);
        GridBagConstraints gbc1 = new GridBagConstraints();  
        gbc1.insets = new Insets(10, 10, 0, 0);
        Service_Label = new JLabel[Services];
        Service_Spinner = new JSpinner[Services];
        ServiceButton = new JButton[Services];
        
        //Create Prices and Store Them into Array
        Service_Price = new double[Services];
        Service_Price[0] = 30;
        Service_Price[1] = 22;
        Service_Price[2] = 15;
        Service_Price[3] = 12;
        
        Service_Label[0] = new JLabel("Womens' Long Hair Cut - RM 30");
        Service_Label[1] = new JLabel("Womens' Short Hair Cut - RM 22");
        Service_Label[2] = new JLabel("Mens' Hair Cut - RM 15");
        Service_Label[3] = new JLabel("Children Hair Cut - RM 12");
  
        
        ServiceButton[0] = new JButton("Add");
        ServiceButton[0].addActionListener((ActionEvent e) -> {        
             addRowtoTable("Womens' Long Hair Cut",(Integer)Service_Spinner[0].getValue(), Service_Price[0]);
        });
        ServiceButton[1] = new JButton("Add");
        ServiceButton[1].addActionListener((ActionEvent e) -> {        
             addRowtoTable("Womens' Short Hair Cut",(Integer)Service_Spinner[1].getValue(), Service_Price[1]);
        });
        ServiceButton[2] = new JButton("Add");
        ServiceButton[2].addActionListener((ActionEvent e) -> {        
             addRowtoTable("Mens' Hair Cut",(Integer)Service_Spinner[2].getValue(), Service_Price[2]);
        });
        ServiceButton[3] = new JButton("Add");
        ServiceButton[3].addActionListener((ActionEvent e) -> {        
             addRowtoTable("Children Hair Cut",(Integer)Service_Spinner[3].getValue(), Service_Price[3]);
        });
 
        

              

        
    
        File path = new File("ServicesImg");
        File[] allFiles = path.listFiles();
        allImages = new BufferedImage[allFiles.length];
        JLabel Image[] = new JLabel[allFiles.length];
        
        for(int i = 0; i < allFiles.length; i ++)
        {       
            try{       
                allImages[i] = ImageIO.read(allFiles[i]);
                Image[i] = new JLabel();
                ImageIcon icon = new ImageIcon(allImages[i].getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
                Image[i].setIcon(icon);
                
                
                SpinnerNumberModel spnummodel = new SpinnerNumberModel(1,0,10,1);
                Service_Spinner[i] = new JSpinner(spnummodel);
                
                

                
                if(i % 3 == 0)
                {
                  gbc1.gridx += 2;
                  gbc1.gridy = 0;
                }
                
                
                
                //gridx is for row
  
                
                //gridy is for column

                panel_1.add(Image[i], gbc1);
                gbc1.gridy++;  // add one row for              
                panel_1.add(Service_Label[i], gbc1);               
                gbc1.gridy--; // remove row
                gbc1.gridx++; // move to next column  
                
                panel_1.add(Service_Spinner[i], gbc1);
                gbc1.gridx++;
                
                panel_1.add(ServiceButton[i], gbc1);
                gbc1.gridx++;

            }catch (IOException e){
                System.out.println(e);
            }
        }
           
        frame.add(panel_1);
        
    
        
        
        
        
   
        
        //Create Products
        JPanel panel_2 = new JPanel(new GridBagLayout());
        panel_2.setBackground(Color.GREEN);
        panel_2.setBounds(300, 120,1000,800);
        //Set it to Visible
        panel_2.setVisible(false);
        GridBagConstraints gbc2 = new GridBagConstraints();  
        gbc2.insets = new Insets(10, 10, 0, 0);
        Product_Label = new JLabel[Products];
        Product_Spinner = new JSpinner[Products];
        ProductButton = new JButton[Products];
        
        Product_Price = new double[Products];
        Product_Price[0] = 86;
        Product_Price[1] = 30;
        Product_Price[2] = 20;
        Product_Price[3] = 16;
        
        Product_Label[0] = new JLabel("Royal Spa Hair Shampoo - RM 86");
        Product_Label[1] = new JLabel("Roreal Paris Hair Oil - RM 30");
        Product_Label[2] = new JLabel("JOICE Hair Conditioner - RM 20");
        Product_Label[3] = new JLabel("Roreal Paris Hair Spray - RM 16");
  
        
        ProductButton[0] = new JButton("Add");
        ProductButton[0].addActionListener((ActionEvent e) -> {        
             addRowtoTable("Royal Spa Hair Shampoo",(Integer)Product_Spinner[0].getValue(), Product_Price[0]);
        });
        
        ProductButton[1] = new JButton("Add");
        ProductButton[1].addActionListener((ActionEvent e) -> {
             addRowtoTable("Roreal Paris Hair Oil", (Integer)Product_Spinner[1].getValue(), Product_Price[1]);
        });
        ProductButton[2] = new JButton("Add");
        ProductButton[2].addActionListener((ActionEvent e) -> {
             addRowtoTable("JOICE Hair Conditioner", (Integer)Product_Spinner[2].getValue(), Product_Price[2]);
        });
        ProductButton[3] = new JButton("Add");
        ProductButton[3].addActionListener((ActionEvent e) -> {
             addRowtoTable("Roreal Paris Hair Spray", (Integer)Product_Spinner[3].getValue(), Product_Price[3]);
        });
 
        
        
        
        File path2 = new File("ProductsImg");
        File[] allFiles2 = path2.listFiles();
        allImages2 = new BufferedImage[allFiles2.length];
        JLabel Image2[] = new JLabel[allFiles2.length];
        
        for(int i = 0; i < allFiles2.length; i++)
        {
            try{
                
                allImages2[i] = ImageIO.read(allFiles2[i]);
                Image2[i] = new JLabel();
                ImageIcon icon2 = new ImageIcon(allImages2[i].getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
                Image2[i].setIcon(icon2);
                
                
                SpinnerNumberModel spnummodel2 = new SpinnerNumberModel(1,0,10,1);
                Product_Spinner[i] = new JSpinner(spnummodel2);
                        
                if(i % 3 == 0)
                {
                  gbc2.gridx += 2;
                  gbc2.gridy = 0;
                }
                
                
                //gridx is for row
  
                
                //gridy is for column

                panel_2.add(Image2[i], gbc2);
                gbc2.gridy++;  // add one row for              
                panel_2.add(Product_Label[i], gbc2);               
                gbc2.gridy--; // remove row
                gbc2.gridx++; // move to next column  
                
                panel_2.add(Product_Spinner[i], gbc2);
                gbc2.gridx++;
                
                panel_2.add(ProductButton[i], gbc2);
                gbc2.gridx++;

            }catch (IOException ex){
                System.out.println(ex);
            }
        }
             
        
        frame.add(panel_2);
        
        
        
     Service_Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(panel_1.isEnabled())
                {
                    panel_2.setVisible(false);
                    panel_1.setVisible(true);
                }
                else if(panel_2.isEnabled())
                {
                    panel_1.setVisible(false);
                    panel_2.setVisible(true);
                }
            
            }
        });
     Product_Btn.addActionListener (new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            if(panel_2.isEnabled())
            {
                panel_1.setVisible(false);
                panel_2.setVisible(true);
            }
            else if(panel_1.isEnabled())
            {
                panel_2.setVisible(false);
                panel_1.setVisible(true);
            }

        }
     });
     frame.add(cart1.frame);
     frame.setVisible(true);
    }
    
    //adding row into the table 
    public void addRowtoTable(String _itemName, int _itemQuantity, double _unitPrice){
        if(_itemQuantity >0){
            int tableRowsNum = cart1.table.getRowCount();
                cart1.row[0] = _itemName;
                cart1.row[1] = _itemQuantity;
                cart1.row[2] = _unitPrice;
                cart1.row[3] = _itemQuantity * _unitPrice;
                cart1.row[4] = "delete";
                if (tableRowsNum == 0){
                    cart1.model.addRow(cart1.row); 
                    cart1.findTotal();
                }
                else{
                //if item is already in cart
                    for(int i = 0 ; i < tableRowsNum ; i++){
                        if( _itemName  == cart1.table.getValueAt(i, 0).toString()){ 
                            int quantity = Integer.parseInt(cart1.table.getValueAt(i, 1).toString());
                            cart1.table.setValueAt(quantity+_itemQuantity ,i,1);
                            cart1.table.setValueAt(Double.parseDouble(cart1.table.getValueAt(i, 1).toString()) * Double.parseDouble(cart1.table.getValueAt(i, 2).toString()),i,3);
                            cart1.findTotal();                    
                            break;
                        }

                        // add row to the model
                        else if(i == tableRowsNum-1){
                            cart1.model.addRow(cart1.row); 
                            cart1.findTotal();
                            break;
                        }
                    }
                }
            }
        }

}
