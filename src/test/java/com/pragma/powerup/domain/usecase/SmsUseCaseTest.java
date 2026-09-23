package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.exception.InvalidCellphoneException;
import com.pragma.powerup.domain.model.SmsModel;
import com.pragma.powerup.domain.spi.ISmsSenderPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SmsUseCaseTest {

    @Mock
    private ISmsSenderPort smsSenderPort;

    @InjectMocks
    private SmsUseCase smsUseCase;

    private SmsModel validSms;

    @BeforeEach
    void setUp(){
        validSms= new SmsModel("+5731231323212","Tu pedido está listo. Tu pin es: 434233");
    }

    @Test
    void sendSms_whenValidData_thenDelegateToSender(){
        smsUseCase.sendSms(validSms);
        verify(smsSenderPort).sendSms(validSms);
    }

    @Test
    void sendSms_whenPhoneNumberIsNull_thenThrowsException(){
        validSms.setToPhoneNumber(null);
        assertThrows(InvalidCellphoneException.class, () ->smsUseCase.sendSms(validSms));
        verify(smsSenderPort, never()).sendSms(validSms);
    }

    @Test
    void sendSms_whenPhoneNumberIsBlank_thenThrowsException(){
        validSms.setToPhoneNumber("   ");
        assertThrows(InvalidCellphoneException.class, () ->smsUseCase.sendSms(validSms));
        verify(smsSenderPort, never()).sendSms(validSms);
    }
}