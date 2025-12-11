public class PrincipalsDiferents {
    public class PrincipalDiferents {

    public static void main(String[] args) {
 
        Fil pepe = new Fil("Pepe", 9, Thread.MIN_PRIORITY, 0, 1);

        Fil juan = new Fil("Juan", 9, Thread.MAX_PRIORITY, 0 , 1);

        pepe.start();

        juan.start();

        System.out.println("Acaba thread main");

    }
}

}
