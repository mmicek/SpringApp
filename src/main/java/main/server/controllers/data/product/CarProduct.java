package main.server.controllers.data.product;


public class CarProduct extends Product {

    @Additional
    private String vin;
    @Additional
    private int year;
    @Additional
    private int mileage;

    public CarProduct(){}

    public CarProduct(String vin,int year,int mileage){
        //TODO REMOVE only for testing
        super("Auto",23000,123456789);
        this.vin = vin;
        this.year = year;
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
