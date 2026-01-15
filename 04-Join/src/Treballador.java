import java.util.Random;

public class Treballador extends Thread{
    private int sou_anual_brut;
    private int edad_inici_treball;
    private int edad_fi_treball;
    private int edad_actual;
    private float cobrado;
    private Random rand;

    public Treballador(String nom, int sueldo, int inicio, int fi){
        super(nom);
        edad_fi_treball = fi;
        edad_inici_treball = inicio;
        edad_actual = 0;
        sou_anual_brut = sueldo;
        cobrado = 0.0f;
        rand = new Random();
    }

    public void cobra(){
        this.cobrado += (sou_anual_brut / 12.0f);
    }

    public float getCobrado(){
        return cobrado;
    }

    public int getEdad(){
        return edad_actual;
    }

    public void pagaImpuestos(){
        float mensualidad = sou_anual_brut / 12.0f;
        cobrado -= (mensualidad * 0.24f);
    }

    @Override
    public void run(){
        try{
            for (edad_actual = edad_inici_treball; edad_actual < edad_fi_treball; edad_actual++) {
                Thread.sleep(10);
                for (int mes = 1; mes <= 12; mes++) {
                    this.cobra();
                    this.pagaImpuestos();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}