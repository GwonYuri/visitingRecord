import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecordMain {
    public static void main(String[] args){
        ArrayList<Person> myList = new ArrayList<>();

        Menu menu = new Menu(myList);
        boolean check = true;

        System.out.println("-----코로나 19 방문일지 기록 시작-----");
        while (check) {
            try {
                menu.printMenu();
                BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in));
                String input = sbr.readLine();
                check = menu.menuChoose(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


