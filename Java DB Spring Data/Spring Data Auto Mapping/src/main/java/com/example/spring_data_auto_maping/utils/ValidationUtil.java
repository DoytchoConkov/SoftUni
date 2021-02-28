package com.example.spring_data_auto_maping.utils;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {
    <T> boolean isValid(T entity);
    <T> Set<ConstraintViolation<T>> getViolations(T entity);
}
