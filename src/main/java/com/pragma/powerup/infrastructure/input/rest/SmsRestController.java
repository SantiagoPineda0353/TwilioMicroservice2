package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.SendSmsRequestDto;
import com.pragma.powerup.application.handler.ISmsHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/messaging")
@RequiredArgsConstructor
public class SmsRestController {

    private final ISmsHandler smsHandler;

    @PostMapping("/sms")
    public ResponseEntity<Void> sendSms(@RequestBody SendSmsRequestDto sendSmsRequestDto) {
        smsHandler.sendSms(sendSmsRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
