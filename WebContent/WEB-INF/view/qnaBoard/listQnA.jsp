<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.qna.vo.QnABoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<QnABoardVO> qnaList = (List<QnABoardVO>)request.getAttribute("qnaList");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
%>

<%@ include file="/WEB-INF/view/layout/top.jsp" %>

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="index.html">Welcome, Admin!</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
            <div class="input-group-append">
                <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
            </div>
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="login.html">로그아웃</a>
            </div>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">MAIN</div>
                    <a class="nav-link" href="index.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Admin Main Page
                    </a>
                    <div class="sb-sidenav-menu-heading">ADMIN DATA</div>
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                        Layouts
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="layout-static.html">Static Navigation</a>
                            <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                        </nav>
                    </div>
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                        Pages
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                Authentication
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="login.html">Login</a>
                                    <a class="nav-link" href="register.html">Register</a>
                                    <a class="nav-link" href="password.html">Forgot Password</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                Error
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="401.html">401 Page</a>
                                    <a class="nav-link" href="404.html">404 Page</a>
                                    <a class="nav-link" href="500.html">500 Page</a>
                                </nav>
                            </div>
                        </nav>
                    </div>
                    <div class="sb-sidenav-menu-heading">Addons</div>
                    <a class="nav-link" href="charts.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                        Charts
                    </a>
                    <a class="nav-link" href="tables.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Tables
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                굿끼제먹 관리자
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <h1 class="mt-4 mb-4">Board Administration</h1>

                <ul class="nav nav-pills mb-4">
                  <li class="nav-item">
                    <a class="nav-link" href="boardAdmin.html">전체</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="noticeAdmin.html">공지</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="faqAdmin.html">FAQ</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" href="qnaAdmin.html">문의</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="eventAdmin.html">홍보/이벤트</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="commuAdmin.html">커뮤니티</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="partyAdmin.html">파티</a>
                  </li>
                </ul>
                <div class="card mb-4">
                    <div class="card-body">
                       문의 게시판 테스트용 임시 페이지 입니다.
                       <a type="button" class="btn btn-outline-danger btn-sm" href="insert.do">글쓰기</a>
                    </div>
                </div>

                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table mr-1"></i>
                        문의 게시판
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>조회수</th>
                                        <th>작성 게시판</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                int qnaSize = qnaList.size();

                                if(qnaSize > 0){
                                    for(int i = 0; i < qnaSize; i++){
                                    %>
                                    <tr>
                                        <td><%= qnaList.get(i).getBoardSeq() %></td>
                                        <td><a href="select.do?boardSeq=<%=qnaList.get(i).getBoardSeq() %>"><%=qnaList.get(i).getBoardTitle() %></a></td>
                                        <td><%= qnaList.get(i).getUserId() %></td>
                                        <td><%= qnaList.get(i).getBoardDate() %></td>
                                        <td><%= qnaList.get(i).getBoardHits() %></td>
                                        <td><%= qnaList.get(i).getBoardType() %></td>
                                    </tr>
                                    <%
                                    }
                                }else{
                                    %>
                                    <tr align="center">
                                        <td colspan="5">게시글이 없습니다.</td>
                                    </tr>
                                    <%
                                }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Enjoy Your Meal Right On Time 2021</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>

<%@ include file="/WEB-INF/view/layout/bottom.jsp" %>
