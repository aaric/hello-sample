package com.example.hello.validation;

import com.example.hello.validation.constraints.LeapYear;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

/**
 * 闰年校验器
 *
 * @author Aaric, created on 2021-02-08T10:32.
 * @version 0.5.0-SNAPSHOT
 */
public class LeapYearValidator implements ConstraintValidator<LeapYear, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (null != value) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            if (0 == (cal.get(Calendar.YEAR) % 4)) {
                return true;
            }
        }
        return false;
    }
}
