import java.util.*;

import java.time.*;


class Demo1{

    //-------------------CREATE AN ARRAYS ----------------


    public static ContactList contactList = new ContactList();

   

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

                if(contactList.getSize()==0){

                        return "C0001";

                }else{

            return String.format("C%04d",contactList.getSize()+1);

        }

                

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

    //-----------------ADD CONTACTS--------------------

    public static void addContacts(){

        Scanner input=new Scanner(System.in);

        do{

            System.out.println("======================ADD CONTACTS================");

            String id = generateId();

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


            Contact contacts = new Contact(id,name,phoneNumber,companyName,salary,birthday);

            contactList.add(contacts);


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

   

    //--------------------------PRINT DETAILS---------------------------

    public static void printDetails(int index){

        System.out.println("Contact Id : "+contactList.get(index).getId());

        System.out.println("Name : "+contactList.get(index).getName());

        System.out.println("Phone Number : "+contactList.get(index).getPhoneNumber());

        System.out.println("Company Name : "+contactList.get(index).getCompanyName());

        System.out.println("Salary : "+contactList.get(index).getSalary());

        System.out.println("Birthday : "+contactList.get(index).getBirthday());

    }

    //--------------------------SEARCH CONTACT-------------------------

    public static void searchContacts(){

        Scanner input=new Scanner(System.in);

        do{

            System.out.println("=====================SEARCH CONTACTS======================");

            System.out.print("\nSearch contact by name or phone number : ");

            String nameOrPhone=input.next();

            int index = contactList.searchByNameOrPhoneNumber(nameOrPhone);


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

        //contactList.updateName(index,newName);

    }

    //--------------------------UPDATE NAME----------------------------

    public static void updatePhoneNumber(int index){

        Scanner input=new Scanner(System.in);

        System.out.println("\n Update Phonenumber");

        System.out.println("========================");

        System.out.print("\nInput new phone number : ");

        String newPhoneNumber = input.next();

        //contactList.updatePhoneNumber(index,newPhoneNumber);

    }

    //--------------------------UPDATE NAME----------------------------

    public static void updateCompanyName(int index){

        Scanner input=new Scanner(System.in);

        System.out.println("\n Update Company Name");

        System.out.println("===========================");

        System.out.print("\nInput new company name : ");

        String newCompanyName = input.next();

        //contactList.updateCompanyName(index,newCompanyName);

    }

    //--------------------------UPDATE NAME----------------------------

    public static void updateSalary(int index){

        Scanner input=new Scanner(System.in);

        System.out.println("\n Update Salary");

        System.out.println("==================");

        System.out.print("\nInput new salary : ");

        double newSalary = input.nextDouble();

        //contactList.updateSalary(index,newSalary);

    }

    //--------------------------UPDATE CONTACTS-----------------------

    public static void updateContacts(){

        Scanner input = new Scanner(System.in);

        do{

            System.out.println("=======================UPDATE CONTACTS================");

            System.out.print("\nSearch contact by name or phone number : ");

            String nameOrPhone=input.next();

            int index = contactList.searchByNameOrPhoneNumber(nameOrPhone);


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

                    default : System.out.println("\n\tInvalid option...");clearConsole();updateContacts();

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

   

    //--------------------------DELETE CONTACTS-----------------------

    public static void deleteContacts(){

        Scanner input = new Scanner(System.in);

        do{

            System.out.println("======================DELETE CONTACTS================");

            System.out.print("\nSearch contact by name or phone number : ");

            String nameOrPhone=input.next();

            int index = contactList.searchByNameOrPhoneNumber(nameOrPhone);


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

                        contactList.remove(index);

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


            //sortingByName();


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


            contactList.sortingBySalary();


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


            //sortingByBirthday();


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

    // public static void sortingByName(){

        //         Contact[] tempContactArray = new Contact[contactsArray.length];


    //     for(int i=0; i<contactsArray.length; i++){

        //                 tempContactArray[i]=contactsArray[i];

    //     }

    //     for(int j=1; j<contactsArray.length; j++){

    //         for(int i=0; i<contactsArray.length-j; i++){

    //             if(tempContactArray[i].getName().compareTo(tempContactArray[i+1].getName())>0){

        //                                 Contact tempContact=tempContactArray[i];

        //                                 tempContactArray[i]=tempContactArray[i+1];

        //                                 tempContactArray[i+1]=tempContact;


    //             }

    //         }

    //     }


    //     for(int i=0; i<contactsArray.length; i++) {

    //         System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",tempContactArray[i].getId(),tempContactArray[i].getName(),tempContactArray[i].getPhoneNumber(),tempContactArray[i].getCompanyName(),tempContactArray[i].getSalary(),tempContactArray[i].getBirthday());

    //     }


    // }

   

    //-------------------------BIRTHDAY SORT---------------------------

    // public static void sortingByBirthday(){

        //         Contact[] tempContactArray = new Contact[contactsArray.length];


    //     for(int i=0; i<contactsArray.length; i++){

    //         tempContactArray[i]=contactsArray[i];

    //     }

    //     for(int j=1; j<contactsArray.length; j++){

    //         for(int i=0; i<contactsArray.length-j; i++){

    //             if(tempContactArray[i].getBirthday().compareTo(tempContactArray[i+1].getBirthday())>0){

        //                                 Contact tempContact = tempContactArray[i];

    //                 tempContactArray[i]=tempContactArray[i+1];

    //                 tempContactArray[i+1]=tempContact;

    //             }

    //         }

    //     }


    //     for(int i=0; i<contactsArray.length; i++) {

    //         System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",tempContactArray[i].getId(),tempContactArray[i].getName(),tempContactArray[i].getPhoneNumber(),tempContactArray[i].getCompanyName(),tempContactArray[i].getSalary(),tempContactArray[i].getBirthday());

    //     }


    // }

    //-----------------------EXIT--------------------------

    public static void exit(){

        System.exit(0);

    }


}


//================ContactList Class=========================

class ContactList{

    private Node start;


    private boolean isEmpty(){

        return start==null;

    }

    //-------------------------ADD METHOD----------------------------

    public void add(Contact contact){

        Node n1=new Node(contact);

        Node lastNode=start;

        if(isEmpty()){

            start=n1;

        }else{

            while(lastNode.next!=null){

                lastNode=lastNode.next;

            }

            lastNode.next=n1;

        }

    }

    public Contact get(int index){

        if(isValidIndex(index)){

            if(index==0){

                return start.contacts;

            }else{

                Node temp=start;

                for(int i=0; i<index; i++){

                    temp=temp.next;

                }

                return temp.contacts;

            }

        }

        return null;

    }

    //--------------GET SIZE------------------------

    public int getSize(){

        Node temp=start;

        int count=0;

        while(temp!=null){

            count++;

            temp=temp.next;

        }

        return count;

    }

    private boolean isValidIndex(int index){

        return index>=0 && index<=getSize();

    }

    //-------------------------REMOVE METHOD----------------------------

    public boolean remove(int index){

        return false;

    }

    // public void updateName(int index, String name){

    //     contactsArray[index].setName(name);

    // }

    // public void updatePhoneNumber(int index, String phoneNumber){

    //     contactsArray[index].setPhoneNumber(phoneNumber);

    // }

    // public void updateCompanyName(int index, String companyName){

    //     contactsArray[index].setCompanyName(companyName);

    // }

    // public void updateSalary(int index, double salary){

    //     contactsArray[index].setSalary(salary);

    // }

   

    //-----------------------SEARCH METHOD--------------------------

    public int searchByNameOrPhoneNumber(String nameOrPhone){

       Node temp=start;

       int index=0;

       while(temp!=null){

        if(temp.contacts.getName().equals(nameOrPhone)||temp.contacts.getPhoneNumber().equals(nameOrPhone)){

            return index;

        }

        temp=temp.next;

        index++;

       }

       return -1;

    }

    //-------------------------SALARY SORT---------------------------

    public void sortingBySalary(){

        Node temp=start, index=null;

        if(start==null){

            return;

        }else{

            while(temp!=null){

                index=temp.next;


                while(index!=null){

                    if(temp.contacts.getSalary()>index.contacts.getSalary()){

                        Contact tempContacts=temp.contacts;

                        temp.contacts=index.contacts;

                        index.contacts=tempContacts;

                    }

                    index=index.next;

                }

                temp=temp.next;

            }

        }


        for(int i=0; i<getSize(); i++) {

            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(i).getId(),get(i).getName(),get(i).getPhoneNumber(),get(i).getCompanyName(),get(i).getSalary(),get(i).getBirthday());

        }


    }


    //-------------------NODE CLASS---------------------------

    class Node{

        private Contact contacts;

        private Node next;


        Node(Contact contacts){

            this.contacts=contacts;

        }

    }

}

