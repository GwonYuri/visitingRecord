import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
//import java.util.List;

public class Crud {
    BufferedReader br;

    public Person createData(ArrayList<Person> list) throws IOException {
        int num;
        String vit_Date;
        String name;
        String region;
        String phone_num;
        double temperature;
        String agreement;

        num = list.size();

        System.out.println("이름 입력");
        br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();

        System.out.println("지역 입력");
        region = br.readLine();

        System.out.println("휴대폰 번호 입력");
        phone_num = br.readLine();

        System.out.println("체온 입력");
        temperature = Double.parseDouble(br.readLine());

        System.out.println("개인정보 이용 동의( Y(y):동의 , N(n):비동의 )");
        agreement = br.readLine();

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        vit_Date = myFormat.format(time);

        Person p = new Person(num, vit_Date, name, region, phone_num, temperature, agreement);

        return p;
    }

    public void readData(ArrayList<Person> list) {
        if (list.size() == 0) {
            System.out.println("기록이 존재하지 않습니다.");
            return;
        }
        System.out.println("No        Date         Name Region Phone_num Temperature Agree");
        for (Person p : list) {
            System.out.println(p.toString());
        }
    }

    public void updateData(ArrayList<Person> list) {
        if (list.size() == 0) {
            System.out.println("기록이 존재하지 않습니다.");
            return;
        }
        try {
            System.out.println("수정할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine()) -1 ;
            if (RecordMain.valid(list, num)) {
                System.out.println("이름 입력");
                list.get(num).setName(br.readLine());
                System.out.println("지역 입력");
                list.get(num).setRegion(br.readLine());
                System.out.println("휴대폰 번호 입력");
                list.get(num).setPhone_num(br.readLine());
                System.out.println("체온 입력");
                list.get(num).setTemperature(Double.parseDouble(br.readLine()));
                System.out.println("개인정보 이용 동의( Y(y):동의 , N(n):비동의 )");
                list.get(num).setAgreement(br.readLine());
            } else {
                updateData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteData(ArrayList<Person> list) {
        if (list.size() == 0) {
            System.out.println("기록이 존재하지 않습니다.");
            return;
        }
        try {
            System.out.println("삭제할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine()) -1;
            if (RecordMain.valid(list, num)) {
                list.remove(num);
                for (int i = 0; i < list.size(); i++)
                    list.get(i).setNum(i);
            } else {
                deleteData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

