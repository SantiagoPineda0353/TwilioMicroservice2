package com.pragma.powerup.infrastructure.out.twilio;

import com.pragma.powerup.domain.model.SmsModel;
import com.pragma.powerup.domain.spi.ISmsSenderPort;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioSmsAdapter implements ISmsSenderPort {
    private final String fromNumber;

    public TwilioSmsAdapter(String fromNumber) {
        this.fromNumber = fromNumber;
    }

    @Override
    public void sendSms(SmsModel smsModel) {
        Message.creator(
                new PhoneNumber(smsModel.getToPhoneNumber()),
                new PhoneNumber(fromNumber),
                "sms_delivery_updates"
        ).create();
    }
}
