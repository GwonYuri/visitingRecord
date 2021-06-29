import java.io.*;

public class Menu {
    BufferedReader br;

    public String printMenu() throws IOException{
        System.out.println("----메뉴 선택----");
        System.out.println("1. 조회");
        System.out.println("2. 추가");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 체온 검색");
        System.out.println("6. 지역 검색");
        System.out.println("7. 파일 저장");
        System.out.println("0. 종료");
        System.out.println("---------------");

        br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}
