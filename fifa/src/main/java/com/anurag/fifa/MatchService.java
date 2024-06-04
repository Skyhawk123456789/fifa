package com.anurag.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepo mrepo;
    private List<Team> teams = new ArrayList<Team>();

    public List<Matches> getAllMatches(){
        return mrepo.findAll();
    }

    public String getGroupWinners(){
        return "";
    }
    public String getOverallWinner(){
        return "";
    }
    public List<Team> getAllTeams(){
        return teams;
    }
    private Team findOrAddTeam(String teamName){
        return new Team();
    }
    private void playMatch(Team home, Team other, int goals, int oGoals){
        if (oGoals > goals){
            home.setLosses(home.getLosses() + 1);
            other.setWins(home.getWins() + 1);
        } else if (goals > oGoals){
            home.setWins(home.getWins() + 1);
            other.setLosses(other.getLosses() + 1);
        } else {
            home.setTies(home.getTies() + 1);
            other.setTies(other.getTies() + 1);
        }
    }
}
