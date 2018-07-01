package com.gsitm.reserv.service;

import com.gsitm.reserv.dao.ReservDao;
import com.gsitm.reserv.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 이창주
 * @programName : ReservService.java
 * @date : 2018-06-08
 * @function : 예약 서비스
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
 * 이창주   2018-06-15   예약 기능 완료
 */
@Service
public class ReservService {

    private static final Logger logger = LoggerFactory.getLogger(ReservService.class);

    @Resource(name = "reservDao")
    private ReservDao reservDao;

    /**
     * @methodName :  readList
     * @author :  이창주
     * @date :  2018-06-15
     * @function :  공휴일 불러오기
     * ${tags}
     */
    public List<HollydayVO> readList() {

        List<HollydayVO> resultList = reservDao.readHollyList();
        return resultList;
    }

    /**
     * @methodName :  readLongList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  장기 예약 불러오기
     * ${tags}
     */
    public List<ReservVO> readLongList(String roomNo) {

        List<ReservVO> resultList = reservDao.readLongList(roomNo);
        return resultList;
    }

    /**
     * @methodName :  readResrved
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 시간 불러오기
     * ${tags}
     */
    public List<ReservVO> readResrved(String selectDate, String roomNo) {
        List<ReservVO> resultList = reservDao.readResrved(selectDate, roomNo);
        return resultList;
    }

    /**
     * @methodName :  readDeptList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  부서 불러오기
     * ${tags}
     */
    public List<DeptVO> readDeptList() {
        List<DeptVO> resultList = reservDao.readDeptList();
        return resultList;
    }

    /**
     * @methodName :  readTeamEmp
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  부서 팀원 불러오기
     * ${tags}
     */
    public List<EmpVO> readTeamEmp(List<String> teamList) {
        List<EmpVO> resultList = new ArrayList<EmpVO>();
        if (teamList != null) {
            for (String deptNo : teamList) {
                if (reservDao.readTeamEmp(deptNo) != null) {
                    resultList.addAll(reservDao.readTeamEmp(deptNo));
                }

            }
        }


        return resultList;
    }

    /**
     * @methodName :  readFixture
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  기자제 불러오기
     * ${tags}
     */
    public List<FixtureVO> readFixture(String roomNo) {
        List<FixtureVO> resultList = reservDao.readFixture(roomNo);
        return resultList;
    }

    /**
     * @methodName :  readSnack
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  간식 불러오기
     * ${tags}
     */
    public List<SnackVO> readSnack(String roomNo) {

        String wpNo = reservDao.readWP(roomNo);
        List<SnackVO> resultList = reservDao.readSnack(wpNo);

        return resultList;
    }

    /**
     * @methodName :  saveReserv
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 저장
     * ${tags}
     */
    public void saveReserv(ReservDataVO data) {
        String reservNo = reservDao.getReservNo();
        data.setReservNo(reservNo);

        logger.info(data.toString());

        //예약 테이블 저장
        reservDao.insertReserv(data);

        //팀목록 저장
        for (DeptVO depts : data.getDeptList()) {
            reservDao.insertRsvTeam(depts.getDeptNo(), reservNo);
        }

        //사원 목록 저장
        for (EmpVO emps : data.getEmpList()) {
            reservDao.insertRsvEmp(emps.getEmpNo(), reservNo);
        }


        //기자제 사용 내역 저장
        for (FixtureVO fixtures : data.getFixtureList()) {
            reservDao.insertRsvFixture(reservNo, fixtures.getFixtureNo(), fixtures.getQuantity());
            //reservDao.minusFixture(data.getRoomNo(), fixtures.getFixtureNo(), fixtures.getQuantity());
        }
        //간식 사용 내역 저장
        for (SnackVO snacks : data.getSnackList()) {
            reservDao.insertRsvSnack(reservNo, snacks.getSnackNo(), snacks.getQuantity());
            reservDao.minusSnack(data.getRoomNo(), snacks.getSnackNo(), snacks.getQuantity());
        }

        //외부인
        for (OutVO out : data.getOutList()) {
            out.setReservNo(reservNo);
            reservDao.insertOut(out);

        }


    }

