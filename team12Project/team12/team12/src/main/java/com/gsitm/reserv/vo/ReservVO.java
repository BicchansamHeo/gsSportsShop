package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * @author : 이창주
 * @programName : ReservVO.java
 * @date : 2018. 6. 08.
 * @function : 예약 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Alias("ReservVO")
@Data
public class ReservVO {

    @Getter
    @Setter
    String reservNo;

    @Getter
    @Setter
    String startDate;

    @Getter
    @Setter
    String endDate;

    @Getter
    @Setter
    String approval1;

    @Getter
    @Setter
    String approval21;

    @Getter
    @Setter
    String approval22;

    @Getter
    @Setter
    String roomNo;

    @Getter
    @Setter
    String fixtureUse;

    @Getter
    @Setter
    String snackUse;

    @Getter
    @Setter
    String reservContent;

    @Getter
    @Setter
    String longTermYn;

    @Getter
    @Setter
    Integer price;

    @Getter
    @Setter
    String reservEmpNo;

    @Getter
    @Setter
    String extend;

}
