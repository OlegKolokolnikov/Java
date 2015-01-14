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
@Table(name = "klanten")
public class Klant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
    private int klantNr;
    private String familienaam;
    private String voornaam;
    private String straatNummer;
    private String postCode;
    private String Gemeente;

    public Klant(int klantNr, String familienaam, String voornaam, String straatNummer, String postCode, String Gemeente) {
        this.klantNr = klantNr;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.straatNummer = straatNummer;
        this.postCode = postCode;
        this.Gemeente = Gemeente;
    }
    protected Klant(){}
    
    public int getKlantNr() {
        return klantNr;
    }

    public void setKlantNr(int klantNr) {
        this.klantNr = klantNr;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getStraatNummer() {
        return straatNummer;
    }

    public void setStraatNummer(String straatNummer) {
        this.straatNummer = straatNummer;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getGemeente() {
        return Gemeente;
    }

    public void setGemeente(String Gemeente) {
        this.Gemeente = Gemeente;
    }

    @Override
    public String toString() {
        return "Klant{" + "klantNr=" + klantNr + ", familienaam=" + familienaam + ", voornaam=" + voornaam + ", straatNummer=" + straatNummer + ", postCode=" + postCode + ", Gemeente=" + Gemeente + '}';
    }

    
    
}
