public class Rental {
    private Car car;
    private Customer customer;
    private String startDate;
    private String endDate;

    public Rental(Car car, Customer customer, String startDate, String endDate) {
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    // Calculate total fee
    public double calculateTotalFee() {
        // For simplicity, assuming each month has 30 days
        int rentalDays = (Integer.parseInt(endDate.split("-")[0]) - Integer.parseInt(startDate.split("-")[0])) * 30 +
                (Integer.parseInt(endDate.split("-")[1]) - Integer.parseInt(startDate.split("-")[1]));
        return rentalDays * car.getDailyRate();
    }
}
