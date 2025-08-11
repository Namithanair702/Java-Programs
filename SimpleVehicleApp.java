import java.util.Scanner;
import java.time.Year;

class Vehicle {
    String brand, model;
    int year;
    double basePrice;

    Vehicle(String b, String m, int y, double price) {
        brand = b;
        model = m;
        year = y;
        basePrice = price;
        
    }

    double getResaleValue() {
        int age = Year.now().getValue() - year;
        return basePrice * Math.pow(0.85, age);
    }

    void showInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Base Price: ₹" + basePrice);
    }
}

class Car extends Vehicle {
    int doors;

    Car(String b, String m, int y, double price, int d) {
        super(b, m, y, price);
        doors = d;
    }

    double getInsurance() {
        return 5000 + 1000 * doors;
    }

    double getMaintenance() {
        return 3000 + 500 * doors;
    }

    void showInfo() {
        super.showInfo();
        System.out.println("Doors: " + doors);
        System.out.println("Insurance: ₹" + getInsurance());
        System.out.println("Maintenance: ₹" + getMaintenance());
        System.out.printf("Resale Value: ₹%.2f\n", getResaleValue());
    }
}

class Motorcycle extends Vehicle {
    boolean sidecar;

    Motorcycle(String b, String m, int y, double price, boolean s) {
        super(b, m, y, price);
        sidecar = s;
    }

    double getInsurance() {
        return 2500 + (sidecar ? 1500 : 0);
    }

    double getMaintenance() {
        return 2000 + (sidecar ? 1000 : 0);
    }

    void showInfo() {
        super.showInfo();
        System.out.println("Sidecar: " + (sidecar ? "Yes" : "No"));
        System.out.println("Insurance: ₹" + getInsurance());
        System.out.println("Maintenance: ₹" + getMaintenance());
        System.out.printf("Resale Value: ₹%.2f\n", getResaleValue());
    }
}

public class SimpleVehicleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Car
        System.out.println("Enter Car Details:");
        System.out.print("Brand: ");
        String cBrand = sc.nextLine();

        System.out.print("Model: ");
        String cModel = sc.nextLine();

        System.out.print("Year: ");
        int cYear = sc.nextInt();

        System.out.print("Base Price: ");
        double cPrice = sc.nextDouble();

        System.out.print("Number of Doors: ");
        int cDoors = sc.nextInt();
        sc.nextLine(); // consume newline

        Car c = new Car(cBrand, cModel, cYear, cPrice, cDoors);

        // Input for Motorcycle
        System.out.println("\nEnter Motorcycle Details:");
        System.out.print("Brand: ");
        String mBrand = sc.nextLine();

        System.out.print("Model: ");
        String mModel = sc.nextLine();

        System.out.print("Year: ");
        int mYear = sc.nextInt();

        System.out.print("Base Price: ");
        double mPrice = sc.nextDouble();

        System.out.print("Has Sidecar (true/false): ");
        boolean hasSidecar = sc.nextBoolean();

        Motorcycle m = new Motorcycle(mBrand, mModel, mYear, mPrice, hasSidecar);

        // Output
        System.out.println("\n--- Car Info ---");
        c.showInfo();

        System.out.println("\n--- Motorcycle Info ---");
        m.showInfo();
    }
}

