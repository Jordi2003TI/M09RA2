public class Dona extends Thread{
    private  String nom;
    private static BanyUnisex banyUnisex;

    public Dona(String nom, BanyUnisex banyUnisex){
        this.nom = nom;
        this.banyUnisex = banyUnisex;
    }

    @Override
    public void run(){
        try {
            // aqui deberiamos hacer que un dona use un baño y entre
            System.out.println(nom + " vol entrar al bany");
            banyUnisex.entraDona(nom);
            ultilizaLavabo();
            banyUnisex.surtDona(nom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ultilizaLavabo(){
        try{
            int timepo = (int)(Math.random() * 1000) + 2000; // con esto hacemos que duerma entre 1 a 2s
            Thread.sleep(timepo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
