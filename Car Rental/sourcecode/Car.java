public class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private String carType;
    private double dailyRate;
    private boolean availability;

    public Car(String make, String model, int year, int mileage, String carType, double dailyRate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.carType = carType;
        this.dailyRate = dailyRate;
        this.availability = true;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", carType='" + carType + '\'' +
                ", dailyRate=" + dailyRate +
                ", availability=" + availability +
                '}';
    }
}
