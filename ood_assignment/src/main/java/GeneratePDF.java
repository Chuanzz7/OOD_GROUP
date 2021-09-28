import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter; 



public class GeneratePDF {
    
    public static void main1(String args[])  {
    Document doc = new Document();
    
           
       
    try 
    {
    PdfWriter writer = new PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Quah Jin Min\\Desktop\\COO"));
    System.out.println("PDF created");
    doc.open();
    doc.add(new Paragraph("Chuan is GAY"));
    doc.close();
    writer.close();
    }
    catch(DocumentException e)
    {
        e.printStackTrace();
    }
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }
}
}
    

