package com.testingzk.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Merchant {
	private int merchantId;
	private String merchantName;
	private String merchantEmail;
	private String merchantDescription;
	private String merchantWebsite;
	private String merchantSocialMedia;
	private String merchantAddress;
	private Object merchantType;
	private Object companyType;
	private String merchantLogo;
	private boolean isKycVerified;
	private Date verifiedAt;
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;
	private String merchantVerifiedBy;	
	private String merchantUpdatedBy;	
	private String merchantCreatedBy;	
	private String merchantStatus;	
	private String merchantLogoImageURI;	
	private String merchantPhoneNo;	
	private String merchantPicName;	
	private String merchantPicPhoneNo;
}
