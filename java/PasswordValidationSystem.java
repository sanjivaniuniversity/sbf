import java.util.*;

public class PasswordValidationSystem {

    static boolean isValidPassword(String password) {

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        if (password.length() < 8) {
            System.out.println("❌ Password must be at least 8 characters long.");
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }

        if (!hasUpper)
            System.out.println("❌ Must contain at least one uppercase letter.");

        if (!hasLower)
            System.out.println("❌ Must contain at least one lowercase letter.");

        if (!hasDigit)
            System.out.println("❌ Must contain at least one digit.");

        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (isValidPassword(password)) {
            System.out.println("✅ Password is VALID.");
        } else {
            System.out.println("❌ Password is INVALID.");
        }
    }
}