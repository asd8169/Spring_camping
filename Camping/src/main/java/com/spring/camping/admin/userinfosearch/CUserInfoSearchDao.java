package com.spring.camping.admin.userinfosearch;

import java.util.ArrayList;


public interface CUserInfoSearchDao {

	public ArrayList<CUserInfoSearchDto> search(String select, String content);
	
}
