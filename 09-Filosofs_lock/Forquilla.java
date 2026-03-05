import java.util.concurrent.locks.ReentrantLock;
/*Clase de forquilla donde pondremos las varibles y metodos necesarios de la practica */
public class Forquilla{
    private int numero;
    private ReentrantLock bloqueig;

    public Forquilla (int numero){
        this.numero = numero;
        this.bloqueig = new ReentrantLock();
    }

    public int getNum(){
        return numero;
    }

    public void agafar(){
        bloqueig.lock();
    }

    public void deixar(){
        bloqueig.unlock();
    }
}