package com.realcomp.data.annotation;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for a realcomp-data Validator.
 *
 * The annotated class must have a default no-arg constructor.
 * The constructor requirement is enforced by a custom annotation processor.
 *
 * @author krenfro
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validator {

    /**
     * The name for the validator.  This name should be unique and will be used
     * for operations like schema serialization.
     *
     * @return the name for the validator.
     */
    String value();
}
