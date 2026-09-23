package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.SendSmsRequestDto;

public interface ISmsHandler {
    void sendSms(SendSmsRequestDto sendSmsRequestDto);
}
