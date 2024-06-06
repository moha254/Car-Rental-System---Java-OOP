import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {
    private RentalAgency agency;
    private Car car1;
    private Car car2;
    private Customer customer;

    @BeforeEach
    void setUp() {
        agency = new RentalAgency("Best Rentals");
        car1 = new Car("Toyota", "Camry", 2020, 15000, "Sedan", 50);
        car2 = new Car("Honda", "CRV", 2021, 10000, "SUV", 70);
        customer = new Customer("John Doe", "D123456", "555-1234", "john@example.com");

        agency.addCar(car1);
        agency.addCar(car2);
    }

    @Test
    void testAddAndRemoveCar() {
        Car car3 = new Car("Ford", "Fiesta", 2019, 20000, "Hatchback", 40);
        agency.addCar(car3);
        assertEquals(3, agency.listAvailableCars().size());

        agency.removeCar(car3);
        assertEquals(2, agency.listAvailableCars().size());
    }

    @Test
    void testSearchAvailableCars() {
        List<Car> sedans = agency.searchAvailableCars("Sedan");
        assertEquals(1, sedans.size());
        assertEquals("Toyota", sedans.get(0).getMake());

        List<Car> suvs = agency.searchAvailableCars("SUV");
        assertEquals(1, suvs.size());
        assertEquals("Honda", suvs.get(0).getMake());
    }

    private void assertEquals(String string, String make) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    void testRentCar() {
        boolean rented = agency.rentCar(car1, customer, "2023-06-01", "2023-06-10");
        assertTrue(rented);
        assertTrue(car1.isAvailable());
        assertEquals(1, agency.listOngoingRentals().size());
    }

    @Test
    void testReturnCar() {
        agency.rentCar(car1, customer, "2023-06-01", "2023-06-10");
        double fee = agency.returnCar(car1);
        assertEquals(500, fee);
        assertTrue(car1.isAvailable());
        assertEquals(0, agency.listOngoingRentals().size());
    }

    private void assertEquals(int i, double fee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    private void assertEquals(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    private void assertTrue(boolean available) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }

    @Test
    void testListAvailableCars() {
        List<Car> availableCars = agency.listAvailableCars();
        assertEquals(2, availableCars.size());
    }

    @Test
    void testListOngoingRentals() {
        agency.rentCar(car1, customer, "2023-06-01", "2023-06-10");
        List<Rental> ongoingRentals = agency.listOngoingRentals();
        assertEquals(1, ongoingRentals.size());
    }
}
