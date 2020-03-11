package com.testingzk.controller.login;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.testingzk.model.Merchant;
import com.testingzk.service.rest.MerchantService;

public class HomeController extends SelectorComposer<Component> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Wire
	private Window winHome;
	
	@Wire
	private Listbox listBoxMerchant;
	
	@Wire
	private Textbox txtMerchantEmail, txtMerchantName, txtMerchantPhone;

	@Wire
	private Button btnMerchantJoin, btnGetDataMerchant;
	
	private MerchantService merchantService = new MerchantService();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	@Listen("onClickGetDataMerchant = #winHome")
	public void onClickGetDataMerchant(ForwardEvent e) {
		List<Merchant> listMerchant = merchantService.getAllVoucher();
		ListModelList<Merchant> listMerchantModel = new ListModelList<Merchant>(listMerchant);
		listBoxMerchant.setModel(listMerchantModel);
		listBoxMerchant.setCheckmark(true);
		listBoxMerchant.renderAll();
	}
	
	@Listen("onClickJoinAsMerchant = #winHome")
	public void onClickJoinAsMerchant(ForwardEvent e) {
		
	}
	
	
}
