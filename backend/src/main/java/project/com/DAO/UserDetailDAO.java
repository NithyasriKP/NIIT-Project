package project.com.DAO;

import project.com.Model.UserDetail;

public interface UserDetailDAO {

	public boolean registerUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUser(String username);
}
