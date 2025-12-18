public class MainFutbol {
    public static void main(String[] args) {
        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbapé"
        };

        Futbolista[] jugadores = new Futbolista[Futbolista.NUM_JUAGDORS];

        System.out.print("Inici del xuts --------------------");
        
        for(int i = 0; i < jugadores.length; i++){
            jugadores[i] = new Futbolista(noms[i]);
        }

        for(Futbolista f : jugadores){
            f.start();
        }

        for (Futbolista f : jugadores) {
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts --------------------");
        System.out.println("--- Estadísticas ---");

         for (Futbolista f : jugadores) {
            System.out.println(f.getName() + " -> " + f.getNgolsIntirades() + " gols");
        }
    }
}
