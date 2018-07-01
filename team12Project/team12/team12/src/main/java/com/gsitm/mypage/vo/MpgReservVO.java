package com.gsitm.mypage.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * @programName : MpgReservVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 09. 
 * @function    : 마이페이지 예약관련 데이터를 담당하는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-09	초안작성
 * 허빛찬샘	2018-06-17	프로퍼티 추가
 * 허빛찬샘	2018-06-19	프로퍼티 추가
 */ 
@Alias("MpgReservVO")
@Data
public class MpgReservVO {
	
	@Getter
	@Setter
	String reservNo;
	
	@Getter
	@Setter
	String startDate;
	
	@Getter
	@Setter
	String endDate;
	
	@Getter
	@Setter
	String startTime;
	
	@Getter
	@Setter
	String startHour;
	
	@Getter
	@Setter
	String startMi;
	
	@Getter
	@Setter
	String endTime;
	
	@Getter
	@Setter
	String approval1;

	@Getter
	@Setter
	String approval21;
	
	@Getter
	@Setter
	String approval22;
	
	@Getter
	@Setter
	String roomNo;
	
	@Getter
	@Setter
	String roomKind;
	
	@Getter
	@Setter
	String fixtureUse;
    
	@Getter
	@Setter
	String snackUse;

	@Getter
	@Setter
	String reservContent;
	
	
	@Getter
	@Setter
	String reservContent2;
	
	@Getter
	@Setter
	String longTermYn;
	
	@Getter
	@Setter
	String totalTime;
	
	@Getter
	@Setter
	int price;

}
