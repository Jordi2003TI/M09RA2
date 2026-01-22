public class Compte {
    private float saldo = 0;
    private static Compte instancia;

    public Compte(){
        
    }

    public static Compte getInstace(){
        if(instancia == null){
            instancia = new Compte();
        }
        return instancia;
    }

    public float getSaldo(){
        return saldo;
    }

    public synchronized void ingressar(float cantidad){
        saldo += cantidad;
    }

    public synchronized void retirar(float cantidad){
        saldo -= cantidad;
    }
}
