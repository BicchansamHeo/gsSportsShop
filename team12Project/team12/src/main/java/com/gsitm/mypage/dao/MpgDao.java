package com.gsitm.mypage.dao;

import com.gsitm.login.vo.UserVO;
import com.gsitm.mypage.mapper.MpgMapper;
import com.gsitm.mypage.vo.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * @author : 허빛찬샘
 * @programName : MpgDao.java
 * @date : 2018. 6. 12.
 * @function : MpgDao
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-12	초안 작성, List<UserVO> userList(UserVO vo), reservList 메소드 추가
 * 허빛찬샘	2018-06-17	reservDetail(MpgReservVO vo), deptList(MpgReservVO vo) 메소드 추가
 * 허빛찬샘	2018-06-17	fixtureList(MpgReservVO vo), snackList(MpgReservVO vo), reservDel(MpgReservVO vo) 메소드 추가
 */
@Repository(value = "mpgDao")
public class MpgDao {
    private static final Logger logger = LoggerFactory.getLogger(MpgDao.class);

    @Autowired
    protected SqlSession sqlSession;

    /**
     * @methodName : userView
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 마이페이지 멤버 정보 보여주는 메소드
     */
    public UserVO userView(UserVO vo) {
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            vo = mpgMapper.userView(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return vo;
    }

    /**
     * @methodName : userList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 팀원 리스트
     */
    public List<UserVO> userList(UserVO vo) {
        List<UserVO> list = new ArrayList<>();
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            list = mpgMapper.userList(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName : reservList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 리스트
     */
    public List<MpgReservVO> reservList(UserVO vo) {
        List<MpgReservVO> list = new ArrayList<>();
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            list = mpgMapper.reservList(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName : reservDetail
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 상세
     */
    public MpgReservVO reservDetail(MpgReservVO vo) {
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            vo = mpgMapper.reservDetail(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return vo;
    }

    /**
     * @methodName : deptList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 부서리스트
     */
    public List<MpgDeptVO> deptList(MpgReservVO vo) {
        List<MpgDeptVO> deptList = new ArrayList<>();
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            deptList = mpgMapper.deptList(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return deptList;
    }

    /**
     * @methodName : empList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 사원 리스트
     */
    public List<MpgEmpVO> empList(MpgReservVO vo) {
        List<MpgEmpVO> empList = new ArrayList<>();
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            empList = mpgMapper.empList(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return empList;
    }

    /**
     * @methodName : guestList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 외부인 리스트
     */
    public List<MpgGuestVO> guestList(MpgReservVO vo) {
        List<MpgGuestVO> guestList = new ArrayList<>();
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            guestList = mpgMapper.guestList(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return guestList;
    }

    /**
     * @methodName : fixtureList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 기자제 리스트
     */
    public List<MpgFixtureVO> fixtureList(MpgReservVO vo) {
        List<MpgFixtureVO> fixtureList = new ArrayList<>();
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            fixtureList = mpgMapper.fixtureList(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return fixtureList;
    }

    /**
     * @methodName : snackList
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 간식 리스트
     */
    public List<MpgSnackVO> snackList(MpgReservVO vo) {
        List<MpgSnackVO> snackList = new ArrayList<>();
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            snackList = mpgMapper.snackList(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return snackList;
    }

    /**
     * @methodName : reservDel
     * @author : 허빛찬샘
     * @date : 2018. 6. 17.
     * @function : 예약 취소
     */
    public int reservDel(MpgReservVO vo) {
        int result = 0;
        try {
            MpgMapper mpgMapper = sqlSession.getMapper(MpgMapper.class);
            result = mpgMapper.reservDel(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return result;
    }

}
