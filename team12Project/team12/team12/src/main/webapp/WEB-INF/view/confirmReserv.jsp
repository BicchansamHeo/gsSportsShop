<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%--
subject     : confirmReserv.jsp
author      : ��â��
date        : 2018. 6. 12.
description : ����Ȯ�� ������

[�̸�]   [������]   	[����]
------------------------------------------------
������ 	2018-06-13	�ʾ�, ������ �� �޾ƿ���
������	2018-06-14	����Ȯ�� �ֿ� ���� ���̺�
������ 	2018-06-15	������, �ٰ� ���̺� �߰� 
--%>

<head>
	<style>
		p {
			color: #7f8c8d !important;
		}
	</style>

</head>

<div class="container">

<!-- �Ϸ�Ǹ� ����� 
		<div id="data">
			<c:out value="${data}" escapeXml="false"></c:out>
		</div>
 -->




            <div id="main" class="wrapper">
                <div id="primary" class="site-comtent">
                    <div class="container">
                        <section class="section">
                        <div class="row">

								 <!-- /.col-md-8  	����Ȯ�� �ֿ� ���� -->
						         <div class="col-md-8" >
						             <div class="pricing professional">
						                 <div class="p-header">
						                     <div class="title">
						                         <h4>���� �ֿ� ����</h4>
						                     </div>
						                     <div class="price">
						                         <span class="dollar">�� ���� ���� �ݾ� : ��</span>
                                                 <h2 id="price"> ${data.price} </h2>
						                         <span class="per">��</span>
						                     </div>
						                 </div>
						                 <div class="list-group">
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">�������ȣ����</strong>${data.reservNo}</a>
                                             <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
                                                     class="text-uppercase">��ȸ�ǽ��̸�(��ȣ)����</strong> ${data.roomName}(${data.roomNo})</a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">������ ���۽ð�����</strong> ${data.startDate}</a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">~ ���� ����ð�����</strong> ~ ${data.endDate}</a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">���������� ����</strong>
												<c:choose>
													<c:when test="${data.longTermYn=='Y'}"> 
														��⿹��
													</c:when>
													<c:when test="${data.longTermYn=='N'}"> 
														�ܱ⿹��
													</c:when>
												</c:choose>
											</a>
											 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
													 class="text-uppercase">��ȸ�Ǳ��С���</strong>${data.reservContent}</a>
											 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
													 class="text-uppercase">��ȸ�Ǹ�������</strong>${data.reservContent2}</a>

											 <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong
													 class="text-uppercase">ȸ������ �� ����</strong>
									                    <c:forEach var="list" items="${data.deptList}" varStatus="status" >
															<p style="padding : 0px 10px; vertical-align:middle;">��������������${list.deptNo}(${list.deptName})</p>
														</c:forEach>
						                     </a>
						                     <a class="list-group-item" ><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">��������ϡ���</strong>
						                			     <c:forEach var="list" items="${data.empList}" varStatus="status" >
															 <p style="padding : 0px 10px; vertical-align:middle;">
																 ����������${list.empNo}(${list.deptName})</p>
														</c:forEach>
						                     </a>
						                 </div>
						                 <div class="p-footer">
                                             <a href="/mypage.do?empNo=${data.empNo}" class="btn adv-color squre">Ȯ��</a>
						                 </div>
						             </div>
						             <!-- /.pricing -->
						         </div> 
						         <!-- /pricing professional --> 
                        	
                        	
	                        	<!-- ����, ������ ����Ʈ  -->
	                            <div>
	                                <div class="col-md-4">
	                                    <div class="pricing">
	                                        <div class="p-header">
	                                            <div class="title">
	                                                <h4>�߰� ����1</h4>
	                                            </div>
	                                            <div class="price">
	                                                <span class="dollar">�ٰ�</span>
	                                                <h2></h2>
	                                                <span class="per"></span>
	                                            </div>
	                                        </div>
	                                        <div class="list-group">
	                                        	<c:choose>
													<c:when test="${data.snackList ne null}"> 
										    			<c:forEach var="list" items="${data.snackList}" varStatus="status" >
									                        <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">${list.snackName}(${list.snackNo}) </strong>������${list.quantity}��</a>
														</c:forEach>  													
													</c:when>
													<c:when test="${data.snackList eq null}">  
														<a>�ٰ��� �������� �ʾҽ��ϴ�.</a>
													</c:when>
												</c:choose>

	                                        </div>
	                                    </div>
	                                    <!-- /.pricing -->
	                           		 </div>
	                           	</div>
	                            <!-- / ����, ������ ����Ʈ -->
	                            
	                                      	<!-- ����, ������ ����Ʈ  -->
	                            <div>
	                                <div class="col-md-4">
	                                    <div class="pricing">
	                                        <div class="p-header">
	                                            <div class="title">
	                                                <h4>�߰� ����2</h4>
	                                            </div>
	                                            <div class="price">
	                                                <span class="dollar">������</span>
	                                                <h2></h2>
	                                                <span class="per"></span>
	                                            </div>
	                                        </div>
	                                        <div class="list-group">
	                                        	<c:choose>
													<c:when test="${data.fixtureList ne null}"> 
										    			<c:forEach var="list" items="${data.fixtureList}" varStatus="status" >
									                        <a class="list-group-item"><i class="fa fa-check fa-fw"></i>&nbsp; <strong class="text-uppercase">${list.fixtureName}(${list.fixtureNo}) </strong>������${list.quantity}��</a>
														</c:forEach>  													
													</c:when>
													<c:when test="${data.snackList eq null}">  
														<a>�ٰ��� �������� �ʾҽ��ϴ�.</a>
													</c:when>
												</c:choose>

	                                        </div>
	                                    </div>
	                                    <!-- /.pricing -->
	                           		 </div>
	                           	</div>
	                            <!-- / ����, ������ ����Ʈ -->
	                            
                       	 </div>
                        </section>
                    </div>
                </div>
                <!-- /.site-comtent -->
            </div>

		
</div>
<script>
    $('#price').text(numberWithCommas($('#price').text()));

    //���� �޸�
    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
</script>