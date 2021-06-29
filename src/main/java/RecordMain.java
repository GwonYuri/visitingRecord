import java.io.IOException;
import java.util.ArrayList;

public class RecordMain {
    public static void main(String[] args){
        ArrayList<Person> myList;

        Menu m = new Menu();
        Crud crudService = new Crud();
        Search searchService = new Search();
        FileService fileService = new FileService();

        myList = fileService.readFile();

        System.out.println("-----코로나 19 방문일지 기록 시작-----");

        while(true) {
            try {
                String choose = m.printMenu();
                switch(choose){
                    case "1":
                        crudService.readData(myList);
                        break;

                    case "2":
                        myList.add(crudService.createData(myList));
                        System.out.println("기록이 추가되었습니다.");
                        break;

                    case "3":
                        crudService.readData(myList);
                        System.out.println("기록을 수정하겠습니다.");
                        crudService.updateData(myList);
                        System.out.println("기록이 수정되었습니다.");
                        break;

                    case "4":
                        crudService.readData(myList);
                        crudService.deleteData(myList);
                        System.out.println("기록이 삭제되었습니다.");
                        break;

                    case "5":
                        searchService.searchBy(myList, "temperature");
                        break;

                    case "6":
                        searchService.searchBy(myList, "region");
                        break;

                    case "7":
                        fileService.saveFile(myList);
                        System.out.println("파일에 저장되었습니다.");
                        break;

                    case "0":
                        System.out.println("프로그램 종료");
                        return;

                    default:
                        System.out.println("메뉴를 잘못 선택하셨습니다.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean valid(ArrayList<Person> myList, int num) {

        if (myList.size() <= num || num == -1) {
            System.out.println("없는 번호 입니다.");
            return false;
        }
        return true;
    }
}


