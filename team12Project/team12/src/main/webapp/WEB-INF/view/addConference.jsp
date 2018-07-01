<%--
subject    : addConference.jsp
author     : 조현우
date       : 2018. 6. 15.
description : 회의실을 추가하는 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
    조현우	2018-06-15	초안 업로드
    강혜정	2018-06-16	페이지 디자인 완성
    조현우	2018-06-17	오류수정 및 재구현
    강혜정	2018-06-18	페이지 디자인 재수정
    조현우	2018-06-19	사진 추가 오류 수정
    강헤정	2018-06-20	페이지 반응형으로 수정, 디비에 저장안되는 오류까지 수정
    
--%>



<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="initial-scale=1.0">

</head>
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
<body>
<%--
<h1>회의실 등록</h1>
	<form action="addConf.do" method="post" enctype="multipart/form-data">
		<div>
			<label>회의실 이름</label> <input type="text" name="confName"
				placeholder="회의실 이름" />
		</div>
		<div>
			<label>회의실 주소</label> <select class="confAddr" name="confAddr">
					<option value="회의실 선택">회의실 선택</option> 
				<c:forEach var="list" items="${selectList}" varStatus="status">
					<option value="${list.siteName}">${list.siteName}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>회의실 내용</label> <input type="text" name="roomComm"
				placeholder="회의실 내용" />
		</div>
		<div>
			<label>회의실 종류</label> <select name="roomKind">
				<option value="conference">회의실</option>
				<option value="education">교육실</option>
			</select>
		</div>
		<div>
			<label>방 크기</label> <input type="text" name="roomSize" />
		</div>
		<div>
			<label>네트워크 사용여부</label> <select name="network">
				<option value="Y">Y</option>
				<option value="N">N</option>
			</select> <label>최대 수용인원</label> <input type="text" name="maxPeople" />
		</div>

		<div>
			<label>회의실 예약 상태</label> <input type="text" name="roomState" />
		</div>
		<div>
			<label>대여료</label> <input type="text" name="roomPrice"
				placeholder="30분당 기본 가격" />
		</div>
		<div>
			<label>메인사진저장</label> <input multiple="multiple" type="file"
				name="mainFile" /> <label>회의실 이름</label><input type="text" name="src" />
		</div>
		<div>
			<label>사진저장</label> <input multiple="multiple" type="file"
				name="file" /> <label>회의실 이름</label><input type="text" name="src" />
		</div>
		<div>
			<label>longitude</label> <input type="text" id="long"
				name="longitude" />
		</div>
		<div>
			<label>latitude</label> <input type="text" id="lati" name="latitude" />
		</div>
		<div>
		<label>기자재리스트</label> <select id="temp" class="fix" name="fix">
		
				<c:forEach var="list" items="${fixList}" varStatus="status">
					<option value="${list.fixName}">${list.fixName}</option>
				</c:forEach>
			</select>
		<table id="table">
		
		
		</table>
		<input type="button" id="addTR" value="추가">
		<div>
		<input type="hidden" id="siteNo" name="siteNo">
		</div>
		<div>
		<input type="hidden" id="siteAddr" name="siteAddr">
		</div>
		<input type="hidden" id="cnt" name="cnt">
		</div>
		<div>
		<input type="hidden" id="roomSeq" name="roomSeq" value="${roomSeq}">
		</div>
		
		<div>
		<c:forEach var="list" items="${roomCount}" varStatus="status">
		<label>카운트</label><input type="text" name="roomCnt" value="${list.count}">
		</c:forEach>
		</div>
		<input type="submit" value="등록" />
	</form>

 --%>


   <div class="container">
       <div class="pricing professional">
           <div class="p-header">
               <div class="title">
                   <h4>회의실 관리</h4>
               </div>
               <div class="price">
                   <span class="dollar"></span>
                   <h2>회의실 추가</h2>
                   <span class="per"></span>
               </div>
           </div>
           <form action="addConf.do" method="post" enctype="multipart/form-data">
           <div class="list-group">
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">체크표시는 필수 입력 사항입니다.</strong>
             </a>                
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">회의실 이름　　　　</strong>
             	<input type="text" name="confName" placeholder="회의실 이름" />
             </a>                 
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">건물선택　　　　　</strong>
               	<select class="confAddr" name="confAddr">
				<option value="회의실 선택">건물 선택</option> 
				<c:forEach var="list" items="${selectList}" varStatus="status">
				<option value="${list.siteName}">${list.siteName}</option>
				</c:forEach>
			</select>	    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">회의실 설명　　　　</strong>
             	<input type="text" name="roomComm" placeholder="회의실설명" />    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">회의실종류　　　　</strong>
             	<select name="roomKind">
					<option value="conference">회의실</option>
					<option value="education">교육실</option>
				</select>
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">방 크기　　　　　　</strong>
             	<input type="text" name="roomSize" />m² 
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">최대 수용인원　　　</strong>
             	<input type="text" name="maxPeople" />명    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
	            <strong class="text-uppercase">네트워크 사용여부　</strong>
	           	<select name="network">
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select> 
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">회의실 예약 상태　　</strong>
             	 <input type="text" name="roomState" />    
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">대여료　　　　　　</strong>
             	 <input type="text" name="roomPrice" placeholder="30분당 기본 가격" />
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">기자재리스트　　　</strong>
					 <select id="temp" class="fix" name="fix">
						<c:forEach var="list" items="${fixList}" varStatus="status">
							<option value="${list.fixName}">${list.fixName}</option>
						</c:forEach>
				</select>
				<input type="button" id="addTR" value="추가">
             </a>
			<table id="table">
			
			
			</table>             	 
						<div>
						<input type="hidden" id="siteNo" name="siteNo">
						</div>
						<div>
						<input type="hidden" id="siteAddr" name="siteAddr">
						</div>
						<div>
						<input type="hidden" id="cnt" name="cnt">
						</div>
						<div>
						<input type="hidden" id="roomSeq" name="roomSeq" value="${roomSeq}">
						</div>
						
					<div>
						<c:forEach var="list" items="${roomCount}" varStatus="status">
						<label>카운트</label><input type="text" name="roomCnt" value="${list.count}">
						</c:forEach>
					</div>
                           
            <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">회의실 대표사진　　
             	      <input type="text" name="src" placeholder="(회의실이름 입력)"   />    
             	</strong>
             	<input multiple="multiple" type="file" name="mainFile" />   
             </a>
             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
             	<strong class="text-uppercase">기타사진　　　　　
             	      <input type="text" name="src" placeholder="(회의실이름 입력)"   />    
             	</strong>
             	<input multiple="multiple" type="file" name="file" /> 
             </a>

    

              
              
           </div>
           <div class="p-footer">
          		 <input type="submit" value="등록"  class="btn adv-color squre" />
           </div>
           <!-- /list group -->
          	<input type="hidden" id="long" name="longitude" />    
           	<input type="hidden" id="lati" name="latitude" />   


           
       </form>              
       </div>
       <!-- /.pricing professional -->
