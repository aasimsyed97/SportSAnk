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
        match.setTossWinner(matchInput.getTossWinner());
        match.setTossDecision(matchInput.getTossDecision());
        match.setSuperOver(matchInput.getSuperOver());
        match.setWinningTeam(matchInput.getWinningTeam());
        match.setWonBy(matchInput.getWonBy());
        match.setPlayerOfMatch(matchInput.getPlayerOfMatch());
        match.setMargin(matchInput.getMargin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

        return match;
    }
}
