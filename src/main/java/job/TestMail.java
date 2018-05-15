package job;


import org.apache.commons.lang.ArrayUtils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by xiaoyue26 on 17/12/6.
 */
public class TestMail {
    public static final String SMTP_HOST = "smtp.exmail.qq.com";
    public static final int SMTP_PORT = 25;
    public static final String USER = "no-reply@fenbi.com";
    public static final String PASSWORD = "xxx";

    public static void sendMessage(String from, String[] to,
                                   String subject, String messageText)
            throws javax.mail.MessagingException, java.io.UnsupportedEncodingException {

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.transport.protocol", "smtp");
        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(false);

        InternetAddress fromAddress = new InternetAddress(from);
        if (ArrayUtils.isEmpty(to)) {
            return;
        }
        InternetAddress[] toAddresses = new InternetAddress[to.length];
        for (int i = 0; i < to.length; i++) {
            toAddresses[i] = new InternetAddress(to[i]);
        }
        MimeMessage testMessage = new MimeMessage(mailSession);
        testMessage.setFrom(fromAddress);
        testMessage.addRecipients(javax.mail.Message.RecipientType.TO, toAddresses);
        testMessage.setSentDate(new java.util.Date());
        testMessage.setSubject(MimeUtility.encodeText(subject, "utf8", "B"));

        testMessage.setContent(messageText, "text/html;charset=utf8");

        Transport transport = mailSession.getTransport("smtp");
        transport.connect(SMTP_HOST, USER, PASSWORD);
        try {
            transport.sendMessage(testMessage, testMessage.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        transport.close();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
        sendMessage("devil@fenbi.com",
                new String[]{"fengmq01@fenbi.com"}, "subject", "content");


    }
}
