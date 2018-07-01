package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 이창주
 * @programName : FixtureVO.java
 * @date : 2018. 6. 08.
 * @function : 기자제 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Data
public class FixtureVO {
    @Getter
    @Setter
    String fixtureNo;

    @Getter
    @Setter
    String fixtureName;

    @Getter
    @Setter
    String roomNo;

    @Getter
    @Setter
    int quantity;
    
    @Getter
    @Setter
    int price;
}
