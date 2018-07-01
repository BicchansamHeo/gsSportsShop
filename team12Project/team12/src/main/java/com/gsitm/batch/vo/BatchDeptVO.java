package com.gsitm.batch.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @programName : BatchDeptVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 14. 
 * @function    : DEPT 정보를 갖는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-14	초안 작성
 */ 
@Data
public class BatchDeptVO {
	@Getter
	@Setter
	String deptNo;
	
	@Getter
	@Setter
	String reservNo;

	@Getter
	@Setter
	Integer price;
	
	
}
