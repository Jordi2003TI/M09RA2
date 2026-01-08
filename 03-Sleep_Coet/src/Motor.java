import java.util.Random;
import java.util.Scanner;

public class Motor extends Thread {
    private int potenciaActual;
    private int potenciaObjetivo;

    public Motor(){
        this.potenciaActual = 0;
        this.potenciaObjetivo = 0;
    }
    public void setPotencia(int p){
        this.potenciaObjetivo = p;
    }
    @Override
    public void run(){
        while(true){

            if(potenciaActual == 0){
                break;
            }
            if(potenciaActual <= potenciaObjetivo){
                potenciaActual++;
            }
            if(potenciaActual > potenciaObjetivo){
                potenciaActual--;
            }

        }
    }

    public static void main(String[] args){
        Motor motor1 = new Motor();
        Motor motor2 = new Motor();
        Motor motor3 = new Motor();
        Motor motor4 = new Motor();
        while(true){
            System.out.println("Cual es la potencia Objetivo");
            Scanner sc = new Scanner(System.in);
            int numero = sc.nextInt();
            if(numero == 0){
                break;
            }

            motor1.setPotencia(numero);
            motor2.setPotencia(numero);
            motor3.setPotencia(numero);
            motor4.setPotencia(numero);

            motor1.start();
            motor2.start();
            motor3.start();
            motor4.start();
        }
    }
}