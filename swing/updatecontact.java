import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;;


public class updatecontact extends JFrame{
    JLabel Title;

    JLabel name;
    JLabel contact;
    JLabel company;
    JLabel salary;
    JLabel birth;
    JLabel contactid;
    JLabel getContactid;


    JTextField txtTitle;
    JTextField txtid;
    JTextField txtname;
    JTextField txtcontact;
    JTextField txtcompany;
    JTextField txtsalary;
    JTextField txtbirth;
    JTextField id;
    
    JButton Update;
    JButton cancel;
    JButton back;
    JButton Search;

    int x;


    updatecontact(){
        CustTemplate Cust=new CustTemplate();
        CustTemplate.contactArrays cust= Cust.new contactArrays();
    setSize(500,600);
    setTitle("update Contact");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    JPanel top=new JPanel();
    Title=new JLabel("UPDATE CONTACT");
    Title.setFont(new Font("",Font.BOLD,24));
    Title.setHorizontalAlignment(0);
    Title.setPreferredSize(new Dimension(400,90));
    top.add(Title);
    top.setBackground(new Color(160,210,250));
    add("North",top);

    JPanel left=new JPanel(new GridLayout(7,1));
    JPanel searchtxt=new JPanel(new FlowLayout(FlowLayout.CENTER));
    id=new JTextField(10);
    id.setFont(new Font("",1,20));
    searchtxt.add(id);
    searchtxt.setBorder(BorderFactory.createEmptyBorder(5,15,0,10));
    left.add(new JPanel().add(searchtxt));


    contactid=new JLabel("Contact Id");
    contactid.setFont(new Font("",1,20));
    contactid.setBorder(BorderFactory.createEmptyBorder(0,30,0,10));
    left.add(contactid);


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

    JPanel right=new JPanel(new GridLayout(7,1));



    JPanel searchButton= new JPanel(new FlowLayout(FlowLayout.CENTER));
    searchButton.setBorder( BorderFactory.createEmptyBorder(5,5,5,5));
    Search =new JButton("Search");
    Search.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            //new contactArrays.searchByNameOrPhoneNumber(txtid.getText());

        }
    }
    );
    
    searchButton.add(Search);
    
    right.add(searchButton);

    JPanel idpPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
    getContactid= new JLabel();
    getContactid.setFont(new Font("",1,20));
    idpPanel.setBorder( BorderFactory.createEmptyBorder(5,5,0,5));
    idpPanel.add(getContactid);
    //right.add(idpPanel);

    

    txtname=new JTextField(13);
    txtname.setFont(new Font("",1,20));
    JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    nameTextPanel.setBorder(BorderFactory.createEmptyBorder(10,30,0,10));
    nameTextPanel.add(txtname);
    //right.add(nameTextPanel);
    
    txtcontact=new JTextField(13);
    txtcontact.setFont(new Font("",1,20));
    JPanel contactTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    contactTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    contactTextPanel.add(txtcontact);
    //right.add(contactTextPanel);

    
    txtcompany=new JTextField(10);
    txtcompany.setFont(new Font("",1,20));
    JPanel companyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    companyTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    companyTextPanel.add(txtcompany);
    //right.add(companyTextPanel);
    
    txtsalary=new JTextField(10);
    txtsalary.setFont(new Font("",1,20));
    JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    salaryTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    salaryTextPanel.add(txtsalary);
    //right.add(salaryTextPanel);
    
    txtbirth=new JTextField(10);
    txtbirth.setFont(new Font("",1,20));
    JPanel birthTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    birthTextPanel.setBorder(BorderFactory.createEmptyBorder(15,30,0,10));
    birthTextPanel.add(txtbirth);
    //right.add(birthTextPanel);

    Search.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            right.add(idpPanel);
            right.add(nameTextPanel);
            right.add(contactTextPanel);
            right.add(companyTextPanel);
            right.add(salaryTextPanel);
            right.add(birthTextPanel);
            
            x=cust.searchByNameOrPhoneNumber(id.getText());
            
            if(x>=0){getContactid.setText((cust.get(x).getid()));
                txtname.setText((cust.get(x).getname()));
                txtcompany.setText((cust.get(x).getcompanyName()));
                txtcontact.setText((cust.get(x).getphoneNumber()));
                txtsalary.setText(String.valueOf(cust.get(x).getsalary()));
                txtbirth.setText((cust.get(x).getbirthday()));
                setVisible(true);}
                
            else{new success(3).setVisible(true);}

        }
    }
    );
    
    add("Center",right);

    JPanel down1=new JPanel(new GridLayout(1,4));
    Update=new JButton("Update Contact"); 
    cancel=new JButton("Cancel");
    back=new JButton("Back To Homepage");
    down1.add(new JPanel());down1.add(new JPanel());

    Update.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            String name=txtname.getText();
            String contact=txtcontact.getText();
            String companyName=txtcompany.getText();
            Double salary=Double.parseDouble(txtsalary.getText());
            String birthday=txtbirth.getText();

            if(Cust.isValidSalary(salary)&&Cust.isValidBirthday(birthday)&& Cust.isValidPhoneNumber(contact)){
                cust.get(x).setname(name);
                cust.get(x).setphoneNumber(contact);
                cust.get(x).setcompanyName(companyName);
                cust.get(x).setsalary(salary);
                cust.get(x).setbirthday(birthday);
                dispose();
                //cust.add(data);
                //update success msg eka
                //get another window
                new updatecontact().setVisible(true);
                new success(5).setVisible(true);
                
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
            
            new App().setVisible(true);
            dispose();
        }
    }
    );

    JPanel AddPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
    AddPanel.setBorder( BorderFactory.createEmptyBorder(5,5,5,5));
    AddPanel.add(Update);
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
    CustTemplate.Customer x=Cust.new Customer("C0004","jaye","0987654321","sdfg",1234567,"2002-01-12");
    CustTemplate.contactArrays cust= Cust.new contactArrays();
    cust.add( x);
    System.out.println(cust.searchByNameOrPhoneNumber("jaye"));
    System.out.println(cust.get(0).getid());


    new updatecontact().setVisible(true);
}


}
