package com.gsitm.pay.dao;

import com.gsitm.pay.mapper.PayMapper;
import com.gsitm.pay.vo.PayDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.PayRoomVO;
import com.gsitm.pay.vo.ReservPayVO;
import com.gsitm.reserv.vo.ReservVO;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @programName : PayDao.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 07.
 * @function    : 결제부분의 전반적인 내용을 담당하는 Dao
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-07	초안 작성, readList 메소드 추가
 * 허빛찬샘	2018-06-08	readReserv, readRoom, readDept, readEmp(ReservPayVO) 메소드 추가
 * 허빛찬샘	2018-06-14	pprovalMod(PayEmpVO vo) 메소드 추가
 */
@Repository(value = "payDao")
public class PayDao {
    private static final Logger logger = LoggerFactory.getLogger(PayDao.class);

    @Autowired
    protected SqlSession sqlSession;

    /**
     * @param EVO
     * @return
     * @methodName : readList
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 결재 내역 불러오기
     */
    public List<ReservPayVO> readList(PayEmpVO EVO) {
        List<ReservPayVO> list = new ArrayList<ReservPayVO>();
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            list = payMapper.readList(EVO);
            for (ReservPayVO vo : list) {
                String userName = payMapper.reservUserName(vo.getReservEmpNo());
                vo.setReservEmpName(userName);
            }//end for
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @param vo
     * @return
     * @methodName : readReserv
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 예약 내역 불러오기
     */
    public ReservPayVO readReserv(ReservVO vo) {
        ReservPayVO reserv = new ReservPayVO();
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            reserv = payMapper.readReserv(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return reserv;
    }

    /**
     * @param vo
     * @return
     * @methodName : readRoom
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 회의실 불러오기
     */
    public PayRoomVO readRoom(ReservPayVO vo) {
        PayRoomVO room = new PayRoomVO();
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            room = payMapper.readRoom(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return room;
    }

    /**
     * @param rpv
     * @return
     * @methodName : adminEmail
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 관리자 이메일 불러오기
     */
    public List<String> adminEmail(ReservPayVO rpv) {
        List<String> list = new ArrayList<>();
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            if (rpv.getRole().equals("ROLE_DM") && rpv.getLongTermYn().equals("Y")
                    && rpv.getRoomKind().equals("education")) {
                list = payMapper.adminEmail(rpv);
            } else if (rpv.getRole().equals("ROLE_DM") && rpv.getLongTermYn().equals("N")
                    && rpv.getRoomKind().equals("education")) {
                list = payMapper.adminEmailEM(rpv);
            } else if (rpv.getRole().equals("ROLE_DM") && rpv.getLongTermYn().equals("Y")
                    && rpv.getRoomKind().equals("conference")) {
                list = payMapper.adminEmailAM(rpv);

            }
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @param vo
     * @return
     * @methodName : readDept
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 부서 가져오기
     */
    public List<PayDeptVO> readDept(ReservPayVO vo) {
        List<PayDeptVO> list = new ArrayList<PayDeptVO>();
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            list = payMapper.readDept(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @param vo
     * @return
     * @methodName : readEmp
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 사원 가져오기
     */
    public List<PayEmpVO> readEmp(ReservPayVO vo) {
        List<PayEmpVO> list = new ArrayList<PayEmpVO>();
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            list = payMapper.readEmp(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @param vo
     * @return
     * @methodName : readEmpReturn
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 사원 리턴
     */
    public PayEmpVO readEmpReturn(ReservPayVO vo) {
        PayEmpVO vo2 = new PayEmpVO();
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            vo2 = payMapper.readEmpReturn(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return vo2;
    }

    /**
     * @param rpv
     * @return
     * @methodName : approvalMod
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 승인 수정
     */
    public int approvalMod(ReservPayVO rpv) {
        int result = 0;
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            if (rpv.getRole().equals("ROLE_DM") || rpv.getRole().equals("ROLE_AM")) {
                result = payMapper.approvalModAM(rpv);
            } else if (rpv.getRole().equals("ROLE_EM")) {
                result = payMapper.approvalModEM(rpv);
            }
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return result;
    }

    /**
     * @param rpv
     * @return
     * @methodName : returnMod
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 승인 반환
     */
    public int returnMod(ReservPayVO rpv) {
        int result = 0;
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            if (rpv.getRole().equals("ROLE_DM")) {
                result = payMapper.returnModDM(rpv);
            } else if (rpv.getRole().equals("ROLE_EM") || rpv.getRole().equals("ROLE_AM")) {
                result = payMapper.returnMod(rpv);
            }
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return result;
    }

    /**
     * @param rpv
     * @return
     * @methodName : applyMailList
     * @author : 허빛찬샘
     * @date : 2018. 6. 08.
     * @function : 승인 메일 리스트
     */
    public ReservPayVO applyMailList(ReservPayVO rpv) {
        try {
            PayMapper payMapper = sqlSession.getMapper(PayMapper.class);
            rpv.setDeptList(payMapper.readDept(rpv));
            //System.out.println(rpv.getDeptList());
            rpv.setEmpList(payMapper.readEmp(rpv));
            //System.out.println(rpv.getEmpList());
            rpv.setFixtureList(payMapper.readFixture(rpv));
            //System.out.println(rpv.getFixtureList());
            rpv.setSnackList(payMapper.readSnack(rpv));
            //System.out.println(rpv.getSnackList());
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return rpv;
    }

}
