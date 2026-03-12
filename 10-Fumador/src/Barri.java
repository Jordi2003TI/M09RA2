import java.util.ArrayList;

public class Barri {
    private Estanc estanc;
    private Fumador[] fumadores;

    public Barri(){
        estanc = new Estanc();
        fumadores = new Fumador[3];

        estanc.start();
         

        for(int i = 0; i < fumadores.length; i++){
            fumadores[i] = new Fumador(i, estanc);
        }

        for(Fumador f: fumadores){
            f.start();
        }

        for(Fumador f: fumadores){
            try{
                f.join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        estanc.tancarEstanc();
        try{
            estanc.join();
        }catch(Exception e){
            e.printStackTrace();
        }  

        

    }

    public static void main(String[] args){
        Barri barri = new Barri();


    }
}
