/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author Oleg.Kolokolnikov
 */
@Entity 
@IdClass(MyKey.class)
@Table(name = "reservaties")
public class Reservatie implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    private int klantNr;
	@Id
    private int filmNr;
	@Id
    private Date reservatieDatum;

    public Reservatie(int klantNr, int filmNr, Date reservatieDatum) {
        this.klantNr = klantNr;
        this.filmNr = filmNr;
        this.reservatieDatum = reservatieDatum;
    }
    protected Reservatie(){}
    
    public Date getReservatieDatum() {
        return reservatieDatum;
    }

    public void setReservatieDatum(Date reservatieDatum) {
        this.reservatieDatum = reservatieDatum;
    }

    public Reservatie(int klantNr, int filmNr) {
        this.klantNr = klantNr;
        this.filmNr = filmNr;
        reservatieDatum = new Date();
    }

    public int getKlantNr() {
        return klantNr;
    }

    public void setKlantNr(int klantNr) {
        this.klantNr = klantNr;
    }

    public int getFilmNr() {
        return filmNr;
    }

    public void setFilmNr(int filmNr) {
        this.filmNr = filmNr;
    }

    
}
