/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chngk
 */
public class cartItem extends cart{
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private double itemTotal;
    
    public cartItem(String _itemName , double _itemPrice , int _itemQuantity){
        this.itemName= _itemName;
        this.itemPrice = _itemPrice;
        this.itemQuantity = _itemQuantity;
    }

   
    public void addQuantiy(cartItem sameItem){
        this.itemQuantity = this.itemQuantity + sameItem.itemQuantity;
    }
    
     public void minusQuantiy(cartItem sameItem){
        this.itemQuantity = this.itemQuantity - sameItem.itemQuantity;
    }
     
     public double calculateTotalItem(){
        itemTotal = this.itemQuantity * this.itemPrice;
        return itemTotal;
    }

     public String toString()
     {
      return this.itemName + " " + this.itemQuantity + " "  + calculateTotalItem();
     }
    
}
