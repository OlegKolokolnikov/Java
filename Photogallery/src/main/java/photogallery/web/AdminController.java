package photogallery.web;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import photogallery.entities.Category;
import photogallery.exceptions.CategoryStillHasImagesException;
import photogallery.services.CategoryService;

@Controller
@RequestMapping("/kryaadm")
public class AdminController {
	
	private final CategoryService categoryService; 
	@Autowired 
	AdminController(CategoryService categoryService) {   
	this.categoryService = categoryService; 
	} 
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView chooseCategory() {
		return new ModelAndView("/adminmenu");
	}
	@RequestMapping(value = "choosecategory", method = RequestMethod.POST)
	public ModelAndView create(@Valid Category category, BindingResult bindingResult) {
		if ( ! bindingResult.hasErrors()) {
			categoryService.create(category);
			return new ModelAndView("redirect:/kryaadm/categorymanager", "categories",
					categoryService.findAll());
		}
		return new ModelAndView("/makenewcategory");
	}
		
		
	
	@RequestMapping(value = "categorymanager", method = RequestMethod.GET)
	public ModelAndView createCategory() {
		return new ModelAndView("/makenewcategory", "category",
				new Category()).addObject("categories", categoryService.findAll());
	}
	@RequestMapping(value = "category/{category}", method = RequestMethod.GET)
	public ModelAndView categoryInfo(@PathVariable Category category) {
		return new ModelAndView("/categoryinfo").addObject(category);
	}
	@RequestMapping(value = "{category}/delete", method = RequestMethod.POST)
	String delete(@PathVariable Category category, RedirectAttributes redirectAttributes) {
		if (category == null) { 
		return "redirect:/categorymanager";
		}
		long id = category.getCategoryId();
		try {
			categoryService.delete(id);
			redirectAttributes.addAttribute("id", id) 
			.addAttribute("name", category.getName());
			return "redirect:/kryaadm/{id}/deleted"; 
		} catch (CategoryStillHasImagesException ex) {
			redirectAttributes.addAttribute("id", id)
			.addAttribute("fout", "Category has images");
			return "redirect:/category/{category}";
		}
	}
	@RequestMapping(value = "{id}/deleted", method = RequestMethod.GET)
	ModelAndView deleted(String name) {
	return new ModelAndView("deleted", "name", name);
	}
	
}
