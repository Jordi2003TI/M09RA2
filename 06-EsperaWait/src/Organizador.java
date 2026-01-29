public class Organizador {
    public static void main(String[] args) {
        Esdeveniment concert = new Esdeveniment(5);
        
        for (int i = 0; i < 10; i++) {
            Assistent a = new Assistent("Assistent-" + i, concert);
            a.start();
        }
    }
}
