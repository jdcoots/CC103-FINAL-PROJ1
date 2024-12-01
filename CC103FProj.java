package FinalProject;

import java.util.Scanner;

public class CC103FProj {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char choice;
        char continueChoice;
        double totalAmountDue = 0;
            do{
            System.out.println("-------------------------------------------");

            System.out.println("\t TUITION FEE ASSESSMENT \t");
            System.out.print("Initial Amount of Tuition: ");
            double initialTuition = scan.nextDouble();
            scan.nextLine(); // Consume newline character
            System.out.println("-------------------------------------------");

            do {
                System.out.print("Are you a Scholar? (Type Y or N): ");
                choice = scan.nextLine().toUpperCase().charAt(0);
                if (choice != 'Y' && choice != 'N') {
                    System.out.println("Invalid Input. Please try again.");
                }
            } while (choice != 'Y' && choice != 'N');

            if (choice == 'Y') {
               scholar(scan, initialTuition);
            } else if (choice == 'N') {
               nonscholar(scan, initialTuition);
            }

            System.out.println("-------------------------------------------");
            //scan.close(); // Close scanner
            System.out.print("Do you wish to continue? (Type Y or N): ");
                continueChoice = scan.nextLine().toUpperCase().charAt(0);
            if (continueChoice == 'N') {
                break;
            }}while(continueChoice == 'Y');
            
            scan.close();
    }

        
    

    public static double scholar(Scanner scan, double initialTuition) {
        char scholar;
        double discount = 0, totalAmountDue;

        do {
            System.out.println("Select Scholarship Type:");
            System.out.println("[A] Full Scholarship (90% Discount)");
            System.out.println("[B] Half Scholarship (50% Discount)");
            System.out.print("Enter your choice (A/B): ");
            scholar = scan.nextLine().toUpperCase().charAt(0);

            if (scholar == 'A') {
                discount = 0.90; // Full scholarship discount
            } else if (scholar == 'B') {
                discount = 0.50; // Half scholarship discount
            } else {
                System.out.println("Invalid Input. Please try again.");
            }
        } while (scholar != 'A' && scholar != 'B');

        totalAmountDue = initialTuition * (1 - discount);

        System.out.printf("Total Amount Due         :   %.2f%n", totalAmountDue);
        System.out.printf("Amount of Discount       :   %.0f%% discount%n", discount * 100);

        return totalAmountDue;
    }

    public static double nonscholar(Scanner scan, double initialTuition) {
        char paymentScheme;
        int installmentPlan;
        double totalAmountDue = 0;

        do {
            System.out.println("Select mode of Payment:");
            System.out.println("[A] Cash\n[B] Installment");
            paymentScheme = scan.nextLine().toUpperCase().charAt(0);

            if (paymentScheme == 'A') {
                totalAmountDue = cash(initialTuition);
            } else if (paymentScheme == 'B') {
                do {
                    System.out.println("Select Installment Plan:");
                    System.out.println("[1] Installment Plan A (2 Payments)");
                    System.out.println("[2] Installment Plan B (3 Payments)");
                    installmentPlan = scan.nextInt();
                    scan.nextLine(); // Consume newline

                    if (installmentPlan == 1) {
                        totalAmountDue = installmentPlan1(initialTuition);
                    } else if (installmentPlan == 2) {
                        totalAmountDue = installmentPlan2(initialTuition);
                    } else {
                        System.out.println("Invalid Input. Please select 1 or 2.");
                    }
                } while (installmentPlan != 1 && installmentPlan != 2);
            } else {
                System.out.println("Invalid Input. Please try again.");
            }
        } while (paymentScheme != 'A' && paymentScheme != 'B');

        return totalAmountDue;
    }

    public static double cash(double initialTuition) {
        double discount = 0.10;
        double totalAmountDue = initialTuition * (1 - discount);

        System.out.printf("Total Amount Due         :   %.2f%n", totalAmountDue);
        System.out.printf("Amount of Discount       :   %.0f%% discount%n", discount * 100);

        return totalAmountDue;
    }

    public static double installmentPlan1(double initialTuition) {
        double interest = 0.10;
        double totalAmountDue = initialTuition * (1 + interest);
        double installment = totalAmountDue / 2;

        System.out.printf("Total Amount Due         :   %.2f%n", totalAmountDue);
        System.out.printf("Semiannual Payment       :   %.2f%n", installment);
        System.out.printf("Amount of Interest       :   %.0f%% interest%n", interest * 100);

        return totalAmountDue;
    }

    public static double installmentPlan2(double initialTuition) {
        double interest = 0.10;
        double totalAmountDue = initialTuition * (1 + interest);
        double installment = totalAmountDue / 3;

        System.out.printf("Total Amount Due         :   %.2f%n", totalAmountDue);
        System.out.printf("Quadrimesterly Payment   :   %.2f%n", installment);
        System.out.printf("Amount of Interest       :   %.0f%% interest%n", interest * 100);

        return totalAmountDue;
    }
}

