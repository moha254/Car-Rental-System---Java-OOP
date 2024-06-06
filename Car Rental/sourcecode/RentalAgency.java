import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private String name;
    private List<Car> availableCars;
    private List<Rental> ongoingRentals;

    public RentalAgency(String name) {
        this.name = name;
        this.availableCars = new ArrayList<>();
        this.ongoingRentals = new ArrayList<>();
    }

    // Add a car to the inventory
    public void addCar(Car car) {
        availableCars.add(car);
    }

    // Remove a car from the inventory
    public void removeCar(Car car) {
        availableCars.remove(car);
    }

    // Search for available cars by car type
    public List<Car> searchAvailableCars(String carType) {
        List<Car> result = new ArrayList<>();
        for (Car car : availableCars) {
            if (car.isAvailable() && car.getCarType().equalsIgnoreCase(carType)) {
                result.add(car);
            }
        }
        return result;
    }

    // Rent a car to a customer
    public boolean rentCar(Car car, Customer customer, String startDate, String endDate) {
        if (car.isAvailable()) {
            car.setAvailability(false);
            ongoingRentals.add(new Rental(car, customer, startDate, endDate));
            return true;
        }
        return false;
    }

    // Return a car
    public double returnCar(Car car) {
        for (Rental rental : ongoingRentals) {
            if (rental.getCar().equals(car)) {
                car.setAvailability(true);
                ongoingRentals.remove(rental);
                return rental.calculateTotalFee();
            }
        }
        return 0;
    }

    // List all available cars
    public List<Car> listAvailableCars() {
        List<Car> result = new ArrayList<>();
        for (Car car : availableCars) {
            if (car.isAvailable()) {
                result.add(car);
            }
        }
        return result;
    }

    // List all ongoing rentals
    public List<Rental> listOngoingRentals() {
        return new ArrayList<>(ongoingRentals);
    }
}
