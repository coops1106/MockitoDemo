package com.lv.demo;

import com.lv.elsewhere.CustomerCommunicationsService;
import com.lv.elsewhere.OtherInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeepForgottenPasswordAdaptorTest {

    private static final String STUB_EMAIL = "anakin.skywalker@lv.com";
    private static final String STUB_LINK = "link";

    public static final String INFO_LV_COM = "info@lv.com";
    public static final String LV = "LV=";
    public static final String PASSWORD_RESET = "Password Reset";
    public static final String LINK = "link";
    public static final String EMAIL_TEXT = "You silly billy, you forgot your password, here's a link {}";

    @InjectMocks
    ForgottenPasswordAdaptor uut;

    @Mock
    CustomerCommunicationsService customerCommunicationsService;

    @Mock
    OtherInformationService otherInformationService;

    @Before
    public void setUp() {
        when(otherInformationService.getLvEmailAddress()).thenReturn(INFO_LV_COM);
        when(otherInformationService.getLvName()).thenReturn(LV);
        when(otherInformationService.getForgottenPasswordEmailSubject()).thenReturn(PASSWORD_RESET);
        String passwordResetText = String.format(EMAIL_TEXT, LINK);
        when(otherInformationService.getForgottenPasswordEmailText(anyString())).thenReturn(passwordResetText);
    }

    @Test
    public void testSendCommunication() {
        ArgumentCaptor<ForgottenPasswordRequest> argumentCaptor = ArgumentCaptor.forClass(ForgottenPasswordRequest.class);
        uut.sendCommunication(STUB_EMAIL, STUB_LINK);
        verify(customerCommunicationsService, times(1)).sendCustomerCommunication(argumentCaptor.capture());  //Change

        ForgottenPasswordRequest forgottenPasswordRequest = argumentCaptor.getValue();

        assertEquals(INFO_LV_COM, forgottenPasswordRequest.getFromAddress());
        assertEquals(LV, forgottenPasswordRequest.getFromName());
        assertEquals(PASSWORD_RESET, forgottenPasswordRequest.getSubject());

        String passwordResetText = String.format(EMAIL_TEXT, LINK);
        assertEquals(passwordResetText, forgottenPasswordRequest.getText());
    }
}
