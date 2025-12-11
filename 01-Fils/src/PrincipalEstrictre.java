public class PrincipalEstrictre {
    public static void main(String[] args){
    Fil juan = new Fil("Juan", 9, Thread.MAX_PRIORITY, 1, 0);
    Fil pepe = new Fil("Pepe", 9, Thread.MIN_PRIORITY, 1, 0);

    juan.start();
    pepe.start();

    System.out.println("Acaba thread main");

    }
}
