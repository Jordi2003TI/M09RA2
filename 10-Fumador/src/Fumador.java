import java.util.Random;

public class Fumador extends Thread{
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int fuamades = 0;

    public Fumador(int id, Estanc estanc){
        this.id = id;
        this.estanc = estanc;
    }

    public void compraTabac(){
        System.out.println("Fumador " + id + " comprant tabac");
        this.tabac = estanc.venTabac();
    }

    public void compraPaper(){
        System.out.println("Fumador " + id + " comprant paper");
        this.paper = estanc.venPaper();
    }

    public void compraLlumi(){
        System.out.println("Fumador " + id + " comprant llumi");
        this.llumi = estanc.venLlumi();
    }

    public void fuma(){
        if(tabac != null && llumi != null && paper != null){
            try{
                Random random = new Random();
                int tiempoEspera = 500 + random.nextInt(1001); // entre 0,5 y 1 segundo
                System.out.println("Fumador " + id + " fumant");
                Thread.sleep(tiempoEspera);
                fuamades++;
                tabac = null;
                llumi = null;
                paper = null;
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void run(){
        while(fuamades < 3){
            compraTabac();
            compraPaper();
            compraLlumi();

            fuma();

            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Fumador " + id + " ha fumat 3 vegades");
    }


}
