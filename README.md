# prime-annotations
Custom annotation support for real-comp/prime

Provides two helpful annotations for your custom Prime Converters and Validators. When your class is annotated with one of these, and has a default no-arg constructor, Prime will automatically register your Converter or Validator.

@Converter

@Validator


An @Converter example:
```java
import com.realcomp.prime.conversion.StringConverter;

@Converter("exclamation")
public class AppendExclamation extends StringConverter{
    
    @Override
    public Object convert(Object value) throws ConversionException{
        return value == null ? null : value.toString().concat("!");
    }
}

```


## Maven
```xml
<dependency>
    <groupId>com.realcomp.prime</groupId>
    <artifactId>prime-annotations</artifactId>
    <version>0.1.0</version>
</dependency>
```


