/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chngk
 */
public class cartItem {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private double itemTotal;
    
    //create object
    public cartItem(String _itemName , int _itemQuantity, double _itemPrice , double _itemTotal){
        this.itemName= _itemName;
        this.itemPrice = _itemPrice;
        this.itemQuantity = _itemQuantity;
        this.itemTotal = _itemTotal;
    }
    
    public String getName(){
        return itemName;
    }
    public int getQuantity(){
        return itemQuantity;
    }
    public double getUnitPrice(){
        return itemPrice;
    }
    public double getTotal(){
        return itemTotal;
    }
     
    protected void finalize(){;}  
    
}
