package com.gsitm.batch.dao;

import com.gsitm.batch.mapper.BatchMapper;
import com.gsitm.batch.vo.BatchDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.ReservPayVO;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * @programName : LoginDao.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 14. 
 * @function    : BatchDao
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-14	초안 작성, reservList(String data) 메소드 추가
 * 허빛찬샘	2018-06-15	masterView(ReservPayVO vo), teamManagerView(ReservPayVO vo) 메소드 추가
 * 허빛찬샘	2018-06-16	cancelList(String data),reservDel(BatchDeptVO vo) 메소드 추가
 * 허빛찬샘	2018-06-19	autoBudget() 메소드 추가
 */ 
@Repository(value = "batchDao")
public class BatchDao{
	private static final Logger logger = LoggerFactory.getLogger(BatchDao.class);

	@Autowired
	protected SqlSession sqlSession;

    /**
     * @param data
     * @return
     * @methodName : reservList
     * @author : 허빛찬샘
     * @date : 2018. 6. 18.
     * @function : 예약 리스트
     */
	public List<ReservPayVO> reservList(String data) {
		List<ReservPayVO> list = new ArrayList<>();
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			list = batchMapper.reservList(data);
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
		return list;
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
		List<ReservPayVO> list = new ArrayList<>();
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			list = batchMapper.cancelList(data);
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
		return list;
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
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			deptList = batchMapper.deptList(vo);
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
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
		int result = 0;
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			result = batchMapper.reservMod(vo);
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
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
		int result = 0;
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			result = batchMapper.reservDel(vo);
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
		return result;
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
		List<PayEmpVO> empList = new ArrayList<>();
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			empList = batchMapper.masterView(roles);
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
		return empList;
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
		List<PayEmpVO> empList = new ArrayList<>();
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			empList = batchMapper.teamManagerView(vo);
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
		return empList;
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
		int result = 0;
		try {
			BatchMapper batchMapper = sqlSession.getMapper(BatchMapper.class);
			result = batchMapper.autoBudget();
		}catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}
		return result;
	}
	
}
