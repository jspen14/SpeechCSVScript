package CSVPackage;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProbabilityParser {
	private ArrayList<String> headers = new ArrayList<String>();
	

	public ArrayList<Double> parseRow(StringTokenizer st) throws IllegalArgumentException{
		ArrayList<Double> probabilities = new ArrayList<Double>();
		
		while(st.hasMoreTokens()) {
			String tempStr = st.nextToken();
						
			probabilities.add(Double.parseDouble(tempStr));
		}
		
		return probabilities;
	}
	
	public void parseHeader(StringTokenizer st) {
		while(st.hasMoreTokens()) {
			this.headers.add(st.nextToken());
		}
	}
	
	public ArrayList<String> getHeaders() {
		return headers;
	}

	public void setHeaders(ArrayList<String> headers) {
		this.headers = headers;
	}
	
	
}	
