package AnnotationClass;

/**
 * @author ChenZT
 */
public @interface MyAnnotation {
    String value() default "hello";
}
