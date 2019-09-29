package Test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import project.com.DAO.CartDAO;
import project.com.Model.Cart;

public class CartDAOTest {

	static CartDAO CartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("project.com");
		context.refresh();
		CartDAO=(CartDAO)context.getBean("CartDAO");
	}
	
	@Ignore
	@Test
	public void addCartItemTest()
	{
		Cart cartItem=new Cart();
		
		
		cartItem.setProductId(2);
		cartItem.setProductName("Samsung A8");
		cartItem.setQuantity(2);
		cartItem.setPrice(16000);
		cartItem.setStatus("NP");
		cartItem.setUsername("fareed");
		
		assertTrue("Problem in Adding CartItem",CartDAO.addToCart(cartItem));
		
	}
	
	@Test
	public void deleteCartItemTest()
	{
		Cart cartItem=CartDAO.getCartItem(2);
		assertTrue("Problem in deleting CartItem",CartDAO.deleteCartItem(cartItem));
	}
	

}
