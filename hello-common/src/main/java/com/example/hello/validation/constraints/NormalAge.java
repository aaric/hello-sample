package com.example.hello.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 正常年龄校验
 *
 * @author Aaric, created on 2021-02-08T09:33.
 * @version 0.5.0-SNAPSHOT
 */
@Min(value = 1, message = "最小年龄为1岁")
@Max(value = 2, message = "最大年龄为120岁")
@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface NormalAge {

    String message() default "年龄必须介于1岁到120岁之间";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
