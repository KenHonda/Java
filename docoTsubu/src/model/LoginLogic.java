package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		return dao.LoginExe(user);
	}
}
