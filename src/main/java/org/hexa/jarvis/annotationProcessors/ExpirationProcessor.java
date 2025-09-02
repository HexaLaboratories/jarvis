package org.hexa.jarvis.annotationProcessors;

import org.hexa.jarvis.annotations.Expiration;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalUnit;
import java.util.Set;

@SupportedAnnotationTypes("org.hexa.jarvis.annotations.Expiration")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class ExpirationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Expiration.class)) {
            Expiration expiration = element.getAnnotation(Expiration.class);
            try {
                Instant expirationDate = Instant.parse(expiration.value());
                if (Instant.now().isAfter(expirationDate)) {
                    processingEnv.getMessager().printMessage(
                            Diagnostic.Kind.WARNING,
                            expiration.message(),
                            element
                    );
                } else if (Instant.now().isAfter(expirationDate.minus(Duration.ofDays(30)))) {
                    processingEnv.getMessager().printMessage(
                            Diagnostic.Kind.WARNING,
                            "This code is about to expire in " + Duration.between(Instant.now(), expirationDate).toDays() + " days. Please consider updating it soon.",
                            element
                    );
                }
            } catch (DateTimeParseException e) {
                processingEnv.getMessager().printMessage(
                        Diagnostic.Kind.ERROR,
                        "Invalid date format in @Expiration: " + expiration.value(),
                        element
                );
            }
        }
        return true;
    }
}