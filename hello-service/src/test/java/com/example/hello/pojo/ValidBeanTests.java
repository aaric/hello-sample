package com.example.hello.pojo;

import com.example.hello.validation.groups.Other;
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

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ValidBean>> validateResults = validator.validate(validBean);
        if (0 != validateResults.size()) {
            Iterator<ConstraintViolation<ValidBean>> it = validateResults.iterator();
            while (it.hasNext()) {
                ConstraintViolation<ValidBean> result = it.next();
                log.info("testValid | {}={}, error={}", result.getPropertyPath(),
                        result.getInvalidValue(), result.getMessage());
            }
        }
    }

    @Test
    public void testValidGroup() {
        ValidBean validBean = new ValidBean();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ValidBean>> validateResults = validator.validate(validBean, Other.class);
        validateResults.forEach(result -> {
            log.info("testValid | {}={}, error={}, level={}", result.getPropertyPath(),
                    result.getInvalidValue(), result.getMessage(),
                    result.getConstraintDescriptor().getPayload().toString());
        });
    }
}
