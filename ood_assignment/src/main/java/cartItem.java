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
    
    public cartItem(String _itemName , double _itemPrice , int _itemQuantity , double _totalCost){
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
     
     public double calculateTotalItem(cartItem item){
        return (this.itemQuantity * this.itemPrice) ;
    }
    
    
}
