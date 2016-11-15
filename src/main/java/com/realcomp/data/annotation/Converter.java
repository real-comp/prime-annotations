package com.realcomp.data.annotation;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker for a converter.  When used, the class must have a default no-arg constructor.
 * The constructor requirement is enforced by a custom annotation processor.
 *
 * @author krenfro
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Converter {

    /**
     * @return the name for the coverter. Used in xml serialization.
     */
    String value();
}
