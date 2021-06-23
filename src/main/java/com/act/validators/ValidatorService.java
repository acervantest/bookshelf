package com.act.validators;

import com.act.exceptions.NullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
@Transactional
public class ValidatorService {

    @Autowired
    private Validator validator;

    public <T> void validate(T obj, Class<T> clazz) throws RuntimeException {

        if (obj == null) throw new NullException(clazz.getSimpleName() + " is missing in request");

        T objectCast = clazz.cast(obj);

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(objectCast);

        if(!constraintViolations.isEmpty()) throw new RuntimeException(buildConstraintViolationMessage(constraintViolations));
    }

    private <T> String buildConstraintViolationMessage(Set<ConstraintViolation<T>> constraintViolations){
        String message = "";

        for (ConstraintViolation<T> c : constraintViolations) {
            message += c.getMessage() + ", ";
        }

        return message;
    }
}
