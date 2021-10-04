import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Jason
 */

public class Checkout extends JFrame implements ActionListener
{
    
    JLabel Checkout_Title , Totalprice, Cashin, Change;
    JTextField totalprice;
    JTextField cashin;
    JTextField change;
    JCheckBox cbox;
    JButton paid;
    JButton cancel;

    public static void main(String[] args) {
        
        new Checkout(); 
    }
    
    public Checkout(){
        
        JPanel Top = new JPanel();
        Top.setLayout(new FlowLayout());
        JPanel Middle = new JPanel();
        Middle.setLayout(new FlowLayout());
        JPanel Bottom = new JPanel();
        Bottom.setLayout(new FlowLayout());
        
        setPreferredSize(new Dimension(1920,1080));        
        setLayout(new BorderLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
        setTitle("Check Out List");
        Top.setLayout(new FlowLayout());
        
        
        Font Design_1 = new Font("TimesRoman", Font.PLAIN, 50);
        Font Design_2 = new Font("Courier", Font.PLAIN, 75);
        Font Design_3 = new Font("TimesRoman", Font.PLAIN, 30);
        
        
        Checkout_Title = new JLabel ("CHECK OUT  LIST");
        Checkout_Title.setFont(Design_2);
        
        Totalprice = new JLabel();
        Totalprice.setText("         Total Price : ");
        Totalprice.setFont(Design_1);
        totalprice = new JTextField();
        totalprice.setPreferredSize(new Dimension(160,18));
        
        
        Cashin = new JLabel();
        Cashin.setText("           Cash In : ");
        Cashin.setFont(Design_1);
        cashin = new JTextField();
        cashin.setPreferredSize(new Dimension(160,18));
        
        
        Change = new JLabel();
        Change.setText ("       Change : ");
        Change.setFont(Design_1);
        change = new JTextField();
        change.setPreferredSize(new Dimension(160,18));
        
        
        cbox = new JCheckBox("Save Receipt");
        cbox.setFont(Design_3);
        
        paid = new JButton("PAID");
        paid.setFont(Design_1);
        
        cancel = new JButton("CANCEL");
        cancel.setFont(Design_1);
        
          add(Checkout_Title);
          add(Totalprice);
          add(Cashin);
          add(Change);
          add(totalprice);
          add(cashin);
          add(change);
          add(cbox);
          add(paid);
          add(cancel);
   
          Top.add(Checkout_Title);
        add("North", Top);

        Middle.add(Totalprice);
        add("West" , Middle);

        Middle.add(totalprice);
        add("West" , Middle);

        Middle.add(Cashin);
        add("West" , Middle);

        Middle.add(cashin);
        add("West" , Middle);

        Middle.add(Change);
        add("West" , Middle);

        Middle.add(change);
        add("West" , Middle);

        Middle.add(cbox);
        add("West" , Middle);

        Bottom.add(paid);
        add("South" , Bottom);

        Bottom.add(cancel);
        add("South" , Bottom);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
  
        
    }
}
