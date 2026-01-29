package main;

import service.EvidenceService;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EvidenceService service = new EvidenceService();

        while (true) {
            System.out.println("\n1. Add Evidence");
            System.out.println("2. View Evidence List");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Case ID: ");
                    String caseId = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    service.registerEvidence(caseId, desc, 1);
                    break;

                case 2:
                    service.viewAllEvidence();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
