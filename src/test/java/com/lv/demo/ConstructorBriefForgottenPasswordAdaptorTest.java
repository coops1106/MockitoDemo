package com.lv.demo;

import com.lv.elsewhere.CustomerCommunicationsService;
import com.lv.elsewhere.OtherInformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConstructorBriefForgottenPasswordAdaptorTest {

    private static final String STUB_EMAIL = "anakin.skywalker@lv.com";
    private static final String STUB_LINK = "link";

    @InjectMocks
    ForgottenPasswordAdaptorWithConstructor uut;

    @Mock
    CustomerCommunicationsService customerCommunicationsService;

    @Mock
    OtherInformationService otherInformationService;

    /*@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }*/

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
