package com.gsitm.mypage.controller;

import com.gsitm.login.vo.UserVO;
import com.gsitm.mypage.service.MpgService;
import com.gsitm.mypage.vo.*;
import com.gsitm.reserv.service.ReservService;
import com.gsitm.reserv.vo.ReservVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 허빛찬샘
 * @programName : MpgController.java
 * @date : 2018. 6. 09.
 * @function : Mypage의 전반적인 Controller
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-11	초안작성, mpgMain(), mypageMmb() 메소드 생성
 * 허빛찬샘	2018-06-12	userAjax(), teamAjax() 메소드 추가
 * 이창주   2018-06-17  현재 진행중인 예약 내역 보여주기
 */
@Controller
public class MpgController {

    private static final Logger logger = LoggerFactory.getLogger(MpgController.class);

    @Resource(name = "mpgService")
    private MpgService mpgService;

    @Resource(name = "reservService")
    private ReservService reservService;

    /**
     * @methodName : mpgMain 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 마이페이지 멤버 정보 보여주는 메소드
     * @return
     */ 
    @RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
    public ModelAndView mpgMain(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param) {

        ModelAndView model = new ModelAndView();
        //현재 로그인 한 사용자의 진행중인 예약 내역 가져오기
        String empNo = request.getParameter("empNo");
        List<ReservVO> curReserv = reservService.getCurReserv(empNo);
        model.addObject("curReserv", curReserv);
        model.setViewName("/mpg_mmb");

        return model;
    }
    
    /**
     * @methodName : mypageTeam 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 마이페이지 팀 정보 보여주는 메소드
     * @return
     */ 
    @RequestMapping(value = "/mypageTeam.do", method = RequestMethod.GET)
    public ModelAndView mypageTeam() {
    	
    	ModelAndView model = new ModelAndView();
    	model.setViewName("/mpg_team");
    	
    	return model;
    }

    /**
     * @methodName : userAjax 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 마이페이지에서 user 정보 보여주는 aJax 메소드
     * @param vo
     * @return
     */ 
    @RequestMapping(value = "/userAjax.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView userAjax(UserVO vo) {
        List<MpgReservVO> reservList = new ArrayList<>();
        try {
            vo = mpgService.userView(vo);
            reservList = mpgService.reservList(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userVO", vo);
        map.put("reservList", reservList);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName : teamAjax 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 마이페이지 team 정보 보여주는 aJax 메소드
     * @param vo
     * @return
     */ 
    @RequestMapping(value = "/teamAjax.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView teamAjax(UserVO vo) {
        List<UserVO> userList = new ArrayList<>();
        try {
            vo = mpgService.userView(vo);
            userList = mpgService.userList(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userVO", vo);
        map.put("userList", userList);
        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName : detailAjax 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 예약 내역 조회 하는 aJax 메소드
     * @param vo
     * @return
     */ 
    @RequestMapping(value = "/detailAjax.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView detailAjax(MpgReservVO vo) {
        List<MpgDeptVO> deptList = new ArrayList<>();
        List<MpgEmpVO> empList = new ArrayList<>();
        List<MpgGuestVO> guestList = new ArrayList<>();
        List<MpgFixtureVO> fixtureList = new ArrayList<>();
        List<MpgSnackVO> snackList = new ArrayList<>();
        try {
            vo = mpgService.reservDetail(vo);
            deptList = mpgService.deptList(vo);
            empList = mpgService.empList(vo);
            guestList = mpgService.guestList(vo);
            fixtureList = mpgService.fixtureList(vo);
            snackList = mpgService.snackList(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("detail", vo);
        map.put("deptList", deptList);
        map.put("empList", empList);
        map.put("guestList", guestList);
        map.put("fixtureList", fixtureList);
        map.put("snackList", snackList);
        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName : reservCancel 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 예약 취소 시키는 메소드
     * @param vo
     * @return
     */ 
    @RequestMapping(value = "/reservCancel.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView reservCancel(MpgReservVO vo) {
        int result = 0;
        try {
            result = mpgService.reservDel(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("data", result);
        return new ModelAndView("jsonView", map);
    }
}