package project.com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import project.com.Model.Category;

public class CategoryDAOImp implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Category> listCategories() {
		Session session=sessionFactory.openSession();
		Query query=(Query) session.createQuery("from Category");
		List<Category> listCategories=((Query) query).list();
		session.close();
		return listCategories;
	}

	@Override
	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=(Category) session.get(Category.class, categoryId);
		session.close();
		return category;
	}

}
