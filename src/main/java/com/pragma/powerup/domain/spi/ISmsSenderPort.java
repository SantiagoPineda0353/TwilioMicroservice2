package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.SmsModel;

public interface ISmsSenderPort {
    void sendSms(SmsModel smsModel);
}
