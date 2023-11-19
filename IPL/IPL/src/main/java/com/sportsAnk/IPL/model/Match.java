package com.sportsAnk.IPL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    private String id;
    private  String city;
    private LocalDate date;
    private String season;
    private String matchNumber;
    private String team1;
    private String team2;
    private String venue;
    private String tossWinner;
    private String tossDecision;
    private String superOver;
    private String winningTeam;
    private String wonBy;
    private String margin;
    private String method;
    private String playerOfMatch;

//    private String team1Players;
//    private String team2Players;
    private String Umpire1;
    private String umpire2;



}
