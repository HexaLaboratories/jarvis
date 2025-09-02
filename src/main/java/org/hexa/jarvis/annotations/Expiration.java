package org.hexa.jarvis.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Expiration {
    String value(); // Expected date/time in ISO format, e.g., "2025-08-04T00:00:00Z"
    String message() default "This code has expired. Please update it.";
}