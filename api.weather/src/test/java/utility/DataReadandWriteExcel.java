package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadandWriteExcel {

    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
        
        File file= new File(filePath+"\\"+fileName);
        FileInputStream fileInputStreams=new FileInputStream(file);
        Workbook wb=null;
        
        String fileExtension= fileName.substring(fileName.indexOf("."));
        
        if(fileExtension.equals(".xlsx")){
        wb=new XSSFWorkbook(fileInputStreams); 
        }else if(fileExtension.equals(".xls"))
        {
            wb=new HSSFWorkbook(fileInputStreams); 
         }
        org.apache.poi.ss.usermodel.Sheet Sh1=wb.getSheet(sheetName);
                
        int rowCount = Sh1.getLastRowNum()+1;
        for (int i=0; i<rowCount; i++){
            Row row= Sh1.getRow(i)
                for(int j=0; j<Sh1.getLastCellNum(); j++){
                    
                }
        }
        
        

    }
    
}