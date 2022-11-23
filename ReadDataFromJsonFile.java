package RCB.RCB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {
	public static void main(String[] args) throws IOException, ParseException {
		int countofforeignplayer = 0;
		int countofwiketkeeper = 0;
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\RcbPlayers\\players.json");
		Object obj = jsonparser.parse(reader);
		JSONObject players = (JSONObject) obj;
		String pname = (String) players.get("name");
		System.out.println("Team name:" + pname);
		JSONArray array = (JSONArray) players.get("player");
		for (int i = 0; i < array.size(); i++) {
			JSONObject player = (JSONObject) array.get(i);
			String playername = (String) player.get("name");
			String country = (String) player.get("country");
			String role = (String) player.get("role");
			if (!country.equals("India")) {
				countofforeignplayer = countofforeignplayer + 1;
			}

			if (role.equals("Wicket-keeper")) {
				countofwiketkeeper++;
			}
		}
		System.out.println("No of foreign players: " + countofforeignplayer);
		System.out.println("No of wicket_keepers: " + countofwiketkeeper);
	}
}
