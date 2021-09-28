
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CreateTxtBox {
    
    
public void CreateFile() {
    
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

public void WriteFile(){
    try{
        FileWriter writeFile = new FileWriter("C:\\Users\\Quah Jin Min\\Desktop\\OOD\\Chuan.txt");
        writeFile.write("Chuan is very GAY");
        writeFile.close();
        System.out.println("Wrote Chuan is GAY");
        
    }catch(IOException e)
    {
        System.out.println("Gayness made ERROR");
        e.printStackTrace();
    }
}
    
}
