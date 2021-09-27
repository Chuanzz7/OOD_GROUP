/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chngk
 */

import java.util.ArrayList;

public class cart
{
    ArrayList<cartItem> cartItemArray  = new ArrayList<>();
   
    
    
    
    
    public double calculateTotal(){
        double totalPrice = 0;
        for (int i = 0; i < cartItemArray.size(); i++){
        totalPrice += cartItemArray.get(i).calculateTotalItem();
          }
    return totalPrice;
    }
    
    public void addItem(String _itemName , double _itemPrice , int _itemQuantity){
        cartItemArray.add(new cartItem(_itemName , _itemPrice , _itemQuantity));
        cartUI cartUI1 = new cartUI(cartItemArray);
    }
    
   
    
   
            
}



