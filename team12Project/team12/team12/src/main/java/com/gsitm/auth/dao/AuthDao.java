package com.gsitm.auth.dao;

import com.gsitm.auth.mapper.AuthMapper;
import com.gsitm.reserv.vo.EmpVO;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : 이창주
 * @programName : AuthDao.java
 * @date : 2018-06-16
 * @function : 권한 관리 기능 DAO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-16   권한 관리 기능 완료
 * 허빛찬샘 2018-06-18   예산 금액 수정 기능
 */
@Repository(value = "authDao")
public class AuthDao {
    private static final Logger logger = LoggerFactory.getLogger(AuthDao.class);

    @Autowired
    protected SqlSession sqlSession;

    /**
     * @methodName : goAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 조회
     * ${tags}
     */
    public List<EmpVO> getAuthList() {
        List<EmpVO> list = null;
        try {
            AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);
            list = authMapper.getAuthList();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName : getEmp
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 사원목록 가져오기
     * ${tags}
     */
    public List<EmpVO> getEmp() {
        List<EmpVO> list = null;
        try {
            AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);
            list = authMapper.getEmp();
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return list;
    }

    /**
     * @methodName : getEmp
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 수정
     * ${tags}
     */
    public void modifyAuth(EmpVO empVO) {
        AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);
        authMapper.modifyAuth(empVO);
    }

    /**
     * @methodName : removeAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 삭제
     * ${tags}
     */
    public void removeAuth(EmpVO empVO) {
        AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);
        authMapper.removeAuth(empVO);
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
    	AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);
    	return authMapper.budgetMod(budget); 
    }

    /**
     * @methodName : getBudget 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 19. 
     * @function   : 예산 정보 조회
     * @return
     */ 
    public int getBudget() {
    	AuthMapper authMapper = sqlSession.getMapper(AuthMapper.class);
    	return authMapper.getBudget(); 
    }

}
