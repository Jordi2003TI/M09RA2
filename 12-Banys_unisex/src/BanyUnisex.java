import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import javax.imageio.IIOException;

public class BanyUnisex extends Thread{
    private final String BANY_BUIT = "BANY_BUIT";
    private final String BANY_AMB_HOMES = "BANY_AMB_HOMES";
    private final String BANY_AMB_DONES = "BANY_AMB_DONES";
    private String estatActual = BANY_BUIT;
    private static final int CAPACITAT_MAX = 3;
    private static Semaphore capacidad = new Semaphore(CAPACITAT_MAX);
    private static int ocupats = 0;
    private ReentrantLock lock = new ReentrantLock(true);


    public static void main(String[] args) throws IOException{
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
            try{
                h.join();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        for(Dona d: dones){
            try{
                d.join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }


        
    }

    public void entraHome(String nom){
        while(true){
            lock.lock();
            try{
                if(estatActual.equals(BANY_BUIT) || estatActual.equals(BANY_AMB_HOMES)){
                    if(capacidad.tryAcquire()){
                        ocupats++;
                        estatActual = BANY_AMB_HOMES;
                        System.out.println("Home entra al bany. Ocupants: " + ocupats);
                        return;
                }
            }
            }finally{
                lock.unlock();
            }
        }
    }

    public void surtHome(String nom){
        try{
            ocupats--;
            capacidad.release();
            if(estatActual.equals(BANY_AMB_HOMES) && ocupats <= 0){
                estatActual = BANY_BUIT;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(nom + "ha acabat d'usar el bany");
    }

    public void entraDona(String nom){
        while(true){
            lock.lock();
            try{
                if(estatActual.equals(BANY_BUIT) || estatActual.equals(BANY_AMB_DONES)){
                    if(capacidad.tryAcquire()){
                        ocupats++;
                        estatActual = BANY_AMB_DONES;
                        System.out.println("Home entra al bany. Ocupants: " + ocupats);
                        return;
                }
            }
            }finally{
                lock.unlock();
            }
        }
    }

    public void surtDona(String nom){
        try{
            ocupats--;
            capacidad.release();
            if(estatActual.equals(BANY_AMB_DONES) && ocupats <= 0){
                estatActual = BANY_AMB_DONES;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(nom + "ha acabat d'usar el bany");
    }
}
