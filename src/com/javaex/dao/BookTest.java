package com.javaex.dao;

import java.util.List;

import com.javaex.vo.GuestVo;

public class BookTest {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		GuestVo guestVo = new GuestVo("이름", "비번", "심한욕");
		
		bookDao.insert(guestVo);
		bookDao.delete(3, "비번");
		
		
		List<GuestVo> list = bookDao.select();
		
		for(GuestVo vo : list) {
			System.out.println(vo.toString());
			}
		
		
		
		}
}
