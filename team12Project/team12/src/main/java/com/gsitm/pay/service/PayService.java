package com.gsitm.pay.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.pay.dao.PayDao;
import com.gsitm.pay.vo.PayDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.PayRoomVO;
import com.gsitm.pay.vo.ReservPayVO;
import com.gsitm.reserv.vo.ReservVO;

/**
 * @programName : PayService.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 07. 
 * @function    : 결제 부분의 전반적인 내용을 담당하는 Service
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-07	초안 작성, readList() 메소드 추가
 * 허빛찬샘	2018-06-08	readReserv(ReservVO), readRoom(ReservPayVO), readDept(ReservPayVO), readEmp(ReservPayVO) 메소드 추가
 * 허빛찬샘	2018-06-14	pprovalMod(PayEmpVO vo) 메소드 추가
 */ 
@Service
public class PayService {
	
	@Resource(name="payDao")
	private PayDao payDao;
	
	public List<ReservPayVO> readList(PayEmpVO EVO) throws Exception{
		return payDao.readList(EVO);
	}
	public ReservPayVO readReserv(ReservVO vo) throws Exception{
		return payDao.readReserv(vo);
	}
	public PayRoomVO readRoom(ReservPayVO vo) throws Exception{
		return payDao.readRoom(vo);
	}
	public List<String> adminEmail(ReservPayVO rpv) throws Exception{
		return payDao.adminEmail(rpv);
	}
	public List<PayDeptVO> readDept(ReservPayVO vo) throws Exception{
		return payDao.readDept(vo);
	}
	public List<PayEmpVO> readEmp(ReservPayVO vo) throws Exception{
		return payDao.readEmp(vo);
	}
	public PayEmpVO readEmpReturn(ReservPayVO vo) throws Exception{
		return payDao.readEmpReturn(vo);
	}
	public int approvalMod(ReservPayVO rpv) throws Exception{
		return payDao.approvalMod(rpv);
	}
	public int returnMod(ReservPayVO rpv) throws Exception{
		return payDao.returnMod(rpv);
	}
	public ReservPayVO applyMailList(ReservPayVO rpv) throws Exception{
		return payDao.applyMailList(rpv);
	}
}