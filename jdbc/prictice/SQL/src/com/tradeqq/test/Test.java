package com.tradeqq.test;

public class Test {
	public static void main(String[] args){
		BaseDao baseDao = new BaseDao();
		if(baseDao.getConn() != null){
			System.out.println("数据库连接成功!!!");
		}else{
			System.out.println("db not connection!!!");
		}
	}
}
