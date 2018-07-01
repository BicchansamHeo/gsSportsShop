package com.gsitm.mypage.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 허빛찬샘
 * @programName : MpgDeptVO.java
 * @date : 2018. 6. 12.
 * @function : MpgDeptVO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-12	초안 작성
 */
@Alias("MpgDeptVO")
@Data
public class MpgDeptVO {

    @Getter
    @Setter
    String deptNo;

    @Getter
    @Setter
    String deptName;


}
