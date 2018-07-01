package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author : 이창주
 * @programName : ReservDataVO.java
 * @date : 2018. 6. 08.
 * @function : 저장용 예약 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Data
public class ReservDataVO {
    @Getter
    @Setter
    String reservNo;
    @Getter
    @Setter
    String roomNo;
    @Getter
    @Setter
    String roomName;
    @Getter
    @Setter
    List<SnackVO> snackList;
    @Getter
    @Setter
    List<FixtureVO> fixtureList;
    @Getter
    @Setter
    List<EmpVO> empList;
    @Getter
    @Setter
    List<DeptVO> deptList;
    @Getter
    @Setter
    List<OutVO> outList;
    
    @Getter
    @Setter
    Date startDate;
    @Getter
    @Setter
    Date endDate;
    @Getter
    @Setter
    String longTermYn;
    @Getter
    @Setter
    String reservContent;
    @Getter
    @Setter
    String reservContent2;
    @Getter
    @Setter
    int price;
    
    @Getter
    @Setter
    String empNo;
    
    @Getter
    @Setter
    String approval1;
    
    @Getter
    @Setter
    String approval21;
    
    @Getter
    @Setter
    String approval22;
}
