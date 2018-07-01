<%--
subject    : detailRoom.jsp
author     : 이창주
date       : 2018-06-08
description :
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  이창주   2018-06-08   초안 작성
  이창주   2018-06-11   예약 폼 추가
  이창주   2018-06-15   예약 폼 디자인 완료
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- 캘린더 -->
<head>
<link rel="stylesheet" href="/datepick/dist/datepickk.css" />
<link rel="stylesheet" href="/timepick/themes/default.css" />
<link rel="stylesheet" href="/timepick/themes/default.time.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/8.7/styles/zenburn.min.css" />
<link href="https://fonts.googleapis.com/css?family=Raleway:400,600"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
<link href="/dist/css/select2.css" rel="stylesheet" />
<script src="/dist/js/select2.js"></script>

<style type="text/css">
#myModal {
	overflow: auto;
}

#myModal2 {
	overflow: auto;
}

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
	width: 80%;
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
.cancel {
	margin-left: 88%;
	border: 0px;
	background-color: #0000;
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

#outInput {
	display: none;
}

#outInput i {
	margin-top: 15px;
}

#myModal2 .info p {
	text-align: center;
	color: #999;
	text-transform: none;
	font-weight: 600;
	font-size: 15px;
	margin-top: 2px
}

#myModal2 .info i {
	color: #F6AA93;
}

#myModal2 form h1 {
	font-size: 18px;
	background: #1299b3 none repeat scroll 0% 0%;
	color: rgb(255, 255, 255);
	padding: 22px 25px;
	border-radius: 5px 5px 0px 0px;
	margin: auto;
	text-shadow: none;
	text-align: left
}

#myModal2 form {
	border-radius: 5px;
	width: 100%;
	background-color: #FFFFFF;
	overflow: hidden;
}

#myModal2 p span {
	color: #F00;
}

#myModal2 p {
	margin: 0px;
	font-weight: 500;
	line-height: 2;
	color: #333;
}

#myModal2 h1 {
	text-align: center;
	color: #666;
	text-shadow: 1px 1px 0px #FFF;
	margin: 50px 0px 0px 0px
}

#myModal2 input[type="text"] {
	border-radius: 0px 5px 5px 0px;
	border: 1px solid #eee;
	margin-bottom: 15px;
	width: 75%;
	height: 42px;
	float: left;
	padding: 0px 15px;
}

#myModal2 select {
	border-radius: 0px 5px 5px 0px !important;
	border: 1px solid #eee !important;
	margin-bottom: 15px !important;
	width: 75% !important;
	height: 42px !important;
	float: left !important;
	padding: 0px 15px !important;
}

#myModal2 ul {
	height: 200px !important;
	background-color: #F6F6F6 !important;
}

#myModal2 a {
	text-decoration: inherit
}

#myModal2 textarea {
	border-radius: 0px 5px 5px 0px;
	border: 1px solid #EEE;
	margin: 0;
	width: 80%;
	height: 95px;
	float: left;
	padding: 0px 15px;
}

#myModal2 .form-group {
	overflow: hidden;
	clear: both;
}

#myModal2 .icon-case {
	width: 35px;
	float: left;
	border-radius: 5px 0px 0px 5px;
	background: #eeeeee;
	height: 42px;
	position: relative;
	text-align: center;
	line-height: 40px;
}

#myModal2 i {
	color: #555;
}

#myModal2 .contentform {
	padding: 40px 30px;
}

#myModal2 .bouton-contact {
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

#myModal2 .leftcontact {
	width: 49.5%;
	float: left;
	border-right: 1px dotted #CCC;
	box-sizing: border-box;
	padding: 0px 15px 0px 0px;
}

#myModal2 .rightcontact {
	width: 49.5%;
	float: right;
	box-sizing: border-box;
	padding: 0px 0px 0px 15px;
}

#myModal2 .validation {
	display: none;
	margin: 0 0 10px;
	font-weight: 400;
	font-size: 13px;
	color: #DE5959;
}

.img-responsive {
	width: 1140px !important;
	height: 570px !important;
}
</style>
</head>
<script src="/invent-v1.0/js/jquery-2.1.4.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/8.7/highlight.min.js"></script>
<script src="/datepick/dist/datepickk.min.js"></script>
<script src="/timepick/picker.js"></script>
<script src="/timepick/picker.time.js"></script>

<script>
	hljs.initHighlightingOnLoad();
