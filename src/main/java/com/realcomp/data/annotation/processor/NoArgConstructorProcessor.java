package com.realcomp.data.annotation.processor;

import com.realcomp.data.annotation.Validator;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

/**
 * Enforces that all classes with the supported annotations have a default public (empty)
 * constructor.
 *
 *
 * @see http://stackoverflow.com/questions/1759457/require-a-default-constructor-in-java
 * @author krenfro
 */
@SupportedAnnotationTypes(
    value={
        "com.realcomp.data.annotation.Validator",
        "com.realcomp.data.annotation.Converter"})
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class NoArgConstructorProcessor extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment re){
        for (TypeElement type : ElementFilter.typesIn(re.getRootElements())) {
            if (requiresDefaultConstructor(type))
                checkForDefaultConstructor(type);
        }
        return false;
    }

    private void checkForDefaultConstructor(TypeElement type) {
        for (ExecutableElement cons :
            ElementFilter.constructorsIn(type.getEnclosedElements())) {
            if (cons.getParameters().isEmpty())
                return;
        }

        // Couldn't find any default constructor here
        processingEnv.getMessager().printMessage(
                Diagnostic.Kind.ERROR,
                "Must have a public default (no argument) constructor.",
                type);
    }

    private boolean requiresDefaultConstructor(TypeElement type) {
        // sample: require any Validator to have a default constructor
        return type.getAnnotation(Validator.class) != null;
    }

}
