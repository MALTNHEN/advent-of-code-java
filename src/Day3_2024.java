
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3_2024 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input/Day3_2024.txt");
        Scanner input = new Scanner(inputFile);
        int puzzleAnswer = 0;
        while (input.hasNextLine()) { //Iterate by raw line

            String line = input.nextLine();
            String[] afterMulRaw = line.split("mul");               //everything after mul in raw line split into afterMulRaw array
            for (int i = 0; i < afterMulRaw.length; i++) {          //for each possible valid equation out of raw line,
                String[] pair = mulTrim(afterMulRaw[i]);            //calls multrim to refine into either valid 2 sized pair array, or null
                
                if (pair != null){                                  //ignores null results
                    System.out.println("Input: " + afterMulRaw[i]);
                    System.out.println(Integer.parseInt(pair[0]) * Integer.parseInt(pair[1]));
                    System.out.println();
                    puzzleAnswer += (Integer.parseInt(pair[0]) * Integer.parseInt(pair[1]));
                }
            }

        }

        System.out.println(puzzleAnswer);
        input.close();
    }

    public static String[] mulTrim(String rawMul) {                   //takes possible equations after mull appears in input 
        String[] output = new String[2];  
        if (rawMul.startsWith("(") && rawMul.contains(")") && rawMul.contains(",")) {    //if a possible statement might be valid, 
            int endPos = rawMul.indexOf(")");
            String trimmedMul = rawMul.substring(1, endPos);          // trim after potential )
            String[] mulSides = trimmedMul.split(",");                // split at , into 2 sized array mulSides
            if (mulSides.length != 2) {return null;}                  //sort out multi comma garbage
            int sideNumber = 0;
            for (String side : mulSides) {                            // is side valid check - loop through each side 
                
                char[] numsOnly = side.toCharArray();                 // convert side to character array of various lengths
                
                

                for (int i = 0; i < numsOnly.length; i++) {           //loop through character array and check if each character is a valid number
                    if ((numsOnly[i] - '0' > 9 || numsOnly[i] - '0' < 0) || (side.length() > 3 || side.length() < 1)) {  // if a character within side is invalid or side length limits - 
                        return null;    //exits method and returns null
                    }      
                }
                
                output[sideNumber] = side;     //if there is no garbage within brackets, 
                sideNumber ++;
            }
            return output;
        } else {
            return null;    // if initial parameters ( , ) not met, return null
        }

    }

}
