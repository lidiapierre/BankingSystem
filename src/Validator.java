import java.util.Scanner;

class Validator {

    static String getAnswer(Scanner sc, String prompt, String option1, String option2) {
        System.out.format("%s? (%s/%s): ", prompt, option1, option2);
        String s;
        while (true) {
            s = sc.next();
            if (s.equalsIgnoreCase(option1) || s.equalsIgnoreCase(option2)) {
                sc.nextLine();
                break;
            } else {
                System.out.format("Please enter '%s' or '%s': ", option1, option2);
            }
        }

        return s;
    }


    static double getAmount(Scanner sc) {
        double d = 0;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.print("Amount ? ");
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                if (d > 0) {
                    isValid = true;
                } else {
                    System.out.println("Error! Amount entered cannot be less than 0. Try again.");
                }

            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }
}
