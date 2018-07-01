package com.gsitm.pay.mapper;

import java.util.List;

import com.gsitm.pay.vo.PayDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.PayRoomVO;
import com.gsitm.pay.vo.ReservPayVO;
import com.gsitm.reserv.vo.FixtureVO;
import com.gsitm.reserv.vo.ReservVO;
import com.gsitm.reserv.vo.SnackVO;

/**
 * @programName : PayMapper.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 07.
 * @function    : PayMapper.sql 과 연결되는 인터페이스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-07	초안 작성, readList() 메소드 추가
 * 허빛찬샘	2018-06-08	readReserv(ReservVO), readRoom(ReservPayVO), readDept(ReservPayVO), readEmp(ReservPayVO) 인터페이스 추가
 * 허빛찬샘	2018-06-14	approvalMod(PayEmpVO vo) 인터페이스 추가
 */ 
public interface PayMapper {
	List<ReservPayVO> readList(PayEmpVO EVO);
	ReservPayVO readReserv(ReservVO vo);
	PayRoomVO readRoom(ReservPayVO vo);
	List<PayDeptVO> readDept(ReservPayVO vo);
	List<PayEmpVO> readEmp(ReservPayVO vo);
	PayEmpVO readEmpReturn(ReservPayVO vo);
	int approvalModAM(ReservPayVO rpv);
	int approvalModEM(ReservPayVO rpv);
	int returnModDM(ReservPayVO rpv);
	int returnMod(ReservPayVO rpv);
	String reservUserName(String reservEmpNo);
	List<String> adminEmail(ReservPayVO rpv);
	List<String> adminEmailEM(ReservPayVO rpv);
	List<String> adminEmailAM(ReservPayVO rpv);
	List<FixtureVO> readFixture(ReservPayVO rpv);
	List<SnackVO> readSnack(ReservPayVO rpv);
}
