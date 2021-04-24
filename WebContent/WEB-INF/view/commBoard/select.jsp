<%@page import="kr.or.ddit.common.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.commBoard.vo.CommBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	CommBoardVO cv = (CommBoardVO)request.getAttribute("boardVO");
	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

%>

<!DOCTYPE HTML>
<html>
<head>
<title>신규게시판 등록</title>
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
			border: 2px solid;
			font-family: "gm";
			text-align: center;
		}
		#content{
			text-align: left;
		}
		img{
			width:400px;
			height: 400px;
		}
</style>
</head>
<body class="is-preload">
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
				<div id="content">
					<!-- Content -->
					<h1>
						개발자<%=cv.getCode() %>
						통합 게시판
					</h1>
					<table >
						<tbody>
							<tr>
								<td>게시글 번호</td>
								<td>유저아이디</td>
								<td>작성일자</td>
								<td>추천수</td>
							</tr>
							<tr>
								<td><%=cv.getBoardSeq()%></td>
								<td><%=cv.getUserId()%>></td>
								<td><%=cv.getBoardDate() %></td>
								<td><%=cv.getBoardHitsNumber() %></td>
							</tr>
							<tr>
								<td ><h1>제목</h1></td>
								<td ><%=cv.getBoardTitle() %></td>
							</tr>
							<tr>
								<td ><h1>내용</h1></td>
								
							</tr>
							<img src="../filedownload.do?fileId=<%=cv.getAtchFileId() %>">
							<tr>
								<td ><%=cv.getBoardContent() %></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</section>

		<!-- Footer -->
		<div id="footer">
			<div class="container">
				<div class="row">
					<section class="col-12 col-12-narrower">
						<div class="copyright">
							<ul class="menu">
								<li>&copy; 굿끼제먹. All rights is not reserved</li>
								<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</section>
				</div>
			</div>
		</div>

		</div>

		<!-- Scripts -->
		<script
			src="<%=request.getContextPath() %>/assets/js/jquery.min.js"></script>
		<script
			src="<%=request.getContextPath() %>/assets/js/jquery.dropotron.min.js"></script>
		<script
			src="<%=request.getContextPath() %>/assets/js/browser.min.js"></script>
		<script
			src="<%=request.getContextPath() %>/assets/js/breakpoints.min.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/util.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/main.js"></script>
	</form>
</body>
</html>