import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double principle = getValidPrinciple(scanner);
        float annualInterestRate = getValidInterestRate(scanner);
        int mortgageTerm = getValidMortgageTerm(scanner);

        scanner.close();

        MortgageCalculator calculator = new MortgageCalculator();
        double monthlyPayment = calculator.calculateMonthlyPayment(principle, annualInterestRate, mortgageTerm);
        double totalPayback = calculator.calculateTotalPayback(monthlyPayment, mortgageTerm);

        System.out.println("\nTotal payback amount: " + NumberFormat.getCurrencyInstance().format(totalPayback));
        System.out.println("Monthly repayment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("10% Deposit: " + NumberFormat.getCurrencyInstance().format(principle * 0.10));
    }

    private static double getValidPrinciple(Scanner scanner) {
        double principle;
        do {
            System.out.print("Enter mortgage principle: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value.");
                System.out.print("\nEnter mortgage principle: ");
                scanner.next(); // Consume invalid input
            }
            principle = scanner.nextDouble();

            if(principle <= 0){
                System.out.println("Mortgage cannot be 0");
            }

        } while (principle <= 0);
        return principle;
    }

    private static float getValidInterestRate(Scanner scanner) {
        float annualInterestRate;
        do {
            System.out.print("Enter annual interest rate: ");
            while (!scanner.hasNextFloat()) {
                System.out.println("Invalid input. Please enter a numeric value.");
                System.out.print("\nEnter annual interest rate: ");
                scanner.next(); // Consume invalid input
            }
            annualInterestRate = scanner.nextFloat() / 100;
        } while (annualInterestRate < 0); // Interest rate can be zero or positive
        return annualInterestRate;
    }

    private static int getValidMortgageTerm(Scanner scanner) {
        int mortgageTerm;
        do {
            System.out.print("Enter term in years for mortgage: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer value.");
                System.out.print("\nEnter term in years for mortgage: ");
                scanner.next(); // Consume invalid input
            }
            mortgageTerm = scanner.nextInt();
        } while (mortgageTerm <= 0); // Term must be positive
        return mortgageTerm;
    }
}
