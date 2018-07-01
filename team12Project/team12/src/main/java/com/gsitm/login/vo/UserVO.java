package com.gsitm.login.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @programName : UserVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 11. 
 * @function    : TB_EMP 테이블을 관리하는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-11	초안 작성
 * 허빛찬샘	2018-06-12	프로퍼티 추가
 */ 
@Data
public class UserVO {
	
	@Getter
	@Setter
	private String empNo;
	
	@Getter
	@Setter
	private String empName;

	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private String managerNo;
	
	@Getter
	@Setter
	private String phone;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String birthday;
	
	@Getter
	@Setter
	private String deptNo;
	
	@Getter
	@Setter
	private String roles;

	@Getter
	@Setter
	private String deptName;

	@Getter
	@Setter
	private String deptBudget;
}
