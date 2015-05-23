import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)

@Target({ElementType.METHOD})

public @interface Before {
    // what shall we do here
    // actually nothing!!!
    // for now... :D
}
