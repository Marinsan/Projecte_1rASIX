/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

/**
 *
 * @author marin
 */
public class Peli {

    private String nom = null;

    private String pais = null;

    private String director = null;
    private int menu;

    private int any = 0;
    private double nota = 0.0;
    private boolean estrena;

    private boolean omplit = false;
    private char estrenas;

    private char esS = ' ';

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isEstrena() {
        return estrena;
    }

    public void setEstrena(boolean estrena) {
        this.estrena = estrena;
    }

    public boolean isOmplit() {
        return omplit;
    }

    public void setOmplit(boolean omplit) {
        this.omplit = omplit;
    }

    public char getEstrenas() {
        return estrenas;
    }

    public void setEstrenas(char estrenas) {
        this.estrenas = estrenas;
    }

    public char getEsS() {
        return esS;
    }

    public void setEsS(char esS) {
        this.esS = esS;
    }

    @Override
    public String toString() {
        return "Pelicula\nNom: "+nom+"\nDirector: "+director+"\nPais: "+pais+"\nAny: "+any+"\nNota: "+nota+"\nEstrena: "+estrena;
    }

}
