package com.vicen.films.framework.errors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class ErrorUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorUtils.class);

    @FunctionalInterface
    public interface FallibleSupplier<R> {
        R get() throws Exception;
    }

    public static <S, T extends Exception> S rethrow(
            FallibleSupplier<S> executableBlock,
            Function<Throwable, ApplicationError> exceptionSupplier
    ) {
        try {
            return executableBlock.get();
        } catch (Throwable e) {
            LOGGER.error("Rethrowing error: ", e);
            throw exceptionSupplier.apply(e);
        }
    }

}
