import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class testBuffer {
    public static void main(String[] args) {
        String filePath = "/home/l104/IdeaProjects/User/target/User/src/敏感词汇.txt";
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(filePath));
            String line = null;
            while((line = buffer.readLine()) != null){
                System.out.println(line);
            }
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
