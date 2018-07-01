<%--
subject    : mpg_mmb.jsp
author     : 허빛찬샘
date       : 2018. 6. 11.
description : 마이페이지 멤버 정보 보여주는 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-11	초안 작성
  허빛찬샘	2018-06-12	디테일 작성
  허빛찬샘	2018-06-17	예약 신청 목록 부분 수정
  허빛찬샘	2018-06-20	sweetAlert, 예약 취소 버튼 수정 완료
  강혜정	2018-06-20	폰트 수정(색, 글씨체)
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.modal-dialog.modal-fullsize {
    width: 40%;
    height: 40%;
    margin: 0;
    padding: 0;
}

#tb1{
	color: #8c9899;
}
#tb, #tb2{	
	color: #8c9899;
}
.modal-content.modal-fullsize {
    height: auto;
    min-height: 70%;
    border-radius: 0;
}

#myModal {
    overflow: auto;
}
.modal.modal-center {
    text-align: center;
    margin: auto;
    

}
@media screen and (min-width: 1000px) {
    .modal.modal-center:before {
        display: inline-block;
        vertical-align: middle;
        content: " ";
        height: 60%;
    }
}

.modal-dialog.modal-center {
    margin: auto;
    display: inline-block;
    text-align: left;
    vertical-align: middle;
    width: 80%;
    height: 800px;
    
}

#mask {
    position: absolute;
    left: 0;
    top: 0;
    z-index: 100;
    background-color: #000;
    display: none;
}

#loadingImg {
    position: absolute;
    left: 45%;
    top: 50%;
    z-index: 120;
}

.minus {
    border: 0px;
    background-color: #0000;
}

<!--
-->
#cancel {
    margin-left: 5%;
    border: 0px;
    background-color: #0000;

}

@media screen and (max-device-width: 640px) {
    .modal-content {
        height: 2000px !important;
    }
}
#add {
    margin-left: 5px;
    border: 0px;
    background-color: #0000;

}

#myModal .info p {
    text-align: center;
    color: #999;
    text-transform: none;
    font-weight: 600;
    font-size: 15px;
    margin-top: 2px
}

#myModal .info i {
    color: #F6AA93;
}

#myModal form h1 {
    font-size: 18px;
    background: #1299b3 none repeat scroll 0% 0%;
    color: rgb(255, 255, 255);
    padding: 22px 25px;
    border-radius: 5px 5px 0px 0px;
    margin: auto;
    text-shadow: none;
    text-align: left
}

#myModal form {
    border-radius: 5px;
    max-width: 1000px;
    width: 100%;

    background-color: #FFFFFF;
    overflow: hidden;
}

#myModal p span {
    color: #F00;
}

#myModal p {
    margin: 0px;
    font-weight: 500;
    line-height: 2;
    color: #333;
}

#myModal h1 {
    text-align: center;
    color: #666;
    text-shadow: 1px 1px 0px #FFF;
    margin: 50px 0px 0px 0px
}

#myModal input[type="text"] {
    border-radius: 0px 5px 5px 0px;
    border: 1px solid #eee;
    margin-bottom: 15px;
    width: 75%;
    height: 42px;
    float: left;
    padding: 0px 15px;
}

#outsider {
    width: 60%;
}

#myModal select {
    border-radius: 0px 5px 5px 0px !important;
    border: 1px solid #eee !important;
    margin-bottom: 15px !important;
    width: 75% !important;
    height: 42px !important;
    float: left !important;
    padding: 0px 15px !important;
}

#myModal ul {
    height: 150px !important;
    background-color: #F6F6F6 !important;
}

#myModal a {
    text-decoration: inherit
}

#myModal textarea {
    border-radius: 0px 5px 5px 0px;
    border: 1px solid #EEE;
    margin: 0;
    width: 80%;
    height: 95px;
    float: left;
    padding: 0px 15px;
}



#myModal .form-group {
    overflow: hidden;
    clear: both;
}

#myModal .icon-case {
    width: 35px;
    float: left;
    border-radius: 5px 0px 0px 5px;
    background: #eeeeee;
    height: 42px;
    position: relative;
    text-align: center;
    line-height: 40px;
}

#myModal i {
    color: #555;
}

#myModal .contentform {
    padding: 40px 30px;
}

#myModal .bouton-contact {
    background-color: #1299b3;
    color: #FFF;
    text-align: center;
    width: 210px;
    border: 0;
    padding: 17px 25px;
    border-radius: 5px 5px;
    cursor: pointer;
    margin :0 30px 30px 30px;
    font-size: 18px;
}