</div>













	<script>
	var cnt=0;
	var i = 0;
	var j = 0;
		$(function() {
			$("#addTR").click(function() {
				i++;
				j++;
				cnt++;
				var select = $('#temp').val(); // 셀렉트한 값
				var fixName;
				$.ajax({
					url : "/getFixList.do?fixName=" + select,
					type : "GET",
					dataType : 'json',
					success : function(data) {
						for(var k = 0; k < data.data.length; k++) {
							if(data.data[k].fixName == select) {
								price = data.data[k].price;
							}
						}
						var row = "<tr>";
						row += "<td><label>기자재 이름</label><input type='text' name='FN" + i + "' value='" + select + "' placeholder='기자재이름'/></td>";
						row += "<td><label>수량</label><input type='text' name='QU" + i + "' value='' placeholder='사용초기값'/></td>"; 
						row += "<td><label>가격 : </label><span>" + price + "</span><td>";
						row += "<td><input type='button' id='delete' value='삭제'><td>";
						row += "</tr>";
						$("#table").append(row);
						$("#cnt").val(cnt);
					}
				});
				
			});
			
			$("#table").on("click", "#delete", function() {
				i--;
				cnt--;
				$(this).closest("tr").remove();
			});
		});

		$('.confAddr').on('change', function() {
			var select = $(this).val(); // 셀렉트한 값

			$.ajax({
				url : "/getSiteLD.do?siteName=" + select,
				type : "GET",
				dataType : 'json',
				success : function(data) {
					$('#siteAddr').val(data.data[0].siteAddr);
					$('#siteNo').val(data.data[0].siteNo);
					$('#long').val(data.data[0].longitude);
					$('#lati').val(data.data[0].latitude);
				}
			});

		})
	</script>
</body>
</html>