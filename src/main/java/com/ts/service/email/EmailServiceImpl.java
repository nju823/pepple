package com.ts.service.email;

import com.ts.model.Email;
import com.ts.dto.ResponseDto;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class EmailServiceImpl implements EmailService {

    //发件人的邮箱和密码
    public static final String myEmailAccount = "exam_online@163.com";
    public static final String myEmailPassword = "zhouti0704";

    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static final String myEmailSMTPHost = "smtp.163.com";



    @Override
    public ResponseDto sendEmail(Email email){
        ResponseDto responseDto = new ResponseDto();
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        //根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log


        try {
            //创建一封邮件
            MimeMessage message = createMimeMessage(session, email);

            Transport transport = session.getTransport();          // 根据 Session 获取邮件传输对象
            transport.connect(myEmailAccount, myEmailPassword);

            System.out.println("connected successfully");

            //发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());

            //关闭连接
            transport.close();

            return responseDto.buildSuccess();

        } catch (Exception e) {
            e.printStackTrace();
            String exceptionMessage = "Exception:" + e.getCause().getClass() + "," + e.getCause().getMessage();
            return responseDto.buildFailure(exceptionMessage);
        }

    }

    @Override
    public ResponseDto sendEmailAsync(Email email) {
        SendEmailTask task=new SendEmailTask(email);
        Executor executor= Executors.newSingleThreadExecutor();
        executor.execute(task);
        return ResponseDto.buildSuccess();
    }


    /**
     * 创建只包含简单文本的邮件
     * @param session 和服务器交互的对话
     * @param email  邮件信息
     * @return
     */
    private static MimeMessage createMimeMessage(Session session, Email email){
        //创建一封邮件
        MimeMessage message = new MimeMessage(session);

        try {
            //设置发件人邮箱
            message.setFrom(new InternetAddress(myEmailAccount, "在线考试支持系统", "UTF-8"));

            //设置收件人邮箱
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email.getReceiveMail(), "XX用户", "UTF-8"));

            //设置邮件标题
            message.setSubject(email.getSubject(), "UTF-8");

            //设置邮件内容
            message.setContent(email.getContent(), "text/html;charset=UTF-8");

            //保存设置
            message.saveChanges();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return message;
    }


    /**
     * 异步发送邮件任务
     */
    class SendEmailTask implements Runnable{
        private Email email;

        private SendEmailTask(Email email){
            this.email=email;
        }

        @Override
        public void run() {
            EmailServiceImpl.this.sendEmail(email);
        }
    }


    public static void main (String[] args) {
        EmailServiceImpl emailServiceImpl = new EmailServiceImpl();
        ResponseDto r = emailServiceImpl.sendEmail(new Email().createNewEmail("1921762406@qq.com", "访问密码", "您的访问密码为：123123"));
        System.out.println(r.getSuccess());
    }
}
