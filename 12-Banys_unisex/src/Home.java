public class Home extends Thread{
    private  String nom;
    private static BanyUnisex banyUnisex;


    public Home(String nom, BanyUnisex banyUnisex){
        this.nom = nom;
        this.banyUnisex = banyUnisex;
    }

    @Override
    public void run(){
        try {
            // aqui deberiamos hacer que un hombre use un baño y entre
            banyUnisex.entraHome(nom);
            ultilizaLavabo();
            banyUnisex.surtHome(nom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ultilizaLavabo(){
        try{
            int timepo = (int)(Math.random() * 1000) + 1000; // con esto hacemos que duerma entre 1 a 2s
            Thread.sleep(timepo);
            System.out.println(nom + "ha acabat d'usar el bany");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
}
