package CSVPackage;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Round {
	private int round;
	private String round_init;
	private ArrayList<String> your_talk = new ArrayList<String>();
	private String talk_sent;
	private ArrayList<String> his_talk = new ArrayList<String>();
	private String talk_received;
	private char your_action;
	private String action_sent;
	private int your_pay;
	private double your_avg;
	private double your_earning;
	private char his_action;
	private String action_received;
	private int his_pay;
	private double his_avg;
	private ArrayList<Double> preRoundStateDist;
	private ArrayList<Double> postRoundStateDist;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(Integer.toString(round) + ",");
		sb.append(this.round_init + ",");
		
		if(this.your_talk.size() == 0) {
			sb.append(" ");
		}
		else {
			for(String str:this.your_talk) {
				sb.append(str+";");
			}
		}
		sb.append(",");
		
		sb.append(this.talk_sent + ",");
		
		if(this.his_talk.size()==0) {
			sb.append(" ");
		}
		else {
			for(String str:this.his_talk) {
				sb.append(str+";");
			}
		}
		
		sb.append(",");
		
		sb.append(this.talk_received + ",");
		sb.append(this.your_action + ",");
		sb.append(this.action_sent + ",");
		sb.append(Integer.toString(this.your_pay) + ",");
		sb.append(Double.toString(this.your_avg) + ",");
		sb.append(Double.toString(this.your_earning) + ",");
		sb.append(this.his_action + ",");
		sb.append(this.action_received + ",");
		sb.append(Integer.toString(this.his_pay) + ",");
		sb.append(Double.toString(this.his_avg) + ",");
		
		for(Double __:this.preRoundStateDist) {
			sb.append(Double.toString(__)+ ",");
		}
		
		for(Double __:this.postRoundStateDist) {
			sb.append(Double.toString(__)+ ",");
		}
		
		return sb.toString();
	}
	//GETTERS AND SETTERS
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	
	public String getRound_init() {
		return round_init;
	}
	public void setRound_init(String round_init) {
		this.round_init = round_init;
	}
	
	public ArrayList<String> getYour_talk() {
		return your_talk;
	}
	public void setYour_talk(String tempStr) {
		StringTokenizer st = new StringTokenizer(tempStr,";");
		
		while(st.hasMoreTokens()) {
			String stHolder = st.nextToken();
			if(!stHolder.contains("$")) {
				this.your_talk.add(stHolder);
			}
		}
	}
	
	public String getTalk_sent() {
		return talk_sent;
	}
	public void setTalk_sent(String talk_sent) {
		this.talk_sent = talk_sent;
	}
	
	public ArrayList<String> getHis_talk() {
		return his_talk;
	}
	public void setHis_talk(String tempStr) {
		StringTokenizer st = new StringTokenizer(tempStr,";");
		
		while(st.hasMoreTokens()) {
			String stHolder = st.nextToken();
			if(!stHolder.contains("$")) {
				this.his_talk.add(stHolder);
			}
		}
	}
	
	public String getTalk_received() {
		return talk_received;
	}
	public void setTalk_received(String talk_received) {
		this.talk_received = talk_received;
	}
	
	public char getYour_action() {
		return your_action;
	}
	public void setYour_action(char your_action) {
		this.your_action = your_action;
	}
	
	public String getAction_sent() {
		return action_sent;
	}
	public void setAction_sent(String action_sent) {
		this.action_sent = action_sent;
	}
	
	public int getYour_pay() {
		return your_pay;
	}
	public void setYour_pay(int your_pay) {
		this.your_pay = your_pay;
	}
	
	public double getYour_avg() {
		return your_avg;
	}
	public void setYour_avg(double your_avg) {
		this.your_avg = your_avg;
	}
	
	public double getYour_earning() {
		return your_earning;
	}
	public void setYour_earning(String tempStr) {
		
		int endIndex = -1;

		for(int i=0; i<tempStr.length(); i++) {
			if(Character.isWhitespace(tempStr.charAt(i)) || Character.isLetter(tempStr.charAt(i))) {
				endIndex = i;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder(tempStr);
		
		double your_earning = Double.parseDouble(sb.substring(0, endIndex).toString());
		
		this.your_earning = your_earning;
	}
	
	public char getHis_action() {
		return his_action;
	}
	public void setHis_action(char his_action) {
		this.his_action = his_action;
	}
	
	public String getAction_received() {
		return action_received;
	}
	public void setAction_received(String action_received) {
		this.action_received = action_received;
	}
	
	public int getHis_pay() {
		return his_pay;
	}
	public void setHis_pay(int his_pay) {
		this.his_pay = his_pay;
	}
	
	public double getHis_avg() {
		return his_avg;
	}
	public void setHis_avg(double his_avg) {
		this.his_avg = his_avg;
	}
	
	public ArrayList<Double> getPreRoundStateDist() {
		return preRoundStateDist;
	}
	public void setPreRoundStateDist(ArrayList<Double> preRoundStateDist) {
		this.preRoundStateDist = preRoundStateDist;
	}
	
	public ArrayList<Double> getPostRoundStateDist() {
		return postRoundStateDist;
	}
	public void setPostRoundStateDist(ArrayList<Double> postRoundStateDist) {
		this.postRoundStateDist = postRoundStateDist;
	}
}
