import java.util.*;
public class CountryCapital {
	HashMap<String,String> M1=new HashMap<>();
	HashMap<String,String> M2=new HashMap<>();
	public CountryCapital() {					//Constructor
		M1=new HashMap<String,String>();
	}
	
	public HashMap<String,String> saveCountryCapital(String CountryName, String capital) { //Storing in HashMap
		M1.put(CountryName, capital);
		return M1;
	}
	
	public String getCapital(String CountryName) { // getting Country Name using Capital
		return M1.get(CountryName);
	}
	
	public String getCountry(String capitalName) { // Getting Capital using Country name
		Iterator it = M1.keySet().iterator();
		boolean flag=true;
		while (it.hasNext()) {
			String Key=(String)it.next();
            if(capitalName == M1.get(Key)) {
            	flag=false;
            	return Key;
            }
        }
		return null;
	}
	public HashMap<String,String> newMap(){
		M2=new HashMap<>();
		Iterator it = M1.keySet().iterator();
		while(it.hasNext()) {
			String Key=(String) it.next();
			M2.put(M1.get(Key),Key);
		}
		return M2;
	}
	public ArrayList<String> CountryName(){
		ArrayList<String> col=new ArrayList<>();
		Iterator it = M1.keySet().iterator();
		while (it.hasNext()) {
			String Key=(String)it.next();
			col.add(Key);
            
        }
		return col;
	}
}
