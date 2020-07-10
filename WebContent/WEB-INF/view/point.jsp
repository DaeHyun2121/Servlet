<%@page import="vo.MentoVO"%>
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
			List<MentoVO> p_list = (List<MentoVO>)request.getAttribute("p_list");
		%>
		<table border="1px solid #dfdfdf" style="text-align: center">
			<tr>
				<td>참가번호</td>
				<td>참가자명</td>
				<td>생년월일</td>
				<td>점수</td>
				<td>등급</td>
				<td>멘토</td>
			</tr>
			
			
		<%
			for(MentoVO vo : p_list){
				request.setAttribute("vo", vo);
		%>	
			<tr>
				<td>${vo.artist_id }</td>
				<td>${vo.artist_name }</td>
				<td>${vo.artist_gender }</td>
				<td>${vo.point }</td>
				<td>${vo.rank }</td>
				<td>${vo.mento_name }</td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
</section>

<jsp:include page="master/footer.jsp"/>