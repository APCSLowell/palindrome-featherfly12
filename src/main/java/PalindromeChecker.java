import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalindromeChecker {
    public void tester() {
        String[] lines = new String[6];

        try {
            File myFile = new File("palindromes.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("there are " + lines.length + " lines");
        for (String line : lines) {
            if (palindrome(line)) {
                System.out.println(line + " IS a palindrome.");
            } else {
                System.out.println(line + " is NOT a palindrome.");
            }
        }
    }

    public boolean palindrome(String word) {
        String cleaned = cleanString(word);
        return cleaned.equals(reverse(cleaned));
    }

    public String reverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    private String cleanString(String str) {
        return str.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        checker.tester();
    }
}
