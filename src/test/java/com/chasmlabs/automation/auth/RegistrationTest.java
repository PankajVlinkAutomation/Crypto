package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.RegistrationManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegistrationTest {

    @Test
    @DisplayName("Test case of success scenario for User attempts to register an user")
    void userRegistrationTest_TC01(){
        RegistrationManager registrationManager = new RegistrationManager("AuthModule/JSON/registration/RegistrationRequest.json");
        var responseManager = registrationManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }

}
