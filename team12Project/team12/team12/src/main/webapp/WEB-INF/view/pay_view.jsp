<%--
subject    : gs_pay_view.jsp
author     : 허빛찬샘
date       : 2018. 6. 08.
description : 결재 페이지

  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-08	초안 작성
  허빛찬샘	2018-06-12	디테일 작성
  허빛찬샘	2018-06-14	디자인 및 추가 기능 수정
  강혜정	2018-06-16	모달창 디자인
  강혜정	2018-06-16	디자인수정
  
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE>
<style>
	h3 {
		color: white;
	}

	#payModal input[type="text"] {
		border-radius: 5px 5px 5px 5px;
		border: 1px solid #eee;
		margin-bottom: 15px;
		width: 100%;
		height: 42px;
		float: left;
		padding: 0px 15px;
		background-color: #F6F6F6;
	}

	ul, ol {
		float: left;
	}

	#payModal {
		overflow: auto !important;
		-ms-overflow-style: none;
	}

	::-webkit-scrollbar {
		display: none;
	}

</style>



<div class="container">
		 <div class="pricing professional">
            <div class="p-header">
                <div class="title">
                    <h4 style="font-weight: 100; font-size: 20px;">관리</h4>
                </div>
                <div class="price">
                    <span class="dollar"></span>
                    <h2 style="font-weight: 530; font-size: 45px;"> 결재목록</h2>
                    <span class="per"></span>
                 </div>
            </div>
		 </div>
		 
	<table id="gs_pay_table" id="test" class="ui celled table" style="width:100%; margin: 15px;">
		<thead>
		<tr>
			<th>예약번호</th>
			<th>기간</th>
			<th>타입</th>
			<th>결재 요청 사항</th>
			<th>신청자</th>
			<th>승인여부</th>
			<th>결재</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${reservList}" varStatus="status" >
			<tr>
				<td class="text-center" style="vertical-align:middle;">
						${list.reservNo}
				</td>
				<td class="text-center" style="vertical-align:middle;">
						${list.startDate} ~ ${list.endDate}
				</td>
				<td class="text-center" style="vertical-align:middle;">
					<c:choose>
						<c:when test="${list.roomKind eq 'conference' }">회의실</c:when>
						<c:when test="${list.roomKind eq 'education' }">교육실</c:when>
					</c:choose>
				</td>
				<td class="text-center" style="vertical-align:middle;">
						${list.reservContent}
				</td>
				<td class="text-center" style="vertical-align:middle;">
						${list.reservEmpName}
				</td>
				<td class="text-center" style="vertical-align:middle;">
					<c:choose>
						<c:when test="${role eq 'ROLE_DM' && list.approval1 eq 'Y'}">
							<button type="button" class="btn adv-success btn-sm" disabled="disabled">승인완료</button>
						</c:when>
						<c:when test="${role eq 'ROLE_AM' && list.approval22 eq 'Y'}">
							<button type="button" class="btn adv-success btn-sm" disabled="disabled">승인완료</button>
						</c:when>
						<c:when test="${role eq 'ROLE_EM' && list.approval21 eq 'Y' }">
							<button type="button" class="btn adv-info btn-sm" disabled="disabled">승인완료</button>
						</c:when>
						<c:otherwise><button type="button" class="btn adv-default btn-sm" disabled="disabled">승인대기</button></c:otherwise>
					</c:choose>
				</td>
				<td class="text-center" style="vertical-align:middle;">
					<c:choose>
						<c:when test="${list.approval1 eq 'Y' && role eq 'ROLE_DM'}"><i class="fa fa-check-circle-o"></i></c:when>
						<c:when test="${list.approval21 eq 'Y' && role eq 'ROLE_EM'}"><i class="fa fa-check-circle-o"></i></c:when>
						<c:when test="${list.approval22 eq 'Y' && role eq 'ROLE_AM'}"><i class="fa fa-check-circle-o"></i></c:when>
						<c:otherwise><a href="javascript:fn_goUrl('<c:out value='${list.reservNo}' />')"><i class="fa fa-check"></i>결재</a></c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<th>예약번호</th>
			<th>기간</th>
			<th>타입</th>
			<th>결재 요청 사항</th>
			<th>신청자</th>
			<th>승인여부</th>
			<th>결재</th>
		</tr>
		</tfoot>
	</table>
</div>

<form id="payFrm" action="/payApply.do" method="post">
	<input id="reservEmpNo" name="reservEmpNo" type="hidden"/>
	<input id="roomKind" name="roomKind" type="hidden">
	<input id="roomNo" name="roomNo" type="hidden">
	<input id="longTermYn" name="longTermYn" type="hidden"/>
	<input id="reservNo2" name="reservNo" type="hidden"/>
	<input id="reservEmpName2" name="reservEmpName" type="hidden"/>
