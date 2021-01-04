/*
 * The class represents the add record window 
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRecordGUI extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t2,t3,t4,t5,t6, t7, t8, t9;
    private JButton b1,b2;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8;

    public AddRecordGUI() {
    	// frame graphics
	    setBounds(600, 200, 430, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		addLabels();
		addTextAreas();
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
		l1.setBounds(73, 84, 90, 22);
		contentPane.add(l1);
	
		l2 = new JLabel("Last Name");
		l2.setForeground(new Color(47, 79, 79));
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(73, 117, 90, 22);
		contentPane.add(l2);
	
		l3 = new JLabel("Phone");
		l3.setForeground(new Color(47, 79, 79));
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(73, 150, 90, 22);
		contentPane.add(l3);
	
		l4 = new JLabel("Email");
		l4.setForeground(new Color(47, 79, 79));
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(73, 183, 90, 22);
		contentPane.add(l4);
	
		l5 = new JLabel("Street");
		l5.setForeground(new Color(47, 79, 79));
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(73, 216, 90, 22);
		contentPane.add(l5);
	
		l6 = new JLabel("City");
		l6.setForeground(new Color(47, 79, 79));
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(73, 249, 90, 22);
		contentPane.add(l6);
	
		l7 = new JLabel("State");
		l7.setForeground(new Color(47, 79, 79));
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(73, 283, 90, 22);
		contentPane.add(l7);
		
		l8 = new JLabel("Postal Code");
		l8.setForeground(new Color(47, 79, 79));
		l8.setFont(new Font("Tahoma", Font.BOLD, 14));
		l8.setBounds(73, 316, 90, 22);
		contentPane.add(l8);
    }
    
    public void addTextAreas() {
    	
		t2 = new JTextField();
		t2.setForeground(new Color(47, 79, 79));
		t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t2.setColumns(10);
		t2.setBounds(169, 87, 198, 20);
		contentPane.add(t2);
	
		t3 = new JTextField();
		t3.setForeground(new Color(47, 79, 79));
		t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t3.setColumns(10);
		t3.setBounds(169, 120, 198, 20);
		contentPane.add(t3);
	
		t4 = new JTextField();
		t4.setForeground(new Color(47, 79, 79));
		t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t4.setColumns(10);
		t4.setBounds(169, 153, 198, 20);
		contentPane.add(t4);
	
	    t5 = new JTextField();
		t5.setForeground(new Color(47, 79, 79));
		t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t5.setColumns(10);
		t5.setBounds(169, 186, 198, 20);
		contentPane.add(t5);
	
		t6 = new JTextField();
		t6.setForeground(new Color(47, 79, 79));
		t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t6.setColumns(10);
		t6.setBounds(169, 219, 198, 20);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setForeground(new Color(47, 79, 79));
		t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t7.setColumns(10);
		t7.setBounds(169, 255, 198, 20);
		contentPane.add(t7);
		
		t8 = new JTextField();
		t8.setForeground(new Color(47, 79, 79));
		t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t8.setColumns(10);
		t8.setBounds(169, 291, 198, 20);
		contentPane.add(t8);
		
		t9 = new JTextField();
		t9.setForeground(new Color(47, 79, 79));
		t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		t9.setColumns(10);
		t9.setBounds(169, 327, 198, 20);
		contentPane.add(t9);
    }
    
    public void addButtons() {
    	
	    b1 = new JButton("Add");
		b1.addActionListener(this);
		b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
	    b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b1.setBounds(102, 370, 100, 33);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		contentPane.add(b1);
	
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b2.setBounds(212, 370, 108, 33);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		contentPane.add(b2);
    }
    
	// define actions of the buttons
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            
            if (ae.getSource() == b1) { // ADD BUTTON
            	if (t2.getText().length() == 0 || t4.getText().length() == 0) {
            		JOptionPane.showMessageDialog(null, "New record must have name and phone!");

            	} else {
            	
	            	Record r = new Record(t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(), t7.getText(), t8.getText(), t9.getText());
	            	String sql = "INSERT INTO contable "
	            			+ "VALUES('" + r.getName() + "', '" + r.getLastName() +  "', '" + r.getPhone() +  "', '" + r.getEmail() + "', '" + r.getStreet() +  "', '" + r.getCity() +  "', '" + r.getState() +  "', '" + r.getPostalCode()  + "', " + " (select now()) )";
	                PreparedStatement st = con.connection.prepareStatement(sql);
	
					int rs = st.executeUpdate();
					if (rs > 0)
	                    JOptionPane.showMessageDialog(null, "Successfully Added");
					else
	                    JOptionPane.showMessageDialog(null, "Error");
					// clean the text areas for the next addition
	                t2.setText("");
	                t3.setText("");
	                t4.setText("");
	                t5.setText("");
	                t6.setText("");
	                t7.setText("");
	                t8.setText("");
	                t9.setText("");
	
					st.close();
            	}
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
}