.bouton-contact-2 {
    background-color: #1299b3;
    color: #FFF;
    text-align: center;
    width: 210px;
    border: 0;
    padding: 17px 25px;
    border-radius: 5px 5px;
    cursor: pointer;
    margin :0 30px 30px 30px;
    font-size: 18px;
}

@media screen and (min-width: 768px) {
    #myModal .leftcontact {
        width: 49.5%;
        float: left;
        border-right: 1px dotted #CCC;
        box-sizing: border-box;
        padding: 0px 15px 0px 0px;
    }

    #myModal .rightcontact {
        width: 49.5%;
        float: right;
        box-sizing: border-box;
        padding: 0px 0px 0px 15px;
    }
}

#myModal .validation {
    display: none;
    margin: 0 0 10px;
    font-weight: 400;
    font-size: 13px;
    color: #DE5959;
}

#myModal #sendmessage {
    border: 1px solid #fff;
    display: none;
    text-align: center;
    margin: 10px 0;
    font-weight: 600;
    margin-bottom: 30px;
    background-color: #EBF6E0;
    color: #5F9025;
    border: 1px solid #B3DC82;
    padding: 13px 40px 13px 18px;
    border-radius: 3px;
    box-shadow: 0px 1px 1px 0px rgba(0, 0, 0, 0.03);
}

#myModal #sendmessage.show, .show {
    display: block;
}

#outInput {
    display: none;
}

#outInput i {
    margin-top: 15px;
}
</style>
</head>
<input id="empNo" type="hidden" value="<sec:authentication property="principal.username" />">
<div class="container">
		<input id="memBtn" type="button" class="btn btn-info" value="개인" />
		<input id="memTeam" type="button" class="btn btn-default" value="팀" /><br/>
<section class="section type2">
    <div class="subpage-title">
        <h4 id="username"></h4>
    </div>

    <blockquote>
        <div class="table-responsive">
            <table id="tb1" class="table table-bordered" style="text-align: center;">
                <tr>
                    <td>핸드폰 번호</td>
                    <td><label id="phone"></label></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><label id="email"></label></td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td><label id="birth"></label></td>
                </tr>
                <tr>
                    <td>부서명</td>
                    <td><label id="deptNm"></label></td>
                </tr>
            </table>
        </div>
    </blockquote>

</section>
<c:choose>
    <c:when test="${fn:length(curReserv) == 0}">

    </c:when>

    <c:otherwise>

        <section class="section type2">
            <div class="subpage-title">
                <h4>현재 진행중인 예약</h4>
            </div>
            <blockquote>
                <div class="table-responsive">
                    <table id="tb2" class="table table-bordered" style="text-align: center;">
                        <tr>
                            <td>예약 번호</td>
                            <td>예약 내역</td>
                            <td>시작 시간</td>
                            <td>종료 시간</td>
                            <td>연장 하기</td>
                        </tr>
                        <c:forEach var="item" items="${curReserv}" varStatus="status">
                            <tr>
                                <td>${item.reservNo}</td>
                                <td>${item.reservContent}</td>
                                <td>${item.startDate}</td>
                                <td>${item.endDate}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${item.extend eq 'Y'}">
                                            이미 연장 하였습니다.
                                        </c:when>

                                        <c:otherwise>
                                            <button type="button" class="btn btn-default">
                                                <a href="/extendReserv.do?empNo=<sec:authentication property='principal.username' />&reservNo=<c:out value='${item.reservNo}' escapeXml="false"/>">
                                                    연장하기</a>
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </blockquote>
        </section>
    </c:otherwise>
</c:choose>


<section class="section type2">
    <div class="subpage-title">
        <h4>예약 내역</h4>
    </div>
    <blockquote>
        <div class="table-responsive">
            <table id="tb" class="table table-hover" style="text-align: center;">
            </table>
        </div>
    </blockquote>
</section>

