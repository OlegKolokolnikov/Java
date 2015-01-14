package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.valueobjects.Adres;
@Entity
@Table(name = "filialen")
@XmlRootElement
public class Filiaal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	@Size(min = 1, max = 50, message = "{Size.tekst}")
	private String naam;
	private boolean hoofdFiliaal;
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal waardeGebouw;
	@DateTimeFormat(style = "S-") 
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date inGebruikName;
	@Valid
	@Embedded
	private Adres adres;
	public Filiaal(String naam, boolean hoofdFiliaal,
	BigDecimal waardeGebouw, Date inGebruikName, Adres adres) {
		setNaam(naam);
		setHoofdFiliaal(hoofdFiliaal);
		setWaardeGebouw(waardeGebouw);
		setInGebruikName(inGebruikName);
		setAdres(adres);
		this.werknemers = new LinkedHashSet<Werknemer>();
	}
	public Filiaal(long id, String naam, boolean hoofdFiliaal,
	BigDecimal waardeGebouw, Date inGebruikName, Adres adres) {
		this(naam, hoofdFiliaal, waardeGebouw, inGebruikName, adres);
		setId(id);
		this.werknemers = new LinkedHashSet<Werknemer>();
	}
	public Filiaal() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public boolean isHoofdFiliaal() {
		return hoofdFiliaal;
	}
	public void setHoofdFiliaal(boolean hoofdFiliaal) {
		this.hoofdFiliaal = hoofdFiliaal;
	}
	public BigDecimal getWaardeGebouw() {
		return waardeGebouw;
	}
	public void setWaardeGebouw(BigDecimal waardeGebouw) {
		this.waardeGebouw = waardeGebouw;
	}
	public Date getInGebruikName() {
		return inGebruikName;
	}
	public void setInGebruikName(Date inGebruikName) {
		this.inGebruikName = inGebruikName;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	@Override
	public String toString() {
		return naam + ':' + id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filiaal other = (Filiaal) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	@OneToMany(mappedBy = "filiaal")
	@XmlTransient
	@JsonIgnore
	private Set<Werknemer> werknemers; 
	public Set<Werknemer> getWerknemers() {
		return Collections.unmodifiableSet(werknemers);
	}
	public void addWerknemer(Werknemer werknemer) {
		werknemers.add(werknemer);
		if (werknemer.getFiliaal() != this) {
			werknemer.setFiliaal(this);
		}
	}
	public void removeWerknemer(Werknemer werknemer) {
		if (werknemer.getFiliaal() == this) {
			werknemers.remove(werknemer);
			werknemer.setFiliaal(null);
		}
	}
}
