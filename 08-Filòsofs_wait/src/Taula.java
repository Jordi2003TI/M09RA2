public class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs){
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        // creamos todos los filosofos
        for(int i = 0; i < numFilosofs; i++){
            forquilles[i] = new Forquilla(i);
        }

        // Crear los filosofos y sus tenerdores 
        for(int i = 0; i < numFilosofs; i++){
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof(i, "fil" + i, esquerra, dreta);
        }
    }

    public void showTaula(){
        for(int i = 0; i < filosofs.length; i++){
            System.out.println("Comensal: fil" + i + " esq:" + i + " dret:" + ((i + 1) % filosofs.length));
        }
        System.out.println("---");
    }

    public void cridarATaula(){
        for(Filosof f : filosofs){
            f.start();
        }

        try {
            for(Filosof f : filosofs){
                f.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
