import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author Jason
 */

public class Checkout extends JFrame implements ActionListener
{
    
 
    
    /*private JButton paid;
    private JButton cancel;
    private JLabel Checkout_Title;
    private JTextField cashin;
    private JTextField change;
    private JLabel Total;
    private JLabel Change;*/
    private JButton pay;
    private JButton cancel;
    private JLabel checkout;
    private JTextField changetxt;
    private JTextField paytxt;
    private JLabel total;
    private JLabel change;

    public static void main(String[] args) {
        
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Checkout());
        frame.pack();
        frame.setVisible (true);
    }
    
    public Checkout(){
        
        //construct components
        pay = new JButton ("Pay");
        cancel = new JButton ("Cancel");
        checkout = new JLabel ("Checkout");
        changetxt = new JTextField (5);
        paytxt = new JTextField (5);
        total = new JLabel ("Total");
        change = new JLabel ("Change");

        //set components properties
        paytxt.setEnabled (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (622, 422));
        setLayout (null);
        setSize(622,422);

        //add components
        add (pay);
        add (cancel);
        add (checkout);
        add (changetxt);
        add (paytxt);
        add (total);
        add (change);

        //set component bounds (only needed by Absolute Positioning)
        pay.setBounds (175, 285, 105, 40);
        cancel.setBounds (360, 285, 105, 40);
        checkout.setBounds (280, 20, 110, 35);
        changetxt.setBounds (380, 175, 125, 40);
        paytxt.setBounds (380, 110, 125, 40);
        total.setBounds (125, 110, 105, 30);
        change.setBounds (125, 180, 100, 25);
        
        
        
        /*paid = new JButton("Pay");
        cancel = new JButton("Cancel");
        Checkout_Title = new JLabel("Checkout");
        cashin = new JTextField(5);
        change = new JTextField(5);
        Total = new JLabel("Total");
        Change = new JLabel("Change");
        
        change.setEnabled(false);
        
        setPreferredSize(new Dimension(1980,1060));        
        setLayout(new BorderLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(622,422);
        setTitle("Check Out List");
        
        
        add(paid);
        add(cancel);
        add(Checkout_Title);
        add(cashin);
        add(change);
        add(Total);
        add(Change);
        
        paid.setBounds (165, 285, 105, 40);
        cancel.setBounds (360, 285, 105, 40);
        Checkout_Title.setBounds (280, 20, 110, 35);
        cashin.setBounds (380, 175, 125, 40);
        change.setBounds (380, 110, 125, 40);
        Total.setBounds (125, 110, 105, 30);
        Change.setBounds (125, 180, 100, 25);
        
        Font Design_1 = new Font("TimesRoman", Font.PLAIN, 50);
        Font Design_2 = new Font("Courier", Font.PLAIN, 75);
        Font Design_3 = new Font("TimesRoman", Font.PLAIN, 30);
        
        paid.setFont(Design_1);
        cancel.setFont(Design_1);
        Checkout_Title.setFont(Design_2);
        cashin.setFont(Design_1);
        change.setFont(Design_1);
        Total.setFont(Design_1);
        Change.setFont(Design_1);
        
        cashin.setPreferredSize(new Dimension(160,18));
        Change.setPreferredSize(new Dimension(160,18));
        Total.setPreferredSize(new Dimension(160,18));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        
       /*setPreferredSize(new Dimension(1920,1080));        
        setLayout(new BorderLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
        setTitle("Check Out List");
        Top.setLayout(new FlowLayout());
        
        
      
        
        
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
        
        */
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
  
        
    }
}
