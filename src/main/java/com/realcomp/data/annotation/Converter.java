package com.realcomp.data.annotation;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Marker annotation for a realcomp-data Converter.</p>
 *
 * The annotated class must have a default no-arg constructor.
 * The constructor requirement is enforced by a custom annotation processor.
 *
 * @author krenfro
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Converter {

    /**
     * The name for the converter.  This name should be unique and will be used
     * for operations like schema serialization.
     *
     * @return the name for the converter.
     */
    String value();
}
