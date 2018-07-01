package com.gsitm.reserv.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 이창주
 * @programName : RoomVO.java
 * @date : 2018. 6. 08.
 * @function : 회의실 정보를 갖는 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주	  2018-06-08	초안 작성
 */
@Data
public class RoomVO {
    @Getter
    @Setter
    String roomNo;
    @Getter
    @Setter
    String wpNo;
    @Getter
    @Setter
    String roomName;
    @Getter
    @Setter
    String roomComm;
    @Getter
    @Setter
    String roomKind;
    @Getter
    @Setter
    int roomPrice;
    @Getter
    @Setter
    String roomSize;
    @Getter
    @Setter
    int maxPeople;
    @Getter
    @Setter
    String nwUse;
    @Getter
    @Setter
    String roomStat;
    @Getter
    @Setter
    String roomAddr;
    @Getter
    @Setter
    String latitude;
    @Getter
    @Setter
    String longitude;
    
    @Getter
    @Setter
    String mainImgPath;
}
