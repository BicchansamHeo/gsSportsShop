package com.gsitm.pay.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @programName : PayEmpVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 08. 
 * @function    : 사원 정보를 갖는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-08	초안 작성
 * 허빛찬샘	2018-06-14	role 프로퍼티 추가
 */ 
@Data
public class PayEmpVO {
	
	@Getter
	@Setter
	String empNo;
	
	@Getter
	@Setter
	String empName;
	
	@Getter
	@Setter
	String phone;
	
	@Getter
	@Setter
	String email;

	@Getter
	@Setter
	String role;
}
