package com.gsitm.voice.controller;

import com.gsitm.reserv.service.ReservService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : 이창주
 * @programName : VoiceController.java
 * @date : 2018-06-19
 * @function : 음성인식 처리
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-19   음성인식 처리
 */
@Controller
public class VoiceController {

    private static final Logger logger = LoggerFactory.getLogger(VoiceController.class);

    @Resource(name = "reservService")
    private ReservService reservService;


    /**
     * @methodName :  voiceRecog
     * @author :  이창주
     * @date :  2018-06-15
     * @function :  음성 처리 결과 반환
     * ${tags}
     */
    @RequestMapping(value = "/voiceRecog.do", method = RequestMethod.GET)
    public ModelAndView voiceRecog(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                   ModelAndView mv) {

        String result = request.getParameter("voice");
        logger.info("음성인식: " + request.getParameter("voice"));
        Map map = new HashMap();
        if (result.equals("회의실")) {
            map.put("data", "http://192.168.9.233:8088/searchConf.do");
        } else {
            map.put("data", "http://192.168.9.233:8088/searchEdu.do");
        }



        return new ModelAndView("jsonView", map);
    }
}
