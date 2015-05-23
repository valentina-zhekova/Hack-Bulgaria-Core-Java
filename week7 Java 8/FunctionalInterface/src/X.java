import java.util.concurrent.Callable;
import java.util.function.Function;

@FunctionalInterface
public interface X {
    Function<?, ?> meaninglessMethod();
}
