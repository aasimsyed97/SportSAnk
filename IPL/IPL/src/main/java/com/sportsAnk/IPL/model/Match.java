package com.sportsAnk.IPL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Match {

    @Id
    private String id;
    private String city;
    private LocalDate date;
    private String season;
    private String matchNumber;
    private String team1;
    private String team2;
    private String venue;
    private String toss_winner;
    private String toss_decision;
    private String super_over;
    private String target_runs;
    private String target_overs;
    private String winner;
    private String result;
    private String result_margin;
    private String method;
    private String player_of_match;
    private String Umpire1;
    private String umpire2;
    private String match_type;


}
