package com.example.jpa;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return entityManager.merge(user);
    }

    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createQuery("FROM UserEntity", UserEntity.class)
                .getResultList();
    }

    @Transactional
    public List<UserEntity> findByLastName(String lastName) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_LAST_NAME, UserEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Transactional
    public List<UserEntity> findAllUsersThatHasLetterOrWord(String word) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_WORD, UserEntity.class)
                .setParameter("word", "%" + word + "%")
                .getResultList();
    }
}
