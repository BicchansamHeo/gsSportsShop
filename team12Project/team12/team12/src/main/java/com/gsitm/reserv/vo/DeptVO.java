package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 이창주
 * @programName : DeptVO.java
 * @date : 2018. 6. 08.
 * @function : 부서 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Data
public class DeptVO {
    @Getter
    @Setter
    String deptNo;

    @Getter
    @Setter
    String deptName;

    @Getter
    @Setter
    int deptBudget;

    @Getter
    @Setter
    String managerNo;
}
