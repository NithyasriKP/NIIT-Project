package project.com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.com.Model.Product;


@Repository("ProductDAO")
@Transactional
public class ProductDAOImp implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product)
	{
	    try
	    {
	    	sessionFactory.getCurrentSession().save(product);
	    	return true;
	    }
	    catch(Exception e)
	    {
		  return false;
	    }
	  }

	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return  true;
		}
		catch(Exception e)
		{
		    return false;
		}
	}

	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
		   return false;
		}
	}
	
	public List<Product> listProducts()
	{
		Session session=sessionFactory.openSession();
		Query query=(Query)session.createQuery("from product");
		List<Product> productList=((org.hibernate.Query) query).list();
		session.close();
		return productList;
	}

	public Product getProduct(int productID) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class,productID);
		session.close();
		return product;
	}
	

	public List<Product> listProductsCategoryWise(int categoryId) {
		Session session=sessionFactory.openSession();
		Query query=(Query)session.createQuery("from Category where categoryId=:catid");
		((org.hibernate.Query)query).setParameter("catid",categoryId);
		List<Product> productList=((org.hibernate.Query)query).list();
		return productList;
	}

}
