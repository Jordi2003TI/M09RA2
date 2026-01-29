import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private final int maxPlazas;
    private int plazasDisponibles;
    private static final List<Assistent> asistentes = new ArrayList<>();

    public Esdeveniment(int maxPlazas){
        this.maxPlazas = maxPlazas;
        this.plazasDisponibles = maxPlazas;
    }

    public synchronized void ferReserva(Assistent assistent){
        
        while(plazasDisponibles == 0){
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

        asistentes.add(assistent);
        plazasDisponibles--;
        System.out.println(assistent.getName() + " ha fet una reserva. Places disponibles: " + plazasDisponibles);
    }

    public synchronized void cancelarReserva(Assistent assistent){
        if(asistentes.contains(assistent)){
            asistentes.remove(assistent);
            plazasDisponibles++;

            System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + plazasDisponibles);
            //Tenemos que informar que cuando haya un plaza disponible a los demas para que el siguiente la pille
            notifyAll();
        }else{
            System.out.println(assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + plazasDisponibles);
        }

    }

}
