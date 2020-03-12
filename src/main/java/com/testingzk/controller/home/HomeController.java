package com.testingzk.controller.home;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.testingzk.model.Account;
import com.testingzk.model.Merchant;
import com.testingzk.model.dto.JoinAsAccountDTO;
import com.testingzk.model.dto.JoinAsMerchantDTO;
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
	private Textbox txtAccountName, txtAccountEmail, txtAccountGender;

	@Wire
	private Button btnAccountJoin, btnGetDataMerchant;
	
	private MerchantService merchantService = new MerchantService();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	@Listen("onClickGetDataAccount = #winHome")
	public void onClickGetDataMerchant(ForwardEvent e) {
		System.out.println("IN");
		List<Account> result = merchantService.getAllAccount();
		List<Map<String, Object>> tempList = new ArrayList<Map<String,Object>>();
		for (Account val : result) {
			Map<String, Object> newMap = new LinkedHashMap<String, Object>();
			newMap.put("accountName", val.getAccountName());
			newMap.put("accountCompany", val.getAccountCompany());
			
			tempList.add(newMap);
			System.out.println("Name : "+val.getAccountName());
			System.out.println("Company : "+val.getAccountCompany());
		}
		//List<Merchant> listMerchant = merchantService.getAllVoucher();
		
		ListModelList<Account> listMerchantModel = new ListModelList<Account>(result);
		listMerchantModel.setMultiple(true);
		
		listBoxMerchant.setModel(listMerchantModel);
		listBoxMerchant.renderAll();
	}
	
	@Listen("onClickJoinAsAccount = #winHome")
	public void onClickJoinAsAccount(ForwardEvent e) {
		System.out.println("--in--");
		//System.out.println(txtMerchantEmail.getValue());
		//System.out.println(txtMerchantName.getValue());
		//System.out.println(txtMerchantPhone.getValue());
		boolean flag = false;
		
		JoinAsAccountDTO temp = new JoinAsAccountDTO();
		temp.setAccountName(txtAccountName.getValue());
		temp.setAccountEmail(txtAccountEmail.getValue());
		temp.setAccountGender(txtAccountGender.getValue());
		
		flag = merchantService.joinAsAccount(temp);
		
		if (flag) {
			//btnMerchantJoin.setDisabled(false);
			Messagebox.show("Success join as merchant");
		}
		else {
			Messagebox.show("Failed to join as merchant");
		}
	}
	
	@Listen("onClickAddDataMerchant = #winHome")
	public void onClickAddDataMerchant(ForwardEvent e) {
		Window winPopUp = null;
		//listBoxMerchant.getSele
		if (listBoxMerchant.getSelectedCount() <= 1) {
			Account merchant = listBoxMerchant.getSelectedItem() != null ? (Account) listBoxMerchant.getSelectedItem().getValue() : null;
			Map<String, Object> throwParam = new LinkedHashMap<String, Object>();
			throwParam.put("listOfMerchant", merchant);
			
			winPopUp = (Window) Executions.createComponents("/home/popup/PopUpAddMerchant.zul", winHome, throwParam);
			winPopUp.doModal();
		}
		else {
			Messagebox.show("Please checkmark one item only");
		}
	}
	
	
}
