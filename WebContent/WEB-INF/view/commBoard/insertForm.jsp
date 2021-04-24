<%@page import="kr.or.ddit.commBoard.vo.CommBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<CommBoardVO> boardList = (List<CommBoardVO>)request.getAttribute("boardList");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

%>
    
<!DOCTYPE HTML>
<!--
	Arcana by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>신규게시판 등록</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/main.css" />
		<style>@import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap');</style>
		<style>
			h1, h2 {
				font-family: 'Jua', sans-serif;
				font-size : 1.5em;
			}
 			h3, h4, h5, h6, p, span{
				font-family: "Cute Font"; 
				font-size : 1.5em;
			}
/* 			//폰트 적용 안되고 있음 */
			#header h1{
				padding : 0px;
			}
		
		</style>
	</head>
	<body class="is-preload">
		<form action="insert.do" method="post" enctype="multipart/form-data">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">

					<!-- Logo -->
						<h1><a href="index.html" id="logo">Arcana <em>by HTML5 UP</em></a></h1>

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
									</ul>							
								</li>
								<li class="current"><a href="mealparty.html">Meal파티 게시판</a></li>
								<li class="current"><a href="community.html">커뮤니티 게시판</a>
									<ul>
										<li><a href="#">개발 게시판</a></li>
										<li><a href="#">취업 게시판</a></li>
										<li><a href="#">잡담 게시판</a></li>
									</ul>
								</li>
								<li class="current"><a href="mypage.html">마이 페이지</a>
									<ul>
										<li><a href="#">고객정보 조회</a></li>
										<li><a href="#">고객정보 수정</a></li>
										<li><a href="#">작성 게시글 조회</a>
											<ul>
												<li><a href="#">게시글 조회  주제 : 개발</a></li>
												<li><a href="#">게시글 조회  주제 : 취업</a></li>
												<li><a href="#">게시글 조회  주제 : 잡담</a></li>										
											</ul>
										</li>
										<li><a href="#">찜한식당 조회</a></li>
										<li><a href="#">Meal파티</a>
											<ul>
												<li><a href="#">매칭 Meal파티 조회</a></li>
												<li><a href="#">매칭 Meal파티 삭제</a></li>
											</ul>
										</li>
									</ul>
								</li>
								<li class="current"><a href="#footer">문의 게시판</a></li>
								<li class="current">
									<a href="#">전체메뉴 Quick</a>
									<ul>
										<li><a href="#">마이페이지</a>
											<ul>
												<li><a href="#">내 정보 조회</a></li>
												<li><a href="#">찜한 식당</a></li>
												<li><a href="#">밀 파 티</a></li>
												<li><a href="#">작성 게시글 보기</a></li>
												<li><a href="#">작성 리뷰 보기</a></li>
											</ul>
										</li>
										<li><a href="#">커뮤니티 게시판</a>
											<ul>
												<li><a href="#">주제 : 개발 정보 게시판</a></li>
												<li><a href="#">주제 : 취업 정보 게시판</a></li>
												<li><a href="#">주제 : 친목(잡담) 게시판</a></li>
											</ul>
										</li>
										<li><a href="#">식당검색</a></a>
											<ul>
												<li><a href="#">거리별 검색</a></li>
												<li><a href="#">가격별 검색</a></li>
												<li><a href="#">분류별 검색</a></li>
												<li><a href="#">안심식당 여부</a></li>
											</ul>
										</li>
									</ul>
								</li>
							</ul>
						</nav>

				</div>

			<!-- Main -->
				<section class="wrapper style1">
					<div class="container">
						<div id="content">

							<!-- Content -->

								<article >
								<header>
										<p><h2>개발 게시판 글쓰기</h2></p>
										<input type="hidden" name="code" value="01"> 
										<input type="hidden" name="userId" value="ihyeon"> 
										<h2>제목<input type="text" name="boardTitle" value=""></h2>								
								</header>
									<h3>내용</h3>
									<span>블랙리스트에 오르고 싶지 않다면 순순히 바른말 고운말을 사용합시다.</span>
									<textarea cols="10" rows="10"name="boardContent" value=""></textarea>
									<span>파일을 올려주세요.</span>
									<input type="file" name="atchFileId">
									<br>
									<input type="submit" value="게시판 등록">
								</article>

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
								<li>&copy; 굿끼제먹. All rights is not reserved</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
							</ul>
								</div>
							</section>
						</div>
					</div>
				</div>

		</div>

		<!-- Scripts -->
			<script src="<%=request.getContextPath() %>/assets/assets/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath() %>/assets/assets/js/jquery.dropotron.min.js"></script>
			<script src="<%=request.getContextPath() %>/assets/assets/js/browser.min.js"></script>
			<script src="<%=request.getContextPath() %>/assets/assets/js/breakpoints.min.js"></script>
			<script src="<%=request.getContextPath() %>/assets/assets/js/util.js"></script>
			<script src="<%=request.getContextPath() %>/assets/assets/js/main.js"></script>
			</form>
	</body>
</html>