package com.gsitm.reserv.dao;

import com.gsitm.reserv.mapper.ReservMapper;
import com.gsitm.reserv.vo.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 이창주
 * @programName : ReservDao.java
 * @date : 2018-06-08
 * @function : 예약 DAO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-08   초안 작성
 * 이창주   2018-06-09   예약에 필요한 정보 불러오기
 * 이창주   2018-06-10   예약에 필요한 정보 불러오기
 * 이창주   2018-06-11   예약에 필요한 정보 불러오기
 * 이창주   2018-06-12   예약 정보 저장
 * 이창주   2018-06-13   예약 정보 저장
 * 이창주   2018-06-14   예약 완료 메일 전송
 * 이창주   2018-06-15   예약 기능 1차 완료
 * 이창주   2018-06-20   예약 기능 완료
 */
@Repository(value = "reservDao")
public class ReservDao {
    private static final Logger logger = LoggerFactory.getLogger(ReservDao.class);

    @Autowired
    protected SqlSession sqlSession;

    /**
     * @methodName :  readList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 정보 받아오기
     * ${tags}
     */
    public List<ReservVO> readList() {
        List<ReservVO> list = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readResrvList();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName :  insertReserv
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 정보 저장
     * ${tags}
     */
    public void insertReserv(ReservDataVO rvVO) {
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            reservMapper.insertReserv(rvVO);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
    }

    /**
     * @methodName :  insertOut
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  외부인 리스트 저장
     * ${tags}
     */
    public void insertOut(OutVO out) {
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            reservMapper.insertOut(out);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
    }

    /**
     * @methodName :  insertRsvEmp
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의 참여 사원 리스트 저장
     * ${tags}
     */
    public void insertRsvEmp(String empNo, String reservNo) {
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("empNo", empNo);
            params.put("reservNo", reservNo);

            reservMapper.insertRsvEmp(params);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
    }

    /**
     * @methodName :  insertRsvTeam
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의 참여 부서 리스트 저장
     * ${tags}
     */
    public void insertRsvTeam(String deptNo, String reservNo) {
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("deptNo", deptNo);
            params.put("reservNo", reservNo);
            reservMapper.insertRsvTeam(params);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
    }

    /**
     * @methodName :  insertRsvFixture
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의 참여 기자제 리스트 저장
     * ${tags}
     */
    public void insertRsvFixture(String reservNo, String fixtureNo, int quantity) {
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("reservNo", reservNo);
            params.put("fixtureNo", fixtureNo);
            params.put("quantity", quantity);

            reservMapper.insertRsvFixture(params);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
    }

    /**
     * @methodName :  insertRsvSnack
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의 참여 간식 리스트 저장
     * ${tags}
     */
    public void insertRsvSnack(String reservNo, String snackNo, int quantity) {
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("reservNo", reservNo);
            params.put("snackNo", snackNo);
            params.put("quantity", quantity);
            reservMapper.insertRsvSnack(params);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
    }

    /**
     * @methodName :  readHollyList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  공휴일 불러오기
     * ${tags}
     */
    public List<HollydayVO> readHollyList() {
        List<HollydayVO> list = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readHollyList();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName :  readLongList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  장기예약 불러오기
     * ${tags}
     */
    public List<ReservVO> readLongList(String roomNo) {
        List<ReservVO> list = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readLongList(roomNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName :  readResrved
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  선택 날짜 예약 불러오기
     * ${tags}
     */
    public List<ReservVO> readResrved(String selectDate, String roomNo) {
        List<ReservVO> list = null;
        try {
        	Map<String, Object> params = new HashMap<>();
        	params.put("selectDate", selectDate);
        	params.put("roomNo", roomNo);
        	
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readResrved(params);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName :  readDeptList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  부서 리스트 불러오기
     * ${tags}
     */
    public List<DeptVO> readDeptList() {
        List<DeptVO> list = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readDeptList();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }


    /**
     * @methodName :  readTeamEmp
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  부서 사원 리스트 불러오기
     * ${tags}
     */
    public List<EmpVO> readTeamEmp(String deptNo) {
        List<EmpVO> list = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readTeamEmp(deptNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName :  readFixture
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  기자제 리스트 불러오기
     * ${tags}
     */
    public List<FixtureVO> readFixture(String roomNo) {
        List<FixtureVO> list = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readFixture(roomNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName :  readWP
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  건물 번호 불러오기
     * ${tags}
     */
    public String readWP(String roomNo) {
        String wpNo = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            wpNo = reservMapper.readWP(roomNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return wpNo;
    }

    /**
     * @methodName :  readSnack
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  건물 간식 불러오기
     * ${tags}
     */
    public List<SnackVO> readSnack(String wpNo) {
        List<SnackVO> list = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            list = reservMapper.readSnack(wpNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName :  getReservNo
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 번호 불러오기
     * ${tags}
     */
    public String getReservNo() {
        String reserNo = "";
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            reserNo = "RV_" + reservMapper.getReservNo();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return reserNo;
    }

    /**
     * @methodName :  getRoomPrice
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 가격 불러오기
     * ${tags}
     */
    public int getRoomPrice(String roomNo) {
        int price = 0;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            price = reservMapper.getRoomPrice(roomNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return price;
    }

    /**
     * @methodName :  getFixturePrice
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  기자제 가격 불러오기
     * ${tags}
     */
    public int getFixturePrice(String fixtureNo) {
        int price = 0;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            price = reservMapper.getFixturePrice(fixtureNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return price;
    }

    /**
     * @methodName :  getSnackPrice
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  간식 가격 불러오기
     * ${tags}
     */
    public int getSnackPrice(String snackNo) {
        int price = 0;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            price = reservMapper.getSnackPrice(snackNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return price;
    }

    /**
     * @methodName :  getLongCheck
     * @author :  이창주
     * @date :  2018-06-15
     * @function :  장기 예약 체크
     * ${tags}
     */
    public int getLongCheck(ReservDataVO rvVO) {
        int cnt = 0;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            cnt = reservMapper.getLongCheck(rvVO);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return cnt;
    }

    /**
     * @methodName :  getHoliCnt
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  공휴일 수 체크
     * ${tags}
     */
    public int getHoliCnt(ReservDataVO rvVO) {
        int cnt = 0;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            cnt = reservMapper.getHoliCnt(rvVO);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return cnt;
    }

    /**
     * @methodName :  minusSnack
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  간식 빼기
     * ${tags}
     */
    public void minusSnack(String roomNo, String snackNo, int quantity) {
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("roomNo", roomNo);
            params.put("snackNo", snackNo);
            params.put("quantity", quantity);
            reservMapper.minusSnack(params);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
    }

    /**
     * @methodName :  getManagerEmail
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  팀장 이메일 가져오기
     * ${tags}
     */
    public String getManagerEmail(String empNo) {
        String email = "";
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            email = reservMapper.getManagerEmail(empNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return email;
    }

    /**
     * @methodName :  getEmail
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  이메일 가져오기
     * ${tags}
     */
    public String getEmail(String empNo) {
        String email = "";
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            email = reservMapper.getEmail(empNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return email;
    }

    /**
     * @methodName :  getDept
     * @author :  이창주
     * @date :  2018-06-15
     * @function :  부서 가져오기
     * ${tags}
     */
    public String getDept(String empNo) {
        String deptNo = "";
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            deptNo = reservMapper.getDept(empNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return deptNo;
    }


    /**
     * @methodName :  getMaxPeople
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의실 최대 인원 가져오기
     * ${tags}
     */
    public int getMaxPeople(String roomNo) {
        int maxPeople = 0;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            maxPeople = reservMapper.getMaxPeople(roomNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return maxPeople;
    }

    /**
     * @methodName :  readSnackList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  간식 리스트 가져오기
     * ${tags}
     */
    public List<SnackVO> readSnackList() {
        List<SnackVO> resultList = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            resultList = reservMapper.readSnackList();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return resultList;
    }

    /**
     * @methodName :  readFixtureList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  기자제 리스트 가져오기
     * ${tags}
     */
    public List<FixtureVO> readFixtureList() {
        List<FixtureVO> resultList = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            resultList = reservMapper.readFixtureList();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return resultList;
    }

    /**
     * @methodName :  getPosRoom
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  현재 예약 가능 리스트 가져오기
     * ${tags}
     */
    public List<RoomVO> getPosRoom() {
        List<RoomVO> resultList = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            resultList = reservMapper.getPosRoom();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return resultList;
    }

    /**
     * @methodName :  getCurReserv
     * @author :  이창주
     * @date :  2018-06-20
     * @function :  현재 예약 가져오기
     * ${tags}
     */
    public List<ReservVO> getCurReserv(String empNo) {
        List<ReservVO> resultList = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            resultList = reservMapper.getCurReserv(empNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return resultList;
    }

    /**
     * @methodName :  extendReserv
     * @author     :  이창주
     * @date       :  2018-06-20
     * @function   :  예약 연장
     * ${tags}
     */
    public int extendReserv(String reservNo) {
        int result = 0;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            result = reservMapper.extendReserv(reservNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return result;
    }

    /**
     * @methodName :  getRoomName
     * @author     :  이창주
     * @date       :  2018-06-20
     * @function   :  회의실 이름 가져오기
     * ${tags}
     */
    public String getRoomName(String roomNo) {
        String roomName = "";
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            roomName = reservMapper.getRoomName(roomNo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return roomName;
    }

    /**
     * @methodName :  searchEmp
     * @author     :  이창주
     * @date       :  2018-06-20
     * @function   :  사원 검색
     * ${tags}
     */
    public List<EmpVO> searchEmp(String empName) {
        List<EmpVO> resultList = null;
        try {
            ReservMapper reservMapper = sqlSession.getMapper(ReservMapper.class);
            resultList = reservMapper.searchEmp(empName);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return resultList;
    }
}
