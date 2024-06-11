package com.anurag.fifa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @Autowired
    private MatchService mservice;
    private String jsonFile = "src/main/resources/static/static.json";

    private void saveToFile(List<Matches> matches){
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter fileWriter = new FileWriter(jsonFile)){
            System.out.println("===========WRITING FILE ==========");
            objectMapper.writeValue(fileWriter, matches);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/display")
    public List<Matches> getAll(){
        saveToFile(mservice.getAllMatches());
        return mservice.getAllMatches();
    }

    @GetMapping("/all")
    public String getAllTeams(){
        /**List<Team> teams = mservice.getAllTeams();
        StringBuilder resultBuilder = new StringBuilder();

        int teamCount = 1;
        resultBuilder.append("<ol>");
        for (Team team : teams){
            resultBuilder.append(team.toString());
        }
        resultBuilder.append("</ol>");
        return resultBuilder.toString();*/
        return mservice.getAllMatches().toString();
    }
    @GetMapping("/group/{gname}")
    public String getWinnerByGroup(@PathVariable String gname){
        return "Hello";
    }

    @GetMapping("/group-winners")
    public String getGroupWinners(){
        return "Heylo";
    }

    @GetMapping("/overall-winner")
    public String getOverallWinner(){
        return "What's good";
    }
}
