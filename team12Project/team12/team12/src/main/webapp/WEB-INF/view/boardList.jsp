<%--
subject    : boardList.jsp
author     : ������
date       : 2018. 6. 18.
description : ���������� Ȯ���ϴ� ������
 
 [�̸�]   [������]		[����]
 ----------------------------------------------------------
 ������	2018-06-18	�ʾ�
 ������	2018-06-19	������ ���̺� ����
--%>


<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE>
<style>
h3 {
	color: white;
}

h2{
	font-size: 27px;
	color : #333;
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

.btn-primary {
background-color: #1299b3;
border-color: #1299b3;
}


</style>

<div id="page" >

            
	<div class="container">
		 <div class="pricing professional">
            <div class="p-header">
                <div class="title">
			      <h4 style="font-weight: 100; font-size: 20px;">Ŀ�´�Ƽ</h4>
                </div>
                <div class="price">
                    <span class="dollar"></span>
                     <h2 style="font-weight: 530; font-size: 45px;"> ��������</h2>
                    <span class="per"></span>
                    <sec:authorize access="hasAnyRole('ROLE_TM','ROLE_AM','ROLE_EM','ROLE_DM')">
						<button class="btn btn-primary" onclick="location.href='writeNotice.do'">+�����߰�</button>
					</sec:authorize>
                </div>
            </div>
		 </div>
					
		<table id="notice" class="ui celled table" style="width: 100%;">
			<thead>
				<tr>
					<th width="20%">�ۼ���</th>
					<th width="30%">����</th>
					<th width="50%">����</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${noticeList}" varStatus="status">
					<tr>
						<td class="text-center" style="vertical-align: middle;">${list.noticeDate}</td>
						<td class="text-center" style="vertical-align: middle;">${list.noticeTitle}</td>
						<td id="addr" class="text-center" style="vertical-align: middle;">${list.noticeContent}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

		
	
<!--  
		<h2>���� ���� ����</h2>
		<table id="gs_pay_table" class="ui celled table" style="width:100%">
			<thead>
				<tr>
					<th width="20%">�� �ۼ���</th>
					<th width="40%">����</th>
					<th width="30%">�ۼ���</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${boardList}" varStatus="status">
					<tr>
						<td class="text-center" style="vertical-align: middle;">${list.dates}</td>
						<td class="text-center" style="vertical-align: middle;"><a href="#">${list.boardTitle}</a></td>
						<td id="addr" class="text-center" style="vertical-align: middle;">
							<c:choose>
								<c:when test="${list.writer eq null}">�͸�</c:when>
								<c:otherwise> ${list.writer}</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
-->


	</div>
</div>


<script>
$(document).ready(function(){
	//gs_pay_datatable
    $('#gs_pay_table').DataTable();
})
</script>



