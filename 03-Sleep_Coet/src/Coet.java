import java.util.Scanner;

public class Coet{
        Motor motor1;
        Motor motor2;
        Motor motor3;
        Motor motor4;

        public Coet(){
            motor1 = new Motor(1);
            motor2 = new Motor(2);
            motor3 = new Motor(3);
            motor4 = new Motor(4);
        }

        public void passaAPotencia(int p){
            if(p < 0 || p > 10){
                System.out.println("Valor fuera de rango");
                return;
            }
            System.out.println("Passant a potència " + p);
            motor1.setPotencia(p);
            motor2.setPotencia(p);
            motor3.setPotencia(p);
            motor4.setPotencia(p);

        }

        public void arranca(){
            motor1.start();
            motor2.start();
            motor3.start();
            motor4.start();
        }
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Coet coete = new Coet();
        coete.arranca();
        while(true){
            System.out.println("Cual es la potencia Objetivo");
            int numero = sc.nextInt();
            coete.passaAPotencia(numero);
            if(numero == 0){
                break;
            }
        }
        sc.close();
    }
}