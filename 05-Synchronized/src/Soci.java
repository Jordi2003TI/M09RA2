import java.util.Random;

public class Soci extends Thread{
    private final Compte compte;
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private final int maxAnys = 10;
    private final Random random = new Random();

    public Soci(){
        this.compte = Compte.getInstace();
    }

    @Override 
    public void run(){
        for(int m = 0; m < maxAnys * 12; m++){
            if(m % 2 == 0){
                compte.ingressar(aportacio);
            }else{
                compte.retirar(aportacio);
            }
        }

        try{
            Thread.sleep(random.nextInt(esperaMax));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
