package validations;

public @interface Email {
    String message() default "Invalid email";
}
