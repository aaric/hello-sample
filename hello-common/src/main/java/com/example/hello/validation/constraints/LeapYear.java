package com.example.hello.validation.constraints;

import com.example.hello.validation.LeapYearValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 闰年校验
 *
 * @author Aaric, created on 2021-02-08T10:30.
 * @version 0.5.0-SNAPSHOT
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {LeapYearValidator.class})
public @interface LeapYear {

    String message() default "日期必须为闰年";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
