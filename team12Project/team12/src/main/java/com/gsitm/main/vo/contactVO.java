package com.gsitm.main.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @programName : contactVO.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 19. 
 * @function    : Contact에서의 정보를 갖는 VO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-19	초안 작성
 */ 
@Data
public class contactVO {
	@Getter
	@Setter
	String userName;
	
	@Getter
	@Setter
	String email;

	@Getter
	@Setter
	String title;
	
	@Getter
	@Setter
	String content;
	
}
