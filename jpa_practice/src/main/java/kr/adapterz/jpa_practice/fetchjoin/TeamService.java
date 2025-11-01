package kr.adapterz.jpa_practice.fetchjoin;

import jakarta.transaction.Transactional;

import java.util.List;

public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {

        this.teamRepository = teamRepository;

    }

    @Transactional
    public void init() {

        Team teamA = new Team();

        teamA.addMember(new Member("회원1", 20, teamA));

        teamA.addMember(new Member("회원2", 25, teamA));

        Team teamB = new Team();

        teamB.addMember(new Member("회원3", 30, teamB));

        teamB.addMember(new Member("회원4", 35, teamB));

        teamRepository.save(teamA);

        teamRepository.save(teamB);

    }

    @Transactional
    public List<Team> findAllWithMemberUsingJoin(){

        return teamRepository.findAllWithMemberUsingJoin();

    }

    @Transactional
    public List<Team> findAllWithMemberUsingFetchJoin(){

        return teamRepository.findAllWithMemberUsingFetchJoin();

    }

}
