package Com.Api.Service.api.weather;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {
    private static XSSFWorkbook wb;
    private static XSSFSheet sheet1;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    public String ExcelPath;

    public GetData(String ExcelPath, int sheetNumber){

      try{
          this.ExcelPath=ExcelPath;
        File src=new File(ExcelPath);
        FileInputStream fis=new FileInputStream(src);
        wb= new XSSFWorkbook(fis); //xlsx file


        sheet1=wb.getSheetAt(sheetNumber);
      }catch (Exception e){
          System.out.println("Error Message"+e.getMessage());
      }

    }

    public static int rowcount(int sheetNumber)
    {
        int rows=sheet1.getLastRowNum();
        rows=rows+1;
        return rows;
    }
    public static String getValue(int row, int column)
    {
        Cell=sheet1.getRow(row).getCell(column);
        String data=Cell.getStringCellValue();
        return data;
    }


    public void setCellData(String Result, int row, int column) throws Exception {
        try{
            Row  = sheet1.getRow(row);
            Cell = Row.getCell(column);
            if (Cell == null) {
                Cell = Row.createCell(column);
                Cell.setCellValue(Result);
            } else
            {
                Cell.setCellValue(Result);
            }
         // Constant variables Test Data path and Test Data file name

            FileOutputStream fileOut = new FileOutputStream(ExcelPath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();

        }catch(Exception e){

            throw (e);

        }
    }
}
