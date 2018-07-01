package com.gsitm.stat.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gsitm.stat.mapper.StatMapper;
import com.gsitm.stat.vo.StatBestVO;
import com.gsitm.stat.vo.StatMonthVO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : 허빛찬샘
 * @programName : StatDao.java
 * @date : 2018-06-18
 * @function : 통계 Dao
 * 
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘  2018-06-18  초안 작성, statMonth() 메소드 추가
 * 허빛찬샘	2018-06-19	StatBestVO 메소드 추가
 */
@Repository(value = "statDao")
public class StatDao {
    private static final Logger logger = LoggerFactory.getLogger(StatDao.class);

    @Autowired
    protected SqlSession sqlSession;
    
    public List<StatMonthVO> statMonth(){
    	List<StatMonthVO> list = new ArrayList<StatMonthVO>();
		try{			
			StatMapper statMapper = sqlSession.getMapper(StatMapper.class);
			list = statMapper.statMonth();
		}
		catch(Exception e){
			logger.debug(" [ERROR] "+e);
		}		
		return list;
    }
    
    public List<StatBestVO> StatBest(){
    	List<StatBestVO> list = new ArrayList<StatBestVO>();
    	try{			
    		StatMapper statMapper = sqlSession.getMapper(StatMapper.class);
    		list = statMapper.statBest();
    	}
    	catch(Exception e){
    		logger.debug(" [ERROR] "+e);
    	}		
    	return list;
    }
}
