import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    BufferedReader br;

    public void searchBy(ArrayList<Person> list, String keyword) throws IOException {
      if(keyword.equals("temperature")){
          System.out.println("검색하고 싶은 체온의 최저값과 최고값 입력(예시: 35.6 37.4)");
          Scanner sc = new Scanner(System.in);
          double a,b;
          a = sc.nextDouble();
          b = sc.nextDouble();

          System.out.println("No        Date         Name Region Phone_num Temperature Agree");
          System.out.println("==============================================================");

          for(Person p:list){
              if(p.getTemperature() >= a && p.getTemperature() <= b)
                  System.out.println(p.toString());
          }
      }else if(keyword.equals("region")){
          System.out.println("검색하고 싶은 지역 입력");
          br = new BufferedReader(new InputStreamReader(System.in));
          String region = br.readLine();

          System.out.println("No        Date         Name Region Phone_num Temperature Agree");
          System.out.println("==============================================================");

          for(Person p:list){
              if(p.getRegion().equals(region))
                  System.out.println(p.toString());
          }
      }
    }
}
