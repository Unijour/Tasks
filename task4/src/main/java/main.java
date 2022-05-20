import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {


    public static void main(String[] args) throws FileNotFoundException {

        File txtFile = new File("File.txt");
        Scanner scanner = new Scanner(txtFile);

        ArrayList<Integer> nums = new ArrayList<>();

        while (scanner.hasNext()) {
            nums.add(Integer.parseInt(scanner.nextLine()));
        }

        scanner.close();

        Collections.sort(nums);
        int median = nums.get(nums.size()/2);

        int answer = 0;
        for (int i = 0; i < nums.size(); i++) {
            answer = answer + Math.abs(nums.get(i) - median);
        }

        System.out.println(answer);
    }
}
