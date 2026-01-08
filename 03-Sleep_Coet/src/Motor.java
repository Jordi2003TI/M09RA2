import java.util.Random;
import java.util.Scanner;

public class Motor extends Thread {
    private int id;
    private int potenciaActual;
    private int potenciaObjetivo;

    public Motor(int id){
        this.id = id;
        this.potenciaActual = 0;
        this.potenciaObjetivo = -1;
    }

    public void setPotencia(int p){
        this.potenciaObjetivo = p;
   }

    @Override
    public void run(){
        while(true){
            try{
                if(potenciaActual == potenciaObjetivo){
                    Thread.sleep(200);
                    if(potenciaObjetivo == 0){
                        break;
                    }else{
                        Thread.sleep(1000);
                    }
                }else{
                    int aleatorio = (int) (Math.random() * 1001) + 1000;
                    Thread.sleep(aleatorio);

                    if(potenciaActual < potenciaObjetivo){
                        potenciaActual++;
                        System.out.println("Motor" + id + " Incre. " + "Objetivo: " + potenciaObjetivo + " Actual: " + potenciaActual);
                    }
                    if(potenciaActual > potenciaObjetivo){
                        potenciaActual--;
                        System.out.println("Motor" + id + " Decre. " + "Objetivo: " + potenciaObjetivo + " Actual: " + potenciaActual);
                    }
                    if(potenciaActual == potenciaObjetivo){
                        System.out.println("Motor" + id + " FerRes. " + "Objetivo: " + potenciaObjetivo + " Actual: " + potenciaActual);
                    }
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}