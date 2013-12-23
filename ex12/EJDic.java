package ex12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EJDic {
	private HashMap<String, String> map;

	public EJDic() {
		map = new HashMap<String, String>();
	}

	public void open(String filename) {
		try {
			map.clear();
			File file = new File(filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] field = line.split(",");
				put(field[0], field[1]);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(String filename) {
		try {
			File file = new File(filename);
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (Map.Entry<String, String> entry : map.entrySet()) {
				writer.println(entry.getKey() + "," + entry.getValue());
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String get(String eng) {
		return map.get(eng);
	}

	public void put(String eng, String jap) {
		map.put(eng, jap);
	}

	public void remove(String eng) {
		map.remove(eng);
	}

	public void showWords() {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
	}

	public Set<String> keySet() {
		return map.keySet();
	}

	public static void main(String[] args) {
		EJDic dic = new EJDic();
		dic.open("dic.txt");
		dic.showWords();
		dic.put("banana", "バナナ");
		dic.showWords();
		dic.remove("banana");
		dic.showWords();
		dic.save("dic.txt");
	}

}
