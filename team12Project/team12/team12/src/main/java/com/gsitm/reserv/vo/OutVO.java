package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 이창주
 * @programName : OutVO.java
 * @date : 2018. 6. 08.
 * @function : 외부인 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Data
public class OutVO {
	@Getter
	@Setter
	String reservNo;
	
	@Getter
	@Setter
	String name;
}
