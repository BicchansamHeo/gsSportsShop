package com.gsitm.stat.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 허빛찬샘
 * @programName : StatBestVO.java
 * @date : 2018-06-19
 * @function : 통계 데이터를 담을 VO
 * <p>
 * [이름]     [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘   2018-06-19   초안 작성
 */
@Data
public class StatBestVO {
    @Getter
    @Setter
    private String roomNo;
    
    @Getter
    @Setter
    private int cnt;
    
    @Getter
    @Setter
    private String roomName;
}
