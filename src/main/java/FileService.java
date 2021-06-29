import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileService {

    public ArrayList<Person> readFile(){
        ArrayList<Person> list = new ArrayList<>();
        try {
            String path = Paths.get(".").toAbsolutePath().toString();
            String filename = path + "/data.txt";
            File file = new File("data.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);

            int i=0;
            String line = "";
            while((line = bufReader.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line," ");

                String vit_Date = st.nextToken().trim();
                String vit_Time = st.nextToken().trim();
                String name = st.nextToken().trim();
                String region = st.nextToken().trim();
                String phone_num = st.nextToken().trim();
                double temperature = Double.parseDouble(st.nextToken().trim());
                String agreement = st.nextToken().trim();

                list.add(new Person(i, vit_Date + " " + vit_Time, name, region, phone_num, temperature, agreement));
                i++;
            }
            bufReader.close();
        }catch(FileNotFoundException e){
            System.out.println("data.txt 파일이 존재하지 않습니다.");
        }catch(IOException e){
            System.out.println(e);
        }
        return list;
    }

    public void saveFile(ArrayList<Person> list) {
        try {
            String path = Paths.get(".").toAbsolutePath().toString();
            String filename = path + "/data.txt";
            File file = new File(filename);
            FileUtils.write(file, "", false);
            for (Person p : list) {
                FileUtils.write(file, p.getVit_Date() + " " + p.getName() + " " + p.getRegion() + " " + p.getPhone_num() + " " + p.getTemperature() + " " + p.getAgreement() + "\n", true);
            }
        }catch (FileNotFoundException e) {
            System.out.println("data.txt 파일이 존재하지 않습니다.");
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
