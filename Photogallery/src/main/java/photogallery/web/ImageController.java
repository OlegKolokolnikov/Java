package photogallery.web;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import photogallery.services.ImageService;
import photogallery.valueobjects.FileMeta;

@Controller
@RequestMapping("/kryaadm")
public class ImageController implements ServletContextAware{
	 LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	 FileMeta fileMeta = null;
	private final ImageService imageService;
	private ServletContext servletContext;
	@Autowired 
	ImageController(ImageService imageService) {   
	this.imageService = imageService; 
	} 
	@RequestMapping(value = "imagemanager", method = RequestMethod.GET)
	ModelAndView uploadImage(String name) {
	return new ModelAndView("imagemanager");
	}
	@RequestMapping(value = "/image/add", method = RequestMethod.POST)
	public String addPersonFrom(@RequestParam(value = "image", required = true) MultipartFile image) {
	 
	if (!image.isEmpty()) {
	try {
	validateImage(image);
	 
	} catch (RuntimeException re) {
	return "redirect:/person?new";
	}
	
	try {
	saveImage(image.getOriginalFilename(), image);
	} catch (IOException e) {
	return "redirect:/person?new";
	}
	}
	 
	return "redirect:/allpersons";
	}
	 
	private void validateImage(MultipartFile image) {
	if (!image.getContentType().equals("image/jpeg")) {
	throw new RuntimeException("Only JPG images are accepted");
	}
	}
	 
	@Override
	public void setServletContext(ServletContext servletContext) {
	this.servletContext = servletContext;
	 
	}
	 
	private void saveImage(String filename, MultipartFile image)
	throws RuntimeException, IOException {
	try {
	File file = new File(servletContext.getRealPath("/") + "/images/"
	+ filename);
	BufferedImage bimg = ImageIO.read(new File(servletContext.getRealPath("/") + "/images/"
			+ filename));
	int width          = bimg.getWidth();
	int height         = bimg.getHeight();
	FileUtils.writeByteArrayToFile(file, image.getBytes());
	System.out.println("Go to the location:  " + file.toString()
	+ " on your computer and verify that the image has been stored.");
	} catch (IOException e) {
	throw e;
	}
	}
}
