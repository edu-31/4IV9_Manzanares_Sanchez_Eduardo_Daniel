/* 
Vamos a crear 14 programas dentro de un menu gigante para poner a prueba sus conocimientos de algoritmia
1.Desarrolalr un programa para calcular el bono de un descuento por edad
2.Convertir numeros decimales a binarios
3.Convertir temperaturas entre los 3 principales grados C -> F y K
4.Realizar un programa para contar n de positivos y negativos de una serie de numeros
5.Desarrollar una tienda para agregar productos y precios 
6.Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.Desarrolar una tabla
8.Desarrollar un programa para calcular el factorial con recursividad
9.Vamos a hacer dibujitos
10.Desarrollar una figura hueca
11.Realizar algunos patrones
12.Realizar un diamante
13.Desarrolar una calculadora básica
 */

import java.util.Scanner;

public class EstructuraDatos {

    public static void main(String[] args) {
        //aqui van las variables
        int opcion;
        char letrapararepetir;
        //aqui van los objetos
        Scanner entrada = new Scanner(System.in);

        //aqui va el menu
        do{
        System.out.println("Bienvenidos a este programa para verificar que tanto saben programar a partir de algoritmos básicos.");
        System.out.println("Por favor eliga la opcion que dese");
        System.out.println("1. - ");
        System.out.println("2. - ");
        System.out.println("3. - ");
        System.out.println("4. - ");
        System.out.println("5. - ");
        System.out.println("6. - ");
        System.out.println("7. - ");
        System.out.println("8. - ");
        System.out.println("9. - ");
        System.out.println("10. - ");
        System.out.println("11. - ");
        System.out.println("12. - ");
        System.out.println("13. - ");
        System.out.println("14. Salir ");
        
        //entrada de dato
        opcion = entrada.nextInt();

        //ahora tengo que evaluar la entrada
        switch (entrada) {
            case 1:
                break;
            case 2:
            //convertir un numero decimal a binario
            System.out.println("Ingrese un numero positivo entero que se desee convertir a binario");
            int numbinario
            String guardarbinario;
            numbinario = entrada.nextInt();

            if (numbinario > 0) {
                //realizamos el modulo de 2
                while (numbinario > 0) {
                    if (numbinario%2 == 0) {
                        guardarbinario = "0" + guardarbinario;
                    }else{
                        guardarbinario = "1" + guardarbinario;
                    }
                    numbinario (int)numbinario/2;
                    
                }
            }else if(numbinario == 0){
                guardarbinario = "0";
            }else{
                guardarbinario = "No se puede convertir ese numero, solo acepta positivos";
            }
            System.out.println("");
                break;
            case 3:
                break;
            case 4:
                break;
            
        
            default:
                break;
        }
        System.out.println("Deseas repetir el programa escribe S o s para si");
        letrapararepetir = entrada.next().charAt(0);
        }while(letrapararepetir != 's' || letrapararepetir == 'S');

    }
}