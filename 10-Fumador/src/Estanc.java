import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread{
    private List<Tabac> tabacs;
    private List<Llumi> llumins;
    private List<Paper> papers;
    private boolean obert;

    public Estanc(){
        tabacs = new ArrayList<>();
        llumins = new ArrayList<>();
        papers = new ArrayList<>();
        obert = true;
    }

    public void nouSubministrament(){
        Random random = new Random();
        int opcion = random.nextInt(3);

        switch (opcion) {
            case 0:
                addTabac(new Tabac());
                break;
            case 1:
                addPaper(new Paper());
                break;
            case 2:
                addLlumi(new Llumi());
                break;
            default:
                break;
        }

    }

    public synchronized void addTabac(Tabac tabac){
        System.out.println("Afegint tabac");
        tabacs.add(tabac);
        notifyAll();
    }

    public synchronized void addLlumi(Llumi llumi){
        System.out.println("afegint llumi");
        llumins.add(llumi);
        notifyAll();
    }

    public synchronized void addPaper(Paper paper){
        System.out.println("Afegint paper");
        papers.add(paper);
        notifyAll();
    }

    public void tancarEstanc(){
        System.out.println("Estanc tancat");
        obert = false;
    }

    public synchronized Tabac venTabac(){
        while (tabacs.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        if(!obert) return null;

        Tabac t = tabacs.remove(0);
        return t;
    }

    public synchronized Paper venPaper(){
        while (papers.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        if(!obert) return null;

        Paper p = papers.remove(0);
        return p;
    }

    public synchronized Llumi venLlumi(){
        while (llumins.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        if(!obert) return null;

        Llumi l = llumins.remove(0);
        return l;
    }

    @Override
    public void run(){
        while(obert){
            nouSubministrament();

            try{
                Random random = new Random();
                int tiempoEspera = 500 + random.nextInt(1001); // entre 0,5 y 1 segundo
                Thread.sleep(tiempoEspera);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}
