<%--
subject    : gs_stat_view.jsp
author     : 허빛찬샘
date       : 2018. 6. 18.
description : 통계 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  허빛찬샘	2018-06-18	통계 페이지 초안 작성
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE>
<script src="/stat/vendor/chart.js/Chart.min.js"></script>
<script src="/stat/js/sb-admin-charts.min.js"></script>
<div class="container">
		<div class="pricing professional">
            <div class="p-header">
                <div class="title">
                    <h4 style="font-weight: 100; font-size: 20px;">관리</h4>
                </div>
                <div class="price">
                    <span class="dollar"></span>
                    <h2 style="font-weight: 530; font-size: 45px;"> 월별 회의실 예약 현황</h2>
                    <span class="per"></span>
                 </div>
            </div>
		 </div>

	<!-- <input id="barBtn" type="button" class="btn btn-info" value="월별 회의실 예약 현황" disabled="disabled"/> -->
	<!-- <input id="pieBtn" type="button" class="btn btn-default" value="회의실 예약 BEST" /> --><br/><br/>
 	<!-- <div class="card-body"> -->
    <canvas id="myChart" width="200%" height="60%"></canvas>
    <br/>
	<table class="table">
		<tr>
			<td>/</td>
			<c:forEach var="list" items="${monthList}">
				<td>
					${list.month }월
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td>가장 많이 예약한 회의실</td>
			<c:forEach var="list" items="${monthList}">
				<td>
					${list.roomNameMax } / ${list.maxCnt }
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td>가장 적게 예약한 회의실</td>
			<c:forEach var="list" items="${monthList}">
				<td>
					${list.roomNameMin } / ${list.minCnt }
				</td>
			</c:forEach>
		</tr>
	</table>
    <script>
	    $("#barBtn").on("click", function(){
			location.href = "/stat.do";
		})
	    $("#pieBtn").on("click", function(){
			location.href = "/statPie.do";
		})
          var ctx = document.getElementById("myChart");
          var monthName = [];
          var roomNameMax = [];
          var roomNameMin = [];
          var maxCnt = [];
          var minCnt = [];
          <c:forEach var="list" items="${monthList}" varStatus="status">
				monthName.push('${list.month}'+'월');
				roomNameMax.push('${list.roomNameMax}');
				roomNameMin.push('${list.roomNameMin}');
				maxCnt.push('${list.maxCnt}');
				minCnt.push('${list.minCnt}');
          </c:forEach> 
          
          var myChart = new Chart(ctx, {
              type: 'bar',
              data: {
                  labels: monthName,
                  datasets: [{
                      label: "최대 예약 회의실",
                      data: maxCnt
                  },{
                      label: "최소 예약 회의실",
                      data: minCnt
                  }],
                  backgroundColor: [
                       'rgba(255, 99, 132, 0.2)',
                       'rgba(54, 162, 235, 0.2)',
                       'rgba(255, 206, 86, 0.2)',
                       'rgba(75, 192, 192, 0.2)',
                       'rgba(153, 102, 255, 0.2)',
                       'rgba(255, 159, 64, 0.2)'
                   ],
                   borderColor: [
                       'rgba(255,99,132,1)',
                       'rgba(54, 162, 235, 1)',
                       'rgba(255, 206, 86, 1)',
                       'rgba(75, 192, 192, 1)',
                       'rgba(153, 102, 255, 1)',
                       'rgba(255, 159, 64, 1)'
                   ],
                   borderWidth: 1
              },
              options: {
                  scales: {
                      yAxes: [{
                          ticks: {
                              beginAtZero:true
                          }
                      }]
                  }
              }
          });
       </script>
   </div>