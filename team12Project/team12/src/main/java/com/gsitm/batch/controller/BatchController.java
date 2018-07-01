package com.gsitm.batch.controller;

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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.batch.ExBatchJob;
import com.gsitm.batch.vo.BatchContactVO;
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
 * @programName : BatchController.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 15. 
 * @function    : batch의 전반적인 내용을 담당하는 controller
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-15	초안 작성
 */ 
@Controller
public class BatchController {
	private static final Logger logger = LoggerFactory.getLogger(BatchController.class);
}