package kr.adapterz.jpa_practice.fetchjoin;

import jakarta.persistence.*;
import kr.adapterz.jpa_practice.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {

        member.setTeam(this);

        members.add(member);

    }
}
