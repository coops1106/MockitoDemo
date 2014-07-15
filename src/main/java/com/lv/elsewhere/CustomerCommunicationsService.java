package com.lv.elsewhere;

import com.lv.demo.ForgottenPasswordRequest;

public interface CustomerCommunicationsService {
    public void sendCustomerCommunication(final ForgottenPasswordRequest forgottenPasswordRequest);
}
