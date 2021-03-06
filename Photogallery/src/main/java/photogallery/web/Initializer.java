package photogallery.web;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import photogallery.dao.CreateDAOBeans;
import photogallery.datasource.CreateDataSourceBean;
import photogallery.services.CreateServiceBeans;

public class Initializer  extends AbstractAnnotationConfigDispatcherServletInitializer { 
	
	@Override   
	protected String[] getServletMappings() { 
		return new String[] { "/" }; 
	}   
	@Override   
	protected Class<?>[] getRootConfigClasses() { 
		return new Class<?>[] { CreateDataSourceBean.class, CreateDAOBeans.class, CreateServiceBeans.class };    
	}   
	@Override   
	protected Class<?>[] getServletConfigClasses() { 
		return new Class<?>[] { CreateControllerBeans.class }; 
	}   
	@Override   
	protected Filter[] getServletFilters() { 
		CharacterEncodingFilter utf8Filter = new CharacterEncodingFilter(); 
		utf8Filter.setEncoding("UTF-8"); 
		return new Filter[] {utf8Filter, new OpenEntityManagerInViewFilter()};
	}
	
	
}
