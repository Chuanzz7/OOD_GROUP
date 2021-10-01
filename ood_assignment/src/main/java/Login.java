import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * @author Alex Cheow
 **/
public class Login extends JFrame
        implements ActionListener
{

    JPanel Panel;
    JLabel Welcome_Title, Username, Password;
    JTextField Username_Input;
    JPasswordField Password_Input;
    JButton Login_Button;
    JOptionPane Message;
    static JFrame Frame;
    
    public static void main(String[] args) 
    {
        new Login();
        
    }
    
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
        Panel = new JPanel();
        
        Panel.add(Welcome_Title);
        Panel.add(Username);
        Panel.add(Username_Input);
        Panel.add(Password);
        Panel.add(Password_Input);
        Panel.add(Login_Button);
        Login_Button.addActionListener(this);
        add(Panel, BorderLayout.CENTER);
        setSize(600,600);
        setTitle("Login Page");
        //Center the Windows
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e)         
    {
        String Input_Username = Username_Input.getText();
        String Input_Password = Password_Input.getText();
        
        if(Input_Username.equals("Admin01") && Input_Password.equals("abc123"))
        {
            //When the Username & Password is correct, it will proceed to the Main Menu and close the previous Window. 
            MainMenu Proceed = new MainMenu();
            Proceed.GUI();
            setVisible(false);
            Frame.dispose();
            
            
        } 
        else
        {
            //Popout another window with message
             JOptionPane.showMessageDialog(null,"Login Failed!");
        }
     
        
    }
}
