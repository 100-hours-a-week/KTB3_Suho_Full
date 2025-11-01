package kr.adapterz.jpa_practice.entity;

import jakarta.persistence.*;
import kr.adapterz.jpa_practice.fetchjoin.Team;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String nickname;

    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
