package skeleton;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hnpc on 11/30/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface SkipWrapperObject {
    String value();
}