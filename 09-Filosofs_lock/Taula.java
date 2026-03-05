public class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosfs){
        filosofs = new Filosof[numFilosfs];
        forquilles = new Forquilla[numFilosfs];

        for(int i = 0; i < numFilosfs; i++){
            forquilles[i] = new Forquilla(i);
        }

        for(int i = 0; i < numFilosfs; i++){
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i+1) % numFilosfs];
            filosofs[i] = new Filosof(i, "Fil" + i, esquerra, dreta);
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.printf("Comensal: Fil%d esq: %d dret: %d%n", 
                i, i, (i + 1) % filosofs.length);
        }
        System.out.println("---");
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }

        try {
            for (Filosof f : filosofs) {
                f.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
