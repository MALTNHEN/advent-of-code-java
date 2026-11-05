import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1_2024 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/Day1_2024.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> sideA = new ArrayList<>();
        List<Integer> sideB = new ArrayList<>();
        
        int multiTotal = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tempArray = line.split("   ");
            sideA.add(Integer.parseInt(tempArray[0]));
            sideB.add(Integer.parseInt(tempArray[1]));
        }
        sideA.sort(Integer::compareTo);
        sideB.sort(Integer::compareTo);
        
        for (int i = 0; i < sideA.size(); i++) {
            int multi = 0;
            for (int j = 0; j < sideB.size(); j++) {
                if (sideA.get(i).equals(sideB.get(j))) {
                    
                    multi++;
                }
            }
            
            multiTotal += sideA.get(i) * multi;
            
        }
        System.out.println("Total Multiplication: " + multiTotal);
        scanner.close();
    }
}
