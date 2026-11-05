import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day1_2025 {
    public static void main(String[] args) throws FileNotFoundException {
        File puzzleFile = new File("input/Day1_2025.txt");
        Scanner input = new Scanner(puzzleFile);
        int position = 50;
        int positionChange = 0;
        int counter = 0;
        while (input.hasNextLine()) {
            
            String line = input.nextLine();
            char direction = line.charAt(0); //direction = L or R
            String numberText = line.substring(1); //numberText = # after direction as string
            int amount = Integer.parseInt(numberText); //amount = numberText as integer
            
            System.out.println(counter + ": " + numberText + direction); 
            
            
            if (direction == 'R') {
                for (int i = 0; i<amount; i++) {
                    position++;
                    if (position > 99) {
                        position = 0;
                    }
                    if (position == 0) {
                        counter++;
                    }
                }
                
            } else if (direction == 'L') {
                for (int i = 0; i<amount; i++) {
                    position--;
                    if (position < 0) {
                        position = 99;
                    }
                    if (position == 0) {
                        counter++;
                    }
                }
            }
            
            System.out.println("Position: " + position);
            
            
        }
    System.out.println("Number of zeros: " + counter);
    input.close();
    }
}
