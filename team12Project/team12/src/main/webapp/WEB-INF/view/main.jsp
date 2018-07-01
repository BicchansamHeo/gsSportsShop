<%--
subject    : main.jsp
author     : 강혜정
date       : 2018. 6. 07.
description : main 페이지
 
  [이름]   [수정일]     [내용]
  ----------------------------------------------------------
  강혜정		2018-06-07	초안 작성
  허빛찬샘	2018-06-13	웹 크롤링 추가
  강혜정		2018-06-15	디자인 수정
  이창주    2018-06-18     예약가능 회의실 보여주기 추가
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE>
<style>
    #supplementary {
        padding-bottom: 5px;
        top: 550px;
    }
</style>
<div class="section type5">
    <div class="tp-banner-container">
        <div class="tp-banner">
            <ul>
                <c:forEach var="text" items="${textList }">
                    <!-- SLIDE -->
                    <li data-transition="random" data-slotamount="7"
                        data-masterspeed="700" data-title="Responsive Design">
                        <!-- MAIN IMAGE --> <img src="/invent-v1.0/img/slider/gsitm_bg.jpg"
                                                 alt="slidebg1" data-bgfit="cover" data-bgposition="left top"
                                                 data-bgrepeat="no-repeat"> <!-- LAYERS --> <!-- LAYER NR. 1 -->
                        <div class="tp-caption sfr randomrotateout" data-x="695"
                             data-y="35" data-speed="500" data-start="2000" data-easing="Power4.easeOut">
                            <img src="${text.img }" alt="" data-ww="600" data-hh="400">
                        </div>
                        <div class="tp-caption emphatic_large_bold sfl randomrotateout"
                             data-x="170" data-y="175" data-speed="500" data-start="3500"
                             data-easing="Power4.easeOut">
                            <p style="width:500px; color:black;">${text.text }</p>
                        </div>
                        <a href="https://gsitm.com/news/${text.text }"
                           class="tp-caption btn adv-color squre thin sfb randomrotateout" data-x="170" data-y="290"
                           data-speed="500" data-start="4000" data-easing="Power3.easeInOut">More View &nbsp; &raquo;
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <div class="tp-bannertimer tp-bottom"></div>
        </div>
    </div>
</div>

