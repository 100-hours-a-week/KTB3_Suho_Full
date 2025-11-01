package kr.adapterz.jpa_practice.fetchjoin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    private Team team;

    public Member(String name, int age, Team team){

        this.name = name;

        this.age = age;

        this.team = team;

    }
}
