package rpc;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email  {
   // private static String USER_NAME = "producttesting.shaochong";  // GMail user name (just the part before "@gmail.com")
   // private static String PASSWORD = "asDF12#$"; // GMail password
    //private static String RECIPIENT = "lizard.bill@myschool.edu";

//    public static void main(String[] args) {
//        String from = USER_NAME;
//        String pass = PASSWORD;
//        //String[] to = { RECIPIENT }; // list of recipient email addresses
//        String subject = "Java send mail example";
//        String body = "Welcome to JavaMail!";
//
//        sendFromGMail(from, pass, to, subject, body);
//    }

    

	

	public static void sendFromGMail(String receiver,String username) {
        System.out.println("I am inside email function!!!");
		Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "producttesting.shaochong");
        //props.put("mail.smtp.password", "asDF12#$");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        
        String body = "Hello from our Event Recommendation Website, your account name is " +username +" and have a great day! ";

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("producttesting.shaochong"));
            System.out.println("I am inside email function!!!22222");

//            InternetAddress[] toAddress = new InternetAddress[to.length];
//
//            // To get the array of addresses
//            for( int i = 0; i < to.length; i++ ) {
//                toAddress[i] = new InternetAddress(to[i]);
//            }
//
//            for( int i = 0; i < toAddress.length; i++) {
//                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
//            }
            message.setRecipients(Message.RecipientType.TO, receiver);
            message.setSubject("Account Info");
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "producttesting.shaochong", "asDF12#$");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}

