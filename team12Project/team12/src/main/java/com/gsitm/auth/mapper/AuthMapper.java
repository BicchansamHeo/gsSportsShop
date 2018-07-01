package com.gsitm.auth.mapper;

import java.util.List;
import java.util.Map;

import com.gsitm.reserv.vo.DeptVO;
import com.gsitm.reserv.vo.EmpVO;
import com.gsitm.reserv.vo.FixtureVO;
import com.gsitm.reserv.vo.HollydayVO;
import com.gsitm.reserv.vo.OutVO;
import com.gsitm.reserv.vo.ReservDataVO;
import com.gsitm.reserv.vo.ReservVO;
import com.gsitm.reserv.vo.SnackVO;

/**
 * @author : 이창주
 * @programName : AuthMapper.java
 * @date : 2018-06-16
 * @function : 권한 관리 기능 MAPPER interface
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-16   권한 관리 기능 완료
 * 허빛찬샘 2018-06-18   예산 금액 수정 기능
 */
public interface AuthMapper {

    /**
     * @methodName : goAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 조회
     * ${tags}
     */
    List<EmpVO> getAuthList();

    /**
     * @methodName : getEmp
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 사원목록 가져오기
     * ${tags}
     */
    List<EmpVO> getEmp();

    /**
     * @methodName : getEmp
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 수정
     * ${tags}
     */
    void modifyAuth(EmpVO empVO);

    /**
     * @methodName : removeAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 삭제
     * ${tags}
     */
    void removeAuth(EmpVO empVO);

    /**
     * @methodName : budgetMod 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 18. 
     * @function   : 예산 금액 수정
     * @param budget
     * @return 
     */ 
    int budgetMod(int budget);
    
    /**
     * @methodName : getBudget 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 19. 
     * @function   : 예산 정보 조회
     * @return
     */ 
    int getBudget();

}
