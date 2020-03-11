package com.testingzk.controller.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModelList;

import com.testingzk.model.DummyMerchantType;
import com.testingzk.model.Merchant;

public class HomePopUpController extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	private Combobox cmbMerchantType;
	
	@Override
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		List<DummyMerchantType> dummy = new ArrayList<DummyMerchantType>();
		dummy.add(0, new DummyMerchantType("0", "-SELECT-"));
		dummy.add(new DummyMerchantType("1", "RESTAURANT"));
		dummy.add(new DummyMerchantType("2", "E-COMMERCE"));
		dummy.add(new DummyMerchantType("3", "BEVERAGE"));
		dummy.add(new DummyMerchantType("4", "BOOK STORE"));
		
		ListModelList<DummyMerchantType> listDummyMerchantType = new ListModelList<DummyMerchantType>(dummy);
		
		cmbMerchantType.setModel(listDummyMerchantType);
		cmbMerchantType.setItemRenderer(new ComboitemRenderer<DummyMerchantType>() {

			public void render(Comboitem item, DummyMerchantType data, int index) throws Exception {
				// TODO Auto-generated method stub
				item.setValue(data.getMerchantId());
				item.setLabel(data.getMerchantId() + " - "+ data.getMerchantType());
			}
		});
		//cmbMerchantType.setSelectedIndex(0);
		
		Map<String, Object> getThrowParam = (Map<String, Object>) Executions.getCurrent().getArg();
		
		Merchant merchant = (Merchant) getThrowParam.get("listOfMerchant");
		
		System.out.println(merchant);
		
		
	}
}
