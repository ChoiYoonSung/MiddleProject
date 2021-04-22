<%@page import="kr.or.ddit.commBoard.vo.CommBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<CommBoardVO> boardList = (List<CommBoardVO>)request.getAttribute("boardList");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CommBoard</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/main.css" />
		<style>
		@import
			url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap')
			;
		</style>
		<style>
		h1, h2 {
			font-family: 'Jua', sans-serif;
			font-size: 1.5em;
		}
		
		h3, h4, h5, h6, p, span {
			font-family: "gm";
			font-size: 1.5em;
		}
		#header h1 {
			padding: 0px;
		}
		tbody{
			width:70%;
			font-size:1.0em;
			border-bottom: 2px solid;
			font-family: "gm";
			text-align: center;
		}
		</style>
		<!-- Scripts -->
		<script src="<%=request.getContextPath() %>/assets/js/jquery.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/jquery.dropotron.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/browser.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/breakpoints.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/util.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/main.js"></script>
</head>
<body class="is-preLoad">
	<form id="shorty">
		<!-- Header -->
		<div id="header">
			<h1>
				<a href="index.html" id="logo">굿 끼 제 먹</a>
			</h1>
			<span>굿! 끼니는 제 때 먹어야지.</span>

			<!-- Nav -->
			<nav id="nav">
			<ul>
				<li class="current"><a href="event.html">홍보 및 이벤트 게시판</a></li>
				<li class="current"><a href="search.html">식당 검색</a>
					<ul>
						<li><a href="#">거리별 검색</a></li>
						<li><a href="#">가격별 검색</a></li>
						<li><a href="#">분류별 검색</a></li>
						<li><a href="#">로나 안심식당</a></li>
					</ul></li>
				<li class="current"><a href="mealparty.html">Meal파티 게시판</a></li>
				<li class="current"><a href="community.html">커뮤니티 게시판</a>
					<ul>
						<li><a href="#">개발 게시판</a></li>
						<li><a href="#">취업 게시판</a></li>
						<li><a href="#">잡담 게시판</a></li>
					</ul></li>
				<li class="current"><a href="mypage.html">마이 페이지</a>
					<ul>
						<li><a href="#">고객정보 조회</a></li>
						<li><a href="#">고객정보 수정</a></li>
						<li><a href="#">작성 게시글 조회</a>
							<ul>
								<li><a href="#">게시글 조회 주제 : 개발</a></li>
								<li><a href="#">게시글 조회 주제 : 취업</a></li>
								<li><a href="#">게시글 조회 주제 : 잡담</a></li>
							</ul></li>
						<li><a href="#">찜한식당 조회</a></li>
						<li><a href="#">Meal파티</a>
							<ul>
								<li><a href="#">매칭 Meal파티 조회</a></li>
								<li><a href="#">매칭 Meal파티 삭제</a></li>
							</ul></li>
					</ul></li>
				<li class="current"><a href="#footer">문의 게시판</a></li>
				<li class="current"><a href="#">전체메뉴 Quick</a>
					<ul>
						<li><a href="#">마이페이지</a>
							<ul>
								<li><a href="#">내 정보 조회</a></li>
								<li><a href="#">찜한 식당</a></li>
								<li><a href="#">밀 파 티</a></li>
								<li><a href="#">작성 게시글 보기</a></li>
								<li><a href="#">작성 리뷰 보기</a></li>
							</ul></li>
						<li><a href="#">커뮤니티 게시판</a>
							<ul>
								<li><a href="#">주제 : 개발 정보 게시판</a></li>
								<li><a href="#">주제 : 취업 정보 게시판</a></li>
								<li><a href="#">주제 : 친목(잡담) 게시판</a></li>
							</ul></li>
						<li><a href="#">식당검색</a></a>
							<ul>
								<li><a href="#">거리별 검색</a></li>
								<li><a href="#">가격별 검색</a></li>
								<li><a href="#">분류별 검색</a></li>
								<li><a href="#">안심식당 여부</a></li>
							</ul></li>
					</ul></li>
			</ul>
			</nav>

		</div>

		<!-- Main -->
		<section class="wrapper style1">
		<div class="container">
			<div class="row gtr-200">
				<div class="col-8 col-12-narrower imp-narrower">
					<div id="content">
						<!-- Content -->
						<h1>개발자 통합 게시판</h1>
						<table border="1">
							<tbody>
								<tr>
									<td>게시글 번호</td>
									<td>유저아이디</td>
									<td>code</td>
									<td>제목</td>
									<td>작성일자</td>
									<td>내용</td>
									<td>파일첨부 여부</td>
									<td>추천수</td>
								</tr>
							</tbody>
		<%
				int boardSize = boardList.size();
				if(boardSize > 0){
					for(int i = 0; i < boardSize; i++){
						System.out.print(boardList.get(i).toString());
		%>
							<tr>
								<td><%=boardList.get(i).getBoardSeqNum()%></td>
								<td><a
									href="select.do?memId=<%=boardList.get(i).getUserId()%>"> </a><%=boardList.get(i).getUserId() %></td>
								<td><%= boardList.get(i).getCode() %></a></td>
								<td><%=boardList.get(i).getBoardTitle() %></td>
								<td><%=boardList.get(i).getBoardDate() %></td>
								<td><%=boardList.get(i).getBoardContent() %></td>
								<td><%=boardList.get(i).getAtchFileId() %></td>
								<td><%=boardList.get(i).getBoardHitsNumber() %></td>
							</tr>
		<%
					}
				}else{
			
		%>
							<tr>
								<td colspan="8">게시판 정보가 없습니다.</td>
							</tr>
		<%
				}
		%>
							<tr align='center'>
								<td colspan="8"><a href="insert.do">게시글 등록</a></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="col-3 col-12-narrower">
					<div id="sidebar2">
						<!-- Sidebar 2 -->

						<section>
						<h3>오늘의 핫한 게시글</h3>
						<ul class="links">
							<li><a href="#">자바가 그지같은 이유 9가지</a></li>
							<li><a href="#">CSS가 자바보다 그지같음</a></li>
							<li><a href="#">아니 왜 목으로 날라가냐고</a></li>
							<li><a href="#">초프할 때가 좋았지..</a></li>
							<li><a href="#">변수가 뭐에요?</a></li>
							<li><a href="#">아니. 이게 왜 돌아가지?</a></li>
						</ul>
						<footer> <a href="#" class="button">핫한 게시글 보러가기</a> </footer> </section>


					</div>
				</div>
			</div>
		</div>
		</section>


			<!-- Icons -->
			<ul class="icons">
				<li><a href="#" class="icon brands fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon brands fa-facebook-f"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon brands fa-github"><span
						class="label">GitHub</span></a></li>
				<li><a href="#" class="icon brands fa-linkedin-in"><span
						class="label">LinkedIn</span></a></li>
				<li><a href="#" class="icon brands fa-google-plus-g"><span
						class="label">Google+</span></a></li>
			</ul>

			<!-- Copyright -->
			<div class="copyright">
				<ul class="menu">
					<li>&copy; Untitled. All rights reserved</li>
					<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
				</ul>
			</div>

		</div>

		</div>


</body>
</html>