<!-- 모달 부분 -->
<div id="myModal" class="modal modal-center" role="dialog" aria-hidden="true">
    <img alt="loading" id="loadingImg" src="/dist/img/ajax-loader.gif">
    <div class="modal-dialog modal-center">
        <div class="modal-content modal-center">
            <input type="hidden" id="reservNo" name="reservNo">
            <div id="head">
                <h1> 예약 하기
                    <button type="button" id="cancel" data-dismiss="modal">
                        <i class="fa fa-times"></i>
                    </button>
                </h1>
            </div>

            <div class="contentform">
                <div class="leftcontact">
                    <div class="form-group">
                        <p>예약자 사번</p>
                        <span class="icon-case"><i class="fa fa-user"></i></span>
                        <input type="text" id="empNo" value="<sec:authentication property='principal.username' />"
                               disabled/>
                        <div class="validation"></div>
                    </div>

                    <div class="leftcontact">
                        <div class="form-group">
                            <p>예약 시작 날짜</p>
                            <span class="icon-case"><i class="fa fa-calendar"></i></span>
                            <input type="text" class="form-control selectDate" id="selectDate" name="selectDate"
                                   readonly>
                        </div>
                    </div>
                    <div class="rightcontact">
                        <div class="form-group">
                            <p>예약 시작 시간</p>
                            <span class="icon-case"><i class="fa fa-clock-o"></i></span>
                            <input type="text" class="form-control timepicker" id="startTime" name="startTime"
                                   placeholder="시작시간" disabled>
                        </div>
                    </div>
                    <div class="leftcontact">
                        <div class="form-group">
                            <p>예약 종료 날짜</p>
                            <span class="icon-case"><i class="fa fa-calendar"></i></span>
                            <input type="text" class="form-control selectDateEnd"
                                   id="selectDateEnd" name="selectDateEnd" readonly>

                        </div>
                    </div>
                    <div class="rightcontact">
                        <div class="form-group">
                            <p>예약 종료 시간</p>
                            <span class="icon-case"><i class="fa fa-clock-o"></i></span> <input
                                type="text" class="form-control timepicker2" id="endTime"
                                name="endTime" placeholder="종료시간" disabled>

                        </div>
                    </div>

                    <div class="form-group">
                        <p>*회의 구분</p>
                        <span class="icon-case"><i class="fa fa-edit"></i></span>
                        <input type="text" data-rule="required" id="reservContent" name="reservContent"
                               placeholder="회의구분"/>
                    </div>

                    <div class="form-group">
                        <p>*회의 목적</p>
                        <span class="icon-case"><i class="fa fa-edit"></i></span>
                        <input type="text" data-rule="required" id="reservContent2" name="reservContent"
                               placeholder="회의목적"/>
                    </div>
                </div>

                <div class="rightcontact">
                    <div class="leftcontact">
                        <div class="form-group">
                            <p>참여 팀 목록</p>
                            <br>
                            <ul class="nav nav-pills nav-stacked teams">

                            </ul>
                            <div class="validation"></div>
                        </div>
                    </div>
                    <div class="rightcontact">
                        <div class="form-group">
                            <p>참여 사원 목록</p>
                            <br>
                            <ul class="nav nav-pills nav-stacked emps">

                            </ul>
                            <div class="validation"></div>
                        </div>
                    </div>
                    <br>

                    <div class="leftcontact">
                        <div class="form-group">
                            <p>사용 기자제 목록</p>
                            <br>
                            <ul class="nav nav-pills nav-stacked fixtures">

                            </ul>
                            <div class="validation"></div>
                        </div>
                    </div>
                    <div class="rightcontact">
                        <div class="form-group">
                            <p>사용 간식 목록</p>
                            <br>
                            <ul class="nav nav-pills nav-stacked snacks">

                            </ul>
                            <div class="validation"></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <p>예상 결제 비용</p>
                        <span class="icon-case"><i class="fa fa-krw"></i></span>
                        <input type="text" class="form-control" id="price" name="price"
                               readonly>
                        <div class="validation"></div>
                    </div>


                </div>
            </div>


            <div id="modDiv" style="text-align: center; display: inline-block; width: 100%; height: 80px;">
                <button type="button" class="bouton-contact-2" id="delBtn">예약취소</button>
                <button type="button" class="bouton-contact-2" id="canBtn">취소</button>
            </div>
        </div>
    </div>
