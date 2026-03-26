import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    private final String BANY_BUIT = "BANY_BUIT";
    private final String BANY_AMB_HOMES = "BANY_AMB_HOMES";
    private final String BANY_AMB_DONES = "BANY_AMB_DONES";
    private String estatActual = BANY_BUIT;
    private static final int CAPACITAT_MAX = 3;
    private static Semaphore capacidad = new Semaphore(CAPACITAT_MAX);
    private static int ocupats = 0;
    private ReentrantLock lock = new ReentrantLock(true);


    public static void main(String[] args){
        BanyUnisex bany = new BanyUnisex(); // mismo baño para todos
        List<Home> homes = new ArrayList<>();
        List<Dona> dones = new ArrayList<>();

        
        for(int i = 1; i <= 5; i++){
            Home home = new Home("Home-" + i, bany);
            homes.add(home);
        }

        for(int i = 1; i <= 5; i++){
            Dona Dona = new Dona("Dona-" + i, bany);
            dones.add(Dona);
        }

        for(Home h: homes){
            h.start();
        }
        
        for(Dona d: dones){
            d.start();
        }

        for(Home h: homes){
            h.join();
        }
        
        for(Dona d: dones){
            d.join();
        }


        
    }

    public void entraHome(String nom){
        System.out.println(nom + "Vol entrar al bany");
        if(capacidad.tryAcquire()){
            lock.lock();
            ocupats++;
            System.out.println(nom + "entra en el bany. Ocupants: " + ocupats);
        }
    }

    public void surtHome(String nom){
        ocupats--;
        System.out.println(nom + "surt del bany. Ocupants: " + ocupats);
        capacidad.release();
        lock.unlock();
    }

    public void entraDona(String nom){
        System.out.println(nom + "Vol entrar al bany");
        if(capacidad.tryAcquire()){
            lock.lock();
            ocupats++;
            System.out.println(nom + "entra en el bany. Ocupants: " + ocupats);
        }
    }

    public void surtDona(String nom){
        ocupats--;
        System.out.println(nom + "surt del bany. Ocupants: " + ocupats);
        capacidad.release();
        lock.unlock();
    }
}
