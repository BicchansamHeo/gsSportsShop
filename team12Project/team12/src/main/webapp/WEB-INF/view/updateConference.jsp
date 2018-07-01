<%--
subject    : updateConference.jsp
author     : 조현우
date       : 2018. 6. 19.
description : 회의실 수정 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
    조현우	2018-06-19	초안
    강혜정	2018-06-19	페이지 디자인
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
<div class="container">
    <div>
        <div class="pricing professional">
            <div class="p-header">
                <div class="title">
                    <h4>회의실/교육실 관리</h4>
                </div>
                <div class="price">
                    <span class="dollar"></span>
                    <h2>회의실/교육실 수정</h2>
                    <span class="per"></span>
                </div>
            </div>
            <form action="confUpdate.do" method="post" enctype="multipart/form-data">
            <div class="list-group">
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">체크표시는 필수 입력 사항입니다.</strong>
              </a>
               <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
              <label>회의실/교육실 선택</label> 
              	<select class="confName">
					<option value="회의실을 선택해주세요">회의실/교육실 선택</option>
						<c:forEach var="list" items="${confInfoList}" varStatus="status">
							<option value="${list.confName}">${list.confName}</option>
						</c:forEach>
					</select> 
			  </a>          
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">회의실/교육실 이름</strong>
					<input type="text" id="siteName" name="siteName" placeholder="회의실이름"/>
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">회의실/교육실 주소</strong>
					<input type="text" id="confAddr" name="confAddr" placeholder="회의실 주소" />
                </a>
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">회의실/교육실 설명</strong>
					<input type="text" id="roomComm" name="roomComm" placeholder="회의실 설명" />
                </a>
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">회의실/교육실 종류</strong>
					<select id="roomKind" name="roomKind">
						<option value="conference">회의실</option>
						<option value="education">교육실</option>
					</select>
                </a>
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">방크기</strong>
					<input type="text" id="roomSize" name="roomSize" />
                </a>
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">네트워크 사용여부</strong>
					<select id="network" name="network">
						<option value="Y">Y</option>
						<option value="N">N</option>
					</select>
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">최대 수용인원</strong>
					<input type="text" id="maxPeople" name="maxPeople" />
                </a>
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">회의실/교육실 예약 상태</strong>
					<input type="text" id="roomState" name="roomState" />
                </a>               
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">회의실/교육실 대여료</strong>
					<input type="text" id="roomPrice" name="roomPrice" placeholder="30분당 기본 가격" />
                </a>
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                 	<input type="hidden" id="long" name="longitude" />
					<input type="hidden" id="lati" name="latitude" />               	
                </a>
                
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; 
                	<strong class="text-uppercase">회의실/교육실 대표사진</strong>
					<input multiple="multiple" type="file" name="mainFile" /> 
					<label>회의실이름</label><input type="text" id="mainSrc" name="mainSrc" placeholder="회의실이름 입력" />
		          </a>           
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp;
                     <strong class="text-uppercase">회의실/교육실 추가사진</strong>
                     <input multiple="multiple" type="file"name="file" /> 
                     <label>회의실 이름</label><input type="text" id="src" name="src"  placeholder="회의실이름 입력" />
                </a>   
                <!-- 위도경도 숨김 -->
                
                <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp;
					<table id="useFixTable">
						<label>---------현재 등록 기자재(최상위 회의실 선택시 자동 생성)------</label>
							<tbody>
							
							</tbody>
					
					</table>
                 </a> 
                 
                 
                 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp;
					<label>기자재리스트</label>
					<select id="temp" class="fix" name="fix">
						<c:forEach var="list" items="${fixList}" varStatus="status">
							<option value="${list.fixName}">${list.fixName}</option>
						</c:forEach>
					</select>
				</a>
				<a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp;
					<label>---------추가 등록 기자재(추가버튼 시 자동 생성)------</label>
					<table id="table">
						<tbody>
						
						</tbody>
					</table>
					<input type="button" id="addTR" value="추가">
						<input type="hidden" id="siteNo" name="siteNo">
						<input type="hidden" id="siteAddr" name="siteAddr">
					<input type="hidden" id="cnt" name="cnt">
						<input type="hidden" id="roomSeq" name="roomSeq">
						<input type="hidden" id="roomNo" name="roomNo">
				
					<c:forEach var="list" items="${useFixList}" varStatus="status">
						<label>기자재번호</label>
						<input type="text" id="fixNo" name="fixNo" value="${list.fixNo}">
						<label>선택한 수량</label>
						<input type="text" id="quantity" name="quantity"
							value="${list.quantity}">
					</c:forEach>
				</a>
					<c:forEach var="list" items="${roomCount}" varStatus="status">
						<label>카운트</label>
						<input type="text" name="roomCnt" value="${list.count}">
					</c:forEach>
			</form>
			

            <div class="p-footer">
				<form action="deleteConf.do" method="post">
					<input type="submit" value="등록" class="btn adv-color squre"/>
				</form>		            
			</div>
			</form>
    </div>
