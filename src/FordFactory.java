import java.lang.Thread;



public class FordFactory {
    public static void produce(CarFactory factory) {
        int turn = 0;
        Car c = factory.getCar();
        while(c.drive()){
            try{
                Thread.sleep(300);
            }catch(Exception e){}
            turn = (int)(Math.random()*4);
            if ( turn > 2)
                c.turn();
        }
    }
    public static void main(String[] args) {
        produce(ModelA.factory);
        produce(ModelT.factory);
    }
} 