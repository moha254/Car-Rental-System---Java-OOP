import java.util.List;
import java.util.Scanner;

public class Main {
    private static RentalAgency agency = new RentalAgency("Best Rentals");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Car Rental System");
            System.out.println("1. Add Car");
            System.out.println("2. Remove Car");
            System.out.println("3. Search Available Cars");
            System.out.println("4. Rent Car");
            System.out.println("5. Return Car");
            System.out.println("6. List Available Cars");
            System.out.println("7. List Ongoing Rentals");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    removeCar();
                    break;
                case 3:
                    searchAvailableCars();
                    break;
                case 4:
                    rentCar();
                    break;
                case 5:
                    returnCar();
                    break;
                case 6:
                    listAvailableCars();
                    break;
                case 7:
                    listOngoingRentals();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCar() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter car type (e.g., Sedan, SUV): ");
        String carType = scanner.nextLine();
        System.out.print("Enter daily rate: ");
        double dailyRate = scanner.nextDouble();
        scanner.nextLine();  // consume newline

        Car car = new Car(make, model, year, mileage, carType, dailyRate);
        agency.addCar(car);
        System.out.println("Car added successfully!");
    }

    private static void removeCar() {
        System.out.print("Enter make of the car to remove: ");
        String make = scanner.nextLine();
        System.out.print("Enter model of the car to remove: ");
        String model = scanner.nextLine();

        List<Car> cars = agency.listAvailableCars();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
                agency.removeCar(car);
                System.out.println("Car removed successfully!");
                return;
            }
        }
        System.out.println("Car not found.");
    }

    private static void searchAvailableCars() {
        System.out.print("Enter car type to search: ");
        String carType = scanner.nextLine();

        List<Car> cars = agency.searchAvailableCars(carType);
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    private static void rentCar() {
        System.out.print("Enter customer's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer's driver's license number: ");
        String driversLicenseNumber = scanner.nextLine();
        System.out.print("Enter customer's phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter customer's email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(name, driversLicenseNumber, phoneNumber, email);

        System.out.print("Enter car make to rent: ");
        String make = scanner.nextLine();
        System.out.print("Enter car model to rent: ");
        String model = scanner.nextLine();

        List<Car> cars = agency.listAvailableCars();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                System.out.print("Enter rental start date (yyyy-mm-dd): ");
                String startDate = scanner.nextLine();
                System.out.print("Enter rental end date (yyyy-mm-dd): ");
                String endDate = scanner.nextLine();

                boolean rented = agency.rentCar(car, customer, startDate, endDate);
                if (rented) {
                    System.out.println("Car rented successfully!");
                } else {
                    System.out.println("Car is not available.");
                }
                return;
            }
        }
        System.out.println("Car not found or not available.");
    }

    private static void returnCar() {
        System.out.print("Enter car make to return: ");
        String make = scanner.nextLine();
        System.out.print("Enter car model to return: ");
        String model = scanner.nextLine();

        List<Rental> rentals = agency.listOngoingRentals();
        for (Rental rental : rentals) {
            Car car = rental.getCar();
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
                double fee = agency.returnCar(car);
                System.out.println("Car returned successfully! Total fee: $" + fee);
                return;
            }
        }
        System.out.println("Rental record not found.");
    }

    private static void listAvailableCars() {
        List<Car> cars = agency.listAvailableCars();
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    private static void listOngoingRentals() {
        List<Rental> rentals = agency.listOngoingRentals();
        if (rentals.isEmpty()) {
            System.out.println("No ongoing rentals.");
        } else {
            for (Rental rental : rentals) {
                System.out.println(rental.getCar() + " rented by " + rental.getCustomer() + " from " + rental.getStartDate() + " to " + rental.getEndDate());
            }
        }
    }
}
