package com.aquamonitor.platform.u202111461.shared.domain.model.results;

public sealed interface Result<T> permits Result.Success, Result.Failure {

    record Success<T>(T value) implements Result<T> {}

    record Failure<T>(String messageKey, ErrorType errorType, Object... args) implements Result<T> {
        public Failure(String messageKey, ErrorType errorType) {
            this(messageKey, errorType, new Object);
        }
    }

    enum ErrorType {
        BAD_REQUEST, // 400
        CONFLICT,    // 409
        INTERNAL     // 500
    }

    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    static <T> Result<T> failure(String messageKey, ErrorType errorType, Object... args) {
        return new Failure<>(messageKey, errorType, args);
    }
}
