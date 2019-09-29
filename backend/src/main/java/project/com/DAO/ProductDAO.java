package project.com.DAO;

import java.util.List;
import project.com.Model.Product;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> listProducts();
	public Product getProduct(int productID);
	public List<Product> listProductsCategoryWise(int categoryId);

}
