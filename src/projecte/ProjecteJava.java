/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;


import java.util.Scanner;

/**
 *
 * @author marin
 */
public class ProjecteJava {

    private static final int MAX_PELIS = 5;
    
    private static Peli[] array = new Peli[MAX_PELIS];
    
    private static int opcio;
    
    public static void main(String[] args) {
               
            inicialitzarVariables();
            do {
                demanarOpcio();
                tractarOpcio();
            }   while (!opcioFinal());
    }

    public static void inicialitzarVariables() {
        
        for (int i = 0; i < array.length; i++) {
            array[i] = new Peli();
            array[i].setOmplit(false);
        }
            
    }
    
    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);
        
            System.out.println("\nMenú de l'aplicació:");
            System.out.println("0. Sortir");
            System.out.println("1. Entrar pel·lícula");
            System.out.println("2. Modificar pel·lícules");
            System.out.println("3. Borrar pel·lícula");
            System.out.println("4. Llistar pel·lícula");
            System.out.println("5. Recuperar pel·lícula borrada");
            opcio = ent.skip("[\r\n]*").nextInt();
        
    }

    public static void tractarOpcio() {
        
        switch (opcio) {
            
            case 0:
                System.out.println("Adéu!!");
                break;

            case 1:
                introduirPeli();
                break;
                
            case 2:
                modificarPeli();
                break;
            
            case 3:
                borrarPeli();
                break;
            
            case 4:
                llistarPelis();
                break;
                
            case 5:
                recuperarPeli();
                break;
              
            default:
                System.out.println("\nOpció incorrecta!!");
        }
    }
    
    public static boolean opcioFinal(){
        return opcio == 0;
    }
    
    @SuppressWarnings("empty-statement")
    public static void introduirPeli(){
        Scanner ent = new Scanner(System.in);
        
        int i;
        for (i = 0; i < array.length && array[i].isOmplit(); i++);    
        
        if (i < array.length) {
                        
                        System.out.println("\nNom: ");
                        array[i].setNom(ent.skip("[\r\n]*").nextLine());
                        System.out.println("Pais: ");
                        array[i].setPais(ent.skip("[\r\n]*").nextLine());
                        System.out.println("Director: ");
                        array[i].setDirector(ent.skip("[\r\n]*").nextLine());
                        System.out.println("Any: ");
                        array[i].setAny(ent.skip("[\r\n]*").nextInt());
                        System.out.println("Nota:");
                        array[i].setNota(ent.skip("[\r\n]*").nextDouble());
                        
                        char estrenas;
                        do {
                            System.out.println("Estrena (Si/No): ");
                            estrenas = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (estrenas != 'S' && estrenas != 'N');
                        array[i].setEstrena(estrenas == 'S');
                        array[i].setOmplit(true);
                    } else {
                        System.out.println("Ja has introduït dades, si vols omplir-lo esborra'l primer.");
                    }
            
        }
    public static void modificarPeli(){
        
        Scanner ent = new Scanner(System.in);
        
        Peli p = null;
        int cont = 1, i = 0;
        p = array[i];
        char ns = ' ';
        
        for (; i < array.length && ns != 'A'; i++) {
            if (array[i].isOmplit()) {
                System.out.format("\nPel·lícula %d:\n", cont++);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols modificar la pel·lícula(Escriu S per si o N per No) o acabar la busqueda (Escriu A per acabar)?;");
                    ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (ns != 'S' && ns != 'N' && ns != 'A');
            }
            if (ns == 'S') {
                break;
            }
        }
        
        
        if (ns == 'S') {
            System.out.println("\nNom: " + array[i].getNom());
            do {
                System.out.println("\nVols modificar el nom? (S/N):");
                ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (ns != 'S' && ns != 'N');
            if (ns == 'S') {
                System.out.println("Introdueix el nom: ");
                array[i].setNom(ent.skip("[\r\n]*").nextLine());
            }
        }
        
        if (array[i].isEstrena()) {
                System.out.println("\nÉs estrena");
            } else {
                System.out.println("\nNo és estrena");
            }
            do {
                System.out.println("\nVols modificar si es estrena o no?(S/N):");
                ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (ns != 'S' && ns != 'N');
            if (ns == 'S') {
                char esEstrena;
                do {
                    System.out.println("Es estrena?(S/N) ");
                    esEstrena = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (esEstrena != 'S' && esEstrena != 'N');
                if (esEstrena == 's') {
                    p.setEstrena(true);
                } else {
                    p.setEstrena(false);
                }
        }
    }
    
    public static void borrarPeli(){
        
        Scanner ent = new Scanner(System.in);
        
        Peli p = null;
        char ns = ' ';
        int i;
        
        for (i = 0; i < array.length && ns != 'A'; i++) {
            p = array[i];
            if (p.isOmplit()) {
                System.out.println(p);
                do {
                    System.out.println("\nVols borrar la pel·licaula (Escriu S per si o N per No) o acabar la busqueda (Escriu A per acabar)?:");
                    ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (ns != 'S' && ns != 'N' && ns != 'A');
            }
            if (ns == 'S') {
                break;
            }
        }

        if (ns == 'S') {
            p.setOmplit(false);
            System.out.println("Pel·lícula borrada correctament");
        } else {
            System.out.println("No s'ha borrat cap pel·lícula");
        }
        
    }
    
    public static void llistarPelis(){
        
        Scanner ent = new Scanner(System.in);
        
        boolean x = false;
        char ns = 'S';
        int i;
        
        for (i = 0; i < array.length; i++) {
            Peli p = array[i];
            if (p.isOmplit()) {
                x = true;
                System.out.println(p);
                do {
                    System.out.println("\nVols llistar més pel·lícules?(Escriu S per si o N per No):");
                    ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (ns != 'S' && ns != 'N');
            }
            if (ns == 'N') {
                break;
            }
        }
        if (!x) {
            System.out.println("\nNo hi ha pel·licules per mostrar");
        }         
        
    }
    
    public static void recuperarPeli(){
        
        Scanner ent = new Scanner(System.in);
        
        char ns = 'N';
        int cont = 0, i;
        
        for (i = 0; i < array.length && ns != 'S' && ns != 'A'; i++) {
            if (!array[i].isOmplit()) {
                System.out.format("\nPel·lícula %d:\n", ++cont);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols recuperar la pel·lícula(Escriu S per si o N per No) o acabar la busqueda (Escriu A per acabar)?:");
                    ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (ns != 'S' && ns != 'N' && ns != 'A');
            }
            if (ns == 'S') {
                break;
            }
        }
        if (ns == 'S') {
            array[i].setOmplit(true);
            System.out.println("Pel·lícula recuperada correctament.");
        } else {
            if(cont==0) System.out.println("No hi ha cap pel·lícula a recuperar");
            else System.out.println("Pel·lícula no recuperat.");
        }
    }
    
    }

        

