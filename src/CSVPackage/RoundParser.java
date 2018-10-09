package CSVPackage;

import java.util.StringTokenizer;

public class RoundParser {
	
	public Round parseRound(StringTokenizer st) throws IllegalArgumentException {
		Round round = new Round();
		
		if(st.countTokens() == 18) {
			round.setRound(Integer.parseInt(st.nextToken())-1);
			
			//Consume unnecessary data
			st.nextToken();
			st.nextToken();
			st.nextToken();
			
			round.setRound_init(st.nextToken());
			round.setYour_talk(st.nextToken());
			round.setTalk_sent(st.nextToken());
			round.setHis_talk(st.nextToken());
			round.setTalk_received(st.nextToken());
			round.setYour_action(st.nextToken().charAt(0));
			round.setAction_sent(st.nextToken());
			round.setYour_pay(Integer.parseInt(st.nextToken()));
			round.setYour_avg(Double.parseDouble(st.nextToken()));
			round.setYour_earning(st.nextToken());
			round.setHis_action(st.nextToken().charAt(0));
			round.setAction_received(st.nextToken());
			round.setHis_pay(Integer.parseInt(st.nextToken()));
			round.setHis_avg(Double.parseDouble(st.nextToken()));
		}
		
		
		return round;
	}
	
}
