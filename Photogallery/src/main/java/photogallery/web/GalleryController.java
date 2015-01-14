package photogallery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import photogallery.entities.Category;
import photogallery.services.CategoryService;
import photogallery.services.ImageService;
@Controller
@RequestMapping("/gallery")
public class GalleryController {
	private final CategoryService categoryService;
	private final ImageService imageService;
	@Autowired 
	GalleryController(CategoryService categoryService, ImageService imageService) {   
		this.categoryService = categoryService;
		this.imageService = imageService;
	} 
	@RequestMapping(value = "choosecategory", method = RequestMethod.GET)
	public ModelAndView chooseCategory() {
		return new ModelAndView("/chooseCategory", "categories",
				categoryService.findAll());
	}
	@RequestMapping(value = "{category}", method = RequestMethod.GET)
	ModelAndView read(@PathVariable Category category) {
		System.out.println(category);
		return new ModelAndView("/gallery", "images",
				imageService.findByCategoryId(category)).addObject(category);
	}
}