</div>
</div>
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- sweetalert SCRIPT -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

    	$("#memTeam").on("click", function(){
    		location.href = "/mypageTeam.do";
        });
    	$("#memBtn").on("click", function(){
    		location.href = "/mypage.do";
        });
    	$("#delBtn").on("click", function () {
            swal("예약을 취소 하시겠습니까?", {
            	  buttons: {
            	    catch: {
            	      text: "확인",
            	      value: "catch",
            	    },
            	    cancel: "취소",
            	  },
            	})
            	.then((value) => {
            	  switch (value) {
                  case "catch":
            	      aJaxCancel();
            	      break;
            	    default:
            	      break;
            	  }
            })
        });
    	
        $("#basic_modal_Yes").on("click", function () {
            var url = "reservCancel.do?reservNo=" + $("#reservNo").val();
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                success: function (data) {
                    if (data != '') {
                        $("#basic_modal").modal("hide");
                        $("#myModal").modal("hide");
                        if (data.data == 0) {
                        	swal("예약실패", "예약 취소가 실패하였습니다.", "warning");
                        } else {
                        	swal("취소성공", "예약이 취소 되었습니다.", "success");
                        }
                    }
                }
            })//ajax
        });

        var url = "/userAjax.do?empNo=" + $('#empNo').val();
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            success: function (data) {
                if (data != '') {
                    $("#username").html(data.userVO.empName + '님');
                    $("#phone").html(data.userVO.phone);
                    $("#email").html(data.userVO.email);
                    $("#birth").html(data.userVO.birthday);
                    $("#deptNm").html(data.userVO.deptName);
                    $("#headDeptNm").html(data.userVO.deptName);
                    var str = '<tr><td>예약번호</td><td>시작시간</td><td>종료시간</td>' +
                        '<td>총예약시간</td><td>단기/장기</td><td>공간 구분</td><td>승인여부</td><td>상세보기</td></tr>';
                    if (data.reservList.length == null) {
                        str += '<tr><td colspan="5">데이터가 없습니다.</td></tr>';
                    } else {
                        for (var i = 0; i < data.reservList.length; i++) {
                            str += '<tr>';
                            str += '<td>';
                            str += data.reservList[i].reservNo;
                            str += '</td>';
                            str += '<td>';
                            str += data.reservList[i].startDate;
                            str += '</td>';
                            str += '<td>';
                            str += data.reservList[i].endDate;
                            str += '</td>';
                            str += '<td>';
                            str += data.reservList[i].totalTime;
                            str += '시간</td>';
                            str += '<td>';
                            if(data.reservList[i].longTermYn == 'Y'){
	                            str += '장기예약';
                            }else{
	                            str += '단기예약';
                            }
                            str += '</td>';
                            str += '<td>';
                            if(data.reservList[i].roomKind == 'conference'){
	                            str += '회의실';
                            }else{
	                            str += '교육실';
                            }
                            str += '</td>';
                            str += '<td>';
                            if (data.reservList[i].approval1 == 'Y' && data.reservList[i].approval21 == 'N' && data.reservList[i].approval22 == 'N') {
                                str += '<button type="button" class="btn adv-primary btn-sm" disabled="disabled">1차승인완료</button>';
                            } else if (data.reservList[i].approval21 == 'Y' && data.reservList[i].approval22 == 'N') {
                                str += '<button type="button" class="btn adv-info btn-sm" disabled="disabled">교육담당자 승인완료</button>';
                            } else if (data.reservList[i].approval22 == 'Y' && data.reservList[i].approval21 == 'N') {
                                str += '<button type="button" class="btn adv-info btn-sm" disabled="disabled">총무담당자 승인완료</button>';
                            } else if (data.reservList[i].approval1 == 'N') {
                                str += '<button type="button" class="btn adv-default btn-sm" disabled="disabled">승인대기</button>';
                            } else {
                                str += '<button type="button" class="btn adv-success btn-sm" disabled="disabled">승인완료</button>';
                            }
                            str += '</td>';
                            str += '<td><i class="fa fa-search" id="detail" reservNo="' + data.reservList[i].reservNo + '"></i>';
                            str += '</td>';
                            str += '</tr>';
                        }
                    }
                    $("#tb").html(str);
                }
            }
        });//ajax
        $("#loadingImg").hide();
        
        $(document).on("click", "#detail", function () {
            var url = "/detailAjax.do?reservNo=" + $(this).attr("reservNo");
            var Now = new Date();
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                success: function (data) {
                    if (data != '') {
                        $("#reservNo").val(data.detail.reservNo);
                        $("#selectDate").val(data.detail.startDate);
                        $("#startTime").val(data.detail.startTime);
                        $("#selectDateEnd").val(data.detail.endDate);
                        $("#endTime").val(data.detail.endTime);
                        $("#reservContent").val(data.detail.reservContent);
                        $("#price").val(numberWithCommas(data.detail.price));
                        
                        //시간 체크해서 예약취소 막아주기
                        if(data.detail.roomKind == 'conference' && data.detail.longTermYn =='N' && Now < new Date(data.detail.startHour)){
                        	$("#delBtn").attr("disabled", false);
                        }else{
                        	if(Now > new Date(data.detail.startHour) || data.detail.approval21 == 'Y' || data.detail.approval22 == 'Y'){
	                        	$("#delBtn").attr("disabled", true);
	                        }else{
	                        	$("#delBtn").attr("disabled", false);
	                        }
                        }
                        
                        var deptStr = "";
                        for (var i = 0; i < data.deptList.length; i++) {
                            deptStr += '<li class="' + data.deptList[i].deptNo + '"><button type="button" class="minus ' + data.deptList[i].deptNo + '_btn"><i class="fa fa-check"></i></button>' + data.deptList[i].deptName + ' / ' + data.deptList[i].deptNo + '</li>';
                        }
                        $(".teams").html(deptStr);
                        var empStr = "";
                        for (var i = 0; i < data.empList.length; i++) {
                            empStr += '<li name="' + data.empList[i].empNo + '" class="' + data.empList[i].deptNo + ' ' + data.empList[i].empNo + '"><button type="button" class="minus ' + data.empList[i].empNo + '_btn"><i class="fa fa-check"></i></button>' + data.empList[i].empName + ' / ' + data.empList[i].empNo + '</li>';
                        }
                        for (var i = 0; i < data.guestList.length; i++) {
                            empStr += '<li id="' + data.guestList[i].name + '"><button type="button" id="delete" class="minus ' + data.guestList[i].name + '"><i class="fa fa-check"></i></button>' + data.guestList[i].name + '</li>';
                        }
                        $(".emps").html(empStr);
                        var fixtureStr = "";
                        for (var i = 0; i < data.fixtureList.length; i++) {
                            fixtureStr += '<li>' + data.fixtureList[i].fixtureName + ' / ' + (data.fixtureList[i].maxQuantity - data.fixtureList[i].reservQuantity) + '(사용가능 수량)<input type="number" class="form-control" id="' + data.fixtureList[i].fixtureNo + '" placeholder="수량을 입력하세요." value="' + data.fixtureList[i].reservQuantity + '"></li>';
                        }
                        $(".fixtures").html(fixtureStr);
                        var snackStr = "";
                        for (var i = 0; i < data.snackList.length; i++) {
                            snackStr += '<li>' + data.snackList[i].snackName + ' / ' + (data.snackList[i].maxQuantity - data.snackList[i].reservQuantity) + '(사용가능 수량)<input type="number" class="form-control" id="' + data.snackList[i].snackNo + '" placeholder="수량을 입력하세요." value="' + data.snackList[i].reservQuantity + '"></li>';
                        }
                        $(".snacks").html(snackStr);
                        
                    }
                }
            });//ajax
            $("#myModal").modal("show");

        })
    });
	function aJaxCancel(){
		 var url = "reservCancel.do?reservNo=" + $("#reservNo").val();
         $.ajax({
             type: "GET",
             url: url,
             dataType: "json",
             success: function (data) {
                 if (data != '') {
                     $("#basic_modal").modal("hide");
                     $("#myModal").modal("hide");
                     if (data.data == 0) {
                     	swal("예약실패", "예약 취소가 실패하였습니다.", "error");
                     } else {
                     	swal("취소성공", "예약이 취소 되었습니다.", "success")
                     	.then((value) => {
                     		reloadFnc();	//취소 성공 시 페이지 새로 고침
                     })
                     }
                 }
             }
         })//ajax
	}
    function reloadFnc() {
        window.location.href = ""; //윈도우 새로고침
    }
    function pad(n, width) {
		n = n + '';
		return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
   	}
    function getQuerystring(paramName) {

        var _tempUrl = window.location.search.substring(1); //url에서 처음부터 '?'까지 삭제
        if (_tempUrl)
            var _tempArray = _tempUrl.split('&'); // '&'을 기준으로 분리하기
        for (var i = 0; _tempArray.length; i++) {
            var _keyValuePair = _tempArray[i].split('='); // '=' 을 기준으로 분리하기
            if (_keyValuePair[0] == paramName) { // _keyValuePair[0] : 파라미터 명 // _keyValuePair[1] : 파라미터 값
                return _keyValuePair[1];
            }
        }
    }

    var result = getQuerystring('result');
    if (result) {
        if (result == '0') {
        	swal("연장 실패", "다른 예약 일정으로 인해 연장할 수 없습니다.", "error");
        } else {
        	swal("연장 성공", "예약시간이 30분 연장되었습니다.", "success");
        }
    }
    //숫자 콤마
    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
</script>
</html>