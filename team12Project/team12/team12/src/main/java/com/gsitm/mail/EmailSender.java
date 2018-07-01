package com.gsitm.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.internet.MimeUtility;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.StringUtils;

import com.gsitm.mail.vo.EmailVO;
import com.gsitm.reserv.controller.ReservController;

/**
 * @author : 이창주
 * @programName : EmailSender.java
 * @date : 2018-06-14
 * @function : 메일 보내기
 * <p>
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 이창주   2018-06-14   메일 보내기 완료
 */
public class EmailSender {

    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    protected JavaMailSender javaMailSender;
    @Resource(name = "velocityEngine")
    VelocityEngine velocityEngine;

    /**
     * @methodName : sendVelocityEmail
     * @author : 이창주
     * @date : 2018-06-14
     * @function : html템플릿 사용한 이메일(Velocity 사용)
     * ${tags}
     */
    public void sendVelocityEmail(EmailVO email) {

        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {

            helper = new MimeMessageHelper(msg, false, "UTF-8");
            velocityEngine.addProperty("contentType", "text/html; charset=UTF-8");
            velocityEngine.addProperty("default.contentType", "UTF-8");
            velocityEngine.addProperty("input.encoding", "UTF-8");
            velocityEngine.addProperty("output.encoding", "UTF-8");
            String veloTemplate = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                    "templates/mail/" + email.getVeloTemplate(), "UTF-8", email.getEmailMap());

            helper.setSubject(email.getSubject());
            helper.setFrom(email.getFrom());
            helper.setTo(email.getReceiver());

            if (StringUtils.isEmpty(email.getHtmlYn()) == false && email.getHtmlYn().equals("Y")) {
                helper.setText(veloTemplate, true);
            } else {
                helper.setText(veloTemplate);
            }
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        try {
            msg.setHeader("Content-Type", "text/html; charset=UTF-8");
            javaMailSender.send(msg);
        } catch (MailException e) {
            logger.error("Email MailException...");
            logger.debug(e.getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
