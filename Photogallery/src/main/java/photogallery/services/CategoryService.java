package photogallery.services;


import photogallery.entities.Category;

public interface CategoryService {
	 void create(Category category);   
	 Category read(long categoryId);   
	 void update(Category category);   
	 void delete(long categoryId);   
	 Iterable<Category> findAll();
}
