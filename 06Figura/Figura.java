//librerias
import java.util.Scanner;
import java.lang.Math;

public class Figura {
    
    //vamos a colocar las variables globales
    double lado, altura, area, perimetro, base, apotema;
    int opcion;
    char letra;
    boolean esValido = false;

    //la instancia del objeto para entrada de datos
    Scanner entrada = new Scanner(System.in);

    //metodos
    public void menu(){
        
        //while(opcion >= 1 && opcion <= 7){
        do{  
            System.out.println("Este es un programa para calcular Areas y Perimetros de Figuras Geometricas");
            System.out.println("1.- Triangulo");
            System.out.println("2.- Cuadrado");
            System.out.println("3.- Circulo");
            System.out.println("4.- Pentagono");
            System.out.println("5.- Hexagono");
            System.out.println("Elija alguna de las opciones que son citadas");

            //leemos la opcion
            opcion = entrada.nextInt();

            //entrada del sw    
            switch (opcion) {
                case 1:
                    //triangulo
                    calcularTriangulo();
                    
                    break;
                case 2:
                    //cuadrado
                    calcularCuadrado();
                    
                    break;
                case 3:
                    //circulo
                    calcularCirculo();
                    
                    break;
                case 4:
                    calcularPentagono();

                    break;
                case 5:
                    calcularHexagono();

                    break;
                default:
                    System.out.println("Gracias por ocuparme UwU");
                    break;
            }
            System.out.println("Si desea repetir el programa ingrese la letra S");
            letra = entrada.next().charAt(0);
        
        }while(letra == 's' || letra == 'S');

    }

    public void calcularTriangulo(){
        System.out.println("Area y Perimetro de un Triangulo");
        System.out.println("Que tipo de triangulo desea calcular:");
        System.out.println("1.-Equilatero");
        System.out.println("2.-Isoseles");
        System.out.println("3.-Escaleno");
        opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                //formula P = 3 * Lado
                //A = (b * a) / 2
                esValido = false;
                do{
                System.out.println("Ingresa la base del triangulo");
                try{
                    if(entrada.hasNextDouble()){
                        base = entrada.nextDouble();
                        if(base > 0){
                            esValido = true;
                        }else{
                            System.out.println("La base debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        entrada.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
                }while(!esValido);



                System.out.println(base * altura / 2);
                System.out.println(lado * 3);
                break;
            case 2:
                //formula P = 2* lado igual + base
                //A = (b * a) / 2
                
                break;
            case 3:
                //formula P = a + b+ c
                //A = (b * a) / 2
                
                break;
        
            default:
                break;
        }

    }

    public void calcularCuadrado(){
        
    }

    public void calcularCirculo(){
        
    }

    public void calcularPentagono(){
        System.out.println("Area y Perimetro de un Pentagono");
        System.out.println("Ingresa la base del pentagono");
                try{
                    if(entrada.hasNextDouble()){
                        base = entrada.nextDouble();
                        if(base > 0){
                            esValido = true;
                        }else{
                            System.out.println("La base debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        entrada.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            
            System.out.println("Ingresa la altura del pentagono");
                try{
                    if(entrada.hasNextDouble()){
                        altura = entrada.nextDouble();
                        if(altura > 0){
                            esValido = true;
                        }else{
                            System.out.println("La altura debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        entrada.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
                       System.out.println("Ingresa la apotema del pentagono");
                try{
                    if(entrada.hasNextDouble()){
                        apotema = entrada.nextDouble();
                        if(apotema > 0){
                            esValido = true;
                        }else{
                            System.out.println("La apotema debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        entrada.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }

                System.out.println(base * 5);
                System.out.println(base * 5 * apotema / 2);
    }

    public void calcularHexagono(){
        System.out.println("Area y Perimetro de un Hexagono");
        System.out.println("Ingresa la base del hexagono");
                try{
                    if(entrada.hasNextDouble()){
                        base = entrada.nextDouble();
                        if(base > 0){
                            esValido = true;
                        }else{
                            System.out.println("La base debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        entrada.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
        System.out.println("Ingresa la altura del hexagono");
                try{
                    if(entrada.hasNextDouble()){
                        altura = entrada.nextDouble();
                        if(altura > 0){
                            esValido = true;
                        }else{
                            System.out.println("La altura debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        entrada.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
        System.out.println("Ingresa la apotema del hexatagono");
                try{
                    if(entrada.hasNextDouble()){
                        apotema = entrada.nextDouble();
                        if(apotema > 0){
                            esValido = true;
                        }else{
                            System.out.println("La apotema debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        entrada.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }

                System.out.println(base * 6);
                System.out.println(base * 6 * apotema / 2);
    }

}