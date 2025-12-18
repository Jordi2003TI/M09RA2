import java.util.concurrent.Future;

public class Futbolista extends Thread{
    public static final int NUM_JUAGDORS = 11;
    public static final int NUM_TIRADAS = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngolsIntirades;

    public Futbolista(String name){
        super(name);
        this.ngolsIntirades = 0;
    }

    public int getNgolsIntirades(){
        return ngolsIntirades;
    }

    @Override 
    public void run(){
        for(int i = 0; i < NUM_TIRADAS; i++){
            if(Math.random() < PROBABILITAT){
                ngolsIntirades++;
            }
        }
    }
}