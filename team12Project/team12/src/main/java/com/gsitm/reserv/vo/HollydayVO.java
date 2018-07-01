package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author : 이창주
 * @programName : HollydayVO.java
 * @date : 2018. 6. 08.
 * @function : 공휴일 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Alias("HollydayVO")
@Data
public class HollydayVO {
    @Getter
    @Setter
    String holidayName;

    @Getter
    @Setter
    Date holidayDate;
}
