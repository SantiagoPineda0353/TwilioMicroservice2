package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.SendSmsRequestDto;
import com.pragma.powerup.application.handler.ISmsHandler;
import com.pragma.powerup.application.mapper.ISmsRequestMapper;
import com.pragma.powerup.domain.api.ISmsServicePort;
import com.pragma.powerup.domain.model.SmsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsHandler implements ISmsHandler {
    private final ISmsServicePort smsServicePort;
    private final ISmsRequestMapper smsRequestMapper;

    @Override
    public void sendSms(SendSmsRequestDto sendSmsRequestDto) {
        SmsModel smsModel=smsRequestMapper.toSms(sendSmsRequestDto);
        smsServicePort.sendSms(smsModel);
    }
}

