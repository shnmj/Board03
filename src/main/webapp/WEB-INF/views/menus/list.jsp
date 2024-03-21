<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
<link rel="icon" type="image/png" href="/img/favicon.png" />
<script src="https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js"></script>
<style>
	td {
			padding 	 : 15px;  
			width   	 : 150px;
			text-align : center; 
			}
			
	tr:first-child {
		background-color: grey;
		color : white;
		font-weight: bold;
		/* SCSS 문법에 적용 */
		td {
			border-color : pink;  
		} 
	}
	
	/*
	tr:first-child > td {
		border-color : black;	
	}
	*/
	
	tr:nth-child(2) > td {
		text-align: right;
	}
</style>
</head>
<body>
	<main>
		<h2>메뉴 목록</h2>
		<table>
			<tr>
				<td>Menu_id</td>
				<td>Menu_name</td>
				<td>Menu_seq</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			<tr>
				<td colspan="5">
					[<a href="/Menus/WriteForm">메뉴 등록</a>]
				</td>
			</tr>
			<c:forEach var="menu" items="${menuList}" >  <!-- c: =  별도의 dtd 필요 -->
			<tr>
				<td>${menu.menu_id}</td>
				<td>${menu.menu_name}</td>
				<td>${menu.menu_seq}</td>
				<td><a href="수정"></a></td>
				<td><a href="삭제"></a></td>
			</tr>
			</c:forEach>
		</table>
		
	</main>
</body>
</html>