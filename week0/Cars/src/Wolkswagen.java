public class Wolkswagen implements Car {
    private String brand = "Wolkswagen";
    private String releaseDate;
    
    Wolkswagen(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
}
