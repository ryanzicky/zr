package com.mashibing.disruptor.v1;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
    /**
     *
     * @param longEvent
     * @param l RingBuffer的序号
     * @param b 是否为最后一个元素
     * @throws Exception
     */
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
