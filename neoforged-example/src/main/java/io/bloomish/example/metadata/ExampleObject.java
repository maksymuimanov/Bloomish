package io.bloomish.example.metadata;

import io.bloomish.api.bean.Bean;

@Bean
@ExampleAnnotation("Hello from Class")
public class ExampleObject {
    @ExampleAnnotation("Hello from Field")
    private String field;

    @ExampleAnnotation("Hello from Method")
    private void doSmth() {
    }
}
