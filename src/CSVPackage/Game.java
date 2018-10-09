package CSVPackage;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Game {
	private String game = "";
	private String ur_ID = "";
	private int player = 0;
	private TreeMap<Integer,Round> rounds = new TreeMap<Integer,Round>();
	private ArrayList<String> headers = new ArrayList<String>();

	public void setGameVals(StringTokenizer st) throws IllegalArgumentException {
		//CONSUME ROUND
		st.nextToken();
		
		this.game = st.nextToken();
		this.ur_ID = st.nextToken();
		this.player = Integer.parseInt(st.nextToken());
	}
	
	public int getPlayer() {
		return player;
	}

	public String getUr_ID() {
		return ur_ID;
	}

	public String getGame() {
		return game;
	}
	
	public void addRound(Round round) {
		this.rounds.put(round.getRound(),round);
	}
	
	public TreeMap<Integer,Round> getRounds(){
		return this.rounds;
	}

	public ArrayList<String> getHeaders() {
		return headers;
	}

	public void setHeaders(String tempStr) {
		StringTokenizer st = new StringTokenizer(tempStr,",");
		
		while(st.hasMoreTokens()) {
			this.headers.add(st.nextToken());
		}
		
	}
}
