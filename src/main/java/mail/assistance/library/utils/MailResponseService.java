package mail.assistance.library.utils;

import lombok.extern.slf4j.Slf4j;
import mail.assistance.library.dto.Response;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class MailResponseService {
    /**
     *Function to be called to return success response
     * @param message passed argument
     * @return Response
     */
    public Response success(String message){
        return  new Response(false, message);
    }

    /**
     *Function to be called to return failure response
     * @param message passed argument
     * @return Response
     */
    public Response failure(String message){
        return  new Response(true, message);
    }
}
