package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GetdataPropFile {
    static FileInputStream fis;
    static Properties prop;

    public GetdataPropFile(){

            File src= new File("Constant.property");
            try {
                fis= new FileInputStream(src);
                prop= new Properties();
            } catch (FileNotFoundException e) {

                System.out.println("Exception occurs "+e.getMessage());
            }

    }

    public String getURL()
    {
    String data=prop.getProperty("URL");
    return data;
    }

    public String APPID()
    {
    String data=prop.getProperty("APPID");
    return data;
    }

    public static String getTestExcelData1() {

        String data=prop.getProperty("TestData");

        return data;
    }

}
