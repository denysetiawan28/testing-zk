package com.testingzk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class JoinAsMerchantDTO {
	private String merchantEmail;
	private String merchantName;
	private String merchantPhoneNo;
}
