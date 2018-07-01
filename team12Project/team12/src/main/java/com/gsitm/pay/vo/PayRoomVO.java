package com.gsitm.pay.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @programName : PayRoomVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 08. 
 * @function    : 회의실 정보를 갖는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘 2018-06-08	초안 작성
 */ 
@Data
public class PayRoomVO {
	
	@Getter
	@Setter
	String roomNo;
	
	@Getter
	@Setter
	String wpNo;
	
	@Getter
	@Setter
	String roomName;
	
	@Getter
	@Setter
	String roomComm;
	
	@Getter
	@Setter
	String roomKind;
	
	@Getter
	@Setter
	Integer roomPrice;
	
	@Getter
	@Setter
	String roomSize;
	
	@Getter
	@Setter
	Integer maxPeople;
	
	@Getter
	@Setter
	String nwUse;
	
	@Getter
	@Setter
	String roomStat;
}
