/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class ProjecteJava {

    private static final int MAX_PELIS = 50;
    
    private static Peli[] array = new Peli[MAX_PELIS];
    
    private static int opcio;
    
    private static File dades=new File("pelis.db");
    
     
    public static void main(String[] args){
               
            inicialitzarVariables();
            do {
                demanarOpcio();
                tractarOpcio();
            }   while (!opcioFinal());
    }

      public static void inicialitzarVariables() {
        
        
        int i=0;
        
       
        if(dades.exists()){
            
            boolean finalitzar=false;
            
            
            ObjectInputStream lectura=null;
            try{
                
                lectura=new ObjectInputStream(new BufferedInputStream(new FileInputStream(dades)));
                
                while(true){
                    array[i]=(Peli) lectura.readObject();
                    
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                
                System.err.println("No pots introduir més pelicules!! Vols continuar?(S/N):");
                Scanner ent = new Scanner(System.in);
                char siNo=' ';
                do {                    
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                    
                } while (siNo != 'S' && siNo != 'N');
                if(siNo=='N') finalitzar=true;
                
            } catch (IOException ex) {
                
            } catch (ClassNotFoundException ex) {
                
            }finally{
                try {
                    if(lectura!=null) lectura.close();
                } catch (IOException ex) {
                    
                }
                if(finalitzar) System.exit(0);
            }
        
        }

        for (; i < array.length; i++) {
            array[i] = new Peli();
            array[i].setOmplit(false);
        }
    }
    
    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);
        
        do {
            System.out.println("\nMenú de l'aplicació:");
            System.out.println("0. Sortir");
            System.out.println("1. Entrar pel·lícula");
            System.out.println("2. Modificar pel·lícules");
            System.out.println("3. Borrar pel·lícula");
            System.out.println("4. Llistar pel·lícula");
            System.out.println("5. Recuperar pel·lícula borrada");
            try{
                opcio = ent.nextInt();
                break;
            }catch(java.util.InputMismatchException e){
                System.out.println("Opció incorrecta!!");
                
                ent.next();
                
            }
        }while(true);

    }
    

     public static void tractarOpcio() {

        switch (opcio) {
            case 0:                            
                sortir();
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
                llistarPeli();
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
    
    public static void sortir(){
        
        ObjectOutputStream escriptura=null;
        try{
            
            escriptura=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dades)));
    
            for (Peli array1 : array) {
                if (array1.isOmplit()) {
                    escriptura.writeObject(array1);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error en guardar les dades!!");
        } finally{
            try {
                if(escriptura!=null) escriptura.close();
            } catch (IOException ex) {
             }

        }
     
        System.out.println("Que vaigue be!!");

    }
    

    @SuppressWarnings("empty-statement")
    public static void introduirPeli(){
        Scanner ent = new Scanner(System.in);
        
        int i;
        for (i = 0; array[i].isOmplit() && i < array.length; i++);
        
        if (i < array.length) {
            
            System.out.println("\nNom:");
            array[i].setNom(ent.skip("[\r\n]*").nextLine());
            
            System.out.println("\nPais:");
            array[i].setPais(ent.skip("[\r\n]*").nextLine());
            
            System.out.println("\nDirector:");
            array[i].setDirector(ent.skip("[\r\n]*").nextLine());
            
            do{
                try{ 
                    System.out.println("\nAny:");
                    array[i].setAny(ent.skip("[\r\n]*").nextInt());
                    break;
                }catch(java.util.InputMismatchException e){
                    System.out.println("Any incorrecte!!");
                    ent.next();
                }
            }while(true);
            do{
                try{
                    System.out.println("\nNota:");                
                    array[i].setNota(ent.skip("[\r\n]*").nextDouble());
                    break;
                }catch(java.util.InputMismatchException e){
                    System.out.println("Nota incorrecta!!");
                    ent.next();
                }
            }while(true);
            char estrenas;
            do {
                System.out.println("\nÉs estrena o no?(S/N):");
                estrenas = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                
            } while (estrenas != 'S' && estrenas != 'N');
            array[i].setEstrena(estrenas == 'S');    
            array[i].setOmplit(true);
        } else {
            System.out.println("\nNo hi caben més pelis, borra un registre de peli per introduir la nova.");
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
        
        if (ns == 'S') {
            System.out.println("\nPais: " + array[i].getPais());
            do {
                System.out.println("\nVols modificar el Pais? (S/N):");
                ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (ns != 'S' && ns != 'N');
            if (ns == 'S') {
                System.out.println("Introdueix el Pais: ");
                array[i].setPais(ent.skip("[\r\n]*").nextLine());
            }
        }
        
        if (ns == 'S') {
            System.out.println("\nDirector: " + array[i].getDirector());
            do {
                System.out.println("\nVols modificar el Director? (S/N):");
                ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (ns != 'S' && ns != 'N');
            if (ns == 'S') {
                System.out.println("Introdueix el Director: ");
                array[i].setDirector(ent.skip("[\r\n]*").nextLine());
            }
        }
        
        if (ns == 'S') {
            System.out.println("\nAny: " + array[i].getAny());
            do {
                System.out.println("\nVols modificar l'Any? (S/N):");
                ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (ns != 'S' && ns != 'N');
            if (ns == 'S') {
                System.out.println("Introdueix l'any: ");
                array[i].setAny(ent.skip("[\r\n]*").nextInt());
            }
        }
        
        if (ns == 'S') {
            System.out.println("\nNota: " + array[i].getNota());
            do {
                System.out.println("\nVols modificar la Nota? (S/N):");
                ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (ns != 'S' && ns != 'N');
            if (ns == 'S') {
                System.out.println("Introdueix la Nota: ");
                array[i].setNota(ent.skip("[\r\n]*").nextInt());
            }
        }
        if (ns == 'S') {
                char esEstrena;
                do {
                    System.out.println("És Estrena o no?(S/N):");
                    esEstrena = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (esEstrena != 'S' && esEstrena != 'N');
                array[i].setEstrena(esEstrena == 'S');     
                System.out.print("És estrena; ");
                if (array[i].isEstrena()) {
                    System.out.println("Si");
                } else {
                    System.out.println("No");
                }
            }

            System.out.println("Peli modificada correctament.");

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
                    System.out.println("\nVols borrar la pel·licula (Escriu S per si o N per No) o acabar la busqueda (Escriu A per acabar)?:");
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
    
    public static void llistarPeli(){
        
        Scanner ent = new Scanner(System.in);
        
        boolean si = false;
        char ns = 'S';
        int i;
        
        for (i = 0; i < array.length; i++) {
            Peli p = array[i];
            if (p.isOmplit()) {
                si = true;
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
        if (!si) {
            System.out.println("\nNo hi ha pel·licules per mostrar");
        }         
        
    }
    
    public static void recuperarPeli(){
        
        Scanner ent = new Scanner(System.in);
       
        char ns = 'N';
        int cont = 0, i;
        for (i = 0; i < array.length && ns != 'S' && ns != 'A'; i++) {
            if (!array[i].isOmplit()) {
                System.out.format("\nPeli %d:\n", ++cont);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols recuperar la pel·lícula(Escriu S per si o N per No) o acabar la busqueda (Escriu A per acabar)?:");
                    ns = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                } while (ns!= 'S' && ns != 'N' && ns != 'A');
            }
            if (ns == 'S') {
                break;
            }
        }
        
        if (ns == 'S') {
            array[i].setOmplit(true);
            System.out.println("Pelicula recuperada correctament.");
        } else {
            if(cont==0) System.out.println("No hi ha cap pel·lícula a recuperar.");
            else System.out.println("Pelicula no recuperada.");
        }
    
    }
           

    public static Peli[] getArray() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    }
    
     
        

