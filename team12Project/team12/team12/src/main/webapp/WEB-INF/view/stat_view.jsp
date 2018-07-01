<%--
subject    : gs_stat_view.jsp
author     : �������
date       : 2018. 6. 18.
description : ��� ������
 
  [�̸�]   [������]     [����]
  ----------------------------------------------------------
  �������	2018-06-18	��� ������ �ʾ� �ۼ�
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
                    <h4 style="font-weight: 100; font-size: 20px;">����</h4>
                </div>
                <div class="price">
                    <span class="dollar"></span>
                    <h2 style="font-weight: 530; font-size: 45px;"> ���� ȸ�ǽ� ���� ��Ȳ</h2>
                    <span class="per"></span>
                 </div>
            </div>
		 </div>

	<!-- <input id="barBtn" type="button" class="btn btn-info" value="���� ȸ�ǽ� ���� ��Ȳ" disabled="disabled"/> -->
	<!-- <input id="pieBtn" type="button" class="btn btn-default" value="ȸ�ǽ� ���� BEST" /> --><br/><br/>
 	<!-- <div class="card-body"> -->
    <canvas id="myChart" width="200%" height="60%"></canvas>
    <br/>
	<table class="table">
		<tr>
			<td>/</td>
			<c:forEach var="list" items="${monthList}">
				<td>
					${list.month }��
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td>���� ���� ������ ȸ�ǽ�</td>
			<c:forEach var="list" items="${monthList}">
				<td>
					${list.roomNameMax } / ${list.maxCnt }
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td>���� ���� ������ ȸ�ǽ�</td>
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
				monthName.push('${list.month}'+'��');
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
                      label: "�ִ� ���� ȸ�ǽ�",
                      data: maxCnt
                  },{
                      label: "�ּ� ���� ȸ�ǽ�",
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