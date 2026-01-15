public class Administració {
    private static final int num_poblacio_activa = 50;
    private static Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administració(){
        for(int i = 0; i < num_poblacio_activa; i++){
            poblacio_activa[i] = new Treballador("Ciutada- " + i, 25000, 20, 65);
        }
    }
    public static void main (String[] args){
        Administració administració = new Administració();

        for(Treballador t : poblacio_activa){
            t.start();
        }
        // El join es para decirle que pare hasta aqui y hasta que el hilo no se haya hecho del todo no continues el main.
        // En nuestro caso del ejercicio nos hace que cada trabajador no siga hasta que acabe su ciclo de vida
        try {
            for(Treballador t: poblacio_activa){
                t.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Treballador t : poblacio_activa){
            System.out.printf("%s-> edad: %d / total: %.2f\n", t.getName(), t.getEdad(), t.getCobrado());
        }
    }
}
