package com.gsitm.main.controller;

import com.gsitm.batch.vo.BatchContactVO;
import com.gsitm.mail.EmailSender;
import com.gsitm.mail.vo.EmailVO;
import com.gsitm.reserv.service.ReservService;
import com.gsitm.reserv.vo.RoomVO;
import com.gsitm.roommanage.service.ManageService;
import com.gsitm.roommanage.vo.ConfVO;
import com.gsitm.roommanage.vo.ImgVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.velocity.tools.generic.DateTool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 허빛찬샘
 * @programName : MainController.java
 * @date : 2018-06-08
 * @function : 메인 페이지
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘 2018-06-08   초안 작성
 * 이창주   2018-06-17   메인 예약가능 리스트 뿌리기
 */
@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Resource(name = "reservService")
    private ReservService reservService;

    @Resource(name = "manageService")
    private ManageService manageService;

    @Autowired(required = true)
    private EmailSender emailSender;

    /**
     * @methodName : detailRoom
     * @author : 허빛찬샘, 이창주
     * @date : 2018-06-08
     * @function : 메인 웹 크롤링, 현제 시간 기반 예약 안잡힌 회의실 리스트 불러오기
     * ${tags}
     */
    @RequestMapping(value = "/main.do", method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                             ModelAndView mv) throws Exception {
        Document doc = Jsoup.connect("https://gsitm.com/news").get();
        Elements hotNews = doc.select(".view-content");
        Elements body = hotNews.select(".title-inner");
        Elements img = hotNews.select(".view-image img");
        List<HashMap<String, String>> textList = new ArrayList<>();

        for (int i = 0; i < body.size(); i++) {
            HashMap<String, String> textMap = new HashMap<>();
            textMap.put("text", body.get(i).text());
            textMap.put("img", img.get(i).getElementsByAttribute("src").attr("src"));
            textList.add(textMap);
        }

        //현제 시간 기반 예약 안잡힌 회의실 리스트 불러오기
        List<RoomVO> roomList = reservService.getPosRoom();
        logger.info("roomList: " + roomList);
        logger.info("roomList: " + roomList.size());
        mv.addObject("roomList", roomList);
        mv.addObject("roomCnt", roomList.size());

        mv.addObject("textList", textList);
        mv.addObject("news", hotNews.toString());
        mv.setViewName("/main");
        return mv;
    }

    /**
     * @param request
     * @param response
     * @param param
     * @param mv
     * @return
     * @methodName : index
     * @author : 허빛찬샘
     * @date : 2018. 6. 20.
     * @function : 빈 index 페이지
     */
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                              ModelAndView mv) {
        mv.setViewName("/blank");
        return mv;
    }


    /**
     * @methodName : detailRoom
     * @author : 이창주
     * @date : 2018-06-08
     * @function : 회의실 상세 페이지(예약하기)
     */
    @RequestMapping(value = "/detailRoom.do", method = RequestMethod.GET)
    public ModelAndView detailRoom(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                   ModelAndView mv, ConfVO confVO, ImgVO imgVO) {

        //회의실 번호 받고 해당 회의실 정보 받아와서 셋
        System.out.println("roomNogg : " + request.getParameter("roomNo"));
        String roomNo = request.getParameter("roomNo");
        try {
            confVO.setRoomNo(roomNo);
            ConfVO confInfo = manageService.detailList(confVO);
            System.out.println("confInfo : " + confInfo);
            imgVO.setRoomNo(roomNo);
            List<ImgVO> detailImgs = manageService.detailImgs(imgVO);
            System.out.println("imgs : " + detailImgs);
            mv.addObject("confInfo", confInfo);
            mv.addObject("detailImgs", detailImgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("/detailRoom");
        return mv;
    }

    /**
     * @return
     * @methodName : contact
     * @author : 허빛찬샘
     * @date : 2018. 6. 20.
     * @function : contact 페이지 view
     */
    @RequestMapping(value = "/contact.do", method = RequestMethod.GET)
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/contact");
        return mv;
    }

    /**
     * @param vo
     * @return
     * @methodName : sendEmail
     * @author : 허빛찬샘
     * @date : 2018. 6. 20.
     * @function : contact 내용 이메일 전송 메소드
     */
    @RequestMapping(value = "/sendEmail.do", method = RequestMethod.POST)
    public String sendEmail(BatchContactVO vo) {
        sendMailCancel(vo);
        return "redirect:contact.do";
    }

    /**
     * @param data
     * @methodName : sendMailCancel
     * @author : 허빛찬샘
     * @date : 2018. 6. 20.
     * @function : 이메일 처리 메소드
     */
    public void sendMailCancel(BatchContactVO data) {
        String title = "";      // 제목
        EmailVO email1 = new EmailVO();
        email1.setHtmlYn("Y");                              // html 형식으로 세팅
        email1.setFrom(data.getEmail());                    // 보내는 사람from
        email1.setReceiver("heobi@gsitm.com");              // 받는사람:가입유저
        title = "[contact 요청 메일]" + data.getTitle();
        email1.setSubject(title);                           // 메일 제목 properties 파일 참조
        email1.setVeloTemplate("mailContact.vm");           // 템플릿 파일명
        Map<String, Object> map = new HashMap<>();
        try {
            map = PropertyUtils.describe(data);
            map.put("title", title);
            map.put("date", new DateTool());
            email1.setEmailMap(map);
            emailSender.sendVelocityEmail(email1);           // 메일 전송
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
