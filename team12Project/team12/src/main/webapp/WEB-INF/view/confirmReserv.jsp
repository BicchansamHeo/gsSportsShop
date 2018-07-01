<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%--
subject     : confirmReserv.jsp
author      : 이창주
date        : 2018. 6. 12.
description : 예약확인 페이지

[이름]   [수정일]   	[내용]
------------------------------------------------
강혜정 	2018-06-13	초안, 데이터 값 받아오기
강혜정	2018-06-14	예약확인 주요 내역 테이블
강혜정 	2018-06-15	기자재, 다과 테이블 추가 
--%>

<head>
	<style>
		p {
			color: #7f8c8d !important;
		}
	</style>

</head>

<div class="container">

<!-- 완료되면 지우기 
		<div id="data">
			<c:out value="${data}" escapeXml="false"></c:out>
		</div>
 -->




            <div id="main" class="wrapper">
                <div id="primary" class="site-comtent">
                    <div class="container">
                        <section class="section">
                        <div class="row">

								 <!-- /.col-md-8  	예약확인 주요 내역 -->
						         <div class="col-md-8" >
						             <div class="pricing professional">
						                 <div class="p-header">
						                     <div class="title">
						                         <h4>예약 주요 일정</h4>
						                     </div>
						                     <div class="price">
						                         <span class="dollar">총 결제 예상 금액 : 　</span>
                                                 <h2 id="price"> ${data.price} </h2>
						                         <span class="per">￦</span>
						                     </div>
						                 </div>
						                 <div class="list-group">
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">　예약번호　　</strong>${data.reservNo}</a>
                                             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
                                                     class="text-uppercase">　회의실이름(번호)　　</strong> ${data.roomName}(${data.roomNo})</a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">　예약 시작시간　　</strong> ${data.startDate}</a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">~ 예약 종료시간　　</strong> ~ ${data.endDate}</a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">　예약종류 　　</strong>
												<c:choose>
													<c:when test="${data.longTermYn=='Y'}"> 
														장기예약
													</c:when>
													<c:when test="${data.longTermYn=='N'}"> 
														단기예약
													</c:when>
												</c:choose>
											</a>
											 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
													 class="text-uppercase">　회의구분　　</strong>${data.reservContent}</a>
											 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
													 class="text-uppercase">　회의목적　　</strong>${data.reservContent2}</a>

											 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
													 class="text-uppercase">회의참여 팀 　　</strong>
									                    <c:forEach var="list" items="${data.deptList}" varStatus="status" >
															<p style="padding : 0px 10px; vertical-align:middle;">　　　　　　　${list.deptNo}(${list.deptName})</p>
														</c:forEach>
						                     </a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">　팀원목록　　</strong>
						                			     <c:forEach var="list" items="${data.empList}" varStatus="status" >
															 <p style="padding : 0px 10px; vertical-align:middle;">
																 　　　　　${list.empNo}(${list.deptName})</p>
														</c:forEach>
						                     </a>
						                 </div>
						                 <div class="p-footer">
                                             <a href="/mypage.do?empNo=${data.empNo}" class="btn adv-color squre">확인</a>
						                 </div>
						             </div>
						             <!-- /.pricing -->
						         </div> 
						         <!-- /pricing professional --> 
                        	
                        	
	                        	<!-- 스낵, 기자재 리스트  -->
	                            <div>
	                                <div class="col-md-4">
	                                    <div class="pricing">
	                                        <div class="p-header">
	                                            <div class="title">
	                                                <h4>추가 내역1</h4>
	                                            </div>
	                                            <div class="price">
	                                                <span class="dollar">다과</span>
	                                                <h2></h2>
	                                                <span class="per"></span>
	                                            </div>
	                                        </div>
	                                        <div class="list-group">
	                                        	<c:choose>
													<c:when test="${data.snackList ne null}"> 
										    			<c:forEach var="list" items="${data.snackList}" varStatus="status" >
									                        <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">${list.snackName}(${list.snackNo}) </strong>　　　${list.quantity}개</a>
														</c:forEach>  													
													</c:when>
													<c:when test="${data.snackList eq null}">  
														<a>다과를 예약하지 않았습니다.</a>
													</c:when>
												</c:choose>

	                                        </div>
	                                    </div>
	                                    <!-- /.pricing -->
	                           		 </div>
	                           	</div>
	                            <!-- / 스낵, 기자재 리스트 -->
	                            
	                                      	<!-- 스낵, 기자재 리스트  -->
	                            <div>
	                                <div class="col-md-4">
	                                    <div class="pricing">
	                                        <div class="p-header">
	                                            <div class="title">
	                                                <h4>추가 내역2</h4>
	                                            </div>
	                                            <div class="price">
	                                                <span class="dollar">기자재</span>
	                                                <h2></h2>
	                                                <span class="per"></span>
	                                            </div>
	                                        </div>
	                                        <div class="list-group">
	                                        	<c:choose>
													<c:when test="${data.fixtureList ne null}"> 
										    			<c:forEach var="list" items="${data.fixtureList}" varStatus="status" >
									                        <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">${list.fixtureName}(${list.fixtureNo}) </strong>　　　${list.quantity}대</a>
														</c:forEach>  													
													</c:when>
													<c:when test="${data.snackList eq null}">  
														<a>다과를 예약하지 않았습니다.</a>
													</c:when>
												</c:choose>

	                                        </div>
	                                    </div>
	                                    <!-- /.pricing -->
	                           		 </div>
	                           	</div>
	                            <!-- / 스낵, 기자재 리스트 -->
	                            
                       	 </div>
                        </section>
                    </div>
                </div>
                <!-- /.site-comtent -->
            </div>

		
</div>
<script>
    $('#price').text(numberWithCommas($('#price').text()));

    //숫자 콤마
    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
</script>