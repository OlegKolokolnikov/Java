package photogallery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import photogallery.entities.Image;

public interface ImageDAO extends JpaRepository<Image, Long>{
	 @EntityGraph("Image.withCategory") 
	 public List<Image> findByCategoryId(long categoryId); 
}
