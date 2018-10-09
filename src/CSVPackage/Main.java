package CSVPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// This needs to take in two files (A _Rnds.csv and a _Probs.csv)
		if(args.length != 3) {
			System.out.println("Command Line Parameters should be: __Rnds.csv __Probs.csv  Out_File.csv");
		}
		else {
			parseData(args);
		}
		
		 
	}
	
	static void parseData(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		Game game = new Game();
		
		RoundParser rp = new RoundParser();
	
		if(scanner.hasNextLine()) {
			game.setHeaders(scanner.nextLine());
		}
		
		if(scanner.hasNextLine()) {
			String tempStr = scanner.nextLine();
			
			try {
				StringTokenizer st = new StringTokenizer(tempStr,",");
				game.setGameVals(st);
				
				st = new StringTokenizer(tempStr,",");
				game.addRound(rp.parseRound(st));
			}catch(IllegalArgumentException e) {
				System.out.println(e);
			}
		}
		
		while(scanner.hasNextLine()) {
			String tempStr = scanner.nextLine();
			
			StringTokenizer st = new StringTokenizer(tempStr,",");
			
			try {
				game.addRound(rp.parseRound(st));
			}catch(IllegalArgumentException e) {
				System.out.println(e);
			}
			
		}
		
		file = new File(args[1]);
		scanner = new Scanner(file);
		
		//Consume Header AND Put Header Values into Storage
		
		
		ProbabilityParser pp = new ProbabilityParser();
		
		if(scanner.hasNextLine()) {
			String tempStr = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(tempStr,",");
			st.nextToken(); // CONSUME header tag
			
			pp.parseHeader(st);
		}
		
		while(scanner.hasNextLine()) {
			String tempStr = scanner.nextLine();
			
			StringTokenizer st = new StringTokenizer(tempStr,",");
			
			try {
				int roundID = Integer.parseInt(st.nextToken());
	
				ArrayList<Double> tempArray = pp.parseRow(st);
				
				if(game.getRounds().get(roundID).getPreRoundStateDist()==null) {
					game.getRounds().get(roundID).setPreRoundStateDist(tempArray);
				}
				else {
					game.getRounds().get(roundID).setPostRoundStateDist(tempArray);
				}
				
			}catch(IllegalArgumentException e) {
				System.out.println(e);
			}
		}
		scanner.close();
		
		ArrayList<String> header = new ArrayList<String>();
		
		for(String str:game.getHeaders()) {
			header.add(str);
		}
		
		for(String str:pp.getHeaders()) {
			header.add("PRE"+str);
		}
		
		for(String str:pp.getHeaders()) {
			header.add("POST"+str);
		}
		
		writeFile(game,header,args[2]);
	}
	
	
	static void writeFile(Game game, ArrayList<String> header, String filePath) throws FileNotFoundException {
		File writeFile = new File(filePath);
		PrintWriter writer = new PrintWriter(writeFile);
		
		for(String str:header) {
			writer.print(str + ",");
		}
		writer.println();
		
		for(int roundKey:game.getRounds().keySet()) {
			StringTokenizer st = new StringTokenizer(game.getRounds().get(roundKey).toString(), ",");
			if(st.hasMoreTokens()) {
				writer.print(st.nextToken() + ",");
			}
			writer.print(game.getGame() + ",");
			writer.print(game.getUr_ID() + ",");
			writer.print(game.getPlayer() + ",");
			
			while(st.hasMoreTokens()) {
				writer.print(st.nextToken() + ",");
			}
			writer.println();
		}
		
		writer.close();
	}
		
}
