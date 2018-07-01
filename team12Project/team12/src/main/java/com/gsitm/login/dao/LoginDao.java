package com.gsitm.login.dao;

import com.gsitm.login.mapper.LoginMapper;
import com.gsitm.login.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @programName : LoginDao.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 11.
 * @function    : LoginDao
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-11	초안 작성
 */
@Repository(value = "loginDao")
public class LoginDao {
    private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);

    @Autowired
    protected SqlSession sqlSession;

    /**
     * @methodName : loadUserByUsername
     * @author : 허빛찬샘
     * @date : 2018. 6. 11.
     * @function : 로그인 처리
     */
    public UserDetails loadUserByUsername(String username) {
        UserVO VO = new UserVO();
        try {
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            VO = loginMapper.loadUserByUsername(username);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(VO.getRoles()));
        UserDetails user = new User(VO.getEmpNo(), VO.getPassword(), roles);
        return user;
    }

    /**
     * @methodName : userView
     * @author : 허빛찬샘
     * @date : 2018. 6. 11.
     * @function : 로그인 유저 정보 받아오기
     */
    public UserVO userView(UserVO vo) {
        try {
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            vo = loginMapper.userView(vo);
        } catch (Exception e) {
            logger.debug(" [ERROR] " + e);
        }
        return vo;
    }

}
