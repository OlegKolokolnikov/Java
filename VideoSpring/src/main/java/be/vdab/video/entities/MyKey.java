package be.vdab.video.entities;

import java.io.Serializable;
import java.util.Date;


public class MyKey implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int klantNr;
	
    private int filmNr;
	
    private Date reservatieDatum;
    
	public MyKey() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + filmNr;
		result = prime * result + klantNr;
		result = prime * result
				+ ((reservatieDatum == null) ? 0 : reservatieDatum.hashCode());
		return result;
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

	public Date getReservatieDatum() {
		return reservatieDatum;
	}

	public void setReservatieDatum(Date reservatieDatum) {
		this.reservatieDatum = reservatieDatum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyKey other = (MyKey) obj;
		if (filmNr != other.filmNr)
			return false;
		if (klantNr != other.klantNr)
			return false;
		if (reservatieDatum == null) {
			if (other.reservatieDatum != null)
				return false;
		} else if (!reservatieDatum.equals(other.reservatieDatum))
			return false;
		return true;
	}
    
}
