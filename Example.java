import java.util.*;

//import List.Node;

import java.time.*;

class customer{
    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;

    customer(String id,String name,String phoneNumber,String companyName,double salary,String birthday){
        this.id=id; this.name=name; this.phoneNumber=phoneNumber; this.companyName=companyName; this.salary=salary; this.birthday=birthday; 
    }


    public String getid(){return id;}
	public void setid(String id){this.id=id;}

    public String getname(){return name;}
	public void setname(String name){this.name=name;}
	
	public String getphoneNumber(){return phoneNumber;}
	public void setphoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}
	
    public String getcompanyName(){return companyName;}
	public void setcompanyName(String companyName){this.companyName=companyName;}

	public double getsalary(){return salary;}
	public void setsalary(double salary){this.salary=salary;}

    public String getbirthday(){return birthday;}
	public void setbirthday(String birthday){this.birthday=birthday;}

}

class contactArrays{
    private Node start;
    private Node last; // del weddi check

public void add(customer c1){
    Node n1=new Node(c1);
    if(start==null){  
        start=n1;
        last=n1;
    }
    else{
        Node temp=start;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n1;
        last=n1;
    }

}
public int getSize(){
    Node temp =start;
    int count =0;
    while(temp!=null){
        count ++;
        temp=temp.next;
    }
    return count;
}


private boolean isValidIndex(int index){
    return index>=0 && index<=getSize();
}


public  String generateId(){
    if(start==null){
        return "C0001";
    }
    String lastId=last.customer.getid();
    int lastNo=Integer.parseInt(lastId.substring(1));
    return String.format("C%04d",lastNo+1);}

public int searchByNameOrPhoneNumber(String nameOrPhone){
    Node temp=start;
    int i=0;
    while(temp!=null){
    if(temp.customer.getname().equals(nameOrPhone) || temp.customer.getphoneNumber().equals(nameOrPhone) ){
        return i;
    }
        temp=temp.next;
        i++;

    }
    return -1;
}

public customer get (int index) {
    if(isValidIndex(index)){
        if(index==0)return start.customer;
        else{
            Node temp=start;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp.customer;
        }
    }

    return null;
}



public  void sortingByName(){

    int []order=new int[getSize()];
    for(int i=0; i<getSize(); i++){
        order[i]=i;
    }

    for(int j=1; j<getSize(); j++){
      for(int i=0; i<getSize()-j; i++){
        Node temp=start;
          if(temp.customer.getname().compareTo(temp.next.customer.getname())>0){
              int x=order[i];
              order[i]=order[i+1];
              order[i+1]=x;
              }
        temp=temp.next;
        }}

    for(int i=0; i<getSize(); i++) {
        Node temp=start;
        System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(order[i]).getid(),get(order[i]).getname(),get(order[i]).getphoneNumber(),get(order[i]).getcompanyName(),get(order[i]).getsalary(),get(order[i]).getbirthday());
        temp=temp.next;
    }

}

public void sortingBySalary(){ 
    int []order=new int[getSize()];

    for(int i=0; i<getSize(); i++){
        order[i]=i;
    }


    for(int j=1; j<getSize(); j++){
        for(int i=0; i<getSize()-j; i++){
            Node temp=start;
            if(temp.customer.getsalary() > temp.next.customer.getsalary()){
                int x =order[i];
                order[i]=order[i+1];
                order[i+1]=x;}
            temp=temp.next;
        }}


    for(int i=0; i<getSize(); i++) {
        Node temp=start;
        System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(order[i]).getid(),get(order[i]).getname(),get(order[i]).getphoneNumber(),get(order[i]).getcompanyName(),get(order[i]).getsalary(),get(order[i]).getbirthday());
        temp=temp.next;
    }

}


