package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.ISmsServicePort;;
import com.pragma.powerup.domain.exception.InvalidCellphoneException;
import com.pragma.powerup.domain.model.SmsModel;
import com.pragma.powerup.domain.spi.ISmsSenderPort;

public class SmsUseCase implements ISmsServicePort {

    private final ISmsSenderPort smsSenderPort;

    public SmsUseCase(ISmsSenderPort smsSenderPort) {
        this.smsSenderPort=smsSenderPort;
    }

    @Override
    public void sendSms(SmsModel smsModel) {
        if(smsModel.getToPhoneNumber()==null || smsModel.getToPhoneNumber().isBlank()){
            throw new InvalidCellphoneException();
        }
        smsSenderPort.sendSms(smsModel);
    }
}
