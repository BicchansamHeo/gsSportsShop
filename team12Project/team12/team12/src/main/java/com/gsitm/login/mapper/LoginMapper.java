package com.gsitm.login.mapper;

import com.gsitm.login.vo.UserVO;

/**
 * @author : 허빛찬샘
 * @programName : LoginMapper.java
 * @date : 2018. 6. 11.
 * @function : LoginMapper java 파일
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-11	초안 작성
 */
public interface LoginMapper {
    /**
     * @methodName : loadUserByUsername
     * @author : 허빛찬샘
     * @date : 2018. 6. 11.
     * @function : 로그인 처리
     */
    UserVO loadUserByUsername(String username);

    /**
     * @methodName : userView
     * @author : 허빛찬샘
     * @date : 2018. 6. 11.
     * @function : 로그인 유저 정보 받아오기
     */
    UserVO userView(UserVO vo);
}
