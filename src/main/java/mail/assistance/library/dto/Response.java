package mail.assistance.library.dto;

import java.io.Serializable;

public record Response(Boolean error, String message) implements Serializable {
}
