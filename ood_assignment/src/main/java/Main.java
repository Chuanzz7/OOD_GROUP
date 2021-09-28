/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.io.File;
import java.io.IOException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        cartUI start = new cartUI();
        
        try{
            File createFile = new File("C:\Users\Quah Jin Min\Desktop\OOD\Chuan.txt");
            if(createFile.createNewFile()){
                System.out.println("CHUAN IS GAY" + createFile.getName());
            }else{
                System.out.println("CHUAN IS VERY GAY");
            }
        }catch (IOException e)
        {
            System.out.println("CHUAN GAYNESS MADE ERROR");
            e.printStackTrace();
        }
    }
    
}
