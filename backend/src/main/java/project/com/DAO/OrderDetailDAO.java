package project.com.DAO;

import project.com.Model.OrderDetail;

public interface OrderDetailDAO {
	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username,int orderId);

}