public  void sortingByBirthday(){

    int []order=new int[getSize()];
    for(int i=0; i<getSize(); i++){
        order[i]=i;
    }

    for(int j=1; j<getSize(); j++){
      for(int i=0; i<getSize()-j; i++){
        Node temp=start;
          if(temp.customer.getbirthday().compareTo(temp.next.customer.getbirthday())>0){
              int x=order[i];
              order[i]=order[i+1];
              order[i+1]=x;
              }
        temp=temp.next;
        }}

    for(int i=0; i<getSize(); i++) {
        Node temp=start;
        System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(order[i]).getid(),get(order[i]).getname(),get(order[i]).getphoneNumber(),get(order[i]).getcompanyName(),get(order[i]).getsalary(),get(order[i]).getbirthday());
        temp=temp.next;
    }

}

public  void delete(int index){ if(index>=0 && index<getSize()){
    if(index==0){
        start=start.next;
    }else{
        int count=0;
        Node temp=start;
        while(count<index-1){
            temp=temp.next;
            count++;
        }
        temp.next=temp.next.next;
    }
}

}



class Node{
    private customer customer;
    private Node next;
    Node(customer customer){
            this.customer=customer;}
    }
}




/*class contactArrays{

    int nextIndex;
    int size;
    int loadFactor;
    customer[] contactArray;

    contactArrays( int size,int loadFactor){ 
        nextIndex=0; 
        this.size=size;
        this.loadFactor=loadFactor;
        contactArray=new customer [size];}

    private boolean isFull(){
        return nextIndex%50==0;
    }

    void extendArrays(){ 
        if(isFull()){
        customer []tempArray=new customer[contactArray.length+loadFactor];
        for(int i=0;i<contactArray.length;i++){
            tempArray[i]=contactArray[i];
        }
        contactArray=tempArray;}
    }
    
    public void add(customer customer){
        if(isFull())extendArrays();
        contactArray[nextIndex]=  customer;
        nextIndex++;

    }

    public  void delete(int index){ 
        for(int i=index;i<nextIndex;i++){   
            contactArray[i]=contactArray[i+1];
        }
    nextIndex--;
       
    }

    public void sortingByName(){

        int []order=new int[nextIndex];
        for(int i=0; i<nextIndex; i++){
            order[i]=i;
        }
  
        for(int j=1; j<nextIndex; j++){
          for(int i=0; i<nextIndex-j; i++){
              if(contactArray[i].getname().compareTo(contactArray[i+1].getname())>0){
                  int x=order[i];
                  order[i]=order[i+1];
                  order[i+1]=x;

                  }}}

        for(int i=0; i<nextIndex; i++) {
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",contactArray[order[i]].getid(),contactArray[order[i]].getname(),contactArray[order[i]].getphoneNumber(),contactArray[order[i]].getcompanyName(),contactArray[order[i]].getsalary(),contactArray[order[i]].getbirthday());
        }

    }

    public void sortingBySalary(){ 
        int []order=new int[nextIndex];

        for(int i=0; i<nextIndex; i++){
            order[i]=i;
        }


        for(int j=1; j<nextIndex; j++){
            for(int i=0; i<nextIndex-j; i++){
                if(contactArray[i].getsalary() > contactArray[i+1].getsalary()){
                    int x =order[i];
                    order[i]=order[i+1];
                    order[i+1]=x;}}}


        for(int i=0; i<nextIndex; i++) {
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",contactArray[order[i]].getid(),contactArray[order[i]].getname(),contactArray[order[i]].getphoneNumber(),contactArray[order[i]].getcompanyName(),contactArray[order[i]].getsalary(),contactArray[order[i]].getbirthday());
        }

    }


    public  void sortingByBirthday(){ 
        int[] order= new int[nextIndex
        ];


        for(int i=0; i<nextIndex; i++){
            order[i]=i;
        }


        for(int j=1; j<nextIndex; j++){
            for(int i=0; i<nextIndex-j; i++){
                if(contactArray[i].getbirthday().compareTo(contactArray[i+1].getbirthday())>0){
                    int x =order[i];
                    order[i]=order[i+1];
                    order[i+1]=x;}}}


        for(int i=0; i<nextIndex; i++) {
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",contactArray[order[i]].getid(),contactArray[order[i]].getname(),contactArray[order[i]].getphoneNumber(),contactArray[order[i]].getcompanyName(),contactArray[order[i]].getsalary(),contactArray[order[i]].getbirthday());
        }
    }

}*/



