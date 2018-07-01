package com.gsitm.mypage.mapper;

import com.gsitm.login.vo.UserVO;
import com.gsitm.mypage.vo.*;

import java.util.List;

/**
 * @programName : MpgMapper.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 12.
 * @function    : MpgMapper java 파일
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-12	초안 작성, userView(UserVO vo), userList(UserVO vo), ReservList(UserVO vo) 인터페이스 추가
 * 허빛찬샘	2018-06-17	reservDetail(MpgReservVO vo), deptList(MpgReservVO vo), empList(MpgReservVO vo) 인터페이스 추가
 * 허빛찬샘	2018-06-17	fixtureList(MpgReservVO vo), snackList(MpgReservVO vo), guestList(MpgReservVO vo), reservDel(MpgReservVO vo) 인터페이스 추가
 */
public interface MpgMapper {

    /**
     * @methodName : userView
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 마이페이지 멤버 정보 보여주는 메소드
     */
    UserVO userView(UserVO vo);

    /**
     * @methodName : userList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 팀원 리스트
     */
    List<UserVO> userList(UserVO vo);

    /**
     * @methodName : reservList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 리스트
     */
    List<MpgReservVO> reservList(UserVO vo);

    /**
     * @methodName : reservDetail
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 상세
     */
    MpgReservVO reservDetail(MpgReservVO vo);

    /**
     * @methodName : deptList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 부서리스트
     */
    List<MpgDeptVO> deptList(MpgReservVO vo);

    /**
     * @methodName : empList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 사원 리스트
     */
    List<MpgEmpVO> empList(MpgReservVO vo);

    /**
     * @methodName : guestList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 외부인 리스트
     */
    List<MpgGuestVO> guestList(MpgReservVO vo);

    /**
     * @methodName : fixtureList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 기자제 리스트
     */
    List<MpgFixtureVO> fixtureList(MpgReservVO vo);

    /**
     * @methodName : snackList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 간식 리스트
     */
    List<MpgSnackVO> snackList(MpgReservVO vo);

    /**
     * @methodName : reservDel
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 취소
     */
    int reservDel(MpgReservVO vo);
}
