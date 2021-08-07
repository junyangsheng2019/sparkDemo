package com.sjy.spark.test.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shengjunyang created on 2021/8/7
 * @version v1.0
 */
@Configuration
public class ExecutorConfiguration {

        @Bean(value = "saveCrowdDataExecutor", destroyMethod = "shutdown")
        public ThreadPoolExecutor saveCrowdDataTaskPool() {
            //为了获取workQueue来判断当前任务是否饱和，故这里使用了ThreadPoolExecutor，而不是ThreadPoolTaskExecutor
            BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(10000);
            return new ThreadPoolExecutor(20, 20, 60, TimeUnit.SECONDS, workQueue,
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }

        @Bean(value = "delCrowdDataExecutor", destroyMethod = "shutdown")
        public ThreadPoolExecutor delCrowdDataTaskPool() {
            //为了获取workQueue来判断当前任务是否饱和，故这里使用了ThreadPoolExecutor，而不是ThreadPoolTaskExecutor
            BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(10000);
            return new ThreadPoolExecutor(20, 20, 60, TimeUnit.SECONDS, workQueue,
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }

        @Bean(value = "searchDeletedDataExecutor", destroyMethod = "shutdown")
        public ThreadPoolTaskExecutor searchDeletedDataTaskPool() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(20);
            executor.setMaxPoolSize(20);
            executor.setQueueCapacity(10000);
            return executor;
        }

        @Bean(value = "searchCrowdDataExecutor", destroyMethod = "shutdown")
        public ThreadPoolTaskExecutor searchCrowdDataTaskPool() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(20);
            executor.setMaxPoolSize(20);
            executor.setQueueCapacity(10000);
            return executor;
        }

        @Bean(value = "searchCrmUSPExecutor", destroyMethod = "shutdown")
        public ThreadPoolTaskExecutor searchCrmPoolTaskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(20);
            executor.setMaxPoolSize(20);
            executor.setQueueCapacity(10000);
            return executor;
        }

}
