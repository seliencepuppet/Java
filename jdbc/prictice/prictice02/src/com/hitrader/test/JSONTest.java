package com.hitrader.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hitrader.dao.DarkHorseDao;
import com.hitrader.daoimpl.DarkHorseDaoImpl;
import com.hitrader.model.DarkHorse;

import net.sf.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		DarkHorseDao darkHorseDao = new DarkHorseDaoImpl();
		List<Map> list = darkHorseDao.selectDarkHorse();
		JSONObject json = new JSONObject();
		
		List<JSONObject> jsonList = new ArrayList<>(); 
		for (Map map : list) {
			jsonList.add(JSONObject.fromObject(map));
		}
		
		json.put("data", JSONArray.fromObject(jsonList));
		System.out.println(json);
	}
}
