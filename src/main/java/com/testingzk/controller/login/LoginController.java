package com.testingzk.controller.login;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.testingzk.model.dto.Ad1accessAuthenticateDTO;
import com.testingzk.model.dto.LoginDTO;
import com.testingzk.service.LoginService;
import com.testingzk.service.rest.Ad1accessService;
import com.testingzk.service.rest.MerchantService;

public class LoginController extends GenericForwardComposer<Component> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 595062300568870055L;
	
	private Button btnLogin;
	private Textbox txtUsername, txtPassword;
	
	private Ad1accessService ad1accessService = new Ad1accessService();
	private LoginService loginService = new LoginService();
	private MerchantService voucerService = new MerchantService();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		System.out.println("Hello From Login Controller");
		voucerService.getAllVoucher();
	}
	
	public void onClick$btnLogin(Event e) {
		System.out.println(txtUsername.getValue());
		System.out.println("Ad1access Authenticate : "+ad1accessService.doLogin(new Ad1accessAuthenticateDTO("10000024","adira")));

		
		if (!txtUsername.getValue().equalsIgnoreCase("") && !txtPassword.getValue().equalsIgnoreCase("")) {
			boolean flag = loginService.doLogin(new LoginDTO(txtUsername.getValue(), txtPassword.getValue()));
			
			if (!flag) {
				Messagebox.show("username or password is invalid");
			}
			else {
				Executions.sendRedirect("/home/home.zul");
			}
		}
		else {
			Messagebox.show("username or password is empty");
		}
		
	}
}
