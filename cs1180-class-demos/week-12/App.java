public class App {
    public static void main(String[] args) throws Exception {
        // Using Bicycle.java
        Bicycle road_bike = new Bicycle();
        Bicycle mountain_bike = new Bicycle();

        System.out.println("Road bikes bar tape value is: " + road_bike.getBarTape());
        road_bike.setBarTape(road_bike.getBarTape() - 1);
        System.out.println("Road bikes bar tape value is: " + road_bike.getBarTape());
        System.out.println("Mountain bikes bar tape value is: " + mountain_bike.getBarTape());

        Bicycle bike1 = new Bicycle("Square", 50, 8);
        System.out.println(bike1.toString());
        
        Bicycle[] user_bikes = new Bicycle[4];
    }
}