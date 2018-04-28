package com.hitrader.test;

import java.util.List;
import java.util.Map;

import com.hitrader.dao.DarkHorseDao;
import com.hitrader.daoimpl.DarkHorseDaoImpl;
import com.hitrader.model.DarkHorse;

public class Test {
	public static void main(String[] args) {
		DarkHorseDao darkHorseDao = new DarkHorseDaoImpl();
		List<Map> list = darkHorseDao.selectDarkHorse();
		System.out.println(list.size());
		
		for (Map map : list) {
			System.out.println(map.toString());
		}
	}
}
