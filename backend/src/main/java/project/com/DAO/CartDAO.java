package project.com.DAO;

import java.util.List;

import project.com.Model.Cart;

public interface CartDAO {
	public boolean addToCart(Cart cartItem);
	public boolean deleteCartItem(Cart cartItem);
	public boolean updateCartItem(Cart cartItem);
	public List<Cart> listCartItems(String username);
	public Cart getCartItem(int cartItemId);
}
