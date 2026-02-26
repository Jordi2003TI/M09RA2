public class Filosof extends Thread {
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private int id;

    public Filosof(int id, String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        this.id = id;
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
    }

    public int getIdFilosof(){
        return id;
    }

    public int getGana() {
        return gana;
    }

    public void passarGana() {
        gana++;
    }

    private long espera(int min, int max) {
        return (long) (Math.random() * (max - min)) + min;
    }


    public synchronized void agafarForquilles()throws InterruptedException {
        while (true) {
            if (forquillaEsquerra.getPropietari() == Forquilla.LLIURE) {
                forquillaEsquerra.setPropietari(id);
                System.out.printf("Filòsof: %s agafa la forquilla esquerra %d%n", nom, forquillaEsquerra.getNumero());

                if (forquillaDreta.getPropietari() == Forquilla.LLIURE) {
                    forquillaDreta.setPropietari(id);
                    System.out.printf("Filòsof: %s agafa la forquilla dreta %d%n", nom, forquillaDreta.getNumero());
                    return;
                } else {
                    forquillaEsquerra.setPropietari(Forquilla.LLIURE);
                    System.out.printf("Filòsof: %s deixa l'esquerra(%d) i espera (dreta ocupada)%n", 
                        nom, forquillaEsquerra.getNumero());
                    passarGana();
                    System.out.printf("Filòsof: %s gana=%d%n", nom, gana);
                }
            }
            
            try {
                wait(espera(500, 1001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public synchronized void deixarForquilles(){
        forquillaEsquerra.setPropietari(Forquilla.LLIURE);
        forquillaDreta.setPropietari(Forquilla.LLIURE);
        
        System.out.printf("Filòsof: %s deixa les forquilles%n", nom);
    }

    public void menjar(){
        try{
            System.out.printf("Filòsof: %s menja%n", nom);
            Thread.sleep(espera(1000, 2001)); // De 1 a 2 segundos 
            System.out.printf("Filòsof: %s ha acabat de menjar%n", nom);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void pensar(){
        try{
            System.out.printf("Filòsof: %s pensant%n", nom);
            Thread.sleep(espera(1000, 2001));
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                agafarForquilles();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            menjar();
            deixarForquilles();
            pensar();
        }
    }
    
}
