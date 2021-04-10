package com.zr.javase.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @Author zhourui
 * @Date 2021/3/26 17:48
 */
public class CompletableFutureDemo {

    private static void completableFutureExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        assert cf.isDone();
        /*getNow(null)方法在future完成的情况下会返回结果，就比如下面这个例子，否则返回null(传入的参数)*/
        assert "message".equals(cf.getNow(null));
    }

    private static void runAsyncExample() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            assert Thread.currentThread().isDaemon();

        });
        assert cf.isDone();

        assert cf.isDone();
    }

    private static void thenApplyExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            assert Thread.currentThread().isDaemon();
            return s.toUpperCase();
        });

        assert "MESSAGE".equals(cf.getNow(null));

    }


}
