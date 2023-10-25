package mail.assistance.library;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import mail.assistance.library.dto.Response;
import mail.assistance.library.utils.MailResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static jakarta.mail.Message.RecipientType.TO;

@Service
@Slf4j
public class MailAssistanceImpl implements MailAssistance {

    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    public MailResponseService response;

    /**
     * Create MImeMessage to be sent
     * @param receiver - Receiver's email address
     * @param subject - Mail subject
     * @param body - Mail Body
     * @return - MimeMessage
     * throws - MessagingException
     */
    private MimeMessage returnMimeMessage(@NonNull String sender, @NonNull String receiver, @NonNull String subject, @NonNull String body) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            message.setFrom(sender);
            message.setRecipients(TO, receiver);
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");

            return message;
        }catch (MessagingException e){
            return null;
        }
    }

    /**
     * Method for cheking if recipient email is valid
     * @param ex - MailSendException
     * @return - boolean value (TRUE for valid and FALSE for invalid
     */
    private boolean isThereExceptionForInvalidRecipientEmail(@NonNull MailSendException ex){
        for (Throwable exception : ex.getMessageExceptions()) {
            if (exception instanceof MessagingException) {
                MessagingException messagingException = (MessagingException) exception;
                if (messagingException.getNextException() != null) {
                    if (messagingException.getNextException() instanceof com.sun.mail.smtp.SMTPAddressFailedException) {
                        com.sun.mail.smtp.SMTPAddressFailedException smtpException = (com.sun.mail.smtp.SMTPAddressFailedException) messagingException.getNextException();
                        String errorMessage = smtpException.getMessage().toUpperCase();

                        if (errorMessage.contains("USER UNKNOWN")){
                            return Boolean.TRUE;
                        }
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    /**
     * Now sending mail
     * @param message - MimeMessage
     * @param receiver - Recipient's email
     * @return - Return response Object with status as Boolean and messages as String
     */
    private Response send(MimeMessage message, @NonNull String receiver){
        // send email
        try {
            javaMailSender.send(message);
            return response.success("Email sent to "+receiver);
        } catch (MailSendException ex) {
            if (this.isThereExceptionForInvalidRecipientEmail(ex)){
                log.info("Invalid Email address: {}", receiver);
                return response.failure("Invalid Email address: {}"+receiver);
            }
            log.info("Failed to send mail to {}: Exception: {}", receiver, ex.getMessage());
            return response.failure("Failed to send Email sent to "+receiver);
        }
    }

    /**
     * For sending mail to a single recipient
     * @param sender - Sender's email address
     * @param receiver - Receiver's email address
     * @param subject - Mail subject
     * @param body - Mail Body
     * @return - Return response Object with status as Boolean and messages as String
     * throws MessagingException - Handles exception while sending mail
     */
    public Response sendMail(@NonNull String sender, @NonNull String receiver, @NonNull String subject, @NonNull String body){
        MimeMessage message = this.returnMimeMessage(sender, receiver, subject, body);
        return this.send(message, receiver);
    }

    /**
     * For sending mail to a multiple recipients
     * @param sender - Sender's email address
     * @param receiverList - List of Receiver's email address
     * @param subject - Mail subject
     * @param body - Mail Body
     * @return - Return response Object with status as Boolean and messages as String
     */
    public List<Response> sendMail(@NonNull String sender, @NonNull List<String> receiverList, @NonNull String subject, @NonNull String body){
        List<Response> returnList = new ArrayList<>();
        receiverList.forEach(
                receiver ->
                        returnList.add(sendMail(sender, receiver, subject, body))
        );
        return returnList;
    }

}
