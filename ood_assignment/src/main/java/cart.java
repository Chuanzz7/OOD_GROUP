/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chngk
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class cart
{
    ArrayList<cartItem> cartItemArray  = new ArrayList<>();
    ArrayList<String[]> cartItemString = new ArrayList<>();

    public String calculateTotal(){
        double totalPrice = 0;
        for (int i = 0; i < cartItemArray.size(); i++){
        totalPrice += cartItemArray.get(i).calculateTotalItem();
          }
    return String.valueOf(totalPrice);
    }
    
    public void addItem(String _itemName , double _itemPrice , int _itemQuantity){
        cartItemArray.add(new cartItem(_itemName , _itemPrice , _itemQuantity));
    }
    
    public String[] getItem(int _index){
        return cartItemArray.get(_index).getArray();
    }
    
    /*public String[][] refreshStringArray(){
        cartItemString.clear();
        for(int i = 0 ; i < cartItemArray.size(); i++){
            cartItemString.add(getItem(i));
        }
        //return cartItemString;
*/
    }
   
    
   
            




