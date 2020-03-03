package com.example.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.PARAMETER)
public @interface ParameterValid {
    Class<?> type();

    String msg();

    boolean request() default true;

    boolean isEmpty() default true;

    boolean isBlank() default true;

    boolean isNull() default false;

    int min() default 0;
    int max() default 0;
    int[] section() default {0,0};
    boolean isMin() default false;
    boolean isMax() default false;
    boolean isSection() default false;
}