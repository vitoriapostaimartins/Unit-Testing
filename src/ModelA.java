class ModelA implements Car{
    private int distance = 0;
    public static final int MAX_DISTANCE = 3;
    static class myConstructA extends Car.Construct{
        void buildEngine(){
            System.out.println("basic engine");
        }
        void buildBody(){
            System.out.println("ModelA body");
        }

    }
     private ModelA(){
        myConstructA myA = new myConstructA();
        myA.constructCar();
    }
    @Override
    public boolean drive() {
        System.out.println("ModelA drove " + distance);
        if(distance < (MAX_DISTANCE - 1)){
            distance++;
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void turn() {
        System.out.println("turning ModelA");
        distance = 0;
    }

    public static  CarFactory factory = ModelA::new;
}
