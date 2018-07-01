package com.gsitm.reserv.mapper;

import java.util.List;
import java.util.Map;

import com.gsitm.reserv.vo.*;

public interface ReservMapper {

    List<ReservVO> readResrvList();

    void insertReserv(ReservDataVO rvVO);

    List<HollydayVO> readHollyList();

    List<ReservVO> readResrved(Map<String, Object> params);

    List<DeptVO> readDeptList();

    List<EmpVO> readTeamEmp(String teamName);

    List<FixtureVO> readFixture(String roomNo);

    String readWP(String roomNo);

    List<SnackVO> readSnack(String wpNo);

    List<ReservVO> readLongList(String roomNo);

    List<SnackVO> readSnackList();

    List<FixtureVO> readFixtureList();


    int getReservNo();

    void insertRsvEmp(Map<String, Object> params);

    void insertRsvTeam(Map<String, Object> params);

    void insertRsvFixture(Map<String, Object> params);

    void insertRsvSnack(Map<String, Object> params);

    int getRoomPrice(String roomNo);

    int getFixturePrice(String fixtureNo);

    int getSnackPrice(String snackNo);

    int getLongCheck(ReservDataVO rvVO);

    int getHoliCnt(ReservDataVO rvVO);

    void minusFixture(Map<String, Object> params);

    void minusSnack(Map<String, Object> params);

    String getManagerEmail(String empNo);

    String getEmail(String empNo);

    String getDept(String empNo);

    int getMaxPeople(String roomNo);

    void insertOut(OutVO out);

    List<RoomVO> getPosRoom();

    List<ReservVO> getCurReserv(String empNo);

    int extendReserv(String reservNo);

    String getRoomName(String roomNo);

    List<EmpVO> searchEmp(String empName);
}
