public class DormAleatori extends Thread{
    
    private long instaniciaMilis;

    public DormAleatori(String name){
        super(name);
        instaniciaMilis = System.currentTimeMillis();
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            try{
                int aleatorio = (int) (Math.random() * 900 + 100);

                long tiempoTotal = System.currentTimeMillis() - instaniciaMilis;
                
                System.out.println(
                        getName() + " (" + i + ") a dormir "
                        + aleatorio + "ms total "
                        + tiempoTotal + "ms"
                );

                Thread.sleep(aleatorio);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("=== Fi de main ===");

        DormAleatori uno = new DormAleatori("Joan");
        DormAleatori dos = new DormAleatori("Pep");

        uno.start();
        dos.start();
    }
}
