package com.gsitm.batch.service;

import com.gsitm.batch.dao.BatchDao;
import com.gsitm.batch.vo.BatchDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.ReservPayVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @programName : BatchService.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 14. 
 * @function    :  batch Service
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-14	초안 작성
 * 허빛찬샘	2018-06-15	masterView(ReservPayVO vo), teamManagerView(ReservPayVO vo) 메소드 추가
 * 허빛찬샘	2018-06-16	cancelList(String data), reservDel(BatchDeptVO vo) 메소드 추가
 * 허빛찬샘	2018-06-19	autoBudget() 메소드 추가
 */ 
@Service
public class BatchService{
	
	@Resource(name="batchDao")
	private BatchDao batchDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BatchService.class);

    /**
     * @param data
     * @return
     * @methodName : reservList
     * @author : 허빛찬샘
     * @date : 2018. 6. 18.
     * @function : 예약 리스트
     */
    public List<ReservPayVO> reservList(String data) {
        return batchDao.reservList(data);
    }

    /**
     * @methodName : cancelList
     * @author     : 허빛찬샘
     * @date       : 2018. 6. 18.
     * @function   : 예약 취소
     * @param data
     * @return
	 */
	public List<ReservPayVO> cancelList(String data) {
		return batchDao.cancelList(data);
  }

    /**
     * @methodName : deptList
     * @author     : 허빛찬샘
     * @date       : 2018. 6. 18.
     * @function   : 부서 리스트
     * @param vo
     * @return
	 */
	public List<BatchDeptVO> deptList(ReservPayVO vo) {
		List<BatchDeptVO> deptList = new ArrayList<>();
		deptList = batchDao.deptList(vo);
		return deptList;
  }

    /**
     * @methodName : reservMod
     * @author     : 허빛찬샘
     * @date       : 2018. 6. 18.
     * @function   : 예약 수정
     * @param vo
     * @return
	 */
	public int reservMod(BatchDeptVO vo) {
		int result = batchDao.reservMod(vo);
		return result;
  }

    /**
     * @methodName : reservDel
     * @author     : 허빛찬샘
     * @date       : 2018. 6. 18.
     * @function   : 예약 삭제
     * @param vo
     * @return
	 */
	public int reservDel(ReservPayVO vo) {
		return batchDao.reservDel(vo);
  }

    /**
     * @methodName : masterView
     * @author     : 허빛찬샘
     * @date       : 2018. 6. 18.
     * @function   : 권한에 대한 사원정보
     * @param roles
     * @return
	 */
	public List<PayEmpVO> masterView(String roles) {
		return batchDao.masterView(roles);
  }

    /**
     * @methodName : teamManagerView
     * @author     : 허빛찬샘
     * @date       : 2018. 6. 18.
     * @function   : 팀장 정보
     * @param vo
     * @return
	 */
	public List<PayEmpVO> teamManagerView(ReservPayVO vo) {
		return batchDao.teamManagerView(vo);
  }

    /**
     * @methodName : autoBudget
     * @author     : 허빛찬샘
     * @date       : 2018. 6. 18.
     * @function   : 자동 예산 추가
     * @param
     * @return
	 */
	public int autoBudget() {
		return batchDao.autoBudget();
	}
}