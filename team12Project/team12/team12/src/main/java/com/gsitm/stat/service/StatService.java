package com.gsitm.stat.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.pay.dao.PayDao;
import com.gsitm.pay.vo.PayDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.PayRoomVO;
import com.gsitm.pay.vo.ReservPayVO;
import com.gsitm.reserv.vo.ReservVO;
import com.gsitm.stat.dao.StatDao;
import com.gsitm.stat.vo.StatBestVO;
import com.gsitm.stat.vo.StatMonthVO;

/**
 * @programName : StatService.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 18. 
 * @function    : 통계 Service
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-18	초안 작성, statMonth() 메소드 추가
 * 허빛찬샘	2018-06-19	StatBestVO 메소드 추가
 */ 
@Service
public class StatService {
	
	@Resource(name="statDao")
	private StatDao statDao;
	
	public List<StatMonthVO> statMonth() throws Exception{
		return statDao.statMonth();
	}
	public List<StatBestVO> StatBest() throws Exception{
		return statDao.StatBest();
	}
}