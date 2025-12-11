public class Fil extends Thread {
    private int interaciones;  
    private int delay;  
    private int FOR;        

    public Fil(String nom, int interaciones, int prioridad, int delay, int FOR) {
        super(nom);
        this.interaciones = interaciones;
        this.delay = delay;
        setPriority(prioridad);
        this.FOR = FOR;
    }


    @Override
    public void run() {
        for (int i = 1; i <= this.interaciones; i++) {
            if(FOR == 1){
                for(int j = 0; j  <= 1000; j++){
                    // solo iteramos
                }
            }
            System.out.println(getName() + " " + i);

            if(delay > 0){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Acaba el fil " + getName());
    }
}