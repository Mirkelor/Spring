package com.mirkelor.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(code != null){
            result = code.startsWith(coursePrefix);
        } else {
            result = true;
        }
        return result;
    }

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }
}