<!-- 여기가 사용 가능한 회의실 목록 뿌려주기 -->
<div class="container" id="main_container">
    <section id="caroufredsel-portfolio" class="section type3">
        <div class="row cnbox">
            <div class="col-md-4">
                <div class="cbox">
                    <h3 class="cbox-title">예약가능한 회의실</h3>
                    <!-- 여기에 예약 가능 회의실 개수 표시-->
                    <span class="cbox-counter">${roomCnt}</span>
                </div>
            </div>
            <div class="col-md-8">
                <div class="nbox">
                    <p class="lead">회의실 단기 예약 시 승인없이 이용 가능합니다.<br>회의실 장기 이용 / 교육실 이용의 경우 승인이 필요합니다.</p>
                    <div class="controls">
					<span id="portfolio-prev" class="prev black"><i
                            class="fa fa-angle-left"></i></span> <span id="portfolio-next"
                                                                       class="next black"><i
                            class="fa fa-angle-right"></i></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="hide-overflow">
            <div class="row">
                <div id="caroufredsel-portfolio-container">
                    <c:choose>
					    <c:when test="${fn:length(roomList) == 0}">
							<div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
		                        <div class="portfolio-item type2">
		                            <div class="portfolio-thumb">
		                                <img src="/dist/img/gsitm.png" class="img-responsive"
		                                     alt="1st Portfolio Thumb" width="286" height="190">
		                                
		                                
		                            </div>
		                            <div class="portfolio-details">
		                                <h5 class="portfolio-title">
		                                    	현재 이용 가능 회의실이 없습니다.
		                                </h5>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
		                        <div class="portfolio-item type2">
		                            <div class="portfolio-thumb">
		                                <img src="/dist/img/gsitm.png" class="img-responsive"
		                                     alt="1st Portfolio Thumb" width="286" height="190">
		                                
		                            </div>
		                            <div class="portfolio-details">
		                                <h5 class="portfolio-title">
		                                    	현재 이용 가능 회의실이 없습니다.
		                                </h5>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
		                        <div class="portfolio-item type2">
		                            <div class="portfolio-thumb">
		                                <img src="/dist/img/gsitm.png" class="img-responsive"
		                                     alt="1st Portfolio Thumb" width="286" height="190">
		                                
		                            </div>
		                            <div class="portfolio-details">
		
		                                <h5 class="portfolio-title">
		                                    	현재 이용 가능 회의실이 없습니다.
		                                </h5>
		                            </div>
		                        </div>
		                    </div>
					    </c:when>
						<c:when test="${fn:length(roomList) == 1}">
							<c:forEach var="item" items="${roomList}" varStatus="status">
								<div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
			                        <div class="portfolio-item type2">
			                            <div class="portfolio-thumb">
			                                <img src="${item.mainImgPath}" class="img-responsive"
			                                      onERROR="this.src='/dist/img/gsitm.png'" width="286" height="190">
			                                <div class="image-overlay"></div>
			                                <a href="/detailRoom.do?roomNo=${item.roomNo }" class="portfolio-zoom"><i class="fa fa-plus"></i></a>
			                            </div>
			                            <div class="portfolio-details">
			
			                                <h5 class="portfolio-title">
			                                    <a href="">${item.roomName}</a>
			                                </h5>
			                            </div>
			                        </div>
			                    </div>
							</c:forEach>
		                    <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
		                        <div class="portfolio-item type2">
		                            <div class="portfolio-thumb">
		                                <img src="/dist/img/gsitm.png" class="img-responsive"
		                                     alt="1st Portfolio Thumb" width="286" height="190">
		                                
		                            </div>
		                            <div class="portfolio-details">
		
		                                <h5 class="portfolio-title">
		                                    <a href="">현재 이용 가능 회의실이 없습니다.</a>
		                                </h5>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
		                        <div class="portfolio-item type2">
		                            <div class="portfolio-thumb">
		                                <img src="/dist/img/gsitm.png" class="img-responsive"
		                                     alt="1st Portfolio Thumb" width="286" height="190">
		                                <div class="image-overlay"></div>
		                                
		                            </div>
		                            <div class="portfolio-details">
		
		                                <h5 class="portfolio-title">
		                                    <a href="">현재 이용 가능 회의실이 없습니다.</a>
		                                </h5>
		                            </div>
		                        </div>
		                    </div>
					    </c:when>
					    <c:when test="${fn:length(roomList) == 2}">
							<c:forEach var="item" items="${roomList}" varStatus="status">
								<div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
			                        <div class="portfolio-item type2">
			                            <div class="portfolio-thumb">
			                                <img src="${item.mainImgPath}" class="img-responsive"
			                                      onERROR="this.src='/dist/img/gsitm.png'">
			                                <div class="image-overlay"></div>
			                                <a href="/detailRoom.do?roomNo=${item.roomNo }"
			                                   class="portfolio-zoom"><i class="fa fa-plus"></i></a> 
			                            </div>
			                            <div class="portfolio-details">
			
			                                <h5 class="portfolio-title">
			                                    <a href="">${item.roomName}</a>
			                                </h5>
			                            </div>
			                        </div>
			                    </div>
							</c:forEach>
		                    
		                    <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
		                        <div class="portfolio-item type2">
		                            <div class="portfolio-thumb">
		                                <img src="/dist/img/gsitm.png" class="img-responsive"
		                                     alt="1st Portfolio Thumb" width="286" height="190">
		                                
		                            </div>
		                            <div class="portfolio-details">
		
		                                <h5 class="portfolio-title">
		                                    <a href="">현재 이용 가능 회의실이 없습니다.</a>
		                                </h5>
		                            </div>
		                        </div>
		                    </div>
					    </c:when>
					    <c:otherwise>
							<c:forEach var="item" items="${roomList}" varStatus="status">
								<div class="col-xs-12 col-sm-6 col-md-4 portfolio-item-wrapper artwork creative">
			                        <div class="portfolio-item type2">
			                            <div class="portfolio-thumb">
			                           
			                                <img src="${item.mainImgPath}" class="img-responsive"
			                                      onERROR="this.src='/dist/img/gsitm.png'" width="286" height="190">
			                                <div class="image-overlay"></div>
			                                <a href="/detailRoom.do?roomNo=${item.roomNo }" 
			                                   class="portfolio-zoom"><i class="fa fa-plus"></i></a> 
			                            </div>
			                            <div class="portfolio-details">
			
			                                <h5 class="portfolio-title">
			                                    <a href="">${item.roomName}</a>
			                                </h5>
			                            </div>
			                        </div>
			                    </div>
							</c:forEach>
					    </c:otherwise>
					</c:choose>
                    <!-- /.portfolio-item-wrapper -->
                </div>
                <!-- /.caroufredsel-portfolio-container -->
            </div>
            <!-- /.row -->
        </div>
    </section>
</div>