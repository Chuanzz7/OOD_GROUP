import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.SpinnerNumberModel;
import java.io.File;
import static javax.swing.JOptionPane.showMessageDialog;


/*
 * @author Alex Cheow
 */
public class MainMenu{
    cartUI cart1 = new cartUI();
    
    BufferedImage [] allImages;
    BufferedImage [] allImages2;
    BufferedImage MainBackground;
    BufferedImage SaloonLogo;
    static private JFrame frame;
    static private JButton Product_Btn, Service_Btn, Exit_Btn;
    static private JTextField Title;
    double[] Service_Price;
    double[] Product_Price;
    
    
    private JSpinner[] Service_Spinner;
    static private JLabel[] Service_Label;
    static private JButton[] ServiceButton;
    
    private JSpinner[] Product_Spinner;
    static private JLabel[] Product_Label;
    static private JButton[] ProductButton;
    
    private static final int Services = 4;
    private static final int Products = 4;
    
    
    private JButton button_Checkout;
    private JButton button_EmptyCart;
        

    public void GUI()
    {
        
        frame = new JFrame("Main Menu");
        frame.setSize(1920,1080);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        
        
        
        frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Alex Cheow\\Desktop\\SEM 5\\Object Oriented Development\\Assignment\\OOD_Assignment\\OOD_GROUP\\ood_assignment\\Background\\MainBack.jpg")));
        
        
        Title = new JTextField(12);
        Title = new JTextField("");
        Title.setSize(250, 100);
        Font TitleFont = new Font("Courier", Font.BOLD,45);
        Title.setFont(TitleFont);
        Title.setBorder(null);
        Title.setOpaque(false);
        Title.setLocation(700, 60);
        
        
        Product_Btn = new JButton();
        Service_Btn = new JButton();  
        Exit_Btn = new JButton();
        
        cart1.frame.setBounds(1400, 100, 500, 500);
        
        JPanel Category = new JPanel();
        Category.setBackground(Color.BLACK);
        Category.setBounds(0,0,200,1080);
        try{
            SaloonLogo = ImageIO.read(new File("C:\\Users\\Alex Cheow\\Desktop\\SEM 5\\Object Oriented Development\\Assignment\\OOD_Assignment\\OOD_GROUP\\ood_assignment\\Logo\\Logo.png"));
            
            JLabel Lgo = new JLabel(new ImageIcon(SaloonLogo.getScaledInstance(180, 130, Image.SCALE_SMOOTH)));
            Lgo.setBounds(10, 10, 180, 145);
            
            Category.add(Lgo);
        }catch(IOException e){
            System.out.println(e);
        }
        
        
        frame.getContentPane().add(Category);
        
        
        
        Category.setLayout(null);

        
        

        Product_Btn = new JButton("PRODUCT");
        Product_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 25));
        Product_Btn.setForeground(Color.WHITE);
        Product_Btn.setBackground(Color.BLACK);
        Product_Btn.setBounds(28, 320, 160, 50); 
        Category.add(Product_Btn);
        Product_Btn.setVisible(true);
        
        
        
                
        Service_Btn = new JButton("SERVICE"); 
        Service_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 25));
        Service_Btn.setForeground(Color.WHITE);
        Service_Btn.setBackground(Color.BLACK);
        
        Service_Btn.setBounds(28, 580, 160, 50);
        Category.add(Service_Btn);
        Service_Btn.setVisible(true);
        
        
        Exit_Btn = new JButton("EXIT");
        Exit_Btn.setFont(new Font ("AR ESSENCE", Font.PLAIN, 26));
        Exit_Btn.setForeground(Color.WHITE);
        Exit_Btn.setBackground(Color.BLACK);
	Exit_Btn.setBounds(28, 980, 160, 50);
        Category.add(Exit_Btn);
        Exit_Btn.setVisible(true);
	
        Exit_Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                    Login First_Page = new Login();
                    First_Page.setVisible(true);
                    frame.dispose();      
            }
        });
        
        //button to empty cart
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
        
        //button to checkout the cart
        button_Checkout = new JButton("Checkout");
        button_Checkout.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        button_Checkout.setBounds(1600, 900, 185,70);
        frame.add(button_Checkout);
        button_Checkout.setVisible(true);
        
        button_Checkout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int row = cart1.table.getRowCount();
                
                if(row > 0)
                {
                    String total_Price = cart1.TextTotalP.getText();
                
                    Checkout ck = new Checkout();
                    ck.Checkout(total_Price , cart1.exportTabletoArray(), row);
                    frame.dispose();
                }
                else
                {
                    showMessageDialog(null, "Please select a product");
                }
            }
    });
        
        
        
         
        JPanel panel_1 = new JPanel(new GridBagLayout());
        panel_1.setBounds(300, 120,1000,800);
        panel_1.setOpaque(false);
        
        
        
        panel_1.setVisible(false);
        GridBagConstraints gbc1 = new GridBagConstraints();  
        gbc1.insets = new Insets(10, 10, 0, 0);
        Service_Label = new JLabel[Services];
        Service_Spinner = new JSpinner[Services];
        ServiceButton = new JButton[Services];
        

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
 
        
        //import and display the image
        File path = new File("ServicesImg");
        File[] allFiles = path.listFiles();
        allImages = new BufferedImage[allFiles.length];
        JLabel Image[] = new JLabel[allFiles.length];
        
        for(int i = 0; i < allFiles.length; i ++)
        {       
            try{       
                allImages[i] = ImageIO.read(allFiles[i]);
                Image[i] = new JLabel();
                ImageIcon icon = new ImageIcon(allImages[i].getScaledInstance(265, 265, java.awt.Image.SCALE_SMOOTH));
                Image[i].setIcon(icon);
                Service_Label[i].setOpaque(true);
                
                SpinnerNumberModel spnummodel = new SpinnerNumberModel(1,0,10,1);
                Service_Spinner[i] = new JSpinner(spnummodel);
                Service_Label[i].setFont(new Font("Courier New", Font.PLAIN, 18));
                
                
            }catch (IOException e){
                System.out.println(e);
            }
        }
            
        gbc1.weightx = 0.5;
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        panel_1.add(Image[0], gbc1);
        gbc1.gridy = 2;
        panel_1.add(Service_Label[0], gbc1);
        gbc1.gridy = 4;
        panel_1.add(Service_Spinner[0], gbc1);
        gbc1.gridy = 5;
        panel_1.add(ServiceButton[0], gbc1);
        
        
        
        
        gbc1.weightx = 0.5;
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        panel_1.add(Image[1], gbc1);
        gbc1.gridy = 2;
        panel_1.add(Service_Label[1], gbc1);
        gbc1.gridy = 4;
        panel_1.add(Service_Spinner[1], gbc1);
        gbc1.gridy = 5;
        panel_1.add(ServiceButton[1], gbc1);
        
        
        
        gbc1.weightx = 0.5;
        gbc1.gridx = 0;
        gbc1.gridy = 6;
        panel_1.add(Image[2], gbc1);
        gbc1.gridy = 8;
        panel_1.add(Service_Label[2], gbc1);
        gbc1.gridy = 10;
        panel_1.add(Service_Spinner[2], gbc1);
        gbc1.gridy = 11;
        panel_1.add(ServiceButton[2], gbc1);
        
        
        
        gbc1.weightx = 0.5;
        gbc1.gridx = 1;
        gbc1.gridy = 6;
        panel_1.add(Image[3], gbc1);
        gbc1.gridy = 8;
        panel_1.add(Service_Label[3], gbc1);
        gbc1.gridy = 10;
        panel_1.add(Service_Spinner[3], gbc1);
        gbc1.gridy = 11;
        panel_1.add(ServiceButton[3], gbc1);
        
        
           
        frame.add(panel_1);
        
        
        
   
        
        JPanel panel_2 = new JPanel(new GridBagLayout());
        panel_2.setBounds(300, 120,1000,800);
        panel_2.setOpaque(false);
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
 
        
        
        //import and display the product image
        File path2 = new File("ProductsImg");
        File[] allFiles2 = path2.listFiles();
        allImages2 = new BufferedImage[allFiles2.length];
        JLabel Image2[] = new JLabel[allFiles2.length];
        
        for(int i = 0; i < allFiles2.length; i++)
        {
            try{
                
                allImages2[i] = ImageIO.read(allFiles2[i]);
                Image2[i] = new JLabel();
                ImageIcon icon2 = new ImageIcon(allImages2[i].getScaledInstance(265, 265, java.awt.Image.SCALE_SMOOTH));
                Image2[i].setIcon(icon2);
                Product_Label[i].setOpaque(true);
                
                SpinnerNumberModel spnummodel2 = new SpinnerNumberModel(1,0,10,1);
                Product_Spinner[i] = new JSpinner(spnummodel2);     
                Product_Label[i].setFont(new Font("Courier New", Font.PLAIN, 18));
                
            }catch (IOException ex){
                System.out.println(ex);
            }
        }
             
        gbc2.weightx = 0.5;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        panel_2.add(Image2[0], gbc2);
        gbc2.gridy = 2;
        panel_2.add(Product_Label[0], gbc2);
        gbc2.gridy = 4;
        panel_2.add(Product_Spinner[0], gbc2);
        gbc2.gridy = 5;
        panel_2.add(ProductButton[0], gbc2);
        
        
        
        
        gbc2.weightx = 0.5;
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        panel_2.add(Image2[1], gbc2);
        gbc2.gridy = 2;
        panel_2.add(Product_Label[1], gbc2);
        gbc2.gridy = 4;
        panel_2.add(Product_Spinner[1], gbc2);
        gbc2.gridy = 5;
        panel_2.add(ProductButton[1], gbc2);
        
        
        
        gbc2.weightx = 0.5;
        gbc2.gridx = 0;
        gbc2.gridy = 6;
        panel_2.add(Image2[2], gbc2);
        gbc2.gridy = 8;
        panel_2.add(Product_Label[2], gbc2);
        gbc2.gridy = 10;
        panel_2.add(Product_Spinner[2], gbc2);
        gbc2.gridy = 11;
        panel_2.add(ProductButton[2], gbc2);
        
        
        
        gbc2.weightx = 0.5;
        gbc2.gridx = 1;
        gbc2.gridy = 6;
        panel_2.add(Image2[3], gbc2);
        gbc2.gridy = 8;
        panel_2.add(Product_Label[3], gbc2);
        gbc2.gridy = 10;
        panel_2.add(Product_Spinner[3], gbc2);
        gbc2.gridy = 11;
        panel_2.add(ProductButton[3], gbc2);
        
        frame.add(panel_2);
        frame.add(Title);
        
     //display the service panel
     Service_Btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(panel_1.isEnabled())
                {
                    panel_2.setVisible(false);
                    panel_1.setVisible(true);
                    Title.setText("SERVICES");
                }
                else if(panel_2.isEnabled())
                {
                    panel_1.setVisible(false);
                    panel_2.setVisible(true);
                    Title.setText("PRODUCTS");
                }
            
            }
        });
     
     //display the product panel
     Product_Btn.addActionListener (new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            if(panel_2.isEnabled())
            {
                panel_1.setVisible(false);
                panel_2.setVisible(true);
                Title.setText("PRODUCTS");
            }
            else if(panel_1.isEnabled())
            {
                panel_2.setVisible(false);
                panel_1.setVisible(true);
                Title.setText("SERVICES");
            }

        }
     });
     frame.add(cart1.frame);
     frame.setVisible(true);
    }
    
    //adding row into the cart table 
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
