package app.wiper.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
public class TaskSchedulerConfiguration
{
    @Bean
    public TaskScheduler taskScheduler()
    {
        return new ConcurrentTaskScheduler(); //single threaded by default
    }
}
