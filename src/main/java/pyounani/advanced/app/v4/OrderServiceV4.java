package pyounani.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pyounani.advanced.app.v3.OrderRepositoryV3;
import pyounani.advanced.trace.TraceId;
import pyounani.advanced.trace.TraceStatus;
import pyounani.advanced.trace.logtrace.LogTrace;
import pyounani.advanced.trace.template.AbstractTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {

            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem()");
    }
}
