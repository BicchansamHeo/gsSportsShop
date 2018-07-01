package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author : 이창주
 * @programName : EmpVO.java
 * @date : 2018. 6. 08.
 * @function : 사원 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Data
public class EmpVO {
    @Getter
    @Setter
    String empNo;
    @Getter
    @Setter
    String empName;
    @Getter
    @Setter
    String managerNo;
    @Getter
    @Setter
    String phone;
    @Getter
    @Setter
    String email;
    @Getter
    @Setter
    Date birthday;
    @Getter
    @Setter
    String deptNo;

    @Getter
    @Setter
    String deptName;

    @Getter
    @Setter
    String roles;

}