class Example{
 public static contactArrays cust=new contactArrays();
    
   // public static customer[] customerArray=new customer [0];
   // public static contactArrays contactArray=new contactArrays(100,50) ;
    
	    //----------------------CLEAR CONSOLE --------------------
		public final static void clearConsole() { 
			try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
			System.out.print("\033[H\033[2J"); 
			System.out.flush();
			}
			} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
			}
		}
    //-----------------MAIN METHOD--------------------
    public static void main(String[] args){
        homepage();
    }
    //-------------------GENERATE ID----------------
    public static String generateId(){
		if(cust.getSize()==0){
			return "C0001";
		}
		
        return String.format("C%04d",cust.getSize()+1);
	}  
    //-----------------HOME PAGE--------------------
    public static void homepage(){
        Scanner input = new Scanner(System.in);
        System.out.println("=======================iFRIEND CONTACT ORGANIZER============================");
        System.out.println("\n[01] Add Contacts");
        System.out.println("\n[02] Update Contacts");
        System.out.println("\n[03] Delete Contacts");
        System.out.println("\n[04] Search Contacts");
        System.out.println("\n[05] List Contacts");
        System.out.println("\n[06] Exit");
        System.out.print("\nEnter option to continue : ");
        int option=input.nextInt();
        clearConsole();
        switch(option){
            case 1 : addContacts();break;
            case 2 : updateContacts();break;
            case 3 : deleteContacts();break;
            case 4 : searchContacts();break;
            case 5 : listContacts();break;
            case 6 : exit();break;
            default : System.out.println("Invalid option...");break;
        }

    }
    //------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;

    }
    //-------------------VALIDATE SALARY----------------------
    public static boolean isValidSalary(double salary){
        return salary>0;
    }
    // -------------------BIRTHDAY VALIDATION----------------
	public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
					return false;
    }
    //-------------------------EXTEND ARRAYS-----------------------
   /* public static void extendArrays(){ 

        customer []tempArray=new customer[customerArray.length+1];

        for(int i=0;i<customerArray.length;i++){
            tempArray[i]=customerArray[i];
        }

        
        customerArray=tempArray;


    }*/
    //-----------------ADD CONTACTS--------------------
    public static void addContacts(){
    
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("======================ADD CONTACTS================");
            String id = cust.generateId();
            System.out.println("\n"+id);
            System.out.println("=============");
            System.out.print("Name : ");
            String name=input.next();
            String phoneNumber;
            L1:do{
                System.out.print("Phone Number : ");
                phoneNumber  = input.next();
                if(!isValidPhoneNumber(phoneNumber)){
                    System.out.println("\n\tInvalid phone number...");
                    System.out.print("\nDo you want to input phone number again : ");
                    char ch = input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L1;
                    }else if(ch=='N'||ch=='n'){
                        clearConsole();
                        homepage();
                    }
                }

            }while(!isValidPhoneNumber(phoneNumber));

            System.out.print("Company Name : ");
            String companyName  = input.next();
            double salary;

            L2:do{
                System.out.print("Salary : ");
                salary=input.nextDouble();
                if(!isValidSalary(salary)){
                    System.out.println("\n\tInvalid salary...");
                    System.out.print("\nDo you want to input salary again : ");
                    char ch=input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L2;
                    }else if(ch=='N'||ch=='n'){
                        clearConsole();
                        homepage();
                    }
                }

            }while(!isValidSalary(salary));
            String birthday;

            L3:do{
                System.out.print("Birthday : ");
                birthday = input.next();
                if(!isValidBirthday(birthday)){
                    System.out.println("\n\tInvalid birthday...");
                    System.out.print("\nDo you want to input birthday again : ");
                    char ch=input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue L3;
                    }else if(ch=='N'||ch=='n'){
                        clearConsole();
                        homepage();
                    }
                }

            }while(!isValidBirthday(birthday));

            
            
            customer cus=new customer(id,name,phoneNumber,companyName,salary,birthday);
            
            //create obj & access
            
            cust.add(cus);


            System.out.println("\n\tContact has been added successfully...");
            System.out.print("\nDo you want to add another contact : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                addContacts();
            }else if(ch=='N'||ch=='n'){
                clearConsole();
                homepage();
            }

        }while(true);

    }
    //---------------------------SEARCH METHOD--------------------------
    public static int searchByNameOrPhoneNumber(String nameOrPhone){
        /*for(int i=0; i<=contactArray.nextIndex; i++){
            if(contactArray.contactArray[i].getname().equals(nameOrPhone) || contactArray.contactArray[i].getphoneNumber().equals(nameOrPhone)){
                return i;
            }
        }
        return -1;*/
        return cust.searchByNameOrPhoneNumber(nameOrPhone);
    }
    //--------------------------PRINT DETAILS---------------------------
    public static void printDetails(int index){
        System.out.println("Contact Id : "+cust.get(index).getid());
        System.out.println("Name : "+cust.get(index).getname());
        System.out.println("Phone Number : "+cust.get(index).getphoneNumber());
        System.out.println("Company Name : "+cust.get(index).getcompanyName());
        System.out.println("Salary : "+cust.get(index).getsalary());
        System.out.println("Birthday : "+cust.get(index).getbirthday());
    }
    //--------------------------SEARCH CONTACT-------------------------
    public static void searchContacts(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("=====================SEARCH CONTACTS======================");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone=input.next();
            int index = searchByNameOrPhoneNumber(nameOrPhone);

            if(index == -1){
                System.out.println("\n\tNo contact found for "+nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    searchContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }else{
                printDetails(index);
                System.out.print("\nDo you want to search another contact : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    searchContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }

        }while(true);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updateName(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Name");
        System.out.println("===================");
        System.out.print("\nInput new name : ");
        String newName = input.next();
        cust.get(index).setname(newName);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updatePhoneNumber(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Phonenumber");
        System.out.println("========================");
        System.out.print("\nInput new phone number : ");
        String newPhoneNumber = input.next();
        cust.get(index).setphoneNumber(newPhoneNumber);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updateCompanyName(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Company Name");
        System.out.println("===========================");
        System.out.print("\nInput new company name : ");
        String newCompanyName = input.next();
        cust.get(index).setcompanyName(newCompanyName);
    }
    //--------------------------UPDATE NAME----------------------------
    public static void updateSalary(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\n Update Salary");
        System.out.println("==================");
        System.out.print("\nInput new salary : ");
        double newSalary = input.nextDouble();
        cust.get(index).setsalary(newSalary);
    }
    //--------------------------UPDATE CONTACTS-----------------------
    public static void updateContacts(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("=======================UPDATE CONTACTS================");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone=input.next();
            int index = searchByNameOrPhoneNumber(nameOrPhone);

            if(index == -1){
                System.out.println("\n\tNo contact found for "+nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    updateContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }
            else{
                printDetails(index);

                System.out.println("\nWhat do you want to update");
                System.out.println("\n\t[01] Name");
                System.out.println("\t[02] Phone number");
                System.out.println("\t[03] Company Name");
                System.out.println("\t[04] Salary");
                System.out.println("\nEnter an option to continue...");
                int option=input.nextInt();
                switch(option){
                    case 1 : updateName(index);break;
                    case 2 : updatePhoneNumber(index);break;
                    case 3 : updateCompanyName(index);break;
                    case 4 : updateSalary(index);break;
                    default : System.out.println("\n\tInvalid option...");
                }
                System.out.println("\nContact has been update successfully.");
                System.out.print("\nDo you want to update another contact : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    updateContacts();
                }else if(ch=='N'|| ch=='n'){
                    clearConsole();
                    homepage();
                }
            }
        }while(true);
    }
    //---------------------------DELETE-------------------------------
    /*public static void delete(int index){ 
        customer []tempArray=new customer[customerArray.length-1];

        for(int i=0;i<tempArray.length;i++){
            if(i==index){continue;}
            tempArray[i]=customerArray[i];
        }

        
        customerArray=tempArray;
       
    }*/
    //--------------------------DELETE CONTACTS-----------------------
    public static void deleteContacts(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("======================DELETE CONTACTS================");
            System.out.print("\nSearch contact by name or phone number : ");
            String nameOrPhone=input.next();
            int index = searchByNameOrPhoneNumber(nameOrPhone);

            if(index == -1){
                System.out.println("\n\tNo contact found for "+nameOrPhone);
                System.out.print("\nDo you want to try a new search : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    deleteContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
            }else{
                printDetails(index);
                L1:do{
                    System.out.print("\nDo you want to delete this contact : ");
                    char ch=input.next().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        cust.delete(index);
                        System.out.println("\nContact has been deleted successfully...");
                        break L1;
                    }else if(ch=='N'||ch=='n'){
                        break L1;
                    }

                }while(true);

                System.out.println("\nDo you want to delete another contact : ");
                char ch=input.next().charAt(0);
                if(ch=='Y'||ch=='y'){
                    clearConsole();
                    deleteContacts();
                }else if(ch=='N'||ch=='n'){
                    clearConsole();
                    homepage();
                }
                
            }

        }while(true);

    }
    //--------------------------LIST CONTACTS------------------------
    public static void listContacts(){
        Scanner input = new Scanner(System.in);
        System.out.println("=======================SORT CONTACTS==========================");
        System.out.println("\n[01] Sorting by name");
        System.out.println("\n[02] Sorting by salary");
        System.out.println("\n[03] Sorting by birthday");
        System.out.print("\nEnter option to continue : ");
        int option=input.nextInt();
        switch(option){
            case 1 : sortByName();break;
            case 2 : sortBySalary();break;
            case 3 : sortByBirthday();break;
            default : System.out.println("\n\tInvalid option...");
        }

    }
    //--------------------------SORT BY NAME-------------------------
    public static void sortByName(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("============LIST CONTACT BY NAME============\n");
            System.out.println("+---------------------------------------------------------------------------------------------------+");
            System.out.println("|  Contact Id  |     Name     |   Phone Number   |    Company    |    Salary    |      Birthday     |");
            System.out.println("+---------------------------------------------------------------------------------------------------+");

            cust.sortingByName();

            System.out.println("+---------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                homepage();
            }else if(ch=='N'|| ch=='n'){
                clearConsole();
                listContacts();
            }


        }while(true);
    }
    //--------------------------SORT BY SALARY-------------------------
    public static void sortBySalary(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("============LIST CONTACT BY NAME============\n");
            System.out.println("+---------------------------------------------------------------------------------------------------+");
            System.out.println("|  Contact Id  |     Name     |   Phone Number   |    Company    |    Salary    |      Birthday     |");
            System.out.println("+---------------------------------------------------------------------------------------------------+");

            cust.sortingBySalary();

            System.out.println("+---------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                homepage();
            }else if(ch=='N'|| ch=='n'){
                clearConsole();
                listContacts();
            }


        }while(true);
    }
    //--------------------------SORT BY BIRTHDAY-------------------------
    public static void sortByBirthday(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("============LIST CONTACT BY NAME============\n");
            System.out.println("+---------------------------------------------------------------------------------------------------+");
            System.out.println("|  Contact Id  |     Name     |   Phone Number   |    Company    |    Salary    |      Birthday     |");
            System.out.println("+---------------------------------------------------------------------------------------------------+");

            cust.sortingByBirthday();

            System.out.println("+---------------------------------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go homepage : ");
            char ch=input.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                clearConsole();
                homepage();
            }else if(ch=='N'|| ch=='n'){
                clearConsole();
                listContacts();
            }


        }while(true);
    }
    //-------------------------NAME SORT---------------------------
    /*public static void sortingByName(){

          String[] tempNameArray=new String[nameArray.length];

           for(int i=0; i<nameArray.length; i++){
            tempIdArray[i]=idArray[i];
            tempNameArray[i]=nameArray[i];
            tempPhoneNumberArray[i]=phoneNumberArray[i];
            tempCompanyNameArray[i]=companyNameArray[i];
            tempSalaryArray[i]=salaryArray[i];
            tempBirthdayArray[i]=birthdayArray[i];
        }

          for(int j=1; j<idArray.length; j++){
            for(int i=0; i<idArray.length-j; i++){
                if(tempNameArray[i].compareTo(tempNameArray[i+1])>0){
                    String tempName=tempNameArray[i];
                    tempNameArray[i]=tempNameArray[i+1];
                    tempNameArray[i+1]=tempName;}}}

        for(int i=0; i<tempcustomerArray.length; i++) {
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",tempcustomerArray[i].getid(),tempcustomerArray[i].getname(),tempcustomerArray[i].getphoneNumber(),tempcustomerArray[i].getcompanyName(),tempcustomerArray[i].getsalary(),tempcustomerArray[i].getbirthday());
        }

    }*/
    //-------------------------SALARY SORT---------------------------
    /*public static void sortingBySalary(){ 
        customer[] tempcustomerArray= new customer[customerArray.length];


        for(int i=0; i<customerArray.length; i++){
            tempcustomerArray[i]=customerArray[i];
        }


        for(int j=1; j<customerArray.length; j++){
            for(int i=0; i<customerArray.length-j; i++){
                if(tempcustomerArray[i].getsalary() > tempcustomerArray[i+1].getsalary()){
                    customer tempobj =tempcustomerArray[i];
                    tempcustomerArray[i]=tempcustomerArray[i+1];
                    tempcustomerArray[i+1]=tempobj;}}}


        for(int i=0; i<tempcustomerArray.length; i++) {
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",tempcustomerArray[i].getid(),tempcustomerArray[i].getname(),tempcustomerArray[i].getphoneNumber(),tempcustomerArray[i].getcompanyName(),tempcustomerArray[i].getsalary(),tempcustomerArray[i].getbirthday());
        }

    }*/

    //-------------------------BIRTHDAY SORT---------------------------
    /*public static void sortingByBirthday(){ 
        customer[] tempcustomerArray= new customer[customerArray.length];


        for(int i=0; i<customerArray.length; i++){
            tempcustomerArray[i]=customerArray[i];
        }


        for(int j=1; j<customerArray.length; j++){
            for(int i=0; i<customerArray.length-j; i++){
                if(tempcustomerArray[i].getbirthday().compareTo(tempcustomerArray[i+1].getbirthday())>0){
                    customer tempobj =tempcustomerArray[i];
                    tempcustomerArray[i]=tempcustomerArray[i+1];
                    tempcustomerArray[i+1]=tempobj;}}}


        for(int i=0; i<tempcustomerArray.length; i++) {
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",tempcustomerArray[i].getid(),tempcustomerArray[i].getname(),tempcustomerArray[i].getphoneNumber(),tempcustomerArray[i].getcompanyName(),tempcustomerArray[i].getsalary(),tempcustomerArray[i].getbirthday());
        }


    } */
    //-----------------------EXIT--------------------------
    public static void exit(){
        System.exit(0);
    }

}
