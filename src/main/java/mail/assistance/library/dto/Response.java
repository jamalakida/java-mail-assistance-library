package mail.assistance.library.dto;

import java.io.Serializable;

/**
 * Response Dto
 * @param error - Boolean value(true or false)
 * @param message - message as string
 */
public record Response(Boolean error, String message) implements Serializable {
}
