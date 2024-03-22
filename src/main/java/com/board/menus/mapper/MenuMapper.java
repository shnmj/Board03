package com.board.menus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.menus.domain.MenuVo;

@Mapper
public interface MenuMapper {
	
	// menuMapper.xml 에서 id="insertMenu"로 된 SQL문을 찾아서 실행
	void insertMenu(MenuVo menuVo);

	List<MenuVo> getMenuList();

	void deleteMenu(MenuVo menuVo);

	void insertMenu2(MenuVo menuVo);

	MenuVo getMenu(String menu_id);

	void updateMenu(MenuVo menuVo);

}
