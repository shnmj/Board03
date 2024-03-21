package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus")
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	// Menu 목록 조회 /Menus/List
	@RequestMapping("/List")
	public String list(Model model) {  // 넘겨주는 값
		// 조회한 결과를 ArrayList로 돌려줌
		List<MenuVo> menuList = menuMapper.getMenuList(); // Array 생략 가능
		
		// 조회 결과를 Model에 넘겨줌
		model.addAttribute("menuList", menuList); // 앞 List가 $에 들어갈 값
		System.out.println("MenuController list() menuList:" + menuList);
		
		return "menus/list";
		
	}
	
	// Menu 입력받는 화면 // /Menus/WriteForm
	// @RequestMapping("/Menus/WriteForm")
	@RequestMapping("/WriteForm")
	public String writeForm() {
		return "menus/write";  // /WEB-INF/views/ + menus/write + .jsp
	}
	
	// Menu 저장
	// /Menus/Write?menu_id=MENU02&menu_name=JSP&menu_seq=2
	// @RequestMapping("/Menus/Write")
	@RequestMapping("/Write")
	public String write(MenuVo menuVo) {
		// 넘어온 data를 db에 저장
		
		menuMapper.insertMenu(menuVo);
		// menuMapper.insertMenu(menu_id, menu_name, menu_seq); // (interface) MenuMapper.java 호출 Error
		return "menus/list";   // menus/list.jsp
	}
	
	
}
