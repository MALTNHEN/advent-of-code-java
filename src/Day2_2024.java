
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2_2024 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input/Day2_2024.txt");
        Scanner input = new Scanner(file);
        int counter = 0;
        while (input.hasNextLine()) {
            boolean isValid = false;
            String line = input.nextLine();
            List<String> lineList = Arrays.asList(line.split(" "));
            List<Integer> intList = new ArrayList<>();
            for (String part : lineList) {
                intList.add(Integer.parseInt(part));
            }

            if (validCheck(intList)) {
                counter++;
            } else {
                for (int i = 0; i < intList.size(); i++) {
                    List<Integer> copy = new ArrayList<>(intList);
                    copy.remove(i);
                    if (validCheck(copy)) {
                        counter++;
                        break;
                    }

                }

            }
        }
        System.out.println(counter);
        input.close();
    }

    public static boolean validCheck(List<Integer> intList) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        boolean isValid = false;

        if (intList.get(0) < intList.get(1)) {
            isIncreasing = true;
        } else if (intList.get(0) > intList.get(1)) {
            isDecreasing = true;
        }
        for (int i = 0; i < intList.size() - 1; i++) {

            if (isIncreasing && (intList.get(i + 1) - intList.get(i) < 4 && intList.get(i + 1) - intList.get(i) > 0)) {
                isValid = true;
            } else if (isDecreasing && (intList.get(i) - intList.get(i + 1) < 4 && intList.get(i) - intList.get(i + 1) > 0)) {
                isValid = true;
            } else {
                isValid = false;

                break;
            }
        }

        return isValid;
    }
}
