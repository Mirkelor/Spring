package com.mirkelor.springdemo;

import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("sport.properties"),
        @PropertySource("coach.properties")
})
//@ComponentScan("com.mirkelor.springdemo")
class SportConfig {

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for our swim coach and inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }

}
