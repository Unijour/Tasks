import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {


    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputnm = reader.readLine();
        String[] inputmnSplit = inputnm.split(" ");

        int n = Integer.parseInt(inputmnSplit[0]);

        int m = Integer.parseInt(inputmnSplit[1]);

        ArrayList<Integer> roundArray = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            roundArray.add(i+1);
        }

        int count = 0;

        ArrayList<Integer> interval = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        while (true) {
            interval.clear();
            for (int i = 0; i < m; i++) {
                interval.add(roundArray.get(count));
                if (count == n-1) {
                    count = 0;
                } else {
                    count = count + 1;
                }
            }
            path.add(interval.get(0));
            if (interval.get(interval.size()-1) == roundArray.get(0)) {
                break;
            }
            if (count == 0) {
                count = n - 1;
            }
            else {
                count = count - 1;
            }
            }
        System.out.println(path.toString().replaceAll("[\\[}\\], ]", ""));
        }
    }
