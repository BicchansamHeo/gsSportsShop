package com.gsitm.pay.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.velocity.tools.generic.DateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.mail.EmailSender;
import com.gsitm.mail.vo.EmailVO;
import com.gsitm.pay.service.PayService;
import com.gsitm.pay.vo.PayDeptVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.PayRoomVO;
import com.gsitm.pay.vo.ReservPayVO;
import com.gsitm.reserv.vo.ReservDataVO;
import com.gsitm.reserv.vo.ReservVO;

/**
 * @programName : PayController.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 07. 
 * @function    : 결제부분의 전반적인 내용을 담당하는 controller
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-07	초안 작성
 * 허빛찬샘	2018-06-08	payView, payReserveView 메소드 추가
 * 허빛찬샘	2018-06-14	payApply 메소드 추가
 * 허빛찬샘	2018-06-15	메일보내기 기능 추가
 */ 
@Controller
public class PayController {
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);

	@Resource(name = "payService")
	private PayService payService;
	
    @Autowired(required = true)
    private EmailSender emailSender;
	
	/**
	 * @methodName : payView 
	 * @author     : 허빛찬샘 
	 * @date       : 2018. 6. 20. 
	 * @function   : 결재 메인 화면을 보여주는 메소드
	 * @param authentication
	 * @return
	 */ 
	@RequestMapping(value = "/pay.do", method = RequestMethod.GET)
	public ModelAndView payView(Authentication authentication) {
		ModelAndView model = new ModelAndView();
		String role = authentication.getAuthorities().toString();
		role = role.substring(1, role.length()-1);
		PayEmpVO EVO = new PayEmpVO();
		EVO.setEmpNo(authentication.getName());
		EVO.setRole(role);
		List<ReservPayVO> reservList = new ArrayList<ReservPayVO>();
		try {
			reservList = payService.readList(EVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("role", role);
		model.addObject("reservList", reservList);
		model.setViewName("/pay_view");
		
		return model;
	}
	
	/**
	 * @methodName : payReserveView 
	 * @author     : 허빛찬샘 
	 * @date       : 2018. 6. 20. 
	 * @function   : 결재 상세 화면을 보여주는 메소드
	 * @param vo
	 * @return
	 */ 
	@RequestMapping(value = "/payReserveView.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView payReserveView(ReservVO vo) {
		ReservPayVO reserv = new ReservPayVO();
		PayRoomVO room = new PayRoomVO();
		List<PayDeptVO> deptList = new ArrayList<PayDeptVO>();
		List<PayEmpVO> empList = new ArrayList<PayEmpVO>();
		try {
			reserv = payService.readReserv(vo);
			room = payService.readRoom(reserv);
			deptList = payService.readDept(reserv);
			empList = payService.readEmp(reserv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("reserv", reserv);
	    map.put("room", room);
	    map.put("deptList", deptList);
	    map.put("empList", empList);
	    return new ModelAndView("jsonView", map);
	}
	
	/**
	 * @methodName : payApply 
	 * @author     : 허빛찬샘 
	 * @date       : 2018. 6. 20. 
	 * @function   : 결재처리 하는 메소드
	 * @param authentication
	 * @param rpv
	 * @param reservEmpNo
	 * @return
	 */ 
	@RequestMapping(value = "/payApply.do", method = RequestMethod.POST)
	public ModelAndView payApply(Authentication authentication, ReservPayVO rpv, @RequestParam("reservEmpNo") String reservEmpNo) {
		ModelAndView model = new ModelAndView();
		String role = authentication.getAuthorities().toString();
		role = role.substring(1, role.length()-1);
		rpv.setRole(role);
		int result = 0;
		try {
			result = payService.approvalMod(rpv);
			List<String> adminEmailList = payService.adminEmail(rpv);
			rpv = payService.applyMailList(rpv);
			//for(String mail : adminEmailList) {
				//메일 메소드 호출
				//sendMailApply(mail, rpv);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setViewName("redirect:/pay.do");
		return model;
	}
	
	/**
	 * @methodName : payReturn 
	 * @author     : 허빛찬샘 
	 * @date       : 2018. 6. 20. 
	 * @function   : 반려 처리하는 메소드
	 * @param authentication
	 * @param rpv
	 * @return
	 */ 
	@RequestMapping(value = "/payReturn.do", method = RequestMethod.POST)
	public ModelAndView payReturn(Authentication authentication, ReservPayVO rpv) {
		ModelAndView model = new ModelAndView();
		String role = authentication.getAuthorities().toString();
		role = role.substring(1, role.length()-1);
		rpv.setRole(role);
		int result = 0;
		try {
			result = payService.returnMod(rpv);
			if(result!=0 && role.equals("ROLE_DM")) {
				PayEmpVO PEVO = new PayEmpVO();
				PEVO = payService.readEmpReturn(rpv);
				sendMailReturn(PEVO, rpv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setViewName("redirect:/pay.do");
		return model;
	}
	
    /**
     * @methodName : sendMailReturn 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 반려 이메일 메소드
     * @param data
     * @param rpv
     */ 
    public void sendMailReturn(PayEmpVO data, ReservPayVO rpv) {
        String title = "";      // 제목
        EmailVO email1 = new EmailVO();
        email1.setHtmlYn("Y");                           // html 형식으로 세팅
        email1.setFrom("IT1060@gmail.com");                   // from
        email1.setReceiver(data.getEmail());  // 받는사람:가입유저
        title = "GS ITM 회의실 예약 반려 안내 메일";
        email1.setSubject(title);      // 메일 제목 properties 파일 참조
        email1.setVeloTemplate("mailReturn.vm");        // 템플릿 파일명
        Map<String, Object> map = new HashMap<>();
        try {
            map = PropertyUtils.describe(rpv);
            map.put("title", title);
            email1.setEmailMap(map);
            emailSender.sendVelocityEmail(email1);           // 메일 전송
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @methodName : sendMailApply 
     * @author     : 허빛찬샘 
     * @date       : 2018. 6. 20. 
     * @function   : 결재 승인 이메일 메소드
     * @param email
     * @param data
     */ 
    public void sendMailApply(String email, ReservPayVO data) {
        //sendType
        String title = "";      // 제목

        EmailVO email1 = new EmailVO();
        email1.setHtmlYn("Y");                           // html 형식으로 세팅
        email1.setFrom("IT1060@gmail.com");                   // from
        email1.setReceiver(email);  // 받는사람:가입유저
        title = "GS ITM 회의실 예약 승인 요청 메일";
        email1.setSubject(title);      // 메일 제목 properties 파일 참조
        email1.setVeloTemplate("mail.vm");        // 템플릿 파일명
        Map<String, Object> map;
        try {
            map = PropertyUtils.describe(data);
            map.put("title", title);
            map.put("date", new DateTool());
            email1.setEmailMap(map);
            emailSender.sendVelocityEmail(email1);           // 메일 전송
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}