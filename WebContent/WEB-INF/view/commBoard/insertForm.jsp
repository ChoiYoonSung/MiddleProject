<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신규 게시판 등록</title>
</head>
<body>
	<form action="insert.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>userID</td>
				<td><input type="text" name="userId" value=""></td>
			</tr>
			<tr>
				<td>code</td>
				<td><input type="text" name="code" value=""></td>
			</tr>
			<tr>
				<td>boardTitle</td>
				<td><input type="text" name="boardTitle" value=""></td>
			</tr>
			<tr>
				<td>boardContent</td>
				<td><textarea cols="30" rows="10">  </textarea></td>
			</tr>
<!-- 			<tr>
				<td>atchFileId</td>
				<td><input type="file" name="atchFileId"></td>
			</tr>
 -->		</table>
		<input type="submit" value="게시판 등록">
	</form>
	
	
	
	
</body>
</html>