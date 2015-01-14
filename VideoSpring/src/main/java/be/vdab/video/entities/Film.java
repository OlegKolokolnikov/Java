/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 *
 * @author Oleg.Kolokolnikov
 */
@Entity
@Table(name = "films")
public class Film implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
    private int filmNr;
    private int genreNr;
    private String titel;
    private int voorraad;
    private int gereserveerd;
    private BigDecimal prijs;

    public Film(int filmNr, int genreNr, String titel, int voorraad, int gereserveerd, BigDecimal prijs) {
        this.filmNr = filmNr;
        this.genreNr = genreNr;
        this.titel = titel;
        this.voorraad = voorraad;
        this.gereserveerd = gereserveerd;
        this.prijs = prijs;
    }
    protected Film(){}

    public int getFilmNr() {
        return filmNr;
    }

    public void setFilmNr(int filmNr) {
        this.filmNr = filmNr;
    }

    public int getGenreNr() {
        return genreNr;
    }

    public void setGenreNr(int genreNr) {
        this.genreNr = genreNr;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public int getGereserveerd() {
        return gereserveerd;
    }

    public void setGereserveerd(int gereserveerd) {
        this.gereserveerd = gereserveerd;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }
    public void reserveer(int gereserveerd) {
        this.gereserveerd = gereserveerd+1;
    }
	@Override
	public String toString() {
		return "Film [filmNr=" + filmNr + ", genreNr=" + genreNr + ", titel="
				+ titel + ", voorraad=" + voorraad + ", gereserveerd="
				+ gereserveerd + ", prijs=" + prijs + "]";
	}
    
}
