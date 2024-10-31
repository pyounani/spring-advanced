package pyounani.advanced.trace.callback;

import lombok.RequiredArgsConstructor;
import pyounani.advanced.trace.TraceStatus;
import pyounani.advanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace trace;

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
