package com.gsitm.mail.vo;

import java.util.Map;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : 이창주
 * @programName : EmailVO.java
 * @date : 2018-06-14
 * @function : 메일 정보 VO
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-14   메일 정보 VO 완료
 */

@Data
public class EmailVO {

    @Getter
    @Setter
    private String subject;                         // 제목
    @Getter
    @Setter
    private String content;                         // 내용
    @Getter
    @Setter
    private String receiver;                        // 받는사람
    @Getter
    @Setter
    private String htmlYn;                          // html 사용 여부
    @Getter
    @Setter
    private String from;                            // 보낸사람
    @Getter
    @Setter
    private String regUsr;                          // 등록자(로그에 사용하기 위함)
    @Getter
    @Setter
    private String veloTemplate;                    // Velocity 템플릿 파일
    @Getter
    @Setter
    private Map<String, Object> emailMap = null;    // velocity 에서 사용하기 위한 map 객체


}
