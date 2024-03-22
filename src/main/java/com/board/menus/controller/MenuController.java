package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		// System.out.println("MenuController list() menuList:" + menuList);
		
		return "menus/list";
		
	}
	
	// ============================================
	
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
	public String write(MenuVo menuVo, Model model) {
		// 넘어온 data를 db에 저장
		
		menuMapper.insertMenu(menuVo);
		// menuMapper.insertMenu(menu_id, menu_name, menu_seq); // (interface) MenuMapper.java 호출 Error
		
	//  : 옆에 기재된 주소를 찾아가서 출력 -> 그 주소에서 리턴된 jsp 출력  http302
		return "redirect:/Menus/List"; 
		
		/*
		List<MenuVo> menuList = menuMapper.getMenuList();
		model.addAttribute("menuList", menuList);
		
		return "menus/list";   // menus/list.jsp
		*/
	}
	
	// ===================================================
	
	// /Menus/WriteForm2
	@RequestMapping("/WriteForm2")
	public String writeForm2() {
		return "menus/write2";
	}
	
	@RequestMapping("/Write2")
	public String write2(MenuVo menuVo) {
		// Commit
		menuMapper.insertMenu2(menuVo);
		
		// 조회로 이동
		return "redirect:/Menus/List";
	}
	
	// =================================================
	
	// Menu Update
	// /Menus/UpdateForm?menu_id=${menu.menu_id}
	@RequestMapping("/UpdateForm")
	public String updateForm(MenuVo menuVo, Model model) {
		System.out.println("menuVo:" + menuVo.toString() );
		String menu_id = menuVo.getMenu_id();
		
		// 수정 할 데이터 menu_id 조회
		MenuVo menu = menuMapper.getMenu(menu_id); // get = MENU04
		
		// 조회한 내용을 model에 담는다
		model.addAttribute("menu", menu); //  = "vo", vo
		
		
		return "menus/update";
	}
	
	
	// /Menus/Update?menu_id=MENU07&menu_name=ddds&menu_seq=7
	@RequestMapping("/Update")
	public String update(MenuVo menuVo) {
		
		// 수정
		menuMapper.updateMenu(menuVo);
		
		// 수정 후 조회
		return "redirect:/Menus/List";
		
	}
	
	
	// ==================================================
	
	// Menu Del /Menus/Delete?menu_id=MENU03
	@RequestMapping("/Delete")
	@ResponseBody  // 주소가 아닌 나머지를 보낼 때 사용.
	public String delete(MenuVo menuVo) {
		
		menuMapper.deleteMenu(menuVo);
		
		String html = "<script>";
		html       +="alert('Delete Complete');";
		html       +="location.href='/Menus/List';";
		html       +="</script>";
		return html;
		
	}
	

	/*
	// Menu Del /Menus/Delete?menu_id=MENU03
	@RequestMapping("/Delete")
	public String delete(MenuVo menuVo, Model model) {
		
		// MENU03 delete
		menuMapper.deleteMenu(menuVo);
		
		return "redirect:/Menus/List";
		*/
	
		
		/*
		// 재조회해서 model에 담는다
		List<MenuVo> menuList = menuMapper.getMenuList();
		model.addAttribute("menuList", menuList);
		
		// 이동할 파일
		return "menus/list";
		*/
	
	
	
}
