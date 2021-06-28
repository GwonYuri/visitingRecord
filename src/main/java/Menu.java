import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu {
    BufferedReader br;
    ArrayList<Person> myList;

    Menu(){}
    Menu(ArrayList<Person> myList){
        this.myList = myList;
    }
    public void printMenu() {
        System.out.println("----메뉴 선택----");
        System.out.println("1. 조회");
        System.out.println("2. 추가");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
//        System.out.println("5. 체온 검색");
//        System.out.println("6. 지역 검색");
        System.out.println("0. 종료");
        System.out.println("---------------");
    }

    public boolean menuChoose (String num){
        switch (num) {
            case "1":
                readData();
                break;

            case "2":
                createData();
                break;

            case "3":
                updateData();
                break;

            case "4":
                deleteData();
                break;

//            case "5":
//                searchByTemperature();
//                break;
//
//            case "6":
//                searchRegion();
//                break;

            case "0":
                System.out.println("기록을 종료합니다");
                return false;

            default:
                System.out.println("메뉴를 잘못 선택했습니다.");
        }
        return true;
    }

    private void createData(){
        Person p = new Person();
        try{
            System.out.println("이름 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            p.setName(br.readLine());

            System.out.println("지역 입력");
            p.setRegion(br.readLine());

            System.out.println("휴대폰 번호 입력");
            p.setPhone_num(br.readLine());

            System.out.println("체온 입력");
            p.setTemperature(Double.parseDouble(br.readLine()));

            System.out.println("개인정보 이용 동의(Y(y):동의 , N(n):비동의");
            p.setAgreement(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setNum(myList.size());
        SimpleDateFormat myFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        p.setVit_Date(myFormat.format(time));

        myList.add(p);
        System.out.println("기록이 추가되었습니다.");
    }

    private void readData(){
        if(myList.size() == 0) {
            System.out.println("기록이 존재하지 않습니다.");
            return;
        }
        System.out.println("No        Date         Name Region Phone_num Temperature Agree");
        for (Person p: myList){
            System.out.println(p.toString());
        }
    }

    private void updateData() {
        if(myList.size() == 0) {
            System.out.println("기록이 존재하지 않습니다.");
            return;
        }
        try{
            readData();
            System.out.println("기록을 수정하겠습니다.");

            System.out.println("수정할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());

            if(valid(num)) {
                System.out.println("이름 입력");
                myList.get(num).setName(br.readLine());

                System.out.println("지역 입력");
                myList.get(num).setRegion(br.readLine());

                System.out.println("휴대폰 번호 입력");
                myList.get(num).setPhone_num(br.readLine());

                System.out.println("체온 입력");
                myList.get(num).setTemperature(Double.parseDouble(br.readLine()));

                System.out.println("개인정보 이용 동의(Y(y):동의 , N(n):비동의");
                myList.get(num).setAgreement(br.readLine());

                System.out.println("기록 수정 완료했습니다.");
            } else {
                updateData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean valid(int num) {
        if (myList.size() <= num) {
            System.out.println("없는 번호 입니다.");
            return false;
        }
        return true;
    }

    private void deleteData() {
        if(myList.size() == 0) {
            System.out.println("기록이 존재하지 않습니다.");
            return;
        }
        try {
            readData();

            System.out.println("삭제할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());

            if(valid(num)) {
                myList.remove(num);
                for(int i=0; i < myList.size(); i++)
                    myList.get(i).setNum(i);
                System.out.println("삭제되었습니다.");
            }else {
                deleteData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void searchByTemperature() {
//
//    }
//
//    private void searchRegion(){
//
//    }

}
