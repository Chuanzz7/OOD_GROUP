import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JOptionPane;
import java.text.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;


public class Checkout extends JFrame implements ActionListener
{ 
    private JButton confirm;
    private JButton cancel;
    private JTextField totalTxt;
    private JTextField paidTxt;
    private JTextField changeTxt;
    private JLabel total;
    private JLabel paid;
    private JLabel change;
    private JCheckBox receipt;
    private JLabel checkout;
    private JButton done;
    ArrayList<cartItem> productReceipt = new ArrayList<>();
    private int contentRow;
    
    
    
    public void Checkout(String TP , ArrayList<cartItem> cartItemArray, int cartRow){
        //construct components
        confirm = new JButton ("Confirm");
        cancel = new JButton ("Cancel");
        totalTxt = new JTextField (TP, 10);
        paidTxt = new JTextField (5);
        changeTxt = new JTextField (5);
        total = new JLabel ("Total");
        paid = new JLabel ("Amount Paid");
        change = new JLabel ("Change");
        receipt = new JCheckBox ("Save Receipt");
        checkout = new JLabel ("Checkout");
        done = new JButton ("Done");
        
        contentRow = cartRow;
        
        productReceipt = cartItemArray;
        
        //disable txtbox
        totalTxt.setEnabled (false);
        changeTxt.setEnabled (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (744, 430));
        setLayout (null);
        setSize(744,430);
        setTitle("Checkout");

        //add components
        add (confirm);
        add (cancel);
        add (totalTxt);
        add (paidTxt);
        add (changeTxt);
        add (total);
        add (paid);
        add (change);
        add (receipt);
        add (checkout);
        add (done);
       
        //positioning for components
        confirm.setBounds (200, 315, 120, 40);
        cancel.setBounds (445, 315, 120, 40);
        totalTxt.setBounds (450, 110, 105, 35);
        paidTxt.setBounds (450, 155, 105, 35);
        changeTxt.setBounds (450, 200, 105, 35);
        total.setBounds (180, 95, 165, 55);
        paid.setBounds (180, 145, 165, 55);
        change.setBounds (180, 195, 165, 55);
        receipt.setBounds (450, 250, 185, 35);
        checkout.setBounds (260, 15, 185, 70);
        done.setBounds(325, 315, 120, 40);
        done.setVisible(false);
        receipt.setVisible(false);

        //font styles
        Font Design_1 = new Font("TimesRoman", Font.PLAIN, 26);
        Font Design_2 = new Font("Courier", Font.PLAIN, 36);
        Font Design_3 = new Font("TimesRoman", Font.PLAIN, 30);
        Font Design_4 = new Font("TimesRoman", Font.PLAIN, 16);

        //set font
        confirm.setFont(Design_1);
        cancel.setFont(Design_1);
        totalTxt.setFont(Design_1);
        paidTxt.setFont(Design_1);
        changeTxt.setFont(Design_1);
        total.setFont(Design_3);
        paid.setFont(Design_3);
        change.setFont(Design_3);
        receipt.setFont(Design_4);
        checkout.setFont(Design_2);
        done.setFont(Design_1);
        
        confirm.addActionListener(this);
        cancel.addActionListener(this);
        done.addActionListener(this);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == confirm)
        {
        //take input
        String payment = paidTxt.getText();
        //input into double format
        double DoublePayment = Double.parseDouble(payment);
        //two decimal place
        double FinalDoublePayment = Math.round(DoublePayment*100.0)/100.0;
        String totalCost = totalTxt.getText();
        double cost = Double.parseDouble(totalCost);
        double TOTALCOST = Math.round(cost*100.0)/100.0;
        double FinalChange = TOTALCOST - FinalDoublePayment;
        double FinalRoundChange = Math.round(FinalChange*100.0)/100.0;
        double PositiveChange = FinalRoundChange * -1;
        System.out.println(TOTALCOST);
        System.out.println(FinalDoublePayment);
        System.out.println(FinalRoundChange);
        
        if(FinalRoundChange < 0 || FinalRoundChange == 0)
        {
            String FRC = String.valueOf(PositiveChange); 
           changeTxt.setText(FRC);
           confirm.setVisible(false);
           cancel.setVisible(false);
           done.setVisible(true);
           receipt.setVisible(true);
        }
        else
        {
           showMessageDialog(null, "Please input a valid amount");
        }
        }
        else if (e.getSource() == cancel)
        {
            this.dispose();
            setVisible(false);
            MainMenu menu = new MainMenu();
            menu.GUI();
        }
        else if (e.getSource() == done)
        {
            if(receipt.isSelected())
            {
                File f = new File("Saloon_Receipt");
                //search for folder if exists
                String absolute = f.getAbsolutePath();
                String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
                System.out.println(timeStamp);
                if(f.exists())
                {
                    System.out.println(absolute);
                    CreateFile(absolute, timeStamp, productReceipt, contentRow);
                    WriteFile(absolute, timeStamp, productReceipt, contentRow);
                }
                else
                {
                    System.out.println(absolute);
                    File f1 = new File(absolute);
                    f1.mkdir();
                    CreateFile(absolute, timeStamp, productReceipt, contentRow);
                    WriteFile(absolute, timeStamp, productReceipt, contentRow);
                }
            }
            else
            {
                System.out.println("");
            }
            this.dispose();
            setVisible(false);
            MainMenu menu = new MainMenu();
            menu.GUI();
        }        
    }
    
    public void CreateFile(String absolute, String timeStamp, ArrayList<cartItem> productReceipt, int contentRow) {
    
        try{
            File createFile = new File( absolute + "\\Receipt " + timeStamp + ".txt"); //input file 
            if(createFile.createNewFile()){
                System.out.println(createFile.getName());
            }else{
            }
        }catch (IOException e)
        {           
            e.printStackTrace();
        }
}
 
public void WriteFile(String absolute, String timeStamp, ArrayList<cartItem> productReceipt, int contentRow){
    try{
        int row = contentRow;
        FileWriter writeFile = new FileWriter( absolute + "\\Receipt " + timeStamp + ".txt"); //find and write file
        writeFile.write("                                       INVOICE                 \n===============================================================================================\n");
        writeFile.write(String.format("%-25s %15s %20s %30s\n","Item", "Quantity" ,"Price/Unit", "Total"));
        writeFile.write("\n===============================================================================================\n");
        for(int i=0; i<row; i++ )
        {
            writeFile.write(String.format("%-25.25s %15s %20s %30s\n",productReceipt.get(i).getName(),+productReceipt.get(i).getQuantity(),productReceipt.get(i).getUnitPrice(), productReceipt.get(i).getTotal()));
        }
        writeFile.write("\n===============================================================================================\n");
        writeFile.write(String.format("%-25s %68s","\nTotal", totalTxt.getText()));
        writeFile.write(String.format("%-25s %68s \n","\nPaid", paidTxt.getText()));
        writeFile.write(String.format("%-25s %67s \n","Change", changeTxt.getText()));
        writeFile.close();
        
    }catch(IOException e)
    {
        e.printStackTrace(); 
   }
}   
}
