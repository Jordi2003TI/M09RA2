public class Forquilla {
    private int numero;
    private int propietari;
    public static final int LLIURE = -1;

    public Forquilla(int numero){
        this.numero = numero;
        this.propietari = LLIURE;
    }

    public int getNumero(){
        return numero;
    }

    public synchronized int getPropietari(){
        return propietari;
    }

    public synchronized void setPropietari(int propietari){
        this.propietari = propietari;
        notifyAll(); // Notifica quan canvia de propietari
    }
    
    public synchronized void esperar() throws InterruptedException {
        wait();
    }
}