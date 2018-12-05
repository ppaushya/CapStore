package com.capstore.service;

import com.capstore.model.Login;

public interface ILoginService {

	public Login getLogin(String emailId, String password);
}
