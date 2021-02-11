package com.hcl.userAuthentication;

import com.hcl.userAuthentication.models.UserEntity;
import com.hcl.userAuthentication.repositories.UserRepository;
import com.hcl.userAuthentication.services.LoginService;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserAuthenticationTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @TestConfiguration
    static class UserAuthenticationTestsConfiguration {
        @Bean
        public LoginService loginService() {
            return new LoginService();
        }
    }

    @Test
    public void findByUsernameTest() {
        // given
        UserEntity testUser = new UserEntity();
        testUser.setUsername("test");
        testUser.setPassword("test");

        loginService.addUser(testUser);

        // when
        UserEntity found = loginService.getUserByUsername(testUser.getUsername());

        // then
        assertEquals(found.getUsername(), testUser.getUsername());
    }

    @Test
    public void userNotNullTest() {
        UserEntity nullUser = null;

        boolean addUser = loginService.addUser(nullUser);

        assertFalse(addUser);
    }

    @Test
    public void successfulNewUser() {
        UserEntity testUser = new UserEntity();
        testUser.setUsername("test");
        testUser.setPassword("test");

        boolean newUser = loginService.addUser(testUser);

        assertTrue(newUser);
    }

    @Test
    public void validateUserTest() {
        UserEntity testUser = new UserEntity();
        testUser.setUsername("test");
        testUser.setPassword("test");

        loginService.addUser(testUser);

        boolean valid = loginService.validateUser(testUser, "test");

        assertTrue(valid);
    }
}
