package com.gsitm.mypage.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 허빛찬샘
 * @programName : MpgFixtureVO.java
 * @date : 2018. 6. 12.
 * @function : MpgFixtureVO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-12	초안 작성
 */
@Alias("MpgFixtureVO")
@Data
public class MpgFixtureVO {

    @Getter
    @Setter
    String fixtureName;

    @Getter
    @Setter
    String fixtureNo;

    @Getter
    @Setter
    int quantity;

    @Getter
    @Setter
    int reservQuantity;

    @Getter
    @Setter
    int maxQuantity;

}
