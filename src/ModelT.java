class ModelT implements Car{
    private int distance = 0;
    public static final int MAX_DISTANCE = 5;
    static class myConstructT extends Car.Construct{
        void buildEngine(){
            System.out.println("improved engine");
        }
        void buildBody(){
            System.out.println("ModelT body");
        }

    }
    private ModelT(){
        myConstructT myT = new myConstructT();
        myT.constructCar();
    }
    @Override
    public boolean drive() {
        System.out.println("ModelT drove " + distance);
        if(distance < (MAX_DISTANCE - 1)){
            distance++;
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void turn() {
        System.out.println("turning ModelT");
        distance = 0;
    }

    public static CarFactory factory = ModelT::new;
}
