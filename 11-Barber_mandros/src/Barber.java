import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Barber extends Thread {
    private String nom;
    private Barberia barberia;
    private Random random;
    private Client client;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (barberia.condBarber) {
                client = barberia.seguentClient();
                
                if (client != null) {
                    System.out.println("Li toca al client " + client.getNom());

                    // Cortar el pelo (0.9s + random 0.1s)
                    try {
                        Thread.sleep(900 + random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    client.tallarseElCabell();
                } else {
                    try {
                        System.out.println("Ningú en espera");
                        System.out.println("Barber " + nom + " dormint");
                        barberia.condBarber.wait(); // Barbero se duerme
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}