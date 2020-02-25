package com.example.jpa;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(query = "SELECT u FROM UserEntity u WHERE u.lastName = :lastName", name = UserEntity.FIND_BY_LAST_NAME),
        @NamedQuery(query = "SELECT u FROM UserEntity u WHERE  u.firstName LIKE :word OR u.lastName LIKE :word", name = UserEntity.FIND_BY_WORD)
})

public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public static final String FIND_BY_LAST_NAME = "UserEntity.FIND_BY_LAST_NAME";
    public static final String FIND_BY_WORD = "UserEntity.FIND_BY_WORD";
}
