import java.io.*;
import java.util.Scanner;

public class ReadFileExample{
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn của file:");
        String filePath = new Scanner(System.in).next();
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(filePath);
    }
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            System.out.println(file.getAbsolutePath());
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("\n24");
            fileWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Tổng là: " + sum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("File không tồn tại hoặc nội dung có lỗi!");

        }


    }
}
