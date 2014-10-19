package com.mxy.action.json;

import com.mxy.action.BaseAction;

public class JsonCheckVC extends BaseAction{
	
	private String vc;
	
	public String execute()
	{
		System.out.println(vc);
		return this.SUCCESS;
	}
	
	
	public void setVc(String vc) {
		this.vc = vc;
	}


	public boolean getResult()
	{
		return ((String)session.get("rand")).equals(vc);
		
	}

}
