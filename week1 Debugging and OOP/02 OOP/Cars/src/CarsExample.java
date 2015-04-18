public class CarsExample {
    // think of more interesting structure; more than one package (GermanCar)
    
    public static void main(String[] args) {
        Audi car1 = new Audi((double) 23, "today");
        System.out.println("The mileage of the car are " + car1.getMileage());
    }
}
