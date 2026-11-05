import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day2_2025 {
    public static void main(String[] args) throws FileNotFoundException {
        File puzzleFile = new File("input/Day2_2025.txt");
        Scanner input = new Scanner(puzzleFile);
        String rawData = input.nextLine();
        String[] data = rawData.split(",");
        // for (int i = 0; i< data.length; i++) what i would do, better version:
        long addedNumber = 0;
        for (String code : data) { //FOR EACH xxxx-xxxx, 
            
            
            //System.out.println(code);
            String[] codeParts = code.split("-"); //codeParts = xxxx (range start/end)
            
            long start = Long.parseLong(codeParts[0]);
            long end = Long.parseLong(codeParts[1]); //first and second half of each, start and end
            //System.out.println("Start: " + start + " End: " + end);
        
            for (long i = start; i <= end; i++){
                String number = Long.toString(i); // v if this half is equal to the other half, add it to the sum
                // if (number.substring(0, (number.length() / 2)).equals(number.substring(number.length() / 2))) {
                //     System.out.println("INVALID: " + number);
                //     addedNumber += Long.parseLong(number);
                // }
                for (int k = 2; k <= number.length(); k++) {
                    if (number.length() % k == 0) {
                        String chunk = number.substring(0, number.length() / k);
                        if (number.equals(chunk.repeat(k))) {
                        System.out.println("INVALID: " + number);
                        addedNumber += i;
                        break;
                    }
                    }
                    
                    
                }
            }
            
        }
        System.out.println("Sum of invalid numbers: " + addedNumber);
        input.close();
    }
}
