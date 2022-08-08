public class Main {

	public static void main(String[] args) {
		int option = Integer.parseInt(args[0]);
		DAOClass dao = new DAOClass();
		
		switch (option) {
		/* 1---> to insert data
		 * 2----> to fetch data
		 */
		case 1: 
			/* Input:
			 * 1
			 * 4756 RAMESH X 1995-04-21 57483.00
			 * Output: Inserted successfully
			 */
			int rollno = Integer.parseInt(args[1]);
			String name = args[2];
			String sta = args[3];
			String dob = args[4];
			int fee = Integer.parseInt(args[5]);
			
			if (dao.insert(rollno, name, sta, dob, fee))
				System.out.println("Inserted successfully");
			else 
				System.out.println("Insertion error");
			break;
			
		case 2: 
			try {
				rollno = Integer.parseInt(args[1]);
				/*Example Test case
				2
				5675
				Output: 5675, RITU, V, 2000-07-05, 6788.0
				*/
				dao.display(rollno);
				break;
			} catch (Exception e) {
				//If no roll no. is passed
				/*Input: 2
				   Output: All Rows and Columns
				   5634, SUDHA, V, 2000-10-10, 5647.0
				   5675, RITU, V, 2000-07-05, 6788.0
				 */
				dao.display();
				break;
			}
			
			
		}

	}

}