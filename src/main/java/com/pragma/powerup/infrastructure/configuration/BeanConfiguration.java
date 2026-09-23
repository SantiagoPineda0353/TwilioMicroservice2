package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.ISmsServicePort;
import com.pragma.powerup.domain.spi.*;
import com.pragma.powerup.domain.usecase.SmsUseCase;
import com.pragma.powerup.infrastructure.out.twilio.TwilioSmsAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    @Value("${twilio.from-number}")
    private String fromNumber;

    @Bean
    public ISmsSenderPort smsSenderPort(){
        return new TwilioSmsAdapter(fromNumber);
    }
    @Bean
    public ISmsServicePort smsServicePort() {
        return new SmsUseCase(smsSenderPort());
    }
}