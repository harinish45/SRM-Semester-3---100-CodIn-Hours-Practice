import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        sc.close();

        char ch = firstNonRepeating(text);
        if (ch != '\0') {
            System.out.println("First Non-Repeating Character: " + ch);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static char firstNonRepeating(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return '\0';
    }
}
