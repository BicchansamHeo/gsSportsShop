package com.gsitm.reserv.controller;

import com.google.gson.*;
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
 * @programName : ReservController.java
 * @date : 2018-06-08
 * @function : 예약 컨트롤러
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-08   초안 작성
 * 이창주   2018-06-09   예약에 필요한 정보 불러오기
 * 이창주   2018-06-10   예약에 필요한 정보 불러오기
 * 이창주   2018-06-11   예약에 필요한 정보 불러오기
 * 이창주   2018-06-12   예약 정보 저장
 * 이창주   2018-06-13   예약 정보 저장
 * 이창주   2018-06-14   예약 완료 메일 전송
 * 이창주   2018-06-15   예약 기능 완료
 */
@Controller
public class ReservController {
    private static final int NOTIFY = 1; //예약 완료 메일
    private static final int AUTH = 2;   //예약 승인 요청 메일
    private static final int PAY = 3;    //비용 결제 알림 메일


    private static final Logger logger = LoggerFactory.getLogger(ReservController.class);

    @Resource(name = "reservService")
    private ReservService reservService;

    @Autowired(required = true)
    private EmailSender emailSender;


    /**
     * @methodName :  reserv
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 정보 저장
     * ${tags}
     */
    @RequestMapping(value = "/reserv.do", method = RequestMethod.POST)
    public ModelAndView reserv(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                               ModelAndView mv) throws Exception {

        List<DeptVO> deptLists = reservService.readDeptList();
        List<SnackVO> snackLists = reservService.readSnackList();
        List<FixtureVO> fixtureLists = reservService.readFixtureList();
        List<String> reservData = new ArrayList<String>();
        String json = request.getParameter("reservData");
        JSONObject jsonObject = new JSONObject(json);
        String price = jsonObject.get("price").toString();
        String empNo = jsonObject.get("empNo").toString();
        String deptNo = reservService.getDept(empNo);
        Gson gson = new Gson();
        SnackVO[] snacks = gson.fromJson(jsonObject.getJSONArray("snackList").toString(), SnackVO[].class);
        List<SnackVO> snackList = Arrays.asList(snacks);
        for (SnackVO sn : snackList) {
            for (SnackVO sn2 : snackLists) {
                if (sn.getSnackNo().equals(sn2.getSnackNo())) {
                    sn.setSnackName(sn2.getSnackName());
                    break;
                }
            }
        }
        FixtureVO[] fixs = gson.fromJson(jsonObject.getJSONArray("fixtureList").toString(), FixtureVO[].class);
        List<FixtureVO> fixtureList = Arrays.asList(fixs);
        for (FixtureVO fx : fixtureList) {
            for (FixtureVO fx2 : fixtureLists) {
                if (fx.getFixtureNo().equals(fx2.getFixtureNo())) {
                    fx.setFixtureName(fx2.getFixtureName());
                    break;
                }
            }
        }
        EmpVO[] emps = gson.fromJson(jsonObject.getJSONArray("empList").toString(), EmpVO[].class);
        List<EmpVO> empList = new ArrayList<>(Arrays.asList(emps));
        EmpVO orderEmp = new EmpVO();
        orderEmp.setEmpNo(empNo);
        orderEmp.setDeptNo(deptNo);
        empList.add(0, orderEmp);
        for (EmpVO emp : empList) {
            for (DeptVO dpt : deptLists) {
                if (emp.getDeptNo().equals(dpt.getDeptNo())) {
                    emp.setDeptName(dpt.getDeptName());
                    break;
                }
            }
        }
        DeptVO[] depts = gson.fromJson(jsonObject.getJSONArray("deptList").toString(), DeptVO[].class);
        List<DeptVO> deptList = new ArrayList<>(Arrays.asList(depts));
        boolean flag = true;
        for (DeptVO dept : deptList) {
            if (dept.getDeptNo().equals(deptNo)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            DeptVO orderDept = new DeptVO();
            orderDept.setDeptNo(deptNo);
            deptList.add(0, orderDept);
        }
        for (DeptVO dept : deptList) {
            for (DeptVO dpt : deptLists) {
                if (dept.getDeptNo().equals(dpt.getDeptNo())) {
                    dept.setDeptName(dpt.getDeptName());
                    break;
                }
            }
        }
        OutVO[] outs = gson.fromJson(jsonObject.getJSONArray("outList").toString(), OutVO[].class);
        List<OutVO> outList = Arrays.asList(outs);
        String date_s = jsonObject.get("selectDate").toString() + " " + jsonObject.get("start").toString();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy. MM. dd. HH:mm");
        SimpleDateFormat dtM = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date sdate=null;
        if(date_s.indexOf("/") > -1) {
        	sdate = dtM.parse(date_s);
        }else {
        	sdate = dt.parse(date_s);
        }
        
        String date_e = jsonObject.get("selectDate2").toString() + " " + jsonObject.get("end").toString();
        Date edate=null;
        if(date_s.indexOf("/") > -1) {
        	edate = dtM.parse(date_e);
        }else {
        	edate = dt.parse(date_e);
        }
        
        ReservDataVO data = new ReservDataVO();
        data.setRoomNo(jsonObject.get("roomNo").toString());
        data.setSnackList(snackList);
        data.setFixtureList(fixtureList);
        data.setEmpList(empList);
        data.setDeptList(deptList);
        data.setStartDate(sdate);
        data.setEndDate(edate);
        data.setLongTermYn(jsonObject.get("longTermYn").toString());
        data.setReservContent(jsonObject.get("reservContent").toString()); //회의구분
        data.setReservContent2(jsonObject.get("reservContent2").toString()); //회의목적
        data.setRoomName(jsonObject.get("roomName").toString());
        data.setPrice(Integer.parseInt(price));
        data.setEmpNo(empNo);
        data.setOutList(outList);
        if (jsonObject.get("longTermYn").toString().equals("N")) {
            data.setApproval1("Y");
            data.setApproval21("Y");
            data.setApproval22("Y");
        } else {
            data.setApproval1("N");
            data.setApproval21("N");
            data.setApproval22("N");
        }
        reservService.saveReserv(data);
        Map map = new HashMap();
        map.put("data", data);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  getHollyday
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  공휴일 정보, 장기 예약 정보 받아오기
     * ${tags}
     */
    @RequestMapping(value = "/getHollyday.do", method = RequestMethod.GET)
    public ModelAndView getHollyday(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param
    ) {
        String roomNo = request.getParameter("roomNo");
        Map map = new HashMap();
        map.put("data", reservService.readList());
        map.put("data2", reservService.readLongList(roomNo));

        return new ModelAndView("jsonView", map);
    }


    /**
     * @methodName :  getReserved
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  해당 날짜 예약 내역 가져오기
     * ${tags}
     */
    @RequestMapping(value = "/getReserved.do", method = RequestMethod.GET)
    public ModelAndView getReserved(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                    ModelAndView mv, ReservVO rvVO) throws Exception {

        Map map = new HashMap();
        
        SimpleDateFormat dtM = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat dt2 = new SimpleDateFormat("yyyy. MM. dd.");
        String selectDate = request.getParameter("selectDate");
        
        //2018. 6. 21.
        //모바일 날짜 포맷 구분
        Date dateMobile;
        if(selectDate.indexOf("/") > -1) {
        	dateMobile = dtM.parse(selectDate);
        }else {
        	dateMobile = dt2.parse(selectDate);
        }
   
        
        selectDate=dt2.format(dateMobile);
        
        
        String roomNo = request.getParameter("roomNo");
        List<ReservVO> list = reservService.readResrved(selectDate, roomNo);
        for (ReservVO rv : list) {

            String date_s = rv.getStartDate();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = dt.parse(date_s);
            //시작시간 30분 추가 하기 (회의 준비 시간)
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MINUTE, -30);
            rv.setStartDate(dt.format(cal.getTime()));

            String date_e = rv.getEndDate();
            Date dateE = dt.parse(date_e);
            //시작시간 30분 추가 하기 (회의 준비 시간)
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(dateE);
            cal2.add(Calendar.MINUTE, 30);
            rv.setEndDate(dt.format(cal2.getTime()));
        }

        map.put("data", list);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  getTeam
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  팀목록 가져오기
     * ${tags}
     */
    @RequestMapping(value = "/getTeam.do", method = RequestMethod.GET)
    public ModelAndView getTeam(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                ModelAndView mv, DeptVO dptVO) {

        Map map = new HashMap();
        List<DeptVO> list = reservService.readDeptList();
        map.put("data", list);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  getMaxPeople
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  회의실 최대 수용인원 받아오기
     * ${tags}
     */
    @RequestMapping(value = "/getMaxPeople.do", method = RequestMethod.GET)
    public ModelAndView getMaxPeople(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                     ModelAndView mv, DeptVO dptVO) {

        String roomNo = request.getParameter("roomNo");
        Map map = new HashMap();
        int maxPeople = reservService.getMaxPeople(roomNo);
        map.put("data", maxPeople);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  getTeamEmp
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  팀원목록 가져오기
     * ${tags}
     */
    @RequestMapping(value = "/getTeamEmp.do", method = RequestMethod.POST)
    public ModelAndView getTeamEmp(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                   ModelAndView mv, EmpVO empVO) {

        List<String> teamList = new ArrayList<String>();
        String json = request.getParameter("teamList");
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            teamList.add(jsonObject.get("deptNo").toString());
        }
        Map map = new HashMap();
        List<EmpVO> list = reservService.readTeamEmp(teamList);
        map.put("data", list);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  getFixture
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  기자제 가져오기
     * ${tags}
     */
    @RequestMapping(value = "/getFixture.do", method = RequestMethod.GET)
    public ModelAndView getFixture(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                   ModelAndView mv) {

        String roomNo = request.getParameter("roomNo");
        Map map = new HashMap();
        List<FixtureVO> list = reservService.readFixture(roomNo);
        map.put("data", list);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  getSnack
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  간식 가져오기
     * ${tags}
     */
    @RequestMapping(value = "/getSnack.do", method = RequestMethod.GET)
    public ModelAndView getSnack(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                 ModelAndView mv) {

        String roomNo = request.getParameter("roomNo");
        Map map = new HashMap();
        List<SnackVO> list = reservService.readSnack(roomNo);
        map.put("data", list);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  getPrice
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  가격 정보 반환
     * ${tags}
     */
    @RequestMapping(value = "/getPrice.do", method = RequestMethod.POST)
    public ModelAndView getPrice(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                 ModelAndView mv) {

        String json = request.getParameter("reservData");
        JSONObject jsonObject = new JSONObject(json);
        String roomNo = jsonObject.get("roomNo").toString();
        Gson gson = new Gson();
        SnackVO[] snacks = gson.fromJson(jsonObject.getJSONArray("snackList").toString(), SnackVO[].class);
        List<SnackVO> snackList = Arrays.asList(snacks);
        FixtureVO[] fixs = gson.fromJson(jsonObject.getJSONArray("fixtureList").toString(), FixtureVO[].class);
        List<FixtureVO> fixtureList = Arrays.asList(fixs);
        int roomPrice = reservService.getRoomPrice(roomNo);
        int fixurePrice = 0;
        for (FixtureVO fix : fixtureList) {
            fixurePrice += reservService.getFixturePrice(fix.getFixtureNo()) * fix.getQuantity();
        }
        int snackPrice = 0;
        for (SnackVO snack : snackList) {
            snackPrice += reservService.getSnackPrice(snack.getSnackNo()) * snack.getQuantity();
        }
        Map map = new HashMap();
        map.put("data", roomPrice);
        map.put("data1", fixurePrice);
        map.put("data2", snackPrice);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  confirmReserv
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  예약 완료 화면
     * ${tags}
     */
    @RequestMapping(value = "/confirmReserv.do", method = RequestMethod.POST)
    public ModelAndView confirmReserv(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                      ModelAndView mv, DeptVO dptVO) {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        }).create();
        ReservDataVO reservDataVO = gson.fromJson(request.getParameter("data"), ReservDataVO.class);

        //roomNo로 교육실인지 회의실인지 확인하기
        String rommType = String.valueOf(reservDataVO.getRoomNo().charAt(0));
        //메일 보내기
        //장기 예약의 경우 회의실 -> 총무 담당자
        if (reservDataVO.getLongTermYn().equals("Y")) {
            if (rommType.equals("R")) {
                //회의실 장기예약 -> 팀장(여기서는 이것만) -> 회의실 담당자
                String managerEmail = reservService.getManagerEmail(reservDataVO.getEmpNo());
                sendMail(managerEmail, AUTH, reservDataVO);
                //회의 참여 인원에게 예약 알림 메일 ㄱㄱ
                for (EmpVO emp : reservDataVO.getEmpList()) {
                    sendMail(reservService.getEmail(emp.getEmpNo()), NOTIFY, reservDataVO);
                }
            } else {
                //교육실 장기예약
                String managerEmail = reservService.getManagerEmail(reservDataVO.getEmpNo());
                sendMail(managerEmail, AUTH, reservDataVO);
                //회의 참여 인원에게 예약 알림 메일 ㄱㄱ
                for (EmpVO emp : reservDataVO.getEmpList()) {
                    sendMail(reservService.getEmail(emp.getEmpNo()), NOTIFY, reservDataVO);
                }
            }
        } else {
            if (rommType.equals("R")) {
                //회의실 단기 예약 -> 회의 참여 인원에게 예약 알림 메일 ㄱㄱ
                for (EmpVO emp : reservDataVO.getEmpList()) {
                    sendMail(reservService.getEmail(emp.getEmpNo()), NOTIFY, reservDataVO);
                }
            } else {
                //교육실 단기 예약
                String managerEmail = reservService.getManagerEmail(reservDataVO.getEmpNo());
                sendMail(managerEmail, AUTH, reservDataVO);
                //회의 참여 인원에게 예약 알림 메일 ㄱㄱ
                for (EmpVO emp : reservDataVO.getEmpList()) {
                    sendMail(reservService.getEmail(emp.getEmpNo()), NOTIFY, reservDataVO);
                }
            }
        }

        mv.addObject("data", reservDataVO);
        mv.setViewName("/confirmReserv");
        return mv;
    }


    /**
     * @methodName :  getLongCheck
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  장기예약시 선택 범위에 있는 예약 개수 체크
     * ${tags}
     */
    @RequestMapping(value = "/getLongCheck.do", method = RequestMethod.POST)
    public ModelAndView getLongCheck(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                     ModelAndView mv) throws Exception {

        String json = request.getParameter("reservData");
        JSONObject jsonObject = new JSONObject(json);
        String sd = jsonObject.get("startDate").toString();
        String ed = jsonObject.get("endDate").toString();
        String roomNo = jsonObject.get("roomNo").toString();
        SimpleDateFormat dtM = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat dt2 = new SimpleDateFormat("yyyyy. MM. dd.");
        Date sd1=null;
        Date ed1=null;
        //모바일 날짜 포맷 구분
        if(sd.indexOf("/") > -1) {
        	sd1 = dtM.parse(sd);
            ed1 = dtM.parse(ed);
        }else {
        	sd1 = dt2.parse(sd);
            ed1 = dt2.parse(ed);
        }
        sd=dt2.format(sd1);
        ed=dt2.format(ed1);
        
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy. MM. dd. HH:mm");
        Date sdate = dt.parse(sd + " 00:00");
        Date edate = dt.parse(ed + " 24:00");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdate);
        cal.add(Calendar.DATE, 1);
        sdate = cal.getTime();
        cal.setTime(edate);
        cal.add(Calendar.DATE, -1);
        edate = cal.getTime();
        ReservDataVO rv = new ReservDataVO();
        rv.setStartDate(sdate);
        rv.setEndDate(edate);
        rv.setRoomNo(roomNo);
        int cnt = reservService.getLongCheck(rv);
        ReservDataVO rv2 = new ReservDataVO();
        rv2.setStartDate(sd1);
        rv2.setEndDate(ed1);
        int cnt2 = reservService.getHoliCnt(rv2);
        Map map = new HashMap();
        map.put("data", cnt);
        map.put("data2", cnt2);

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  extendReserv
     * @author :  이창주
     * @date :  2018-06-19
     * @function :  예약 연장
     * ${tags}
     */
    @RequestMapping(value = "/extendReserv.do", method = RequestMethod.GET)
    public String extendReserv(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                               ModelAndView mv) {

        String reservNo = request.getParameter("reservNo");
        String empNo = request.getParameter("empNo");
        logger.info("reservNo:: " + reservNo);
        int result = reservService.extendReserv(reservNo);

        return "redirect:/mypage.do?empNo=" + empNo + "&result=" + result;
    }


    /**
     * @methodName :  getRoomName
     * @author :  이창주
     * @date :  2018-06-15
     * @function :  회의실 이름 가져오기
     * ${tags}
     */
    @RequestMapping(value = "/getRoomName.do", method = RequestMethod.GET)
    public ModelAndView getRoomName(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                    ModelAndView mv) {

        String roomNo = request.getParameter("roomNo");
        Map map = new HashMap();
        String roomName = reservService.getRoomName(roomNo);
        map.put("data", roomName);

        return new ModelAndView("jsonView", map);
    }


    /**
     * @methodName :  searchEmp
     * @author :  이창주
     * @date :  2018-06-15
     * @function :  사원 검색
     * ${tags}
     */
    @RequestMapping(value = "/searchEmp.do", method = RequestMethod.GET)
    public ModelAndView searchEmp(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
                                  ModelAndView mv) {

        String empName = request.getParameter("empName");
        Map map = new HashMap();
        List<EmpVO> empList = reservService.searchEmp(empName);
        if (empList != null) {
            map.put("data", empList);
        } else {
            map.put("data", 0);
        }

        return new ModelAndView("jsonView", map);
    }

    /**
     * @methodName :  sendMail
     * @author     :  이창주
     * @date       :  2018-06-15
     * @function   :  메일 보내기
     * ${tags}
     */
    public void sendMail(String email, int sendType, ReservDataVO data) {
        //sendType
        ////NOTIFY = 1; //예약 완료 메일
        ////AUTH = 2;   //예약 승인 요청 메일
        ////PAY = 3;    //비용 결제 알림 메일
        String title = "";      // 제목
        EmailVO email1 = new EmailVO();
        email1.setHtmlYn("Y");                                  // html 형식으로 세팅
        email1.setFrom("IT1060@gmail.com");                     // from
        email1.setReceiver(email);                              // 받는사람
        if (sendType == 1) {
            title = "GS ITM 회의실 예약 내역 안내 메일";
        } else if (sendType == 2) {
            title = "GS ITM 회의실 예약 승인 요청 메일";
        } else {
            title = "GS ITM 회의실 이용 결제 내역 안내 메일";
        }
        email1.setSubject(title);                               // 메일 제목 properties 파일 참조
        email1.setVeloTemplate("mail.vm");                      // 템플릿 파일명
        Map<String, Object> map;
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
