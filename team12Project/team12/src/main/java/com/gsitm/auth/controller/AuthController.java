package com.gsitm.auth.controller;

import com.google.gson.*;
import com.gsitm.auth.service.AuthService;
import com.gsitm.mail.EmailSender;
import com.gsitm.mail.vo.EmailVO;
import com.gsitm.reserv.service.ReservService;
import com.gsitm.reserv.vo.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.velocity.tools.generic.DateTool;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : 이창주
 * @programName : AuthController.java
 * @date : 2018-06-16
 * @function : 권한 관리 기능 컨트롤러
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-16   권한 관리 기능 완료
 * 이창주   2018-06-18   예산 금액 수정 기능 추가
 */
@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource(name = "authService")
    private AuthService authService;


    /**
     * @methodName : goAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 관리 페이지로 이동 -> 권한 조회해서 empList 만들어서 보내기
     * ${tags}
     */
    @RequestMapping(value = "/authManage.do", method = RequestMethod.GET)
    public ModelAndView goAuth(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                               ModelAndView mv) {

        List<EmpVO> authList = authService.getAuthList();
        int budget = authService.getBudget();
        mv.addObject("authList", authList);
        mv.addObject("budget", budget);
        mv.setViewName("/authManage");
        return mv;
    }

    /**
     * @methodName : getEmp
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 사원목록 가져오기
     * ${tags}
     */
    @RequestMapping(value = "/getEmp.do", method = RequestMethod.GET)
    public ModelAndView getEmp(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                               ModelAndView mv, EmpVO empVO) {

        Map map = new HashMap();
        List<EmpVO> list = authService.getEmp();
        map.put("data", list);
        return new ModelAndView("jsonView", map);
    }


    /**
     * @methodName : getEmp
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 수정
     * ${tags}
     */
    @RequestMapping(value = "/addAuth.do", method = RequestMethod.POST)
    public String addAuth(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                          ModelAndView mv, EmpVO empVO) {

        String curEmpNo = request.getParameter("curEmpNo");
        if (curEmpNo != null) {
            logger.info("safasfs: " + empVO.toString());
            //권한 자 변경
            authService.modifyAuth(empVO);
            empVO.setEmpNo(curEmpNo);
            authService.removeAuth(empVO);
        } else {
            //새로운 권한자 추가
            authService.modifyAuth(empVO);
        }

        return "redirect:/authManage.do";
    }

    /**
     * @methodName : removeAuth
     * @author     : 이창주
     * @date       : 2018-06-16
     * @function   : 권한 삭제
     * ${tags}
     */
    @RequestMapping(value = "/removeAuth.do", method = RequestMethod.GET)
    public String removeAuth(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                             ModelAndView mv, EmpVO empVO) {

        authService.removeAuth(empVO);
        return "redirect:/authManage.do";
    }
    
    /**
     * @methodName : budgetMod
     * @author     : 허빛찬샘
     * @date       : 2018-06-16
     * @function   : 예산 수정
     * ${tags}
     */
    @RequestMapping(value = "/budgetMod.do", method = RequestMethod.POST)
    public String budgetMod(@RequestParam("budget") int budget) {
    	authService.budgetMod(budget);
    	return "redirect:/authManage.do";
    }
}
