package com.gsitm.mypage.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 허빛찬샘
 * @programName : MpgSnackVO.java
 * @date : 2018. 6. 12.
 * @function : MpgSnackVO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-12	초안 작성
 */
@Alias("MpgSnackVO")
@Data
public class MpgSnackVO {

    @Getter
    @Setter
    String wpNo;

    @Getter
    @Setter
    String snackNo;

    @Getter
    @Setter
    String snackName;

    @Getter
    @Setter
    int reservQuantity;

    @Getter
    @Setter
    int maxQuantity;

    @Getter
    @Setter
    int price;

}
