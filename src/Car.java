interface Car {
    boolean drive();
    void turn();
    class Construct{ //right
        void buildEngine(){
            System.out.println("Car Engine");
        }
        void buildBody(){
            System.out.println("Car body");
        }
        void constructCar(){
            System.out.println("Constructing Car components");
            buildEngine();
            buildBody();
        }
    }
}
