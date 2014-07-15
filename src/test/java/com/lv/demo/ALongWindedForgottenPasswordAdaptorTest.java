package com.lv.demo;

import com.lv.elsewhere.CustomerCommunicationsService;
import com.lv.elsewhere.OtherInformationService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ALongWindedForgottenPasswordAdaptorTest {

    private static final String STUB_EMAIL = "anakin.skywalker@lv.com";
    private static final String STUB_LINK = "link";

    private OtherInformationService otherInformationService;
    private CustomerCommunicationsService customerCommunicationsService;

    private ForgottenPasswordAdaptor uut = new ForgottenPasswordAdaptor();

    @Before
    public void setUp() {
        otherInformationService = mock(OtherInformationService.class);
        uut.setOtherInformationService(otherInformationService);

        customerCommunicationsService = mock(CustomerCommunicationsService.class);
        uut.setCustomerCommunicationsService(customerCommunicationsService);
    }

    @Test
    public void testSendCommunication() {
        uut.sendCommunication(STUB_EMAIL, STUB_LINK);

        verify(customerCommunicationsService, times(1)).sendCustomerCommunication(any(ForgottenPasswordRequest.class));
        verify(otherInformationService, times(1)).getForgottenPasswordEmailSubject();
        verify(otherInformationService, times(1)).getForgottenPasswordEmailText(anyString());
        verify(otherInformationService, times(1)).getLvEmailAddress();
        verify(otherInformationService, times(1)).getLvName();
    }
}
