package com.sportsAnk.IPL.Service;

import com.sportsAnk.IPL.model.Match;
import com.sportsAnk.IPL.model.MatchInput;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(MatchInput matchInput) throws Exception {



        Match match = new Match();
        match.setId(matchInput.getId());
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setSeason(matchInput.getSeason());
        match.setMatchNumber(matchInput.getMatchNumber());
        match.setTeam1(matchInput.getTeam1());
        match.setTeam2(matchInput.getTeam2());
        match.setVenue(matchInput.getVenue());
        match.setToss_winner(matchInput.getToss_winner());
        match.setToss_decision(matchInput.getToss_decision());
        match.setSuper_over(matchInput.getSuper_over());
        match.setTarget_runs(matchInput.getTarget_runs());
        match.setTarget_overs(matchInput.getTarget_overs());
        match.setWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResult_margin(matchInput.getResult_margin());
        match.setMethod(matchInput.getMethod());
        match.setPlayer_of_match(matchInput.getPlayer_of_match());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());
        match.setMatch_type(matchInput.getMatch_type());

        return match;
    }
}
