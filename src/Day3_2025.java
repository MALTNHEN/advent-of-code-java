
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3_2025 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input/Day3_2025.txt");
        Scanner input = new Scanner(inputFile);
        int runningTotal = 0;
        while (input.hasNextLine()) { //increments once with each line in the file
            String line = input.nextLine();
            //System.out.println(line);
            int[] rawJolts = new int[line.length()];

            for (int i = 0; i < line.length(); i++) {//convert each char in line into int array rawJolts
                rawJolts[i] = Character.getNumericValue(line.charAt(i));
            }

            int j = 0;
            int maxI = 0;
            int maxJ = 0;

            for (int k = 0; k < rawJolts.length; k++) {
                j = rawJolts[k];
                if (j > maxJ) {
                    maxJ = j;
                }
                if (maxJ > maxI && k < rawJolts.length - 1) {
                    maxI = maxJ;
                    maxJ = 0;
                }

            }
            //System.out.println("MaxI: " + maxI + " MaxJ: " + maxJ);

            runningTotal += (maxI * 10 + maxJ);

        }

        System.out.println("Final Running Total: " + runningTotal);
        input.close();
    }
    
}
