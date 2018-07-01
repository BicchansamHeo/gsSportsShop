package com.gsitm.login.service;

import com.gsitm.login.dao.LoginDao;
import com.gsitm.login.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : 허빛찬샘
 * @programName : LoginService.java
 * @date : 2018. 6. 11.
 * @function : LoginService
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-11	초안 작성
 */
@Service
public class LoginService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    @Resource(name = "loginDao")
    private LoginDao loginDao;

    /**
     * @methodName : loadUserByUsername
     * @author : 허빛찬샘
     * @date : 2018. 6. 11.
     * @function : 로그인 처리
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //dao에서 user 검증
        return loginDao.loadUserByUsername(username);
    }

    /**
     * @methodName : userView
     * @author : 허빛찬샘
     * @date : 2018. 6. 11.
     * @function : 로그인 유저 정보 받아오기
     */
    public UserVO userView(UserVO vo) throws UsernameNotFoundException {
        //dao에서 user 검증
        return loginDao.userView(vo);
    }


}