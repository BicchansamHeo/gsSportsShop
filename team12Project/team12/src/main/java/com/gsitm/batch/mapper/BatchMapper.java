package com.gsitm.batch.mapper;

import com.gsitm.batch.vo.BatchDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.ReservPayVO;

import java.util.List;

/**
 * @programName : BatchMapper.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 14. 
 * @function    : BatchMapper java 파일
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-14	초안 작성, reservList(String data),deptList(ReservVO vo) 인터페이스 추가
 * 허빛찬샘	2018-06-15	masterView(ReservPayVO vo), teamManagerView(ReservPayVO vo) 인터페이스 추가
 * 허빛찬샘	2018-06-16	cancelList(String data), reservDel(ReservPayVO vo) 인터페이스 추가
 * 허빛찬샘	2018-06-19	autoBudget() 인터페이스 추가
 */ 
public interface BatchMapper {
	/**
	 * @param data
	 * @return
	 * @methodName : reservList
	 * @author : 허빛찬샘
	 * @date : 2018. 6. 18.
	 * @function : 예약 리스트
	 */
	List<ReservPayVO> reservList(String data);

	/**
	 * @methodName : deptList
	 * @author     : 허빛찬샘
	 * @date       : 2018. 6. 18.
	 * @function   : 부서 리스트
	 * @param vo
	 * @return
	 */
	List<BatchDeptVO> deptList(ReservPayVO vo);

	/**
	 * @methodName : reservMod
	 * @author     : 허빛찬샘
	 * @date       : 2018. 6. 18.
	 * @function   : 예약 수정
	 * @param vo
	 * @return
	 */
	int reservMod(BatchDeptVO vo);

	/**
	 * @methodName : reservDel
	 * @author     : 허빛찬샘
	 * @date       : 2018. 6. 18.
	 * @function   : 예약 삭제
	 * @param vo
	 * @return
	 */
	int reservDel(ReservPayVO vo);

	/**
	 * @methodName : masterView
	 * @author     : 허빛찬샘
	 * @date       : 2018. 6. 18.
	 * @function   : 권한에 대한 사원정보
	 * @param roles
	 * @return
	 */
	List<PayEmpVO> masterView(String roles);

	/**
	 * @methodName : teamManagerView
	 * @author     : 허빛찬샘
	 * @date       : 2018. 6. 18.
	 * @function   : 팀장 정보
	 * @param vo
	 * @return
	 */
	List<PayEmpVO> teamManagerView(ReservPayVO vo);

	/**
	 * @methodName : cancelList
	 * @author     : 허빛찬샘
	 * @date       : 2018. 6. 18.
	 * @function   : 예약 취소
	 * @param data
	 * @return
	 */
	List<ReservPayVO> cancelList(String data);

	/**
	 * @methodName : autoBudget
	 * @author     : 허빛찬샘
	 * @date       : 2018. 6. 18.
	 * @function   : 자동 예산 추가
	 * @param
	 * @return
	 */
	int autoBudget();
}
