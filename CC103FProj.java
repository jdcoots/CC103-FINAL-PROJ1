package FinalProject;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CC103FProj {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat twodec = new DecimalFormat("0.00");
        DecimalFormat percent = new DecimalFormat("#.##");
        char choice;
        char continueChoice;
        double totalAmountDue;
        double initialTuition;
            do{
                do{
                System.out.print("Initial Amount of Tuition       : ");
                while (!scan.hasNextDouble()) { // Validate if the input is a number
                System.out.println("------------------------------------------------------");
                System.out.println("Invalid Input. Please enter a valid number.");
                System.out.println("------------------------------------------------------");
                System.out.print("Initial Amount of Tuition       : ");
                scan.next(); // Consume the invalid input
             }
            initialTuition = scan.nextDouble();
            scan.nextLine(); // Consume the newline character
                if (initialTuition <= 0) {
                System.out.println("-------------------------------------------------------");
                System.out.println("Invalid Input. Tuition fee must be greater than zero.");
                System.out.println("-------------------------------------------------------");
                }
            } while (initialTuition <= 0);
                System.out.println("-------------------------------------------------------");
            do {
                System.out.print("Are you a Scholar? (Type Y or N): ");
                choice = scan.nextLine().toUpperCase().charAt(0);
                if (choice != 'Y' && choice != 'N') {
                    System.out.println("\n-------------------------------------------\nInvalid Input. Please try again.\n-------------------------------------------\n");
                }
            } while (choice != 'Y' && choice != 'N');

            if (choice == 'Y') {
               scholar(scan, initialTuition, twodec, percent);
            } else if (choice == 'N') {
               nonscholar(scan, initialTuition, twodec, percent);
            }

            System.out.println("\n-------------------------------------------\n");
            //scan.close(); // Close scanner
            do {
            System.out.print("Do you wish to continue? (Type Y or N): ");
                continueChoice = scan.nextLine().toUpperCase().charAt(0);
            if (continueChoice == 'N') {
                System.out.println("\n-------------------------------------------\n\nThank you for using our Tuition Fee Assessment!\n");
                break;
            }
            if (continueChoice != 'Y' && continueChoice !='N'){
                System.out.println("\n-------------------------------------------\nInvalid Input. Please try again.\n-------------------------------------------\n");
                    }
                }while (continueChoice != 'Y' && continueChoice !='N');
            }while(continueChoice == 'Y');
            
            scan.close();
    }

    public static double scholar(Scanner scan, double initialTuition, DecimalFormat twodec, DecimalFormat percent) {
        char scholar;
        double discount = 0, totalAmountDue;

        do {
            System.out.println("-------------------------------------------\n");
            System.out.println("Select Scholarship Type:");
            System.out.println("[A] Full Scholarship (90% Discount)");
            System.out.println("[B] Half Scholarship (50% Discount)\n");
            System.out.print("Enter your choice (A/B)         : ");
            scholar = scan.nextLine().toUpperCase().charAt(0);

            if (scholar == 'A') {
                discount = 0.90; // Full scholarship discount
            } else if (scholar == 'B') {
                discount = 0.50; // Half scholarship discount
            } else {
                System.out.println("\n-------------------------------------------\nInvalid Input. Please try again.");
            }
        } while (scholar != 'A' && scholar != 'B');

        totalAmountDue = initialTuition * (1 - discount);
        
        System.out.println("-------------------------------------------\n");
        System.out.print("Total Amount Due                :   " + twodec.format(totalAmountDue) + "\n");
        System.out.print("Amount of Discount              :   " + percent.format(discount * 100) + "%");

        return totalAmountDue;
    }

    public static double nonscholar(Scanner scan, double initialTuition, DecimalFormat twodec, DecimalFormat percent) {
        char paymentScheme;
        int installmentPlan;
        double totalAmountDue = 0;

        do {
            System.out.println("-------------------------------------------\n");
            System.out.println("Select mode of Payment:\n");
            System.out.println("[A] Cash\n[B] Installment");
            System.out.print("Enter your choice (A/B)         : ");
            paymentScheme = scan.nextLine().toUpperCase().charAt(0);

            if (paymentScheme == 'A') {
                totalAmountDue = cash(initialTuition, twodec, percent);
            } else if (paymentScheme == 'B') {
                do {
                    System.out.println("\n-------------------------------------------\n");
                    System.out.println("Select Installment Plan:\n");
                    System.out.println("[1] Installment Plan A (2 Payments)");
                    System.out.println("[2] Installment Plan B (3 Payments)");
                    System.out.print("Enter your choice (1/2)         : ");
                    installmentPlan = scan.nextInt();
                    scan.nextLine(); // Consume newline

                    if (installmentPlan == 1) {
                        totalAmountDue = installmentPlan1(initialTuition, twodec, percent);
                    } else if (installmentPlan == 2) {
                        totalAmountDue = installmentPlan2(initialTuition, twodec, percent);
                    } else {
                        System.out.println("\n-------------------------------------------\n");
                        System.out.println("\nInvalid Input. Please select 1 or 2.");
                    }
                } while (installmentPlan != 1 && installmentPlan != 2);
            } else {
                System.out.println("\n-------------------------------------------\nInvalid Input. Please try again.\n");
            }
        } while (paymentScheme != 'A' && paymentScheme != 'B');

        return totalAmountDue;
    }

    public static double cash(double initialTuition, DecimalFormat twodec, DecimalFormat percent) {
        double discount = 0.10;
        double totalAmountDue = initialTuition * (1 - discount);
        
        System.out.println("\n-------------------------------------------\n");
        System.out.println("Total Amount Due                :   " + twodec.format(totalAmountDue));
        System.out.println("Amount of Discount              :   " + percent.format(discount * 100) + "&");

        return totalAmountDue;
    }

    public static double installmentPlan1(double initialTuition, DecimalFormat twodec, DecimalFormat percent) {
        double interest = 0.10;
        double totalAmountDue = initialTuition * (1 + interest);
        double installment = totalAmountDue / 2;
        
        System.out.println("\n-------------------------------------------\n");
        System.out.println("Total Amount Due                :   " + twodec.format(totalAmountDue));
        System.out.println("Semiannual Payment              :   " + twodec.format(installment));
        System.out.println("Amount of Interest              :   " + percent.format(interest * 100) + "&");

        return totalAmountDue;
    }

    public static double installmentPlan2(double initialTuition, DecimalFormat twodec, DecimalFormat percent) {
        double interest = 0.10;
        double totalAmountDue = initialTuition * (1 + interest);
        double installment = totalAmountDue / 3;

         System.out.println("\n-------------------------------------------\n");
        System.out.println("Total Amount Due                :   " + twodec.format(totalAmountDue));
        System.out.println("Quadrimesterly Payment          :   " + twodec.format(installment));
        System.out.println("Amount of Interest              :   " + percent.format(interest * 100));

        return totalAmountDue;
    }
}

