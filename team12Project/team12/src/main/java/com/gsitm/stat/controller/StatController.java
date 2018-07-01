package com.gsitm.stat.controller;

import com.gsitm.stat.dao.StatDao;
import com.gsitm.stat.vo.StatMonthVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 허빛찬샘
 * @programName : StatController.java
 * @date : 2018. 6. 11.
 * @function : 통계 Controller
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-11	초안작성
 * 허빛찬샘	2018-06-11	BAR 형 통계 완료
 */
@Controller
public class StatController {

    private static final Logger logger = LoggerFactory.getLogger(StatController.class);
    
    @Resource(name="statDao")
	private StatDao statDao;
	
    /**
     * @methodName : mpgStat 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 차트 메인 보여주는 메소드
     * @return
     */ 
    @RequestMapping(value = "/stat.do", method = RequestMethod.GET)
    public ModelAndView mpgStat() {

        ModelAndView model = new ModelAndView();
        List<StatMonthVO> monthList = new ArrayList<>();
        monthList = statDao.statMonth();
        model.addObject("monthList", monthList);
        model.setViewName("/stat_view");

        return model;
    }
}