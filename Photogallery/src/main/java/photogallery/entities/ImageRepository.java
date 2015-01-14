package photogallery.entities;

public class ImageRepository {
 private int imageId;
 private int categoryId;
 
 public ImageRepository(){}

public ImageRepository(int imageId, int categoryId) {
	this.imageId = imageId;
	this.categoryId = categoryId;
}

public int getImageId() {
	return imageId;
}

public int getCategoryId() {
	return categoryId;
}
 
}
