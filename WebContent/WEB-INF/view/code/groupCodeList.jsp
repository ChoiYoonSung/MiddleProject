<%@page import="kr.or.ddit.groupCode.vo.GroupCodeInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    String msg = (String) request.getAttribute("msg");
	List<GroupCodeInfoVO> groupList = (List<GroupCodeInfoVO>) request.getAttribute("groupList");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link href="<%=request.getContextPath() %>/adminView/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.js"></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
	<title>그룹 코드 리스트 전체 조회</title>
</head>
<body class="sb-nav-fixed">

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
                        <h1 class="mt-4 mb-4">Code Administration</h1>

						<div class="card mb-4">
                            <div class="card-body">
                               코드 삽입 테스트용 임시 페이지 입니다.
                               <div class="g-recaptcha" data-sitekey="6LfwG7QaAAAAADom_Fp9nORAKjAkPpyThYdUKyIl" data-callback="recaptcha"></div>
                            </div>
                        </div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                TB_GROUP_CODE_INFO
                               <a type="button" class="btn btn-outline-danger btn-sm float-right" href="<%=request.getContextPath() %>/group/insert.do">코드 추가</a>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>그룹코드</th>
                                                <th>그룹코드명</th>
                                                <th>사용여부</th>
                                                <th>관리</th>
                                            </tr>
                                        </thead>

                                        <tbody id="chk">

                                            <%
                                            	int groupSize = groupList.size();
                                            	if(groupSize > 0) {
                                            		for(int i = 0; i < groupSize; i++) {
											%>
												<tr>
													<td><%=i + 1 %></td>
													<td><%=groupList.get(i).getGroupCode() %></td>
													<td><%=groupList.get(i).getGroupCodeName() %></td>
													<td><%=groupList.get(i).getUseYn() %></td>
													<td>
														<a class="btn btn-outline-info btn-sm" onclick="fn_detail('<%=groupList.get(i).getGroupCode() %>');">상세</a>
														<a class="btn btn-outline-info btn-sm" onclick="fn_update('<%=groupList.get(i).getGroupCode() %>');">수정</a>
														<a class="btn btn-outline-info btn-sm" onclick="fn_delete('<%=groupList.get(i).getGroupCode() %>');">삭제</a>
													</td>
												</tr>
											<%
                                            		}
                                            	} else {
                                            %>

                                            	<tr>
                                            		<td colspan="5"> 그룹코드정보가 없습니다. </td>
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

        <form id="actionForm" method="post">
            <input type="hidden" id="groupCode" name="groupCode" />
        </form>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/adminView/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/adminView/assets/demo/chart-area-demo.js"></script>
        <script src="<%=request.getContextPath() %>/adminView/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/adminView/assets/demo/datatables-demo.js"></script>
		<script type="text/javascript">
            <%
                if(msg != null) {
            %>
                alert('<%=msg %>');
            <%
                }
            %>
            function fn_update(id) {
                $('#actionForm').attr("method", "get");
                $('#actionForm').attr("action", "<%=request.getContextPath() %>/group/update.do");
                $('#groupCode').val(id);
                $('#actionForm').submit();
            }

            function fn_detail(id) {
                $('#actionForm').attr("action", "<%=request.getContextPath() %>/code/list.do");
                $('#groupCode').val(id);
                $('#actionForm').submit();
            }

            function fn_delete(id) {
                if(confirm("삭제하시겠습니까?")) {
                    $('#actionForm').attr("action", "<%=request.getContextPath() %>/group/delete.do");
                    $('#groupCode').val(id);
                    $('#actionForm').submit();
                }
            }
		</script>


</body>
</html>
