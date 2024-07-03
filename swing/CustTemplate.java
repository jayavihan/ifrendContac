import java.time.LocalDate;
import java.util.*;
import java.time.*;

public class CustTemplate {
    



public class Customer{

    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;

    Customer(String id,String name,String phoneNumber,String companyName,double salary,String birthday){
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class contactArrays{
    

    public static Node start;
    public static Node last; // del weddi check

    


public void add(Customer c1){
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


public String generateId(){
    if(start==null){
        return "C0001";
    }
    return String.format("C%04d",(getSize()+1));
}

public int searchByNameOrPhoneNumber(String nameOrPhone){
    Node temp=start;
    int i=0;
    while(temp!=null){
    if(temp.Customer.getname().equals(nameOrPhone) || temp.Customer.getphoneNumber().equals(nameOrPhone) ){
        return i;
    }
        temp=temp.next;
        i++;

    }
    return -1;
}

public Customer get (int index) {
    if(isValidIndex(index)){
        if(index==0)return start.Customer;
        else{
            Node temp=start;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp.Customer;
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
          if(temp.Customer.getname().compareTo(temp.next.Customer.getname())>0){
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
            if(temp.Customer.getsalary() > temp.next.Customer.getsalary()){
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
          if(temp.Customer.getbirthday().compareTo(temp.next.Customer.getbirthday())>0){
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

public  void delete(int index){ 
    if(index>=0 && index<getSize()){
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
    }}
    new success(4).setVisible(true);
}   




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public static class Node{
    Customer Customer;
    Node next;
    Node(Customer Customer){
            this.Customer=Customer;}
    }


}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//validations


public  boolean isValidSalary(double salary){
    return salary>0;
}
// -------------------BIRTHDAY VALIDATION----------------
public  boolean isValidBirthday(String birthday){
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

public  boolean isValidPhoneNumber(String phoneNumber){
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

}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

