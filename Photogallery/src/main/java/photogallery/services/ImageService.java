package photogallery.services;


import java.util.List;

import photogallery.entities.Category;
import photogallery.entities.Image;

public interface ImageService {
	void create(Image image);   
	 Image read(long id);   
	 void update(Image image);   
	 void delete(long id);   
	 Iterable<Image> findAll();
	 public List<Image> findByCategoryId(Category category); 
}
