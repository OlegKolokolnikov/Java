package photogallery.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
@Entity 
@Table(name = "category") 
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue
	private Long categoryId;
	private int quantity;
	@Length(min = 1, max = 50)
	@SafeHtml 
	@NotBlank
	private String name;
	@Length(min = 1, max = 50)
	@SafeHtml 
	@NotBlank
	private String discription;
	@OneToMany(mappedBy = "category" ) 
	private Set<Image> images; 
	public Category(int quantity, String name, String discription, long categoryId) {
		this.quantity = quantity;
		this.name = name;
		this.discription = discription;
		this.categoryId = categoryId;
	}
	public Category(){}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	
	public Set<Image> getImages() {   
		return Collections.unmodifiableSet(images); 
	} 
	
}
