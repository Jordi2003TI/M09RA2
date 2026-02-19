public class Filosof extends Thread {
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private boolean menjant;

    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta){
        this.nom = nom; 
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
        this.menjant = false;
    }

    public void menjar(){
        try{
            System.out.println("Filòsof: " + nom + " menja");
            Thread.sleep((long) (Math.random() * 1000) + 1000); // 1 - 2 segundos
            System.out.println("Filòsof: " + nom + " ha acabar de menjar");
            gana = 0;
            menjant = false;
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void pensar(){
        try{
            System.out.println("Filòsof: " + nom + " pensant");
            Thread.sleep((long) (Math.random() * 1000) + 1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private boolean agafarForquilles(){
        if(!forquillaEsquerra.isEnUs()){
            forquillaEsquerra.setEnUs(true);
            System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
        
            if(!forquillaDreta.isEnUs()){
                forquillaDreta.setEnUs(true);
                System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getNumero());
            }

            return true;
        }else{
            forquillaEsquerra.setEnUs(false);
            System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + forquillaEsquerra.getNumero() + ") i espera (dreta ocupada)");
            System.out.println("Filòsof: " + nom + " gana=" + gana);
            return false;
        }
    }

    private void deixarForquiles(){
        forquillaEsquerra.setEnUs(false);
        forquillaDreta.setEnUs(false);
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            try{
                if(!menjant){
                    if(!agafarForquilles()){
                        menjant = true;
                        menjar();
                        deixarForquiles();
                    }else{
                        gana++;
                        Thread.sleep((long) (Math.random() * 500) + 500); // de 0.5 a 1s
                    }
                }else{
                    pensar();
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
