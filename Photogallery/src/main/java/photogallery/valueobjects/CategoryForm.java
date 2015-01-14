package photogallery.valueobjects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;




public class CategoryForm {
	@Size(min = 1, max = 50, message = "{Size.tekst}")
	@SafeHtml 
	@NotNull
	private String name;
	@Length(min = 1, max = 50)
	@SafeHtml 
	private String discription;

	
	public String getName() {
		return name;
	}
	
	public String getDiscription() {
		return discription;
	}
	
}