    /**
     * @methodName :  getRoomPrice
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의실 가격
     * ${tags}
     */
    public int getRoomPrice(String roomNo) {

        int price = reservDao.getRoomPrice(roomNo);


        return price;
    }

    /**
     * @methodName :  getFixturePrice
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  기자제 가격
     * ${tags}
     */
    public int getFixturePrice(String fixtureNo) {

        int price = reservDao.getFixturePrice(fixtureNo);


        return price;
    }

    /**
     * @methodName :  getSnackPrice
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  간식 가격
     * ${tags}
     */
    public int getSnackPrice(String snackNo) {

        int price = reservDao.getSnackPrice(snackNo);


        return price;
    }

    /**
     * @methodName :  getLongCheck
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  장기 예약 체크
     * ${tags}
     */
    public int getLongCheck(ReservDataVO rvVO) {

        int cnt = reservDao.getLongCheck(rvVO);


        return cnt;
    }

    /**
     * @methodName :  getHoliCnt
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  공휴일 수
     * ${tags}
     */
    public int getHoliCnt(ReservDataVO rvVO) {

        int cnt = reservDao.getHoliCnt(rvVO);


        return cnt;
    }

    /**
     * @methodName :  getManagerEmail
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  팀장 이메일 불러오기
     * ${tags}
     */
    public String getManagerEmail(String empNo) {
        String email = reservDao.getManagerEmail(empNo);
        return email;
    }

    /**
     * @methodName :  getEmail
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  이메일 불러오기
     * ${tags}
     */
    public String getEmail(String empNo) {
        String email = reservDao.getEmail(empNo);
        return email;
    }

    /**
     * @methodName :  getDept
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  부서 불러오기
     * ${tags}
     */
    public String getDept(String empNo) {
        String deptNo = reservDao.getDept(empNo);
        return deptNo;
    }

    /**
     * @methodName :  getMaxPeople
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  최대 인원
     * ${tags}
     */
    public int getMaxPeople(String roomNo) {
        int maxPeople = reservDao.getMaxPeople(roomNo);
        return maxPeople;
    }

    /**
     * @methodName :  readSnackList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  간식 리스트 불러오기
     * ${tags}
     */
    public List<SnackVO> readSnackList() {
        List<SnackVO> resultList = reservDao.readSnackList();
        return resultList;
    }

    /**
     * @methodName :  readFixtureList
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  기자제 불러오기
     * ${tags}
     */
    public List<FixtureVO> readFixtureList() {
        List<FixtureVO> resultList = reservDao.readFixtureList();
        return resultList;
    }

    /**
     * @methodName :  getPosRoom
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  현재 예약 가능 리스트
     * ${tags}
     */
    public List<RoomVO> getPosRoom() {
        List<RoomVO> resultList = reservDao.getPosRoom();
        return resultList;
    }

    /**
     * @methodName :  getCurReserv
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  현재 예약 불러오기
     * ${tags}
     */
    public List<ReservVO> getCurReserv(String empNo) {
        List<ReservVO> resultList = reservDao.getCurReserv(empNo);
        return resultList;
    }

    /**
     * @methodName :  extendReserv
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 연장
     * ${tags}
     */
    public int extendReserv(String reservNo) {
        int result = reservDao.extendReserv(reservNo);
        return result;
    }

    /**
     * @methodName :  getRoomName
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의실 명 불러오기
     * ${tags}
     */
    public String getRoomName(String roomNo) {
        String roomName = reservDao.getRoomName(roomNo);
        return roomName;
    }

    /**
     * @methodName :  searchEmp
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  사원 검색
     * ${tags}
     */
    public List<EmpVO> searchEmp(String empName) {
        List<EmpVO> resultList = reservDao.searchEmp(empName);
        return resultList;
    }
}