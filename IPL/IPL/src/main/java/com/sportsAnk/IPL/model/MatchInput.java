package com.sportsAnk.IPL.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchInput {
    //id,season,city,date,match_type,player_of_match,venue,team1,team2,toss_winner,
    // toss_decision,winner,result,result_margin,target_runs,target_overs,super_over,method,umpire1,umpire2
    private String id;
    private  String city;
    private String date;
    private String season;
    private String matchNumber;
    private String team1;
    private String team2;
    private String venue;
    private String toss_winner;
    private String toss_decision;
    private String super_over;
    private String target_runs;
    private  String target_overs;
    private String winner;
    private String result;
    private String result_margin;
    private String method;
    private String player_of_match;
    private String team1Players;
    private String team2Players;
    private String Umpire1;
    private String umpire2;
    private String match_type;



}

//id ,city ,date ,season ,matchNumber,team1,team2,venue,toss_winner,toss_decision ,super_over,target_runs,target_overs,winner,result,result_margin,method,player_of_match,Umpire1 ,umpire2 ,match_type