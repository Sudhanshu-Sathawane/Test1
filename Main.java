import java.util.*;
/*
1)

1. Develop a java class with a instance variable M1 (HashMap) create a method saveCountryCapital(String CountryName, String capital) , the method should add the passed country and capital as key/value in the map M1 and return the Map (M1).

Key- Country Value - Capital

India Delhi

Japan Tokyo

2. Develop a method getCapital(String CountryName) which returns the capital for the country passed, from the Map M1 created in step 1.

3. Develop a method getCountry(String capitalName) which returns the country for the capital name, passed from the Map M1 created in step 1.

4. Develop a method which iterates through the map M1 and creates another map M2 with Capital as the key and value as Country and returns the Map M2.

Key – Capital Value – Country

Delhi India

Tokyo Japan

5. Develop a method which iterates through the map M1 and creates an ArrayList with all the Country names stored as keys. This method should return the ArrayList.

*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountryCapital countryCapital= new CountryCapital();
		countryCapital.saveCountryCapital("France","Paris"); //Adding Countries and Capital
		countryCapital.saveCountryCapital("Sri Lanka","Colombo");
		countryCapital.saveCountryCapital("India","Delhi");
		countryCapital.saveCountryCapital("USA","Washington DC");
		countryCapital.saveCountryCapital("UK","London");
		countryCapital.saveCountryCapital("Japan","Tokyo");
		
		
		System.out.println(countryCapital.getCapital("France"));//getCapital Method
		System.out.println(countryCapital.getCountry("London"));//get Country Method
		System.out.println(countryCapital.CountryName()); //ArrayList of Country name
		HashMap<String,String> change= countryCapital.newMap(); //New HashMap
		System.out.println(change);
		
	}

}
