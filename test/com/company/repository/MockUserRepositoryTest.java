package com.company.repository;

import com.company.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MockUserRepositoryTest {
    private static MockUserRepository repository = new MockUserRepository();
    private static final User user1 = new User(1, "firstName1", "lastName1", "user1", "password1", "mail1@mail.com");
    private static final User user2 = new User(2, "firstName2", "lastName2", "user2", "password2", "mail2@mail.com");
    private static final User user3 = new User(3, "firstName3", "lastName3", "user3", "password3", "mail3@mail.com");

    @BeforeAll
    public static void init() {
        repository = new MockUserRepository();
    }

    @BeforeEach
    public void addTestUsers() {
        repository.add(user1);
        repository.add(user2);
        repository.add(user3);
    }

    @Test
    public void addUserToDatabase() {
        assertAll(
                () -> assertEquals("firstName1", repository.findById(1).getFirstName()),
                () -> assertEquals("firstName2", repository.findById(2).getFirstName()),
                () -> assertEquals("firstName3", repository.findById(3).getFirstName())
        );
    }

    @Test
    public void findUserById() {
        assertAll(
                () -> assertEquals(user1, repository.findById(1)),
                () -> assertEquals(user2, repository.findById(2)),
                () -> assertEquals(user3, repository.findById(3))
        );
    }

    @Test
    public void deleteUserFromDatabase() {
        repository.delete(user1);

        assertAll(
                () -> assertNull(repository.findById(1)),
                () -> assertEquals(user2, repository.findById(2)),
                () -> assertEquals(user3, repository.findById(3))
        );
    }

    @Test
    public void doesUserWithIdExist() {
        assertAll(
                () -> assertFalse(repository.exists(-1)),
                () -> assertTrue(repository.exists(1)),
                () -> assertTrue(repository.exists(2)),
                () -> assertTrue(repository.exists(3)),
                () -> assertFalse(repository.exists(4))
        );
    }

    @Test
    public void updateUserById() {
        final User user2Updated = new User(2, "firstName2", "lastName2", "newUser2", "newPassword2", "mail2@mail.com");
        final User user3Updated = new User(3, "firstName3", "lastName3", "newUser3", "newPassword3", "mail3@mail.com");

        repository.update(user2Updated);
        repository.update(user3Updated);

        assertAll(
                () -> assertEquals(user2Updated, repository.findById(2)),
                () -> assertEquals(user3Updated, repository.findById(3))
        );
    }
}