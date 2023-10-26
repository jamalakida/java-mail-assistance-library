package mail.assistance.library;

import mail.assistance.library.dto.Response;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MailAssistance {

    /**
     * For sending mail to a single recipient
     * @param receiver - Receiver's email address
     * @param subject - Mail subject
     * @param body - Mail Body
     * @return - Return response Object with status as Boolean and messages as String
     * throws - MessagingException - Handles exception while sending mail
     */
    Response sendMail(String receiver, String subject, String body);

    /**
     * For sending mail to a multiple recipients
     * @param receiverList - List of Receiver's email address
     * @param subject - Mail subject
     * @param body - Mail Body
     * @return - Return response Object with status as Boolean and messages as String
     * throws - MessagingException - Handles exception while sending mail
     */
    List<Response> sendMail(List<String> receiverList, String subject, String body);
}
