import java.util.Scanner;

public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        sc.close();

        int len = findLength(text);
        char[] uniqueChars = findUniqueChars(text, len);

        System.out.print("Unique Characters: ");
        for (char c : uniqueChars) {
            if (c != '\0') System.out.print(c + " ");
        }
    }

    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static char[] findUniqueChars(String s, int len) {
        char[] unique = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[index++] = c;
            }
        }
        return unique;
    }
}
