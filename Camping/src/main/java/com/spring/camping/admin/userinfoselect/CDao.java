package com.spring.camping.admin.userinfoselect;

import java.util.ArrayList;


public interface CDao {

	public ArrayList<CUserInfoDto> selectUserInfo(int page, int pageSize);
	
}
