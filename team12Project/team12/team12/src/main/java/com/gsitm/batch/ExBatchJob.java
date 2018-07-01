package com.gsitm.batch;


import com.gsitm.batch.service.BatchService;
import com.gsitm.batch.vo.BatchDeptVO;
import com.gsitm.mail.EmailSender;
import com.gsitm.mail.vo.EmailVO;
import com.gsitm.pay.vo.PayEmpVO;
import com.gsitm.pay.vo.ReservPayVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.velocity.tools.generic.DateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.internet.AddressException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author : 허빛찬샘
 * @programName : ExBatchJob.java
 * @date : 2018. 6. 07.
 * @function : 스케줄러를 담당하는 프로그램
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-07	초안 작성
 * 허빛찬샘	2018-06-15	이메일 기능 추가
 * 허빛찬샘	2018-06-16	20분전 자동 cancel 기능 추가
 * 허빛찬샘	2018-06-19	매달 1일 예산 추가 기능 완료
 */
@Component
public class ExBatchJob {

    private static final Logger logger = LoggerFactory.getLogger(ExBatchJob.class);

    @Autowired(required = true)
    private EmailSender emailSender;
    @Resource(name = "batchService")
    private BatchService batchService;

    /**
     * @param args
     * @throws AddressException
     */
    public static void main(String[] args) {
        ExBatchJob proc = new ExBatchJob();
        proc.autoPay();
        proc.autoCancel();
        proc.autoBudget();
    }

    /**
     * @param
     * @return
     * @methodName : autoPay
     * @author : 허빛찬샘
     * @date : 2018. 6. 18.
     * @function : 자동 결제
     */
    public void autoPay() {
        List<ReservPayVO> reservList = new ArrayList<>();
        List<BatchDeptVO> deptList = new ArrayList<>();
        int result = 0;

        //계산해줄 현재 date
        String data = Calendar.getInstance(Locale.KOREA).get(Calendar.YEAR)
                + String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.MONTH) + 1)
                + String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.DAY_OF_MONTH))
                + String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.HOUR_OF_DAY))
                + String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.MINUTE));
        reservList = batchService.reservList(data);
        for (ReservPayVO rvo : reservList) {
            deptList = batchService.deptList(rvo);
            for (BatchDeptVO dvo : deptList) {
                dvo.setPrice(rvo.getPrice() / deptList.size());
                result = batchService.reservMod(dvo);
            }
            rvo.setTeamCount(deptList.size());
        }
        if (result != 0) {
            for (ReservPayVO rvo : reservList) {
                String roles = "";
                rvo.setLastPrice(rvo.getPrice() / rvo.getTeamCount());
                if (rvo.getRoomKind().equals("conference")) {
                    roles = "ROLE_AM";
                } else if (rvo.getRoomKind().equals("education")) {
                    roles = "ROLE_EM";
                }
                List<PayEmpVO> managerList = batchService.masterView(roles);
                List<PayEmpVO> teamManagerList = batchService.teamManagerView(rvo);
                for (PayEmpVO vo : managerList) {
                    sendMailApproval(vo.getEmail(), rvo);
                }//end for
                for (PayEmpVO vo : teamManagerList) {
                    sendMailApproval(vo.getEmail(), rvo);
                }
            }
        }
    }

    /**
     * @param
     * @return
     * @methodName : autoCancel
     * @author : 허빛찬샘
     * @date : 2018. 6. 18.
     * @function : 자동 반려
     */
    public void autoCancel() {
        List<ReservPayVO> cancelList = new ArrayList<>();
        int result = 0;

        //계산해줄 현재 date
        String hour;
        //시간이 40분이면 00으로 초기화
        if (Calendar.getInstance(Locale.KOREA).get(Calendar.MINUTE) == 40) {
            hour = "00";
        } else {
            hour = String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.MINUTE) + 20);
        }
        String data = Calendar.getInstance(Locale.KOREA).get(Calendar.YEAR)
                + String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.MONTH) + 1)
                + String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.DAY_OF_MONTH))
                + String.format("%02d", Calendar.getInstance(Locale.KOREA).get(Calendar.HOUR_OF_DAY))
                + hour;

        cancelList = batchService.cancelList(data);
        for (ReservPayVO rvo : cancelList) {
            result = batchService.reservDel(rvo);
            if (result != 0) {
                sendMailCancel(rvo);
            }
        }

    }

    /**
     * @param
     * @return
     * @methodName : autoBudget
     * @author : 허빛찬샘
     * @date : 2018. 6. 18.
     * @function : 자동 예산 추가
     */
    public void autoBudget() {
        int result = 0;
        result = batchService.autoBudget();
        if (result == 0) {
            logger.debug("예산 update 실패");
        } else {
            logger.info("예산 update 성공");
        }
    }

    /**
     * @param email, data
     * @return
     * @methodName : sendMailApproval
     * @author : 허빛찬샘
     * @date : 2018. 6. 18.
     * @function : 승인 메일 보내기
     */
    public void sendMailApproval(String email, ReservPayVO data) {
        String title = "";      // 제목
        EmailVO email1 = new EmailVO();
        email1.setHtmlYn("Y");                           // html 형식으로 세팅
        email1.setFrom("IT1060@gmail.com");                   // from
        email1.setReceiver(email);  // 받는사람:가입유저
        title = "GS ITM 회의실 비용 처리 안내 메일";
        email1.setSubject(title);      // 메일 제목 properties 파일 참조
        email1.setVeloTemplate("mailApply.vm");        // 템플릿 파일명
        Map<String, Object> map = new HashMap<>();
        try

        {
            map = PropertyUtils.describe(data);
            map.put("title", title);
            map.put("date", new DateTool());
            email1.setEmailMap(map);
            emailSender.sendVelocityEmail(email1);           // 메일 전송
        } catch (IllegalAccessException | InvocationTargetException |
                NoSuchMethodException e)

        {
            e.printStackTrace();
        }

    }

    /**
     * @param data
     * @return
     * @methodName : sendMailCancel
     * @author : 허빛찬샘
     * @date : 2018. 6. 18.
     * @function : 반려 메일 보내기
     */
    public void sendMailCancel(ReservPayVO data) {
        String title = "";      // 제목
        EmailVO email1 = new EmailVO();
        email1.setHtmlYn("Y");                           // html 형식으로 세팅
        email1.setFrom("IT1060@gmail.com");                   // from
        email1.setReceiver(data.getEmail());  // 받는사람:가입유저
        title = "GS ITM 회의실 예약 취소 안내 메일";
        email1.setSubject(title);      // 메일 제목 properties 파일 참조
        email1.setVeloTemplate("mailApply.vm");        // 템플릿 파일명
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
