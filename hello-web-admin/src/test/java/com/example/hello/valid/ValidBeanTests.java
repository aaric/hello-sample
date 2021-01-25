package com.example.hello.valid;

import com.example.hello.pojo.ValidBean;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * ValidBeanTests
 *
 * @author Aaric, created on 2021-01-25T11:46.
 * @version 0.5.0-SNAPSHOT
 */
public class ValidBeanTests {

    @Test
    public void testValid() {
        ValidBean validBean = new ValidBean();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ValidBean>> validateResult = validator.validate(validBean);
        System.err.println(validateResult);
    }
}
