package photogallery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import photogallery.dao.ImageDAO;
import photogallery.entities.Category;
import photogallery.entities.Image;

@Service 
public class ImageServiceImpl implements ImageService{
	
	private final ImageDAO imageDAO;
	@Autowired
	ImageServiceImpl(ImageDAO imageDAO){
		this.imageDAO=imageDAO;
	}
	@Override
	public void create(Image image) {
		image.setName(imageDAO.save(image).getName());
		
	}
	@Override
	public Image read(long id) {
		return imageDAO.findOne(id);
	}
	@Override
	public void update(Image image) {
		imageDAO.save(image);
		
	}
	@Override
	public void delete(long id) {
		Image image = imageDAO.findOne(id);
		if (image != null) {
			imageDAO.delete(id);
		}
		
		imageDAO.delete(id);
		
	}
	@Override
	public Iterable<Image> findAll() {
		return imageDAO.findAll();
	}
	@Override
	public List<Image> findByCategoryId(Category category) {
		return imageDAO.findByCategoryId(category.getCategoryId());
	}
}
