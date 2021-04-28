<%@page import="kr.or.ddit.common.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.comment.vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.qna.vo.QnABoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	QnABoardVO qnaVO = (QnABoardVO) request.getAttribute("qnaVO");
	
	int a = (Integer) request.getAttribute("cnt");
	List<CommentVO> commentList = (List<CommentVO>) request.getAttribute("commentList");
	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
%>    

<%@include file="/WEB-INF/view/common/mainNav.jsp"%>
	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-12">
				<h1 class="my-4">
					Q&A
				</h1>

				<!-- Blog Post -->
				<div class="card mb-4">
					<div class="card-body">
						<table class="table" >
							<tbody>
								<tr class="d-flex text-left">
									<th class="col-1 ">제목</th>
									<th class="col-3 " name="boardTitle"><%=qnaVO.getBoardTitle() %></th>
									<th class="col-6 "></th>
									<th class="col-1 "><small>조회수</small></th>
									<th class="col-1 "name="boardHitsNumber"><small><%=qnaVO.getBoardHits() %></small></th>
								</tr>
								<tr class="d-flex text-left">
									<td class="col-1 ">작성자</td>
									<td class="col-3 "name="userId"><%=qnaVO.getUserId() %></td>
									<th class="col-6 "></th>
									<td class="col-1 "><small>작성일</small></td>
									<td class="col-1 "name="boardDate"><small><%=qnaVO.getBoardDate() %></small></td>
								</tr>
								<%
								if(qnaVO.getAtchFileId() != -1){
									%>
								<tr class="d-flex text-left">
									<td class="col-12"><img class="col-12" src="../filedownload.do?fileId=<%=qnaVO.getAtchFileId() %>">
									</td>
								</tr>
									<%
								}
								%>
								<tr class="d-flex text-left">
									<td class="col-12">
								<%=qnaVO.getBoardContent() %>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="card-footer d-flex justify-content-center">
							<a class="btn btn-lg btn-secondary" type="button" href="list.do">목록으로 돌아가기</a>
							<%
							if(userId != null && userId.equals( qnaVO.getUserId())){
								%>
								&nbsp;&nbsp;
							<a class="btn btn-lg btn-secondary" type="submit" href="update.do?boardSeq=<%=qnaVO.getBoardSeq() %>">수정하기</a>
								&nbsp;&nbsp;
							<a class="btn btn-lg btn-secondary" type="reset" href="delete.do?boardSeq=<%=qnaVO.getBoardSeq() %>">삭제하기</a>
								<%
							}
							%>
					</div>
						</div>
					</div>
				</div>
					<div class="col-11 ml-3 mt-3 text-monospace">
					<h5 class="text-weight-bold">Comments </h5>
					<span><%=a %></span>
					<%
					    for (CommentVO commentVO : commentList) {
					%>
						<div class="card border-secondary" style="max-width: 40rem;">
			              <div id="reply-top<%=commentVO.getReplySeq()%>" class="row card-header pb-0">
			                <p class="col px-md-3 font-weight-bold mb-1"><%=commentVO.getUserId() %></p>
			                <a class="mr-3 text-primary" onclick="fn_update_click('<%=commentVO.getReplySeq()%>');">수정</a>
			                <a class="text-danger" onclick="fn_delete('<%=commentVO.getReplySeq()%>');">삭제</a>
			              </div>
			              <div id="reply-bottom<%=commentVO.getReplySeq()%>" class="row card-header pb-0" style="display: none;">
			                <p class="col px-md-3 font-weight-bold mb-1"><%=commentVO.getUserId() %></p>
			                <a class="mr-3 text-primary" onclick="fn_update_cancel('<%=commentVO.getReplySeq()%>');">취소</a>
			                <a class="text-danger" onclick="fn_update('<%=commentVO.getReplySeq()%>');">등록</a>
			              </div>
			              <div class="card-body">
			                <p class="card-subtitle mb-2 text-muted text-right"><%=commentVO.getReplyDate() %></p>
			                <p class="card-text" id="reply<%=commentVO.getReplySeq()%>"><%=commentVO.getReplyContent() %></p>
			              </div>
			            </div>
					<%
					    }
					%>
					<form id="reply" class="row col-11" method="post">
						<div class="input-group mt-4 mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">내용</span>
							</div>
							<textarea class="form-control" id="replyContent" aria-label="With textarea" name="replyContent"></textarea>
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" id="commentBtn" onclick="fn_insert()">댓글<br>등록</button>
							</div>
						</div>
						<!-- 들고나갈 값 -->
						<input type="hidden" name="code" value="QNA">
						<input type="hidden" name="userId" value="admin">
						<input type="hidden" name="boardSeq" value="<%=qnaVO.getBoardSeq()%>">
						<input type="hidden" name="replySeq" id="replySeq">
						<input type="hidden" id="tmpContent">
					</form>
				</div>
			</div>
			<!-- <form id="delete" method="post"> -->
			<!-- 	<input type="hidden" name="replySeq" id="replySeq"> -->
			<!-- </form>  -->
			</main>
			<script type="text/javascript">
			function fn_update(seq) {
			    if(confirm("댓글을 수정하시겠습니까?")) {
			        $('#reply').attr("action", "<%=request.getContextPath()%>/comment/update.do");
			        $('#replySeq').val(seq);
			        var text = $('#reply' + seq).find('textarea').val();
			        $('#replyContent').val(text);
			        $('#reply').submit();
			    }
			}
			
			function fn_update_click(seq) {
			    $('#reply-top' + seq).hide();
			    $('#reply-bottom' + seq).show();
			    var text = $('#reply' + seq).text();
			    $('#reply' + seq).html('<textarea class="form-control">' + text + '</textarea>');
			    $('#tmpContent').val(text);
			}
			
			function fn_update_cancel(seq) {
			    $('#reply-bottom' + seq).hide();
			    $('#reply-top' + seq).show();
			    $('#reply' + seq).html($('#tmpContent').val());
			}
			
			function fn_insert() {
			    $("#reply").attr("action", "<%=request.getContextPath()%>/comment/insert.do");
			    $("#reply").submit();
			}
			
			function fn_delete(seq) {
			    if(confirm("댓글을 삭제하시겠습니까?")) {
			        $('#reply').attr("action", "<%=request.getContextPath()%>/comment/delete.do");
			        $('#replySeq').val(seq);
			        $('#reply').submit();
			    }
			}
			</script>

			</div>
				<!-- Pagination -->
				<ul class="pagination justify-content-center mb-4">
					<li class="page-item"><a class="page-link" href="#">&larr;
							Older</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Newer
							&rarr;</a></li>
				</ul>


		</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<%@include file="/WEB-INF/view/common/mainFooter.jsp" %>