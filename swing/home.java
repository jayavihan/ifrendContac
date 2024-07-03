import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
class App extends JFrame{
    AddContact addContactGui;
    updatecontact updatecontactGui; 
    search searchGui;
    Delete DeleteGui;
    viewOption viewOptionGui;


    JButton Add;
    JButton Update;
    JButton Search;
    JButton Delete;
    JButton View;
    JButton exit;
    ImageIcon img;
    JLabel Apptitle;
    JLabel Apptitle1;
    JLabel title;

    

	App(){
        setSize(600,370);
        setTitle("Home");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        img=new ImageIcon("C:\\Users\\jayav\\Documents\\oop\\swing\\home.png");
        JLabel image=new JLabel(img);
        
        JPanel left=new JPanel();
        left.setBorder(BorderFactory.createEmptyBorder(5,8,5,5));
        left.setLayout(new BorderLayout());
        Apptitle= new JLabel("iFriend");
        Apptitle1= new JLabel(" Contact Manger ");
        Apptitle1.setHorizontalAlignment(0);
        Apptitle.setHorizontalAlignment(0);
        Apptitle1.setFont(new Font("Sans Serif", Font.BOLD, 16));
        Apptitle.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel x=new JPanel(new BorderLayout());
        x.add(Apptitle1);x.add(Apptitle);
        x.add("North",Apptitle);x.add("South",Apptitle1);
        left.add("North",x);
        
        left.add("South",image);
        add("West",left);

        //

        JPanel right=new JPanel();
        right.setBackground(new Color(160,210,250));
        right.setLayout(new BorderLayout());

        title=new JLabel("Home Page");
        title.setHorizontalAlignment(0);
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        right.add("North",title);

        exit=new JButton("Exit");
        exit.setMaximumSize(new Dimension(50,15));
        exit.setAlignmentX(Component.RIGHT_ALIGNMENT);
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
            
                dispose();
            }
        });

        right.add("South",Box.createRigidArea(new Dimension(100, 0)));
        JPanel Exit=new JPanel();
        Exit.add(Box.createRigidArea(new Dimension(200, 0)));
        Exit.add(exit);
        Exit.setBackground(new Color(160,210,250));
        right.add("South",Exit);

        JPanel R_Center=new JPanel();
        R_Center.setLayout(new BoxLayout(R_Center,BoxLayout.Y_AXIS));
        R_Center.setBackground(new Color(160,210,250));

        Add=new JButton();
        Add.setMaximumSize(new Dimension(200,30));
        Add.setText("Add New Contact");
        Add.setAlignmentX(Component.CENTER_ALIGNMENT);
        Add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addContactGui==null) {addContactGui=new AddContact();
                addContactGui.setVisible(true);}
                dispose();
            }
        }
        );
        R_Center.add(Box.createRigidArea(new Dimension(0, 20)));
        R_Center.add(Add);

        Update=new JButton();
        Update.setMaximumSize(new Dimension(200,30));
        Update.setText("Update Contavt");
        Update.setAlignmentX(Component.CENTER_ALIGNMENT);
        Update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(updatecontactGui==null) {updatecontactGui=new updatecontact();
                updatecontactGui.setVisible(true);}
                dispose();
            }
        }
        );
        R_Center.add(Box.createRigidArea(new Dimension(0, 20)));
        R_Center.add(Update);

        Search=new JButton();
        Search.setMaximumSize(new Dimension(200,30));
        Search.setText("Search Contact");
        Search.setAlignmentX(Component.CENTER_ALIGNMENT);
        Search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(searchGui==null) {searchGui=new search();
                searchGui.setVisible(true);}
                dispose();
            }
        }
        );
        R_Center.add(Box.createRigidArea(new Dimension(0, 20)));
        R_Center.add(Search);

        Delete=new JButton();
        Delete.setMaximumSize(new Dimension(200,30));
        Delete.setText("Delete Contact");
        Delete.setAlignmentX(Component.CENTER_ALIGNMENT);
        Delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(DeleteGui==null) {DeleteGui=new Delete();
                DeleteGui.setVisible(true);}
                dispose();
            }
        }
        );
        R_Center.add(Box.createRigidArea(new Dimension(0, 20)));
        R_Center.add(Delete);

        View=new JButton();
        View.setMaximumSize(new Dimension(200,30));
        View.setText("View Contact");
        View.setAlignmentX(Component.CENTER_ALIGNMENT);
        View.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(viewOptionGui==null) {viewOptionGui=new viewOption();
                    viewOptionGui.setVisible(true);
                    dispose();
                }
            }
        }
        );
        R_Center.add(Box.createRigidArea(new Dimension(0, 20)));
        R_Center.add(View);

        right.add("Center",R_Center);
        
        add("Center",right);
        
    }
    
}

class home{
    public static void main (String args[]){
        new App().setVisible(true);
    }
}