package com.gsitm.pay.vo;

import java.util.List;

import com.gsitm.reserv.vo.FixtureVO;
import com.gsitm.reserv.vo.SnackVO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @programName : ReservPayVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 07. 
 * @function    : 예약 정보를 갖는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-07	초안 작성
 * 허빛찬샘	2018-06-12	프로퍼티 이름 수정
 * 허빛찬샘	2018-06-14	price, reservEmpNo 프로퍼티 추가
 * 허빛찬샘	2018-06-16	email 프로퍼티 추가
 */ 
@Data
public class ReservPayVO {
	
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
	String fixtureUse;
    
	@Getter
	@Setter
	String snackUse;

	@Getter
	@Setter
	String reservContent;

	@Getter
	@Setter
	String totalTime;

	@Getter
	@Setter
	String resulveTime;

	@Getter
	@Setter
	String roomKind;
	
	@Getter
	@Setter
	int price;

	@Getter
	@Setter
	String reservEmpNo;
	
	@Getter
	@Setter
	String reservEmpName;
	
	@Getter
	@Setter
	String role;

	@Getter
	@Setter
	String longTermYn;

	@Getter
	@Setter
	int teamCount;

	@Getter
	@Setter
	int lastPrice;
	
	@Getter
	@Setter
	String email;
	
	@Getter
	@Setter
	List<PayDeptVO> deptList;

	@Getter
	@Setter
	List<PayEmpVO> empList;
	
	@Getter
	@Setter
	List<FixtureVO> fixtureList;
	
	@Getter
	@Setter
	List<SnackVO> snackList;
	
}
