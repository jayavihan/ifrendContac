import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerForm extends JFrame{
	private JLabel titleLabel;
	private JButton btnAdd;
	private JButton btnCancel;

	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblSalary;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtSalary;
	
	AddCustomerForm(){
		setSize(500,300);
		setTitle("Add Customer Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	
		titleLabel=new JLabel("Add Customer Form");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("Add");
		btnAdd.setFont(new Font("",1,20));
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				String name=txtName.getText();
				String address=txtAddress.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				//Customer customer=new Customer(id,name,address,salary);
				//CustomerDBConnection.getInstance().getCustomerList().add(customer);
			}
		});
		buttonPanel.add(btnAdd);
			btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddCustomerForm.this.dispose();
			}
		});
		buttonPanel.add(btnCancel);
		add("South",buttonPanel);
		JPanel labelPanel=new JPanel(new GridLayout(4,1));
		
		lblId=new JLabel("Id");
		lblId.setFont(new Font("",1,20));
		labelPanel.add(lblId);
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		lblAddress=new JLabel("Address");
		lblAddress.setFont(new Font("",1,20));
		labelPanel.add(lblAddress);
		
		lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20));
		labelPanel.add(lblSalary);
		
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		txtId=new JTextField(4);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtAddress=new JTextField(20);
		txtAddress.setFont(new Font("",1,20));
		JPanel addressTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		addressTextPanel.add(txtAddress);
		textPanel.add(addressTextPanel);
		
		txtSalary=new JTextField(6);
		txtSalary.setFont(new Font("",1,20));
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		salaryTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);
		add("Center",textPanel);
	}

    public static void main(String[] args) {
        new AddCustomerForm().setVisible(true);
    }
}

