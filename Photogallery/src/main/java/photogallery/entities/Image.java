package photogallery.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;




@Entity 
@Table(name = "image") 
@NamedEntityGraph(name = "Image.withCategory",   attributeNodes = @NamedAttributeNode("category")) 
public class Image implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id 
	 @GeneratedValue
	private long id;
	private String name;
	private String discription;
	private Date date;
	private long categoryId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)   
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId", insertable = false, updatable = false) 
	Category category;
	public Image(){}

	public Image(String name, String discription, int id, int categoryId) {
		this.name = name;
		this.discription = discription;
		this.id=id;
		this.categoryId = categoryId;
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

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
