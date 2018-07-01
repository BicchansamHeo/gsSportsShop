package com.gsitm.mypage.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 허빛찬샘
 * @programName : MpgGuestVO.java
 * @date : 2018. 6. 12.
 * @function : MpgGuestVO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-12	초안 작성
 */
@Alias("MpgGuestVO")
@Data
public class MpgGuestVO {

    @Getter
    @Setter
    String reservNo;

    @Getter
    @Setter
    String name;


}
