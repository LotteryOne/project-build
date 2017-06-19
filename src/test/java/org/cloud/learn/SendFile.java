package org.cloud.learn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * Created by tappe on 6/11/2017.
 */
public class SendFile {

    public static void main(String[] args) throws Exception {

        // t2();
        // BufferedReader br=new BufferedReader(new FileReader("target/file"));
        //
        // String line=null;
        // while((line=br.readLine())!=null){
        // System.out.println(line);
        // t2(line);
        // }

        // br.close();
        // String sc="C:/Users/BlueSky/Desktop/idea/ideaIC-2017.1.2.part01.rar";
        // System.out.println(sc.substring(sc.lastIndexOf("/")));

        String parent = "C:/Users/tappe/Downloads/aaa/";
        File fs = new File(parent);

        String[] fl = fs.list();

        for (String string : fl) {
            System.out.println(parent+string);
            t2(parent + string);
            System.out.println("=======end");

        }

    }

    public static void t1(String files) throws MessagingException, IOException {

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

		/*
		 * 也可以根据已有的eml邮件文件创建 MimeMessage 对象 MimeMessage message = new
		 * MimeMessage(session, new FileInputStream("MyEmail.eml"));
		 */

        // 2. From: 发件人
        // 其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        // 真正要发送时, 邮箱必须是真实有效的邮箱。

        message.setFrom(new InternetAddress("xuanfengshizi@163.com", "tappe", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("997413602@qq.com", "sun", "UTF-8"));
        message.setSubject("test", "UTF-8");
        message.setContent("this is content", "text/html;charset=UTF-8");
        message.setSentDate(new Date());

        message.saveChanges();

        OutputStream out = new FileOutputStream("MyEmail.eml");
        message.writeTo(out);
        out.flush();
        out.close();
    }

    public static void t2(String files) throws Exception {
        String myCount = "xuanfengshizi@163.com";
        String myPwd = "19900614sun";
        String mySMTPHost = "smtp.163.com";
        String receiveAccount = "sunzhongwen@fullgoalos.com.cn";

        Properties pops = new Properties();

        pops.setProperty("mail.transport.protocol", "smtp");
        pops.setProperty("mail.smtp.host", mySMTPHost);
        pops.setProperty("mail.stmp.auth", "true");

        // final String smtpPort = "465";
        // props.setProperty("mail.smtp.port", smtpPort);
        // props.setProperty("mail.smtp.socketFactory.class",
        // "javax.net.ssl.SSLSocketFactory");
        // props.setProperty("mail.smtp.socketFactory.fallback", "false");
        // props.setProperty("mail.smtp.socketFactory.port", smtpPort);

        Session session = Session.getInstance(pops);
//		session.setDebug(true);

        MimeMessage message = createMimeMessage(session, myCount, receiveAccount, files);

        Transport transport = session.getTransport();
        transport.connect(myCount, myPwd);

        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String files)
            throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "tappe", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "sun", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("test", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）

        Multipart multipart = new MimeMultipart();

        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText("123");
        bodyPart.setHeader("Content-Type", "text/html;charset=UTF-8");
        multipart.addBodyPart(bodyPart);

        File f = new File(files);

        MimeBodyPart filebody = new MimeBodyPart();

        FileDataSource source = new FileDataSource(f);

        filebody.setDataHandler(new DataHandler(source));
        filebody.setFileName(files.substring(files.lastIndexOf("/") + 1));
        multipart.addBodyPart(filebody);

        message.setContent("hahah", "text/html;charset=UTF-8");
        message.setContent(multipart);
        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
}

