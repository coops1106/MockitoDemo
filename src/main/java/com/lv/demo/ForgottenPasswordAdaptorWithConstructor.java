package com.lv.demo;

import com.lv.elsewhere.CustomerCommunicationsService;
import com.lv.elsewhere.OtherInformationService;

public class ForgottenPasswordAdaptorWithConstructor {

    private CustomerCommunicationsService customerCommunicationsService;
    private OtherInformationService otherInformationService;

    public ForgottenPasswordAdaptorWithConstructor(final CustomerCommunicationsService customerCommunicationsService) {
        this.customerCommunicationsService = customerCommunicationsService;
    }

    public void sendCommunication(final String customerEmailAddress, final String resetLink) {
        ForgottenPasswordRequest forgottenPasswordRequest = new ForgottenPasswordRequest();
        forgottenPasswordRequest.setEmailAddress(customerEmailAddress);

        forgottenPasswordRequest.setFromAddress(otherInformationService.getLvEmailAddress());
        forgottenPasswordRequest.setFromName(otherInformationService.getLvName());
        forgottenPasswordRequest.setSubject(otherInformationService.getForgottenPasswordEmailSubject());
        forgottenPasswordRequest.setText(otherInformationService.getForgottenPasswordEmailText(resetLink));

        customerCommunicationsService.sendCustomerCommunication(forgottenPasswordRequest);
    }

    public void setOtherInformationService(final OtherInformationService otherInformationService) {
        this.otherInformationService = otherInformationService;
    }
}
