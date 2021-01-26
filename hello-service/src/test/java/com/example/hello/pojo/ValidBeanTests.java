package com.example.hello.pojo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * ValidBeanTests
 *
 * @author Aaric, created on 2021-01-25T11:46.
 * @version 0.5.0-SNAPSHOT
 */
@Slf4j
public class ValidBeanTests {

    @Test
    public void testValid() {
        ValidBean validBean = new ValidBean();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ValidBean>> validateResult = validator.validate(validBean);
        if (0 != validateResult.size()) {
            Iterator<ConstraintViolation<ValidBean>> it = validateResult.iterator();
            while (it.hasNext()) {
                ConstraintViolation<ValidBean> result = it.next();
                log.info("testValid | {}={}, error={}", result.getPropertyPath(), result.getInvalidValue(), result.getMessage());
            }
        }
    }
}
