
import java.io.File;
import java.io.IOException;


public class CreateTxtBox {
    
    
public void txt(String item_name, double item_price, int item_Quantity) {
    
try{
            File createFile = new File("C:\\Users\\Quah Jin Min\\Desktop\\OOD\\Chuan.txt"); //input file 
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
