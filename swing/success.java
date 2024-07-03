import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class success extends JFrame{
int x ;   
JLabel msg;
JButton ok=new JButton(" OK ");

ImageIcon icon=new ImageIcon("C:\\Users\\jayav\\Downloads\\download.png");


success(int x){
    this.x =x;
    setSize(400,150);
    setTitle(" Massage ");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    JPanel center=new JPanel();
    if(x==1){msg= new JLabel(" Contact Number Saved Successfully");}
    if(x==2){msg= new JLabel("Something Error ");}
    if(x==3){msg= new JLabel("Contact Not Found ");}
    if(x==4){msg= new JLabel("Contact Delete Successfily..");}
    if(x==5){msg= new JLabel("Contact Update Successfily..");}



    msg.setFont(new Font("",Font.BOLD,14));
    msg.setHorizontalAlignment(0);
    center.add(msg);
    add("Center",center);

    
    Image resizedImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
    ImageIcon Ricon=new ImageIcon(resizedImage);
    JLabel img =new JLabel(Ricon);
    img.setPreferredSize(new Dimension(50,50));
    add("West",img);

    JPanel buton=new JPanel();
    ok.setFont(new Font("",Font.BOLD,14));
    ok.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            dispose();
        }
    }
    );
    ok.setHorizontalAlignment(0);
    buton.add(ok);
    add("South",buton);
    if(x==1){new AddContact().setVisible(true);}
    
}

public static void main(String[] args) {
    new success(2).setVisible(true);
}
}


