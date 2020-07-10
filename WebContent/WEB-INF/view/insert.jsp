<%@page import="vo.ArtVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<link rel="stylesheet" href="/css/style.css">
<section>

	<div class="container">
		<div class="title">오디션 등록</div>
		
		<form action="/insert" method="post" name="frm" id="frm">
			<table>
				<tr>
					<td>참가번호</td>
					<td>
						<input type="text" id="artist_id" name="artist_id">
					</td>
				</tr>
				<tr>
					<td>참가자명</td>
					<td>
						<input type="text" id="artist_name" name="artist_name">
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" id="artist_year" name="artist_year"> 년
						<input type="text" id="artist_month" name="artist_month"> 월
						<input type="text" id="artist_day" name="artist_day"> 일
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" id="artist_gender" name="artist_gender" value="M">남
						<input type="radio" id="artist_gender" name="artist_gender" value="F">여
					</td>
				</tr>
				<tr>
					<td>특기</td>
					<td>
						<select id="talent" name="talent">
							<option disabled="disabled" hidden="">특기선택</option>
							<option value="1">보컬</option>
							<option value="2">댄스</option>
							<option value="3">랩</option>
						</select>	
					</td>
				</tr>
				<tr>
					<td>소속사</td>
					<td>
						<input type="text" id="agency" name="agency">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" value="오디션 등록" onclick="return checkForm()">
						<input type="reset" value="다시 쓰기" onclick="return resetForm()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</section>

<script>
	function checkForm(){
		const d = document;

		if(d.frm.artist_id.value.trim() == ""){
			alert("참가번호가 입력되지 않았습니다.");
			d.frm.artist_id.focus();
			return false;
		} 
		else if(d.frm.artist_name.value.trim() == ""){
			alert("참가자명이 입력되지 않았습니다.");
			d.frm.artist_name.focus();
			return false;
		}
		else if(d.frm.artist_year.value.trim() == ""){
			alert("생년월일이 입력되지 않았습니다.");
			d.frm.artist_year.focus();
			return false;
		}
		else if(d.frm.artist_month.value.trim() == ""){
			alert("생년월일이 입력되지 않았습니다.");
			d.frm.artist_month.focus();
			return false;
		}
		else if(d.frm.artist_day.value.trim() == ""){
			alert("생년월일이 입력되지 않았습니다.");
			d.frm.artist_day.focus();
			return false;
		}
		else if(d.frm.artist_gender.value.trim() == ""){
			alert("성별이 선택되지 않았습니다.");
			d.frm.artist_gender.focus();
			return false;
		}
		else if(d.frm.artist_talent.value.trim() == ""){
			alert("특기가 선택되지 않았습니다.");
			d.frm.artist_talent.focus();
			return false;
		}
		else if(d.frm.agency.value.trim() == ""){
			alert("소속사가 입력되지 않았습니다.");
			d.frm.agency.focus();
			return false;
		}
		d.frm.submit();
		alert("등록 완료");

	}

	function resetForm(){
		const d = document;

		alert("전체 내용을 지우고 다시 입력합니다.");
		d.frm.artist_id.focus();
	}

</script>

<jsp:include page="master/footer.jsp"/>