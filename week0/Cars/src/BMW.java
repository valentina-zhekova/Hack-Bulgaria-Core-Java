public class BMW implements Car {
    private String brand = "BMW";
    private String releaseDate;
    
    BMW(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
}
