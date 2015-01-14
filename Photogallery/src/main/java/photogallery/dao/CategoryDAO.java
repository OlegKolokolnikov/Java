package photogallery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import photogallery.entities.Category;



public interface CategoryDAO extends JpaRepository<Category, Long>{ 
}
