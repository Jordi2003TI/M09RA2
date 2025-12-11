public class PrincipalIguals {

    public static void main(String[] args) {

        Fil juan = new Fil("Juan", 9, Thread.NORM_PRIORITY, 0, 1);
        Fil pepe = new Fil("Pepe", 9, Thread.NORM_PRIORITY, 0, 1);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");

        
    }
}
