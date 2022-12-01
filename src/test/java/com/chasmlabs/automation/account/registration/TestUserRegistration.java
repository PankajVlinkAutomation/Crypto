package com.chasmlabs.automation.account.registration;

import com.chasmlabs.automation.controller.account.registraction.RegistrationManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TestUserRegistration {

    @Test
    @DisplayName("Test case of Failed scenario for User attempts to register with an IP Address outside of the United States")
    void userRegistrationTest_TC01(){
        RegistrationManager registrationManager = new RegistrationManager("registration/userRegistrationRequestWithInvalidIPAddress.json");
        var responseManager = registrationManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }


}
