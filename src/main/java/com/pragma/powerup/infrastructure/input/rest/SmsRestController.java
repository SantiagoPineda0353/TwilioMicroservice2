package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.SendSmsRequestDto;
import com.pragma.powerup.application.handler.ISmsHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Enviar Sms al numero enviado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sms Enviado", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos del body incorrectos", content = @Content)
    })
    @PostMapping("/sms")
    public ResponseEntity<Void> sendSms(@RequestBody SendSmsRequestDto sendSmsRequestDto) {
        smsHandler.sendSms(sendSmsRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
