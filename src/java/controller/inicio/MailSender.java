
package controller.inicio;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
    private final Properties properties = new Properties();
    private Session session;

    private void init() {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.mail.sender", "por_salon@hotmail.com");
        properties.put("mail.smtp.password", "ivan1234");
        properties.put("mail.smtp.user", "por_salon@hotmail.com");
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }
    public void send(String destino, String asunto, String mensaje) {
        init();
        try {
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
           message.setSubject(asunto);
           message.setContent(mensaje,"text/html");
           Transport t = session.getTransport("smtp");
           t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
           t.sendMessage(message, message.getAllRecipients());
           t.close();
        } catch (MessagingException e) {
          return;
        }
    }

    public void send(String destino, String asunto, String mensaje, String nombre_archivo, String ruta_archivo) {
        init();
        try {
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
           message.setSubject(asunto);
           BodyPart messageBodyPart = new MimeBodyPart();
           messageBodyPart.setText(mensaje);
           Multipart multipart = new MimeMultipart();
           multipart.addBodyPart(messageBodyPart);
           messageBodyPart = new MimeBodyPart();
           String filename = ruta_archivo;
           DataSource source = new FileDataSource(filename);
           messageBodyPart.setDataHandler(new DataHandler(source));
           messageBodyPart.setFileName(nombre_archivo);
           multipart.addBodyPart(messageBodyPart);
           message.setContent(multipart);
           Transport t = session.getTransport("smtp");
           t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
           t.sendMessage(message, message.getAllRecipients());
           t.close();
        } catch (MessagingException e) {
           return;
        }
    } 
}