package Com.Api.Service.api.weather;


public class ReadData {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        GetData config= new GetData("C:\\Users\\bhagyashri.l.wagaj\\Desktop\\API_Excel\\TestData.xlsx", 0);
        int rows=config.rowcount(0);

        String[][] data=new String[rows][3];

      for(int i=0; i<rows; i++)
      {
          data[i][0]=config.getValue(i, 0);
          data[i][1]=config.getValue(i, 1);
          data[i][2]=config.getValue(i, 2);
    }
      System.out.println("data filled");
    }
}
