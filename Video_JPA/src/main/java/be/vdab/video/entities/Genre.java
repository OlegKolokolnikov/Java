/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Oleg.Kolokolnikov
 */
@Entity
@Table(name = "genres")
public class Genre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
    private int genreNr;
    private String naam;

    public Genre(int genreNr, String naam) {
        this.genreNr = genreNr;
        this.naam = naam;
    }
    protected Genre(){}

    public int getGenreNr() {
        return genreNr;
    }

    public void setGenreNr(int genreNr) {
        this.genreNr = genreNr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    
}
