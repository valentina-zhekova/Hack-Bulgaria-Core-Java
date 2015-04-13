public class Audi implements Car {
    private String brand = "Audi"; // set + constructor calling set; return just "Audi"
    private String releaseDate;
    private double mileage;
    
    public Audi(double mileage, String releaseDate) {
        this.mileage = mileage;
        this.releaseDate = releaseDate;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    
    public void setBrand(double mileage) {
        this.mileage = mileage;
    }
    
    public double getMileage() {
        return mileage;
    }
}
