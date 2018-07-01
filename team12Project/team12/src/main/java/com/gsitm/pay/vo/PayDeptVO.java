package com.gsitm.pay.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @programName : PayDeptVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 08. 
 * @function    : 부서 정보를 갖는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-08	초안 작성
 */ 
@Data
public class PayDeptVO {
	
	@Getter
	@Setter
	String deptNo;
	
	@Getter
	@Setter
	String deptName;
	
	@Getter
	@Setter
	Integer deptBudget;
	
	@Getter
	@Setter
	String managerNo;
}
