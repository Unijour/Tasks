import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {


    public static void main(String[] args) throws FileNotFoundException {


        File txtFile1 = new File("File1.txt");
        File txtFile2 = new File("File2.txt");

        Scanner scanner1 = new Scanner(txtFile1);
        Scanner scanner2 = new Scanner(txtFile2);

        String[] splitedFile1 = scanner1.nextLine().split(" ");

        float x0 = Float.parseFloat(splitedFile1[0]);
        float y0 = Float.parseFloat(splitedFile1[1]);
        float r = Float.parseFloat(scanner1.nextLine());

        scanner1.close();


        float x;
        float y;

        int count = 0;

        ArrayList<Integer> pointPosition = new ArrayList<>();

        while (scanner2.hasNext()) {

            String[] splitedFile2 = scanner2.nextLine().split(" ");

            x = Float.parseFloat(splitedFile2[0]);
            y = Float.parseFloat(splitedFile2[1]);

            if (Math.pow(y - y0, 2) + Math.pow(x - x0, 2) < Math.pow(r, 2)) {
                pointPosition.add(1);
            } else if (Math.pow(y - y0, 2) + Math.pow(x - x0, 2) == Math.pow(r, 2)) {
                pointPosition.add(0);
            } else {
                pointPosition.add(2);
            }

            count++;
            if (count == 100) {
                break;
            }
        }

        System.out.println(pointPosition.toString().replaceAll("[\\[}\\] ]", "").replaceAll(",", "\n"));
        scanner2.close();
    }
}
