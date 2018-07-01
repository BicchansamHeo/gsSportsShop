<%--
subject    : authManage.jsp
author     : 이창주
date       : 2018. 6. 16.
description : 권한 관리 화면
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  이창주   2018-06-16	관리자권한수정 페이지 완료
  허빛찬샘 2018-06-18	예산설정 추가
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<head>
    <style type="text/css">
        .modal-dialog.modal-fullsize {
            width: 80%;
            height: 80%;
            margin: 0;
            padding: 0;
        }

        .modal-content.modal-fullsize {
            height: auto;
            min-height: 80%;
            border-radius: 0;
        }

        .modal.modal-center {
            text-align: center;
            margin: auto;
        }

        @media screen and (min-width: 768px) {
            .modal.modal-center:before {
                display: inline-block;
                vertical-align: middle;
                content: " ";
                height: 100%;
            }
        }

        .modal-dialog.modal-center {
            margin: auto;
            display: inline-block;
            text-align: left;
            vertical-align: middle;

        }

        #cancel {
            margin-left: 85%;
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
            -webkit-border-radius: 0px 5px 5px 0px !important;
            border-radius: 0px 5px 5px 0px !important;
            border: 1px solid #eee !important;
            margin-bottom: 15px !important;
            width: 75% !important;
            height: 42px !important;
            float: left !important;
            padding: 0px 15px !important;
        }

        #myModal ul {
            height: 200px !important;
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
            background-color: #81BDA4;
            color: #FFF;
            text-align: center;
            width: 100%;
            border: 0;
            padding: 17px 25px;
            border-radius: 0px 0px 5px 5px;
            cursor: pointer;
            margin-top: 40px;
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

    </style>
</head>
<div class="container">
    <h1>권한 목록</h1>

    <table id="auth_table" class="ui celled table" style="width:100%">
        <thead>
        <tr>
            <th>권한 명</th>
            <th>사번</th>
            <th>이름</th>
            <th>관리</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${authList}" varStatus="status">
            <tr>
                <td class="text-center" style="vertical-align:middle;">
                    <c:choose>
                        <c:when test="${list.roles eq 'ROLE_AM' }">총무 담당자</c:when>
                        <c:when test="${list.roles eq 'ROLE_EM' }">교육 담당자</c:when>
                        <c:when test="${list.roles eq 'ROLE_SM' }">시스템 담당자</c:when>
                    </c:choose>
                </td>
                <td class="text-center" style="vertical-align:middle;">
                        ${list.empNo}
                </td>
                <td class="text-center" style="vertical-align:middle;">
                        ${list.empName}
                </td>
                <td class="text-center" style="vertical-align:middle;">

                    <button type="button" class="btn btn-link" data-toggle="modal"
                            data-target="#myModal"><a
                            href="javascript:fn_modi('<c:out value='${list.empNo}' />', '<c:out value='${list.roles}' />')"><i
                            class="fa fa-share"></i>위임</a></button>
                    &nbsp
                    <button type="button" class="btn btn-link"><a
                            href="javascript:fn_goUrl('<c:out value='${list.empNo}' />')"><i
                            class="fa fa-ban"></i>박탈</a></button>

                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <button type="button" class="btn adv-info btn-squre" data-toggle="modal" id="add"
            data-target="#myModal">추가
    </button>
	<br/>
	<section class="section type2">
	    <div class="subpage-title">
	        <h4>예산 설정</h4>
	    </div>
	    <blockquote>
	    	<form action="/budgetMod.do" method="post">
	    		<div class="row">
	    			<div class="col-md-6">
	    				<label id="nowBudget"></label>
		        	</div>
	    			<div class="col-md-3">
		        		<input id="budget" name="budget" type="number" class="form-control"/>
		        	</div>
	    			<div class="col-md-3">
			        	<button type="submit" class="btn btn-default">수정</button>
		        	</div>
	        	</div>
	        </form>
	    </blockquote>
	</section>
