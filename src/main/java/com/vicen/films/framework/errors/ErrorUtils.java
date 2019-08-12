package com.vicen.films.framework.errors;

import java.util.function.Function;

public class ErrorUtils {

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
            throw exceptionSupplier.apply(e);
        }
    }

}
