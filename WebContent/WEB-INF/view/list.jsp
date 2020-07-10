<%@page import="vo.ArtVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<link rel="stylesheet" href="/css/style.css">
<section>

	<div class="container">
		<div class="title">목록 조회</div>
		
		<%
			List<ArtVO> list = (List<ArtVO>)request.getAttribute("list");
		%>
		<table border="1px solid #dfdfdf" style="text-align: center">
			<tr>
				<td>참가번호</td>
				<td>참가자명</td>
				<td>생년월일</td>
				<td>성별</td>
				<td>특기</td>
				<td>소속사</td>
			</tr>
			
			
		<%
			for(ArtVO vo : list){
				request.setAttribute("vo", vo);
		%>	
			<tr>
				<td>${vo.artist_id }</td>
				<td>${vo.artist_name }</td>
				<td>${vo.artist_birth }</td>
				<td>${vo.artist_gender }</td>
				<td>${vo.talent }</td>
				<td>${vo.agency }</td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
</section>

<jsp:include page="master/footer.jsp"/>