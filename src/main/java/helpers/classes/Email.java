package helpers.classes;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.FileDataSource;

public class Email {
    private final Properties props;

    public Email(){
        props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        props.put("from", "grupocuatro85@gmail.com");
        props.put("username", "grupocuatro85@gmail.com");
        props.put("password", "8eqtK6sc5eTmNU!");
    }

    @SuppressWarnings("restriction")
    public void enviar(String to, String subject, String content) throws MessagingException{
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
            }
        });

        Message message = new MimeMessage(session);
        BodyPart text = new MimeBodyPart();
        text.setText(content);
        BodyPart adjunto = new MimeBodyPart();
        //Digitaremos la ruta del documento
        adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/Users/Dany/Documents/SOLID Project/Airport-of-Yeet/example.xlsx")));
        adjunto.setFileName("example.xlsx"); //Aqui va el nombre del archivo
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(text);
        m.addBodyPart(adjunto);


        message.setFrom(new InternetAddress(props.getProperty("from")));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setContent(m);
        Transport.send(message);

        System.out.println("Mensaje enviado");

    }

    /*
    public static void main(String[] args) throws MessagingException{
        Email e = new Email();
        e.enviar("jordystalin12@outlook.com", "Prueba 3", "Ya con esto ya queda");
    }*/

}