</form>
<!-- modal창 시작 -->
<div id="payModal" class="modal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 100%; height: 730px; border-radius: 0px; overflow:auto">
			<div id="payhead" class="modal-header" align="center">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 style="">예약 상세 내역</h3>
			</div>
			<div id="paybody" class="modal-body" align="center">

				<div class="row">
					<div class="col-sm-6">
						<label style="float:left; padding-top: 15px;"><i class="fa fa-reorder"></i>　예약번호　</label>
						<input id="reservNo" type="text" disabled="disabled" style="width:100px"/>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-sm-6">
						<label style="float:left; padding-top: 15px;"><i class="fa fa-file-text-o"></i>　예약자　　</label>
						<input id="reservEmpName" type="text" disabled="disabled" style="width:100px"/>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<i class="fa fa-calendar"></i>
						<label for="reservTime">예약 시간</label><br/>
						<input id="reservTime" name="reservTime" type="text" disabled="disabled"/>
					</div>
					<!-- col-sm-8-->
				</div>
				<div class="row">
					<div class="col-sm-12">
						<fieldset
								style="margin: 10px 0px; padding: 10px 0px; border: 1px solid silver">
							<div class="col-sm-6">
								<i class="fa fa-group"></i>
								<label for="totalTeam">총 이용 팀</label><br/>
								<input
										id="totalTeam" name="totalTeam" type="text" disabled="disabled"/><br/>
								<br />
								<!-- 팀목록 -->
								<ul id="teamList">
								</ul>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<fieldset
								style="margin: 10px 0px; padding: 10px 0px; border: 1px solid silver">
							<div class="col-sm-6">
								<!-- 사원목록 -->
								<i class="fa fa-user"></i>
								<label for="totalPeople">총 이용 인원</label><br/>
								<input
										id="totalPeople" name="totalPeople" type="text"
										disabled="disabled"/><br/>
								<br />
								<!-- 사원목록 -->
								<ul id="empList">
								</ul>
							</div>
						</fieldset>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6" style="margin: 10px 0px;">

						<label style="float:left; padding-top: 15px;"><i class="fa fa-clock-o"></i>총 이용 시간　</label>
						<input id="totalTime" name="totalTime" type="text"
							   disabled="disabled" style="width:100px"/>
					</div>
					<!-- /.row -->
				</div>
				<br/>
				<div class="row">
					<div class="col-sm-6" style="margin: 10px 0px;">

						<label style="float:left; padding-top: 15px;"><i class="fa fa-won"></i>총 이용 가격　</label>
						<input id="totalPrice" name="totalPrice" type="text"
							   disabled="disabled" style="width:100px"/>
					</div>
					<!-- /.row -->
				</div>
				<div id="ft" class="modal-footer">
					<button type='button' class='btn btn-default' id='payModalYes'>승인</button>
					<button type='button' class='btn btn-primary' id='payModalNo'>반려</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- modal창 끝 -->


<script>
    $(document).ready(function () {
        //gs_pay_datatable
        $('#gs_pay_table').DataTable();
        $('#payModalYes').on("click", function () {
            $("#payFrm").attr("action", "/payApply.do");
            payFrm.submit();
        });
        $('#payModalNo').on("click", function () {
            $("#payFrm").attr("action", "/payReturn.do");
            payFrm.submit();
        })
    });

    function fn_goUrl(url) {
        $("#payModal").modal("toggle");
        var url = "/payReserveView.do?reservNo=" + url;
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (data) {
                if (data != '') {
                    $('#teamList').html('');
                    $('#empList').html('');
                    $("#reservEmpName").val(data.reserv.reservEmpName);
                    $("#reservEmpName2").val(data.reserv.reservEmpName);
                    $("#reservEmpNo").val(data.reserv.reservEmpNo);
                    $("#reservNo").val(data.reserv.reservNo);
                    $("#reservNo2").val(data.reserv.reservNo);
                    $("#longTermYn").val(data.reserv.longTermYn);
                    $("#roomKind").val(data.room.roomKind);
                    $("#roomNo").val(data.room.roomNo);
                    $('#reservTime').val(data.reserv.startDate + '~' + data.reserv.endDate);
                    $('#totalTime').val(data.reserv.totalTime + "시간");
                    $('#totalPrice').val(data.reserv.price + "원");
                    $('#totalTeam').val(data.deptList.length + "팀");
                    $('#totalPeople').val(data.empList.length + "명");
                    for (var i = 0; i < data.deptList.length; i++) {
                        $('#teamList').append('<li>' + data.deptList[i].deptName + '\t' + data.deptList[i].deptBudget + '원</li>');
                    }
                    for (var i = 0; i < data.empList.length; i++) {
                        $('#empList').append('<li>' + data.empList[i].empName + '</li>');
                    }
                }
            }
        });
    }
</script>