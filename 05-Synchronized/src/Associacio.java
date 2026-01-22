public class Associacio{
    private final int numSocis = 1000;
    private Soci[] socis;

    public Associacio(){
        this.socis = new Soci[1000];
        for(int i = 0; i < numSocis; i++){
            socis[i] = new Soci();
            
        }
    }

    public void iniciaComptesTempsSocis(){
        for(Soci s: socis){
            s.start();
        }
    }

    public void esperaPeriodeSocis(){
        for(Soci s: socis){
            try{
                s.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes(){
        System.out.println("Saldo final: " + Compte.getInstace().getSaldo());
    }

    public static void main(String[] args) {
        Associacio as = new Associacio();
        as.iniciaComptesTempsSocis();
        as.esperaPeriodeSocis();
        as.mostraBalancComptes();
    }

}