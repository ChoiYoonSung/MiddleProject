<%@page import="kr.or.ddit.code.vo.CodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<CodeVO> codeList = (List<CodeVO>)request.getAttribute("codeList");

%>
<%@include file="../common/header.jsp" %>
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4 mb-4">Code Administration</h1>

						<div class="card mb-4">
                            <div class="card-body">
                               코드 삽입 테스트용 임시 페이지 입니다.
                               <a type="button" class="btn btn-outline-danger btn-sm" href="write.html">글쓰기</a>
                            </div>
                        </div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                TB_CODE
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>그룹코드</th>
                                                <th>코드</th>
                                                <th>코드명</th>
                                                <th>코드설명</th>
                                                <th>사용여부</th>
                                            </tr>
                                        </thead>

                                        <tbody>

                                            <%
                                            	int codeSize = codeList.size();
                                            	if(codeSize > 0) {
                                            		for(int i = 0; i < codeSize; i++) {
											%>
												<tr>
													<td><%=i + 1 %></td>
													<td><%=codeList.get(i).getGroupCode() %></td>
													<td><%=codeList.get(i).getCode() %></td>
													<td><%=codeList.get(i).getCodeName() %></td>
													<td><%=codeList.get(i).getDescription() %></td>
													<td><%=codeList.get(i).getUseYn() %></td>
												</tr>
											<%
                                            		}
                                            	} else {
                                            %>

                                            	<tr>
                                            		<td colspan="4"> 코드정보가 없습니다. </td>
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/adminView/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/adminView/assets/demo/chart-area-demo.js"></script>
        <script src="<%=request.getContextPath() %>/adminView/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/adminView/assets/demo/datatables-demo.js"></script>

</body>
</html>
