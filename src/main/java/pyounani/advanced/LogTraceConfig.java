package pyounani.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pyounani.advanced.trace.logtrace.FieldLogTrace;
import pyounani.advanced.trace.logtrace.LogTrace;
import pyounani.advanced.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        //return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
