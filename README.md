# prime-annotations
Custom annotation support for real-comp/prime

Provides two helpful annotations for your custom Prime Converters and Validators. When your class is annotated with one of these, and has a default no-arg constructor, Prime will automatically register your Converter or Validator.

## @Converter

```java
import com.realcomp.prime.conversion.StringConverter;
import com.realcomp.prime.conversion.ConversionException;
import com.realcomp.prime.annotation.Converter;

@Converter("exclamation")
public class AppendExclamation extends StringConverter{
    
    @Override
    public Object convert(Object value) throws ConversionException{
        return value == null ? null : value.toString().concat("!");
    }
}

```

## @Validator

```java
import com.realcomp.prime.validation.ValidationException;
import com.realcomp.prime.validation.field.DefaultFieldValididator;
import com.realcomp.prime.annotation.Validator;

@Validator("validateExclamation")
public class ExclamationValidator extends DefaultFieldValidator{
    
    @Override
    public void validate(Object value) throws ValidationException{
        if (value == null){
            throw new ValidationException("cannot validate null Object");
        }
        else if (!value.toString().endsWith("!")){
            throw new ValidationException(
                    "Value did not have an exclamation point!", value, getSeverity());
        }
    }
}

```


## Maven
```xml
<dependency>
    <groupId>com.real-comp</groupId>
    <artifactId>prime-annotations</artifactId>
    <version>0.0.4</version>
</dependency>
```


