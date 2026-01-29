import java.util.Random;
public class Assistent extends Thread{
    private String nom;
    private final Esdeveniment esdeveniment;
    private final Random random = new Random();

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run(){
        double prob = random.nextDouble();
        try {
            while (true) {
                if(prob < 0.70){ // aqui hacemos un 50% de posibilidades de que ocurra una de las dos opciones a haces reserva o cancelas
                    esdeveniment.ferReserva(this); // mandamos la propia instancia nuestra
                }else {
                    esdeveniment.cancelarReserva(this);
                }
                // Se espera aleatoriamente entre 1 y 0
                Thread.sleep(random.nextInt(1001));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNom(){
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
