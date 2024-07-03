import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

public class viewbyname extends JFrame {

    JLabel title;
    JButton back;
    JTable tableview;
    DefaultTableModel dtm;
    int option;

    viewbyname(int option){

        this.option= option;
        setSize(800,600);
        setTitle("veiw Customers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout() );

        //

        if(option==1){title=new JLabel("LIST CONTACT BY NAME");}
        if(option==2){title=new JLabel("LIST CONTACT BY Salary");}
        if(option==3){title=new JLabel("LIST CONTACT BY Birth-Day");}
        
        title.setFont(new Font("",Font.BOLD,16));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JPanel up=new JPanel();
        up.setBackground(new Color(160,210,250));
        up.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        up.add(title);
        add("North",up);

        //

        back=new JButton("Back To Homepage");
        JPanel BackPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
        BackPanel.setBorder( BorderFactory.createEmptyBorder(10,10,10,30));
        BackPanel.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new App().setVisible(true);
                dispose();
            }
        }
        );

        add("South",BackPanel);

        //

        JPanel tblPanel=new JPanel(new BorderLayout());
        tblPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        String[] columnsName={" Id "," Name "," Number "," Company "," Salary ","Birthday"};
		dtm=new DefaultTableModel(columnsName,0);
        
        tableview= new JTable(dtm);

        JScrollPane tblPane=new JScrollPane(tableview);
        tblPane.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));

        add("Center",tblPane);

        CustTemplate Cust=new CustTemplate();
        CustTemplate.contactArrays cust= Cust.new contactArrays();
        CustTemplate.contactArrays.Node temp;

        int Q=cust.getSize();
        
        
            

    if(option==1){int []order=new int[Q];
            for(int i=0; i<Q; i++){
                order[i]=i;
            }
        
            for(int j=1; j<Q; j++){
              for(int i=0; i<Q-j; i++){
                temp =CustTemplate.contactArrays.start;

                if(temp.Customer.getname().compareTo(temp.next.Customer.getname())>0){
                      int x=order[i];
                      order[i]=order[i+1];
                      order[i+1]=x;
                      }
                temp=temp.next;
                }
            }
        
                
            for(int i=0; i<Q; i++) {
                temp=CustTemplate.contactArrays.start;
                Object[] rowdata={(cust.get(order[i])).getid(),(cust.get(order[i])).getname(),(cust.get(order[i])).getphoneNumber(),(cust.get(order[i])).getcompanyName(),(cust.get(order[i])).getsalary(),(cust.get(order[i])).getbirthday()};         
                temp=temp.next;
                dtm.addRow(rowdata);

            }}
        
        
    if(option==2){int []order=new int[Q];
            for(int i=0; i<Q; i++){
                order[i]=i;
            }
        
            for(int j=1; j<Q; j++){
              for(int i=0; i<Q-j; i++){
                temp =CustTemplate.contactArrays.start;

                if(temp.Customer.getname().compareTo(temp.next.Customer.getname())>0){
                      int x=order[i];
                      order[i]=order[i+1];
                      order[i+1]=x;
                      }
                if(temp.Customer.getsalary()>temp.next.Customer.getsalary()){
                    int x=order[i];
                    order[i]=order[i+1];
                    order[i+1]=x;
                    }
                if(temp.Customer.getbirthday().compareTo(temp.next.Customer.getbirthday())>0){
                      int x=order[i];
                      order[i]=order[i+1];
                      order[i+1]=x;
                      }
                temp=temp.next;
                }
            }
        
                
            for(int i=0; i<Q; i++) {
                temp=CustTemplate.contactArrays.start;
                Object[] rowdata={(cust.get(order[i])).getid(),(cust.get(order[i])).getname(),(cust.get(order[i])).getphoneNumber(),(cust.get(order[i])).getcompanyName(),(cust.get(order[i])).getsalary(),(cust.get(order[i])).getbirthday()};         
                temp=temp.next;
                dtm.addRow(rowdata);

            }}
        
    if(option==3){int []order=new int[Q];
            for(int i=0; i<Q; i++){
                order[i]=i;
            }
            
            for(int j=1; j<Q; j++){
              for(int i=0; i<Q-j; i++){
                temp =CustTemplate.contactArrays.start;
                if(temp.Customer.getsalary()>temp.next.Customer.getsalary()){
                    int x=order[i];
                    order[i]=order[i+1];
                    order[i+1]=x;
                    }
                temp=temp.next;
                }
            }
            
                    
            for(int i=0; i<Q; i++) {
                temp=CustTemplate.contactArrays.start;
                Object[] rowdata={(cust.get(order[i])).getid(),(cust.get(order[i])).getname(),(cust.get(order[i])).getphoneNumber(),(cust.get(order[i])).getcompanyName(),(cust.get(order[i])).getsalary(),(cust.get(order[i])).getbirthday()};         
                temp=temp.next;
                dtm.addRow(rowdata);    
            }}
            
        System.out.println(Q);
        setVisible(true);
    
    }




    public static void main(String[] args) {
        new viewbyname(1).setVisible(true);
    
    }
}
