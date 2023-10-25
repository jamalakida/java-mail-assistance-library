package mail.assistance.library.bean;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation that is used to call MailAssistanceAutoConfiguration far scanning root package
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MailAssistanceAutoConfiguration.class)
public @interface EnableMailAssistance {
}
