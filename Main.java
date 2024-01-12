package org.example;

import java.util.*;
import java.util.stream.Collectors;

class Donation {
    String donorName;
    String donationType;
    double quantity;
    String date;

    public Donation(String donorName, String donationType, double quantity, String date) {
        this.donorName = donorName;
        this.donationType = donationType;
        this.quantity = quantity;
        this.date = date;
    }
}
public class Main {
    private static List<Donation> donations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Record Donation");
            System.out.println("2. Log Donation Distribution");
            System.out.println("3. Generate Inventory Report");
            System.out.println("4. Generate Donator Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    recordDonation(scanner);
                    break;
                case 2:
                    generateInventoryReport();
                    break;
                case 3:
                    generateDonatorReport();
                    break;
                case 4:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void recordDonation(Scanner scanner) {
        System.out.print("Enter donor's name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter donation type: ");
        String donationType = scanner.nextLine();
        System.out.print("Enter quantity or amount donated: ");
        double quantity = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter date of donation: ");
        String date = scanner.nextLine();

        Donation donation = new Donation(donorName, donationType, quantity, date);
        donations.add(donation);

        System.out.println("Donation recorded successfully.");
    }

    private static void generateInventoryReport() {
        Map<String, Double> inventory = new HashMap<>();

        for (Donation donation : donations) {
            inventory.put(donation.donationType, inventory.getOrDefault(donation.donationType, 0.0) + donation.quantity);
        }

        System.out.println("Inventory Report:");
        for (Map.Entry<String, Double> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void generateDonatorReport() {
        Map<String, Double> donatorReport = new HashMap<>();

        for (Donation donation : donations) {
            donatorReport.put(donation.donorName, donatorReport.getOrDefault(donation.donorName, 0.0) + donation.quantity);
        }

        System.out.println("Donator Report:");
        for (Map.Entry<String, Double> entry : donatorReport.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}