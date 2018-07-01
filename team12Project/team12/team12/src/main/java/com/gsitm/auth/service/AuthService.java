package com.gsitm.auth.service;

import com.gsitm.auth.dao.AuthDao;
import com.gsitm.reserv.vo.EmpVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : 이창주
 * @programName : AuthService.java
 * @date : 2018-06-16
 * @function : 권한 관리 기능 service
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-16   권한 관리 기능 완료
 * 허빛찬샘 2018-06-18   예산 금액 수정 기능
 */
@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Resource(name = "authDao")
    private AuthDao authDao;

    /**
     * @methodName : getAuthList
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 조회
     * ${tags}
     */
    public List<EmpVO> getAuthList() {

        List<EmpVO> resultList = authDao.getAuthList();
        return resultList;
    }

    /**
     * @methodName : getEmp
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 사원목록 가져오기
     * ${tags}
     */
    public List<EmpVO> getEmp() {

        List<EmpVO> resultList = authDao.getEmp();
        return resultList;
    }

    /**
     * @methodName : modifyAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 수정
     * ${tags}
     */
    public void modifyAuth(EmpVO empVO) {
        authDao.modifyAuth(empVO);
    }

    /**
     * @methodName : removeAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 삭제
     * ${tags}
     */
    public void removeAuth(EmpVO empVO) {
        authDao.removeAuth(empVO);
    }

    /**
     * @methodName : budgetMod 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 18. 
     * @function   : 예산 정보 수정
     * @param budget
     * @return
     */ 
    public int budgetMod(int budget) {
    	return authDao.budgetMod(budget);
    }

    /**
     * @methodName : getBudget 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 19. 
     * @function   : 예산 정보 조회
     * @return
     */ 
    public int getBudget() {
    	return authDao.getBudget();
    }
}