import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        sc.close();

        System.out.println("Logic 1 (Loop): " + (isPalindromeLoop(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2 (Recursion): " + (isPalindromeRec(text, 0, text.length() - 1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3 (Char Array): " + (isPalindromeArray(text) ? "Palindrome" : "Not Palindrome"));
    }

    public static boolean isPalindromeLoop(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRec(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindromeRec(s, start + 1, end - 1);
    }

    public static boolean isPalindromeArray(String s) {
        char[] arr = s.toCharArray();
        char[] rev = reverseString(s);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != rev[i]) return false;
        }
        return true;
    }

    public static char[] reverseString(String s) {
        char[] rev = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            rev[i] = s.charAt(s.length() - 1 - i);
        }
        return rev;
    }
}
