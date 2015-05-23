import java.lang.annotation.Annotation;

public class MainClass {
    public static void main(String[] args) {
        AnnotatedClass someInstance = new AnnotatedClass();
        Annotation[] annotations = someInstance.getClass().getAnnotations();
        for (Annotation a: annotations) 
            System.out.println(a);
        
        Annotation something = someInstance.getClass().getAnnotation(ClassInfo.class);
        System.out.println(something.annotationType().cast(ClassInfo.class)); // 0.o ?
    }
}
