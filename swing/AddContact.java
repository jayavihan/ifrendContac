import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class AddContact extends JFrame{

    CustTemplate Cust=new CustTemplate();
    CustTemplate.contactArrays cust= Cust.new contactArrays();

    

    JLabel Title;
    JLabel id;
    JLabel name;
    JLabel contact;
    JLabel company;
    JLabel salary;
    JLabel birth;

    JTextField txtid;
    JTextField txtname;
    JTextField txtcontact;
    JTextField txtcompany;
    JTextField txtsalary;
    JTextField txtbirth;

    JButton Add;
    JButton cancel;
    JButton back;


AddContact(){

    setSize(500,600);
    setTitle("Add Contact");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    JPanel top=new JPanel();
    Title=new JLabel("ADD CONTACT");
    Title.setFont(new Font("",Font.BOLD,24));
    Title.setHorizontalAlignment(0);
    Title.setPreferredSize(new Dimension(400,90));
    top.add(Title);
    top.setBackground(new Color(160,210,250));
    add("North",top);

    JPanel left=new JPanel(new GridLayout(6,1));
    String cusId=cust.generateId();
    id=new JLabel("Contact ID - "+cusId);
    id.setBorder(BorderFactory.createEmptyBorder(0,15,0,10));
    id.setFont(new Font("",1,20));
    left.add(new JPanel().add(id));


    name=new JLabel("Name");
    name.setFont(new Font("",1,20));
    name.setBorder(BorderFactory.createEmptyBorder(0,30,0,10));
    left.add(name);
    
    contact=new JLabel("Contact Number");
    contact.setFont(new Font("",1,20));
    contact.setBorder(BorderFactory.createEmptyBorder(0,30,0,10));
    left.add(contact);

    
    company=new JLabel("Company");
    company.setFont(new Font("",1,20));
    company.setBorder(BorderFactory.createEmptyBorder(0,30,0,10));
    left.add(company);
    
    salary=new JLabel("Salary");
    salary.setFont(new Font("",1,20));
    salary.setBorder(BorderFactory.createEmptyBorder(0,30,0,10));
    left.add(salary);

    
    birth=new JLabel("Birthday");
    birth.setFont(new Font("",1,20));
    birth.setBorder(BorderFactory.createEmptyBorder(0,30,0,10));
    left.add(birth);

    add("West",left);
    //

    JPanel right=new JPanel(new GridLayout(6,1));
    right.add(new JPanel());



    txtname=new JTextField(13);
    txtname.setFont(new Font("",1,20));
    name.setBorder(BorderFactory.createEmptyBorder(0,30,0,10));
    JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    nameTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    nameTextPanel.add(txtname);
    right.add(nameTextPanel);
    
    txtcontact=new JTextField(13);
    txtcontact.setFont(new Font("",1,20));
    JPanel contactTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    contactTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    contactTextPanel.add(txtcontact);
    right.add(contactTextPanel);

    
    txtcompany=new JTextField(10);
    txtcompany.setFont(new Font("",1,20));
    JPanel companyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    companyTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    companyTextPanel.add(txtcompany);
    right.add(companyTextPanel);
    
    txtsalary=new JTextField(10);
    txtsalary.setFont(new Font("",1,20));
    JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    salaryTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    salaryTextPanel.add(txtsalary);
    right.add(salaryTextPanel);
    
    txtbirth=new JTextField(10);
    txtbirth.setFont(new Font("",1,20));
    JPanel birthTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    birthTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    birthTextPanel.add(txtbirth);
    right.add(birthTextPanel);

    add("Center",right);

    //

    JPanel down1=new JPanel(new GridLayout(1,4));
    cancel=new JButton("Cancel");
    back=new JButton("Back To Homepage");
    down1.add(new JPanel());down1.add(new JPanel());
    Add=new JButton("ADD Contact"); 

    Add.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            String name=txtname.getText();
            String contact=txtcontact.getText();
            String companyName=txtcompany.getText();
            Double salary=Double.parseDouble(txtsalary.getText());
            String birthday=txtbirth.getText();

            
            if(Cust.isValidSalary(salary)&&Cust.isValidBirthday(birthday)&& Cust.isValidPhoneNumber(contact)){
            CustTemplate. Customer data=Cust.new Customer(cusId,name,contact,companyName,salary,birthday);
            CustTemplate.contactArrays cust1= Cust.new contactArrays();
            dispose();
            cust1.add(data);
            //add success msg eka
            //get another window
            new success(1).setVisible(true);
            
            }

            else{new success(2).setVisible(true);
                    setVisible(true);}

            
        }
    }
    );

    
    cancel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            txtname.setText("");
            txtcontact.setText("");
            txtcompany.setText("");
            txtsalary.setText("");
            txtbirth.setText("");
            setVisible(true);

        }
    }
    );

    back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            dispose();
            new App().setVisible(true);

        }
    }
    );

    JPanel AddPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
    AddPanel.setBorder( BorderFactory.createEmptyBorder(5,5,5,5));
    AddPanel.add(Add);

    JPanel CancelPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
    CancelPanel.setBorder( BorderFactory.createEmptyBorder(5,5,5,5));
    CancelPanel.add(cancel);
    
    JPanel BackPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
    BackPanel.setBorder( BorderFactory.createEmptyBorder(5,5,5,5));
    BackPanel.add(back);

    down1.add(AddPanel);
    down1.add(CancelPanel);

    JPanel down2=new JPanel(new GridLayout(1,2));
    down2.add(new JPanel());
    down2.add(BackPanel);

    JPanel down =new JPanel(new GridLayout(2,1));
    down.add(down1);
    down.add(down2);

    add("South",down);
}



    
public static void main(String[] args) {

    CustTemplate Cust=new CustTemplate();
    CustTemplate.Customer x=Cust.new Customer("C0004","1234567890","sdg","sdfg",1234567,"werjjty");
    CustTemplate.Customer y=Cust.new Customer("C0003","1234567890","sdfg","sdfhg",1234567,"werty");

    CustTemplate.contactArrays cust= Cust.new contactArrays();
    cust.add( x);cust.add( x);
    cust.add(y);
    new AddContact().setVisible(true);
        
}
}


