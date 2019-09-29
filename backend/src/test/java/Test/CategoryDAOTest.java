package Test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import project.com.DAO.CategoryDAO;
import project.com.Model.Category;

public class CategoryDAOTest {

	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("project.com");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
	}
	
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("LenovoMobile");
		category.setCategoryDesc("All Smart Phone Mobile of Lenovo Brand");
		
		assertTrue("Problem Occured While Adding",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategoryDesc("All Smart Phone Mobile with Different cost of MI Brand");
		
		assertTrue("Problem Occured While Updating",categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		assertTrue("Problem Occured While Deleting",categoryDAO.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> categoryList=categoryDAO.listCategories();
		
		assertTrue("Problem Occured While Retrieving the List",categoryList.size()>0);
		
		for(Category category:categoryList)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc()+":::");
		}
	}
	
	
	

}