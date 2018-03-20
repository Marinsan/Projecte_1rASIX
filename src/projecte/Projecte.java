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
public class Projecte {

        public static void main(String[] args) {
        
        Scanner ent = new Scanner(System.in);
        
        String model = null, nom = null;
        int carregador = 0, menu;
        double preu = 0.0;
        boolean camuflatge = false, omplit = false;
        char portacamuflatge = ' ', esS = ' ';

        do {
            System.out.println("\n\nMenú de l'aplicació:");
            System.out.println("0. Sortir");
            System.out.println("1. Entrar arma");
            System.out.println("2. Llistar armes");
            System.out.println("3. Modificar arma");
            System.out.println("4. Eliminar arma");
            menu = ent.nextInt();

            switch (menu) {
                case 0:
                    System.out.println("Exit");
                    break;

                case 1:
                    if (!omplit) {
                        System.out.println("Introdueix les dades");
                        System.out.println("Model: ");
                        model = ent.skip("[\r\n]*").nextLine();
                        System.out.println("Nom: ");
                        nom = ent.skip("[\r\n]*").nextLine();
                        System.out.println("Carregador: ");
                        carregador = ent.skip("[\r\n]*").nextInt();
                        System.out.println("Preu:");
                        preu = ent.skip("[\r\n]*").nextDouble();
                        System.out.println("Camuflatge (Si/No): ");
                        do {
                            portacamuflatge = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (portacamuflatge != 'S' && portacamuflatge != 'N');
                        camuflatge = (portacamuflatge == 'S');

                        omplit = true;
                    } else {
                        System.out.println("Ja has introduït dades, si vols omplir-lo esborra'l primer.");
                    }
                    break;

                case 2:
                    if (omplit == true) {
                        System.out.println("\nModel: " + model);
                        System.out.println("Nom: " + nom);
                        System.out.println("Carregador: " + carregador);
                        System.out.println("Preu:" + preu);
                        System.out.println("Camuflatge (Si/No): " + camuflatge);
                    } else {
                        System.out.println("No hi han dades.");
                    }
                    break;

                case 3:
                    if (omplit = true) {
                        System.out.println("\nVols vore les dades de les armes? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Model: " + model);
                            System.out.println("Nom: " + nom);
                            System.out.println("Carregador: " + carregador);
                            System.out.println("Preu:" + preu);
                            System.out.println("Camuflatge (Si/No): " + camuflatge);
                        }
                        System.out.println("\nVols modificar les dades? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("\nModel: " + model);
                        }
                        System.out.println("\nVols modificar el model? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Model: ");
                            model = ent.skip("[\r\n]*").nextLine();
                        }
                        System.out.println("\nNom: " + nom);
                        System.out.println("\nVols modificar el nom? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Nom: ");
                            nom = ent.skip("[\r\n]*").nextLine();
                        }
                        System.out.println("\nCarregador: " + carregador);
                        System.out.println("\nVols modificar el carregador? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Carregador: ");
                            carregador = ent.skip("[\r\n]*").nextInt();
                        }
                        System.out.println("\nPreu: " + preu);
                        System.out.println("\nVols modificar el Preu? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Preu: ");
                            preu = ent.skip("[\r\n]*").nextLine();
                        }
                        System.out.println("Camuflatge (Si/No): ");
                        System.out.println("\nVols modificar el camuflatge? (Si/No)");
                        do {
                            portacamuflatge = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (portacamuflatge != 'S' && portacamuflatge != 'N');
                        camuflatge = (portacamuflatge == 'S');

                        omplit = true;

                        break;

                    
            
            case 4:
                if (omplit = true) {
                    System.out.println("\nVols vore les dades? (Si/No)");
                    do {
                        esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                    } while (esS != 'S' && esS != 'N');
                    if = (esS == 'S') {
                     System.out.println("Model: " + model);
                     System.out.println("Nom: " + nom);
                     System.out.println("Carregador: " + carregador);
                     System.out.println("Preu:" + preu);
                     System.out.println("Camuflatge (Si/No): " + camuflatge);
                    }
                    System.out.println("\nSegur que vols borrar les dades? (Si/No)");
                    do {
                        esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                    } while (esS != 'S' && esS != 'N');
                    if = (esS == 'S') {
                        omlpit = false;
                    System.out.println("\nDades borrades correctament");
              }else{
                    System.out.println("\nNo s'han borrat les dades");
                    }
            }else{
                    System.out.println("\nNo hi han dades");
           }
            break;

          default:
                    System.out.println("\nOpció erronea.");
                    }                } 
        } while (!(menu == 0));

        }

    }

