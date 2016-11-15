# realcomp-data-annotations
Custom annotation support for realcomp-data

Provides two helpful annotations for your custom realcomp-data Converters and Validators.

@Converter

@Validator

When your class is annotated with one of these, and has a default no-arg constructor, realcomp-data will automatically register your Converter or Validator.

```java
import com.realcomp.data.conversion.StringConverter;

@Converter("exclamation")
public class AppendExclamation extends StringConverter{
    
    @Override
    public Object convert(Object value) throws ConversionException{
        return value == null ? null : value.toString().concat("!");
    }
}

```


Maven
```xml
<dependency>
    <groupId>com.realcomp.data</groupId>
    <artifactId>realcomp-data-annotations</artifactId>
    <version>0.0.3</version>
</dependency>
```


