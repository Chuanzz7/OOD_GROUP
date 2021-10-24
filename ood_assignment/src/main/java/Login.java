import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
/**
 * @author Alex Cheow
 **/

public class Login extends JFrame
        implements ActionListener
{
    private  String Input_Username;
    private String Input_Password;
    JLabel Welcome_Title, Username, Password;
    JTextField Username_Input;
    JPasswordField Password_Input;
    JButton Login_Button;
    JOptionPane Message;
    
    
    public Login()
    {    
        Font Design_1 = new Font("TimesRoman", Font.PLAIN, 20);
        Font Design_2 = new Font("Courier", Font.PLAIN, 30);
        //Title (Shop Name)  
        Welcome_Title = new JLabel("WELCOME TO WAVY HAIR SALON");
        Welcome_Title.setFont(Design_2);
        
        //Allow Admin To Enter The Username      
        Username = new JLabel();
        Username.setText("Username: ");
        Username.setFont(Design_1);
        Username_Input = new JTextField();
        Username_Input.setPreferredSize(new Dimension(160, 18));
        
        //Allow Admin To Enter Password
        Password = new JLabel();
        Password.setText("Password: ");
        Password.setFont(Design_1);
        Password_Input = new JPasswordField();
        Password_Input.setPreferredSize(new Dimension(160, 18));
        
        //Login
        Login_Button = new JButton("Login");
        JFrame frame = new JFrame();
        setContentPane(new JLabel(new ImageIcon("Background/LoginBackground.jpg")));
            
        add(Welcome_Title);
        add(Username);
        add(Username_Input);
        add(Password);
        add(Password_Input);
        add(Login_Button);
        
        Username.setBounds(50, 100, 100, 30);
        Username_Input.setBounds(140, 105, 180, 30);
        Password.setBounds(50, 142, 100, 30);
        Password_Input.setBounds(140, 145, 180, 30);
        Login_Button.setBounds(160, 190, 100, 40);
        
         
        Login_Button.addActionListener(this);
        setPreferredSize(new Dimension (425, 275));
        setLayout(null);
        setSize(425,310);
        setTitle("Login Page");
        //Center the Windows
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
             
    }
   
    public void actionPerformed(ActionEvent e)         
    {
         Input_Username = Username_Input.getText();
         Input_Password = Password_Input.getText();
        
        if(Input_Username.equals("Admin01") && Input_Password.equals("abc123"))
        {
            //When the Username & Password is correct, it will proceed to the Main Menu and close the previous Window. 
            MainMenu Proceed = new MainMenu();
            Proceed.GUI();
            this.dispose();
            setVisible(false);
                
        } 
        else
        {
            //Popout another window with message
             JOptionPane.showMessageDialog(null,"Login Failed!");
        }     
    }
}
