/*
 * The class represents the add record window 
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class EditRecordGUI extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t3 ,t5,t6, t7, t8, t9;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    private JButton b1,b2;
    private Record oldRec;
    private String name, phone;

    public EditRecordGUI(Record r) {
    	oldRec = r;
    	this.name = r.getName();
    	this.phone = r.getPhone(); 
    	
    	// frame graphics
	    setBounds(600, 200, 430, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);		
			
		addLabels();
		addTextFields();
		addButtons();
		
		// the main panel
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Contact", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 29, 398, 400);
		contentPane.add(panel);
	    panel.setBackground(Color.WHITE);
	    contentPane.setBackground(Color.WHITE);

    }
    
    public void addLabels() {
		
		l1 = new JLabel("First Name");
		l1.setForeground(new Color(47, 79, 79));
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(63, 84, 90, 22);
		contentPane.add(l1);
	
		l2 = new JLabel("Last Name");
		l2.setForeground(new Color(47, 79, 79));
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(63, 117, 90, 22);
		contentPane.add(l2);
	
		l3 = new JLabel("Phone");
		l3.setForeground(new Color(47, 79, 79));
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(63, 150, 90, 22);
		contentPane.add(l3);
	
		l4 = new JLabel("Email");
		l4.setForeground(new Color(47, 79, 79));
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(63, 183, 90, 22);
		contentPane.add(l4);
	
		l5 = new JLabel("Street");
		l5.setForeground(new Color(47, 79, 79));
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(63, 216, 90, 22);
		contentPane.add(l5);
	
		l6 = new JLabel("City");
		l6.setForeground(new Color(47, 79, 79));
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(63, 249, 90, 22);
		contentPane.add(l6);
	
		l7 = new JLabel("State");
		l7.setForeground(new Color(47, 79, 79));
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(63, 283, 90, 22);
		contentPane.add(l7);
		
		l8 = new JLabel("Postal Code");
		l8.setForeground(new Color(47, 79, 79));
		l8.setFont(new Font("Tahoma", Font.BOLD, 14));
		l8.setBounds(63, 316, 90, 22);
		contentPane.add(l8);
		
		l9 = new JLabel("Last update ");
		l9.setForeground(new Color(47, 79, 79));
		l9.setFont(new Font("Tahoma", Font.BOLD, 14));
		l9.setBounds(63, 349, 120, 22);
		contentPane.add(l9);
		
		l10 = new JLabel(getDate(name, phone));
		l10.setForeground(new Color(47, 79, 79));
		l10.setFont(new Font("Tahoma", Font.BOLD, 14));
		l10.setBounds(169, 350, 200, 22);
		contentPane.add(l10);
		
		l11 = new JLabel(name);
		l11.setForeground(new Color(47, 79, 79));
		l11.setFont(new Font("Tahoma", Font.BOLD, 14));
		l11.setBounds(169, 87, 198, 20);
		contentPane.add(l11);
		
		l12 = new JLabel(phone);
		l12.setForeground(new Color(47, 79, 79));
		l12.setFont(new Font("Tahoma", Font.BOLD, 14));
		l12.setBounds(169, 153, 198, 20);
		contentPane.add(l12);
    }
    
    public void addTextFields() {
	
		t3 = new JTextField();
		t3.setForeground(new Color(47, 79, 79));
		t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t3.setColumns(10);
		t3.setBounds(169, 120, 198, 20);
		t3.setText(oldRec.getLastName());
		contentPane.add(t3);
	
	    t5 = new JTextField();
		t5.setForeground(new Color(47, 79, 79));
		t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t5.setColumns(10);
		t5.setBounds(169, 186, 198, 20);
		t5.setText(oldRec.getEmail());
		contentPane.add(t5);
	
		t6 = new JTextField();
		t6.setForeground(new Color(47, 79, 79));
		t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t6.setColumns(10);
		t6.setBounds(169, 219, 198, 20);
		t6.setText(oldRec.getStreet());
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setForeground(new Color(47, 79, 79));
		t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t7.setColumns(10);
		t7.setBounds(169, 250, 198, 20);
		t7.setText(oldRec.getCity());
		contentPane.add(t7);
		
		t8 = new JTextField();
		t8.setForeground(new Color(47, 79, 79));
		t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t8.setColumns(10);
		t8.setBounds(169, 285, 198, 20);
		t8.setText(oldRec.getState());
		contentPane.add(t8);
		
		t9 = new JTextField();
		t9.setForeground(new Color(47, 79, 79));
		t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t9.setColumns(10);
		t9.setBounds(169, 320, 198, 20);
		t9.setText(oldRec.getPostalCode());
		contentPane.add(t9);
    	
    }
    
    public void addButtons() {
    	
	    b1 = new JButton("Apply");
		b1.addActionListener(this);
		b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
	    b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b1.setBounds(102, 380, 100, 33);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		contentPane.add(b1);
	
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b2.setBounds(212, 380, 108, 33);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		contentPane.add(b2);
	
    }
    
	// define actions of the buttons
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            
            if(ae.getSource() == b1){ // APPLY BUTTON
            	Record r = new Record(name, t3.getText(), phone, t5.getText(), t6.getText(), t7.getText(), t8.getText(), t9.getText());

            	String sql = "UPDATE contable "
            			+ "SET lastName = '" + r.getLastName() + "', email = '" + r.getEmail() + "', street = '" 
            			+ r.getStreet() +  "', city = '" + r.getCity() +  "', state = '" + r.getState() +  "', postalCode = '" 
            			+ r.getPostalCode()  + "', date = (select now()) " + 
            			"WHERE name = '" + name + "' and phone = '" + phone + "'";

			    PreparedStatement st = con.connection.prepareStatement(sql);
		        int rs = st.executeUpdate();

				if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully updated");
				else
                    JOptionPane.showMessageDialog(null, "Error");

				st.close();
            }
            
            if(ae.getSource() == b2){ // BACK BUTTON
                this.setVisible(false);
                new mainGUI().setVisible(true);
            }
            
            con.connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    // getting the last update of record in DB
    public String getDate(String name, String phone){
        try{
            Conn con = new Conn();
            String sql = "SELECT * "
            		+ "FROM contable "
            		+ "WHERE name = '" + name + "' AND phone = '" + phone + "'";
            PreparedStatement st = con.connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Date result = null;
            if(rs.next())
            	result = rs.getTimestamp("date");
            
            rs.close();
            st.close();
            con.connection.close();
            return result.toString();
        }catch(Exception e) {
            System.out.println(e);
           }
        return "";
        
	}
        
    
    
}