</script>
<div class="container">
	 <div class="pricing professional">
           <div class="p-header">
               <div class="title">
                   <h4 style="font-weight: 100; font-size: 20px;">예약</h4>
               </div>
               <div class="price">
                   <span class="dollar"></span>
                   <h2 style="font-weight: 530; font-size: 45px;">예약신청</h2>
                   <span class="per"></span>
                </div>
           </div>
	 </div>      
	<!-- /.portfolio-navigation -->
	<section class="portfolio-thumb section type2">
	<div id="carousel-example-generic" class="carousel slide">
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="${confInfo.mainImgPath}" class="img-responsive"
					id="imgTag" alt="Carousel Image">
			</div>
			<c:forEach var="list" items="${detailImgs}" varStatus="status">
				<div class="item">
					<img src="${list.imgPath}" class="img-responsive" id="imgTag"
						alt="Carousel Image" width="1140px" height="570px">
				</div>
			</c:forEach>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
	</section>
	<!-- /.portfolio-thumb -->
	<div class="row">
		<div class="col-md-8">
			<section class="section type2"> <!-- 캘린터 삽입 -->
			<div id="demoPicker"
				style="height: 600px; width: 100%; max-width: 700px;"></div>
			</section>
		</div>
		<div class="col-md-4">
			<section class="section type2">
			<div class="subpage-title">
				<h5>상세 정보</h5>
			</div>
			<ul class="project-details-list">
				<li>
					<h6>회의실 이름:</h6>
					<div class="project-terms">${confInfo.confName}</div>
				</li>
				<li>
					<h6>회의실 번호:</h6>
					<div class="project-terms">${confInfo.roomNo}</div>
				</li>
				<li>
					<h6>회의실 주소:</h6>
					<div class="project-terms">${confInfo.confAddr}</div>
				</li>
				<li>
					<h6>회의실 내용:</h6>
					<div class="project-terms">${confInfo.roomComm }</div>
				</li>
				<li>
					<h6>시간당 가격:</h6>
					<div class="project-terms">
						<label id="price"></label>
					</div>
				</li>
				<li>
					<h6>회의실 크기:</h6> 
					<div class="project-terms">${confInfo.roomSize}</div> 
				</li> 
				<li>
					<h6>최대 수용인원:</h6>
					<div class="project-terms">${confInfo.maxPeople}<label>명</label>
					</div>
				</li> 
				<li>
					<h6>네트워크 사용 여부:</h6> 
					<div id="network" class="project-terms">
						<c:choose>
							<c:when test="${confInfo.network eq 'Y'}">
								가능
							</c:when>
							<c:when test="${confInfo.network eq 'N'}">
								불가능
							</c:when>
						</c:choose>
					</div>
				</li>
			</ul>
			<label class="radio-inline"> <input type="radio"
				name="inlineRadioOptions" id="inlineRadio1" value="N" checked>
				단기 예약
			</label> <label class="radio-inline"> <input type="radio"
				name="inlineRadioOptions" id="inlineRadio2" value="Y"> 장기 예약
			</label>
			<button id="reserv" type="button"
				class="btn btn-primary btn-lg reserv-btn" data-toggle="modal"
				data-target="#myModal" disabled>예약하기</button>
			</section>

		</div>
	</div>
	<script>
		
	</script>

	<script async defer id="github-bjs"
		src="https://buttons.github.io/buttons.js"></script>
</div>

<!-- 로딩바 -->
<div id="mask"></div>