</div>

	<script>
		var cnt = 0;
		var i = 0;
		var j = 0;
		$(function() {
			$("#addTR").click(
							function() {
								i++;
								j++;
								cnt++;
								var select = $('#temp').val(); // 셀렉트한 값
								var fixName;
								$.ajax({
											url : "/getFixList.do?fixName="
													+ select,
											type : "GET",
											dataType : 'json',
											success : function(data) {
												
												for (var k = 0; k < data.data.length; k++) {
													if (data.data[k].fixName == select) {
														price = data.data[k].price;
													}
												}
												var row = "<tr>";
												row += "<td><label>기자재 이름</label><input type='text' name='FN" + i + "' value='" + select + "' placeholder='기자재이름'/></td>";
												row += "<td><label>수량</label><input type='text' name='QU" + i + "' value='' placeholder='사용초기값'/></td>";
												row += "<td><label>가격 : </label><span>"
														+ price + "</span><td>";
												row += "<td><input type='button' id='delete' value='삭제'><td>";
												row += "</tr>";
												$("#table > tbody").append(row);
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

		$('.confName').on('change', function() {
			var select = $(this).val(); // 셀렉트한 값
			$('#table > tbody').empty();
			$.ajax({
				url : "/getConfInfo.do?confName=" + select,
				type : "GET",
				dataType : 'json',
				success : function(data) {
					$('#confName').val(data.data[0].confName);
					$('#confAddr').val(data.data[0].confAddr);
					$('#roomComm').val(data.data[0].roomComm);
					$('#roomKind').val(data.data[0].roomKind);
					$('#maxPeople').val(data.data[0].maxPeople);
					$('#roomState').val(data.data[0].roomState);
					$('#roomPrice').val(data.data[0].roomPrice);
					$('#network').val(data.data[0].network);
					$('#roomSize').val(data.data[0].roomSize);
					$('#roomNo').val(data.data[0].roomNo);
					$('#deleteConf').val(data.data[0].roomNo);
					$('#siteNo').val(data.data[0].siteNo);
					console.log(data.data[0].siteNo);
					$.ajax({
						url : "/getConfAddr.do?siteNo=" + data.data[0].siteNo,
						type : "GET",
						dataType : 'json',
						success : function(data) {
							console.log(data.data[0].siteAddr);
							$('#confAddr').val(data.data[0].siteAddr);
						}
					});
					$.ajax({
						url : "/getUseFix.do?roomNo=" + data.data[0].roomNo,
						type : "GET",
						dataType : 'json',
						success : function(data) {
							$('#useFixTable > tbody').empty();
							 for(var i = 0; i < data.data.length; i++) {
								var row = "<tr>";
								row += "<td><label>기자재 이름</label><input type='text' name='updateFixName' value='" + data.data[i].fixName + "'></td>";
								row += "<td><label>수량</label><input type='text' name='updateFixQuantity' value='" + data.data[i].quantity + "'></td>";
								row += "<td><input type='hidden' name='updateFixNo' value='" + data.data[i].fixNo + "'></td>";
								row += "<td><input type='button' id='delete' value='삭제'><td>";
								row += "</tr>";
								$("#useFixTable > tbody").append(row);
							} 
						}
					});
					$.ajax({
						url : "/getConfName.do?roomNo=" + data.data[0].roomNo,
						type : "GET",
						dataType : 'json',
						success : function(data) {
							console.log(data.data[0].confName);
							$('#src').val(data.data[0].confName);
							$('#mainSrc').val(data.data[0].confName);
						}
					});
				}
			});

		})
		
	</script>
</body>
</html>