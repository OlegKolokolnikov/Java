package be.vdab.video.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;







class KlantForm {
	@NotNull
	@Size(min=1, max=25, message="{Size.tekst}")
	private String naam; 

	KlantForm() { // default constructor (package visibility)
	}
	// constructor om command object te initialiseren vanuit Controller:
	KlantForm(String naam) {
		this.naam=naam;
	}
	public String getNaam() {
		return naam;
	}
	

	@Override
	public String toString() {
		return "KlantForm [naam=" + naam + "]";
	}
}