<!-- Modal -->
<div class="modal modal-center fade" id="myModal" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none; z-index: 1050;">
	<img alt="loading" id="loadingImg" src="/dist/img/ajax-loader.gif">
	<div class="modal-dialog modal-center">
		<div class="modal-content modal-center">
			<form id="reservForm">
				<div class="head">
					<h1>
						예약 하기
						<button type="button" class="cancel" data-dismiss="modal">
							<i class="fa fa-times"></i>
						</button>
					</h1>
					<input type="hidden" id="roomNo" value="${roomNo}" />
				</div>

				<div class="contentform">

					<div class="leftcontact">
						<div class="leftcontact">
							<div class="form-group">
								<p>*예약자 사번</p>
								<span class="icon-case"><i class="fa fa-user"></i></span> <input
									type="text" id="empNo"
									value="<sec:authentication property='principal.username' />"
									readonly />
								<div class="validation"></div>
							</div>
						</div>
						<div class="rightcontact">
							<div class="form-group">
								<p>*회의실 번호 / 최대 수용 인원</p>
								<span class="icon-case"><i class="fa fa-check-square-o"></i></span>
								<input type="text" id="roomConfig" readonly />
								<div class="validation"></div>
							</div>
						</div>
						<div class="leftcontact">
							<div class="form-group">
								<p>*예약 시작 날짜</p>
								<span class="icon-case"><i class="fa fa-calendar"></i></span> <input
									type="text" class="form-control selectDate" id="selectDate"
									name="selectDate" readonly>

							</div>
						</div>
						<div class="rightcontact">
							<div class="form-group">
								<p>*예약 시작 시간 선택</p>
								<span class="icon-case"><i class="fa fa-clock-o"></i></span> <input
									type="text" class="form-control timepicker" id="startTime"
									name="startTime" placeholder="시작시간">

							</div>
						</div>
						<div class="leftcontact">
							<div class="form-group">
								<p>*예약 종료 날짜</p>
								<span class="icon-case"><i class="fa fa-calendar"></i></span> <input
									type="text" class="form-control selectDateEnd"
									id="selectDateEnd" name="selectDateEnd" readonly>

							</div>
						</div>
						<div class="rightcontact">
							<div class="form-group">
								<p>*예약 종료 시간 선택</p>
								<span class="icon-case"><i class="fa fa-clock-o"></i></span> <input
									type="text" class="form-control timepicker2" id="endTime"
									name="endTime" placeholder="종료시간" disabled>

							</div>
						</div>

						<div class="leftcontact">
							<div class="form-group">
								<p>*참여 부서 선택</p>
								<span class="icon-case"><i class="fa fa-users"></i></span> <select
									class="form-control teamList" id="selectTeam">
									<option value='0'>부서 선택</option>
								</select>
								<div class="validation"></div>
							</div>
						</div>

						<div class="rightcontact">
							<div class="form-group">
								<p>
									*참여 사원 선택 <a data-toggle="modal" href="#myModal2"><i
										class="fa fa-search"></i></a>
								</p>
								<span class="icon-case"><i class="fa fa-users"></i></span> <select
									class="form-control empList" id="selectEmp" disabled>
									<option value='0'>사원 선택</option>
								</select>


							</div>
						</div>


						<div class="leftcontact">
							<div class="form-group">
								<p>기자제 선택</p>
								<span class="icon-case"><i class="fa fa-laptop"></i></span> <select
									class="form-control fixtureList">
									<option value='0'>기자제 선택</option>
								</select>
								<div class="validation"></div>
							</div>
						</div>

						<div class="rightcontact">
							<div class="form-group">
								<p>간식 선택</p>
								<span class="icon-case"><i class="fa fa-coffee"></i></span> <select
									class="form-control snackList">
									<option value='0'>간식 선택</option>
								</select>
								<div class="validation"></div>
							</div>
						</div>

						<div class="form-group">
							<p>*회의 구분</p>
							<span class="icon-case"><i class="fa fa-edit"></i></span> <input
								type="text" data-rule="required" id="reservContent"
								name="reservContent" placeholder="회의구분" />
						</div>

						<div class="form-group">
							<p>*회의 목적</p>
							<span class="icon-case"><i class="fa fa-edit"></i></span> <input
								type="text" data-rule="required" id="reservContent2"
								name="reservContent" placeholder="회의목적" />
						</div>
					</div>

					<div class="rightcontact">
						<div class="leftcontact">
							<div class="form-group">
								<p>*참여 팀 목록</p>
								<br>
								<ul class="nav nav-pills nav-stacked teams">

								</ul>
								<div class="validation"></div>
							</div>
						</div>
						<div class="rightcontact">
							<div class="form-group">
								<p>*참여 사원 목록</p>
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
							<hr>
							<button type="button" id="addOut"
								class="btn adv-default btn-squre">외부인 추가</button>
							<div id="outInput">
								<span class="icon-case"><i class="fa fa-child"></i></span> <input
									type="text" class="form-control" id="outsider" name="outsider"
									placeholder="이름을 입력하세요.">
								<button type="button" id="add">
									<i class="fa fa-plus"></i>
								</button>
							</div>

							<hr>
						</div>

						<div class="form-group">
							<p>예상 결제 비용</p>
							<span class="icon-case"><i class="fa fa-krw"></i></span> <input
								type="text" class="form-control" id="totalPrice" name="price"
								readonly>
							<div class="validation"></div>
						</div>


					</div>
				</div>


				<button type="button" class="bouton-contact" id="postReserv">예약하기</button>


			</form>
		</div>
	</div>
</div>

<!-- 검색 모달 -->
<div class="modal modal-center fade" id="myModal2" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none; z-index: 1060;">
	<div class="modal-dialog modal-center">
		<div class="modal-content modal-center">
			<form>
				<div class="head">
					<h1>
						예약 하기
						<button type="button" class="cancel" data-dismiss="modal">
							<i class="fa fa-times"></i>
						</button>
					</h1>
				</div>

				<div class="contentform">

						<div class="form-group">
							<p>*이름 검색</p>
							<span class="icon-case"><i class="fa fa-edit"></i></span> <input
								type="text" data-rule="required" id="empName" name="empName"
								placeholder="이름 검색" />
						</div>
					<br>
					<br>

						<div class="form-group">
							<p>검색 결과</p>
							<br>
							<ul id="empList" class="nav nav-pills nav-stacked ">

							</ul>
							<div class="validation"></div>

				</div>

			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#price").text(numberWithCommas(${confInfo.roomPrice})+'원');
});
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
</script>
<!-- sweetalert SCRIPT -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- 중요!!!!!!!!(ajax, timepick, datepick 커스텀) -->
<script src="/dist/js/reserv.js"></script>

