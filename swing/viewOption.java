import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class viewOption extends JFrame{


    JLabel title;

    JButton listbyname;
    JButton listbysalary;
    JButton listbybirthday;
    JButton cancel;
    viewbyname viewbynameGui;


    viewOption(){
        setSize(400,400);
        setTitle("View Options");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //
        title=new JLabel("CONTACT LIST");
        title.setFont(new Font("",Font.BOLD,16));
        JPanel up=new JPanel(new FlowLayout(FlowLayout.CENTER));
        up.setBackground(new Color(160,210,250));
        up.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        up.add(title);
        add("North",up);
        //

        JPanel buttonpaPanel=new JPanel(new GridLayout(3,1));
        //
        listbyname=new JButton(" List by Name ");
        listbyname.setPreferredSize(new Dimension(200,30));
        listbyname.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new viewbyname(1);    
            }
        }
        );
        JPanel lbn=new JPanel();
        lbn.add(listbyname);
        buttonpaPanel.add(lbn);

        listbysalary=new JButton(" List by Salary ");
        listbysalary.setPreferredSize(new Dimension(200,30));
        listbysalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
            dispose();
            new viewbyname(2);}
            
        }
        );
        JPanel lbs=new JPanel();
        lbs.add(listbysalary);
        buttonpaPanel.add(lbs);
        
        listbybirthday=new JButton(" List by BirthDay ");
        listbybirthday.setPreferredSize(new Dimension(200,30));
        listbybirthday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new viewbyname(3);
            }
        }
        );
        JPanel lbd=new JPanel();
        lbd.add(listbybirthday);
        buttonpaPanel.add(lbd);

        buttonpaPanel.setBorder(BorderFactory.createEmptyBorder(30,10,0,10));

        add("Center",buttonpaPanel);

        cancel=new JButton(" Cancel ");
        JPanel cnsl=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        cnsl.add(cancel);
        cnsl.setBorder(BorderFactory.createEmptyBorder(10,10,10,30));
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
            }
        }
        );


        add("South",cnsl);




    }

    

    public static void main(String[] args) {
        new viewOption().setVisible(true);
    }
}
