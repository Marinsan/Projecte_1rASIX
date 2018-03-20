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
        
        String nom = null, pais = null, director = null;
        int menu, any = 0;
        double nota = 0.0;
        boolean estrena = false, omplit = false;
        char estrenas = ' ', esS = ' ';

        do {
            System.out.println("\n\nMenú de l'aplicació:");
            System.out.println("0. Sortir");
            System.out.println("1. Entrar pel·lícula");
            System.out.println("2. Llistar pel·lícules");
            System.out.println("3. Modificar pel·lícula");
            System.out.println("4. Eliminar pel·lícula");
            menu = ent.nextInt();

            switch (menu) {
                case 0:
                    System.out.println("Exit");
                    break;

                case 1:
                    if (!omplit) {
                        System.out.println("Introdueix les dades");
                        System.out.println("Nom: ");
                        nom = ent.skip("[\r\n]*").nextLine();
                        System.out.println("Pais: ");
                        pais = ent.skip("[\r\n]*").nextLine();
                        System.out.println("Director: ");
                        director = ent.skip("[\r\n]*").nextLine();
                        System.out.println("Any: ");
                        any = ent.skip("[\r\n]*").nextInt();
                        System.out.println("Nota:");
                        nota = ent.skip("[\r\n]*").nextDouble();
                        System.out.println("Estrena (Si/No): ");
                        do {
                            estrenas = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (estrenas != 'S' && estrenas != 'N');
                        estrena = (estrenas == 'S');

                        omplit = true;
                    } else {
                        System.out.println("Ja has introduït dades, si vols omplir-lo esborra'l primer.");
                    }
                    break;

                case 2:
                    if (omplit == true) {
                        System.out.println("\nNom: " + nom);
                        System.out.println("Pais: " + pais);
                        System.out.println("Dirctor: " + director);
                        System.out.println("Nota:" + nota);
                        System.out.println("Estrena (Si/No): " + estrena);
                    } else {
                        System.out.println("No hi han dades.");
                    }
                    break;

                case 3:
                    if (omplit == true) {
                        System.out.println("\nVols vore les dades de les pel·lícules? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("\nNom: " + nom);
                            System.out.println("Pais: " + pais);
                            System.out.println("Dirctor: " + director);
                            System.out.println("Nota:" + nota);
                            System.out.println("Estrena (Si/No): " + estrena);
                        }
                        System.out.println("\nVols modificar les dades? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("\nNom: " + nom);
                        }
                        System.out.println("\nVols modificar el nom de la pel·lícula? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Nom: ");
                            nom = ent.skip("[\r\n]*").nextLine();
                        }
                        System.out.println("\nPais: " + pais);
                        System.out.println("\nVols modificar el pais? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Pais: ");
                            nom = ent.skip("[\r\n]*").nextLine();
                        }
                        System.out.println("\nDirector: " + director);
                        System.out.println("\nVols modificar el director? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Director: ");
                            director = ent.skip("[\r\n]*").nextInt();
                        }
                        System.out.println("\nNota: " + nota);
                        //nota = Integer.toString(nota);
                        System.out.println("\nVols modificar la nota? (Si/No)");
                        do {
                            esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esS != 'S' && esS != 'N');
                        if (esS == 'S') {
                            System.out.println("Nota: ");
                            nota = ent.skip("[\r\n]*").nextLine();
                        }
                        System.out.println("Estrena (Si/No): ");
                        System.out.println("\nVols modificar l'estrena? (Si/No)");
                        do {
                            estrenas = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (estrenas != 'S' && estrenas != 'N');
                        estrena = (estrenas == 'S');

                        omplit = true;
                    }

                        break;

                    
            
                case 4:
                    if (omplit == true) {
                        System.out.println("\nVols vore les dades? (Si/No)");
                    do {
                        esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                    } while (esS != 'S' && esS != 'N');
                    if  (esS == 'S') {
                            System.out.println("\nNom: " + nom);
                            System.out.println("Pais: " + pais);
                            System.out.println("Dirctor: " + director);
                            System.out.println("Nota:" + nota);
                            System.out.println("Estrena (Si/No): " + estrena);
                    }
                        System.out.println("\nSegur que vols borrar les dades? (Si/No)");
                    do {
                        esS = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                    } while (esS != 'S' && esS != 'N');
                    if (esS == 'S') {
                        omplit = false;
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
                                }                
                                    } while (!(menu == 0));

        }

    }

