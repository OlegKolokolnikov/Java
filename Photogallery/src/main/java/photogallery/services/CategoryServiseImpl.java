package photogallery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import photogallery.dao.CategoryDAO;
import photogallery.entities.Category;
import photogallery.exceptions.CategoryStillHasImagesException;
@Service 
public class CategoryServiseImpl implements CategoryService{
private final CategoryDAO categoryDAO;
@Autowired
CategoryServiseImpl(CategoryDAO categoryDAO){
	this.categoryDAO=categoryDAO;
}
	@Override
	public void create(Category category) {
		category.setName(categoryDAO.save(category).getName());
		
	}

	@Override
	public Category read(long categoryId) {
		return categoryDAO.findOne(categoryId);
	}

	@Override
	public void update(Category category) {
		categoryDAO.save(category);
	}

	@Override
	public void delete(long categoryId) {
		Category category = categoryDAO.findOne(categoryId);
		if (category != null) {
			if ( ! category.getImages().isEmpty()) {
				throw new CategoryStillHasImagesException();
			}
			categoryDAO.delete(categoryId);
		}
		
		categoryDAO.delete(categoryId);
		
	}

	@Override
	public Iterable<Category> findAll() {
		return categoryDAO.findAll();
	}

}
