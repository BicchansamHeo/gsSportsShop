package com.gsitm.stat.mapper;

import java.util.List;

import com.gsitm.stat.vo.StatBestVO;
import com.gsitm.stat.vo.StatMonthVO;

/**
 * @programName : StatMapper.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 18. 
 * @function    : 통계 Mapper
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-18	초안 작성
 * 허빛찬샘	2018-06-19	StatBestVO 기능 추가
 */ 
public interface StatMapper {
	List<StatMonthVO> statMonth();
	List<StatBestVO> statBest();
}
