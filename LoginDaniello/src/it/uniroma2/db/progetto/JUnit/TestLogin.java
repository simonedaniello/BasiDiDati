package it.uniroma2.db.progetto.JUnit;

import org.junit.Test;

import it.uniroma2.db.controller.LoginController;

public class TestLogin {

	@Test
	public void testLogin(){
		LoginController loginCtrl = LoginController.getGuiControllerInstance(null);
	}
	

}
