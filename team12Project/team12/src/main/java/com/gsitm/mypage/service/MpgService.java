package com.gsitm.mypage.service;

import com.gsitm.login.service.LoginService;
import com.gsitm.login.vo.UserVO;
import com.gsitm.mypage.dao.MpgDao;
import com.gsitm.mypage.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @programName : MpgService.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 12.
 * @function    : Mypage의 전반적인 Service
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-12	초안작성, userAjax() 메소드 추가
 * 허빛찬샘	2018-06-17	reservDetail(MpgReservVO vo), deptList(MpgReservVO vo), empList(MpgReservVO vo) 메소드 추가
 * 허빛찬샘	2018-06-17	fixtureList(MpgReservVO vo), snackList(MpgReservVO vo), reservDel(MpgReservVO vo) 메소드 추가
 */
@Service
public class MpgService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    @Resource(name = "mpgDao")
    private MpgDao mpgDao;

    /**
     * @methodName : userView
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 마이페이지 멤버 정보 보여주는 메소드
     */
    public UserVO userView(UserVO vo) throws UsernameNotFoundException {
        return mpgDao.userView(vo);
    }

    /**
     * @methodName : userList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 팀원 리스트
     */
    public List<UserVO> userList(UserVO vo) throws UsernameNotFoundException {
        return mpgDao.userList(vo);
    }

    /**
     * @methodName : reservList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 리스트
     */
    public List<MpgReservVO> reservList(UserVO vo) {
        return mpgDao.reservList(vo);
    }

    /**
     * @methodName : reservDetail
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 상세
     */
    public MpgReservVO reservDetail(MpgReservVO vo) {
        return mpgDao.reservDetail(vo);
    }

    /**
     * @methodName : deptList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 부서리스트
     */
    public List<MpgDeptVO> deptList(MpgReservVO vo) {
        return mpgDao.deptList(vo);
    }

    /**
     * @methodName : empList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 사원 리스트
     */
    public List<MpgEmpVO> empList(MpgReservVO vo) {
        return mpgDao.empList(vo);
    }

    /**
     * @methodName : guestList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 외부인 리스트
     */
    public List<MpgGuestVO> guestList(MpgReservVO vo) {
        return mpgDao.guestList(vo);
    }

    /**
     * @methodName : fixtureList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 기자제 리스트
     */
    public List<MpgFixtureVO> fixtureList(MpgReservVO vo) {
        return mpgDao.fixtureList(vo);
    }

    /**
     * @methodName : snackList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 간식 리스트
     */
    public List<MpgSnackVO> snackList(MpgReservVO vo) {
        return mpgDao.snackList(vo);
    }

    /**
     * @methodName : reservDel
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 취소
     */
    public int reservDel(MpgReservVO vo) {
        return mpgDao.reservDel(vo);
    }


}