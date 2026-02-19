public class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs){
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        //creamos las forquilles
        for(int i = 0; i < numFilosofs; i++){
            forquilles[i] = new Forquilla(i);
        }

        // Creamos los filosofos y le asignamos forquillas
        for(int i = 0; i < numFilosofs; i++){
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof("fil" + i, esquerra, dreta); 
        }
    }

    public void showTaula(){
        for(int i = 0; i < filosofs.length; i++){
            System.out.println("Comensal:fil" + i + " esq:" + i + " dret:" + ((i + 1) % filosofs.length));
        }
        System.out.println("---");
    }

    public void cridarATaula() {
        for (int i = 0; i < filosofs.length; i++) {
            filosofs[i].start();
        }
        
        try {
            for (int i = 0; i < filosofs.length; i++) {
                filosofs[i].join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