</div>
<!-- Modal -->
<div class="modal modal-center fade" id="myModal" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog modal-center">
        <div class="modal-content modal-center">
            <form id="reservForm" action="/addAuth.do" method="post" onsubmit="return checkForm();">
                <input type="hidden" id="curEmpNo" name="curEmpNo"/>
                <div id="head">
                    <h1>권한 설정
                        <button type="button" id="cancel" data-dismiss="modal"><i class="fa fa-times"></i></button>
                    </h1>
                </div>

                <div class="contentform">
                    <div class="leftcontact">
                        <div class="form-group">
                            <p>권한 선택</p>
                            <span class="icon-case"><i class="fa fa-users"></i></span>
                            <select id="authList" name="roles">
                                <option value='0'>권한 선택</option>
                                <option value='ROLE_AM'>총무 담당자</option>
                                <option value='ROLE_EM'>교육 담당자</option>
                                <option value='ROLE_SM'>시스템 담당자</option>
                            </select>
                        </div>
                    </div>

                    <div class="rightcontact">

                        <div class="form-group">
                            <p>사원 선택</p>
                            <span class="icon-case"><i class="fa fa-users"></i></span>
                            <select id="empList" name="empNo">
                                <option value='0'>사원 선택</option>
                            </select>
                            <div class="validation"></div>
                        </div>

                    </div>
                </div>
                <button type="button" class="bouton-contact" id="addAuth">확인</button>
            </form>
        </div>
    </div>
</div>

<!-- sweetalert SCRIPT -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<%--suppress BadExpressionStatementJS --%>
<script>
    $(document).ready(function () {
    	$("#nowBudget").text('현재 예산 : '+numberWithCommas(${budget }));    	
    	$("#addAuth").on("click", function(){

	    	swal("권한을 부여하시겠습니까?", {
	      	  buttons: {
	      	    catch: {
	      	      text: "확인",
	      	      value: "catch",
	      	    },
	      	    cancel: "취소",
	      	  },
            }).then((value) => {
                switch(value) {
                case "catch":
                    var auth = $("#authList option:selected").val();
                    var emp = $("#empList option:selected").val();

                    if (auth == '0') {
                        swal("권한을 선택해주세요.", "", "warning");
                        return false;
                    }
                    if (emp == '0') {
                        swal("사원을 선택해주세요.", "", "warning");
                        return false;
                    }
                    $("select[id=authList]").attr("disabled", false);


                    swal("수정이 완료되었습니다.", "", "success");
                    reservForm.submit();
                    break;
                default:
                    break;
                }
            });
        });
      	  
        //gs_pay_datatable
        $('#auth_table').DataTable();

        $('#add').on("click", function () {
            $("#authList").attr("disabled", false);
            $('#curEmpNo').val('');
        });
    });

    function checkForm() {


        var auth = $("#authList option:selected").val();
        var emp = $("#empList option:selected").val();

        if (auth == '0') {
        	swal("권한을 선택해주세요.", "", "warning");
            return false;
        }
        if (emp == '0') {
        	swal("사원을 선택해주세요.", "", "warning");
            return false;
        }
        $("select[id=authList]").attr("disabled", false);

        return true;

    }

    $.ajax({
        url: "/getEmp.do",
        type: "GET",
        dataType: 'json',
        success: function (response) {

            console.log(response.data);
            var data = response.data;
            if (data != null) {
                $.each(data, function (key, value) {


                    $("#empList").append("<option value='" + value.empNo + "'>" + value.empName + " / " + value.deptName + "</option>");


                });
            }
        }
    });

    function fn_goUrl(empNo) {

        swal(empNo + " 님의 권한을 박탈하시겠습니까?", {
            buttons: {
                catch: {
                    text: "확인",
                    value: "catch",
                },
                cancel: "취소",
            },
        }).then((value) => {
            switch(value) {
            case "catch":
                location.href = "/removeAuth.do?empNo=" + empNo;
                break;
            default:
                break;
            }
        });
    }

    function fn_modi(empNo, roles) {
        $("#authList").val(roles).prop("selected", true);
        $("select[id=authList]").attr("disabled", true);
        $('#curEmpNo').val(empNo);
    }
  //숫자 콤마
    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
</script>