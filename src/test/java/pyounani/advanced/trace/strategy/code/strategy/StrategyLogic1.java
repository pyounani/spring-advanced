package pyounani.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;
import pyounani.advanced.trace.strategy.code.Strategy;

@Slf4j
public class StrategyLogic1 implements Strategy {

    @Override
    public void call() {
        log.info("비즈니스 로직1 실행");
    }
}
