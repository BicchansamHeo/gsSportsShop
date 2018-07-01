package com.gsitm.stat.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 허빛찬샘
 * @programName : StatMonthVO.java
 * @date : 2018-06-19
 * @function : 통계 데이터를 담을 VO
 * <p>
 * [이름]     [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘   2018-06-19   초안 작성
 */
@Data
public class StatMonthVO {
    @Getter
    @Setter
    private String month;
    
    @Getter
    @Setter
    private String roomNoMax;
    
    @Getter
    @Setter
    private int maxCnt;
    
    @Getter
    @Setter
    private String roomNoMin;
    
    @Getter
    @Setter
    private int minCnt;

    @Getter
    @Setter
    private String roomNameMax;
    
    @Getter
    @Setter
    private String roomNameMin;
}
