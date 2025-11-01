package kr.adapterz.jpa_practice.entity;

import kr.adapterz.jpa_practice.fetchjoin.Team;
import kr.adapterz.jpa_practice.fetchjoin.TeamRepository;
import kr.adapterz.jpa_practice.fetchjoin.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FetchJoinTest {

    @Autowired
    TeamService teamService;

    @BeforeEach
    public void init() {

        teamService.init();

    }

    @Test
    public void joinTest () {
        List<Team> usingJoin = teamService.findAllWithMemberUsingJoin();
        System.out.println(usingJoin);
    }

    @Test
    public void fetchJoinTest () {
        List<Team> usingFetchJoin = teamService.findAllWithMemberUsingFetchJoin();
        System.out.println(usingFetchJoin);
    }

}
