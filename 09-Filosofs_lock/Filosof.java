import java.util.concurrent.TimeUnit;

public class Filosof extends Thread {
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private long iniciGana;
    private long fiGana;
    private long gana;
    private int id;

    public Filosof(int id, String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.id = id;
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
    }

    private long espera(int min, int max) {
        return (long) (Math.random() * (max - min) + min) * 1000;
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        // Un cop té les dues, mostrem el missatge
        System.out.printf("%s té forquilles esq(%d) dreta(%d)%n", 
            nom, forquillaEsquerra.getNum(), forquillaDreta.getNum());
    }

    public void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar();
    }

    public void agafarForquillaDreta() {
        forquillaDreta.agafar();
    }

    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.printf("%s deixa les forquilles%n", nom);
    }

    public void menjar() {
        try {
            iniciGana = System.currentTimeMillis();
            agafarForquilles();
            
            fiGana = System.currentTimeMillis();
            calcularGana();
            System.out.printf("%s menja amb gana %d%n", nom, gana);
            
            Thread.sleep(espera(1, 2)); // Menja entre 1 i 2 segons
            
            System.out.printf("%s ha acabat de menjar%n", nom);
            deixarForquilles();
            resetGana();
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void pensar() {
        try {
            iniciGana = System.currentTimeMillis();
            System.out.printf("%s pensant%n", nom);
            Thread.sleep(espera(1, 2)); // Pensa entre 1 i 2 segons
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void calcularGana() {
        gana = TimeUnit.MILLISECONDS.toSeconds(fiGana - iniciGana);
    }

    public void resetGana() {
        iniciGana = 0;
        gana = 0;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            pensar();
            menjar();
        }
    }
}