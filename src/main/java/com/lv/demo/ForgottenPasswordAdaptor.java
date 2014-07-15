package com.lv.demo;

import com.lv.elsewhere.CustomerCommunicationsService;
import com.lv.elsewhere.OtherInformationService;

public class ForgottenPasswordAdaptor {

    private CustomerCommunicationsService customerCommunicationsService;
    private OtherInformationService otherInformationService;

    public void sendCommunication(final String customerEmailAddress, final String resetLink) {
        ForgottenPasswordRequest forgottenPasswordRequest = new ForgottenPasswordRequest();
        populatePasswordRequest(customerEmailAddress, resetLink, forgottenPasswordRequest);

        customerCommunicationsService.sendCustomerCommunication(forgottenPasswordRequest);
    }

    //How do we test this?
    private void populatePasswordRequest(final String customerEmailAddress, final String resetLink, final ForgottenPasswordRequest forgottenPasswordRequest) {
        forgottenPasswordRequest.setEmailAddress(customerEmailAddress);

        forgottenPasswordRequest.setFromAddress(otherInformationService.getLvEmailAddress());
        forgottenPasswordRequest.setFromName(otherInformationService.getLvName());
        forgottenPasswordRequest.setSubject(otherInformationService.getForgottenPasswordEmailSubject());
        forgottenPasswordRequest.setText(otherInformationService.getForgottenPasswordEmailText(resetLink));
    }

    public void setCustomerCommunicationsService(final CustomerCommunicationsService customerCommunicationsService) {
        this.customerCommunicationsService = customerCommunicationsService;
    }

    public void setOtherInformationService(final OtherInformationService otherInformationService) {
        this.otherInformationService = otherInformationService;
    }
}
