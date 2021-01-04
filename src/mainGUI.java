/*
 *  The main GUI class of the application
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;

public class mainGUI extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1,b2, b3, b4, b5;
    private JScrollPane scrollPane;
    private JLabel l1;
    private Record record;
    
    // parameters for initialization of contact table if it is needed
    private boolean mainTableExists = false;
    static SQLScript initScript;
    
	public mainGUI() throws SQLException {

		// main frame graphics
		setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 133, 771, 282);
		contentPane.add(scrollPane);

		// initialization of the frame components
		addTitle();
		addButtons();
		addSearchArea();		
		addTable();
		showAll();

		// contacts panel 
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Contacts",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(67, 54, 793, 368);
		contentPane.add(panel);
        panel.setBackground(Color.WHITE);	    
	    setVisible(true);
	    
    }
	
	public void addTable() {
		
		// initialization of the table and it's functionality
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent arg0) {
	                int row = table.getSelectedRow();
	                search.setText(table.getModel().getValueAt(row, 0).toString());
	            }
		});
		
		table.setBackground(new Color(240, 248, 255));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
	}
	
	public void addSearchArea() {
		
		// search area
		search = new JTextField();
		search.setBackground(new Color(255, 240, 245));
		search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
		search.setForeground(new Color(47, 79, 79));
		search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		search.setBounds(92, 89, 200, 33);
		contentPane.add(search);
		search.setColumns(10);
	}
	
	public void addButtons() {
		
		// search button
		b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		b1.setForeground(new Color(199, 21, 133));
		b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b1.setBounds(300, 89, 70, 33);
		contentPane.add(b1);

		//delete record button
		b2 = new JButton("Delete");
		b2.addActionListener(this);
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		b2.setBounds(660, 89, 90, 33);
		contentPane.add(b2);

		// edit records button
		b3 = new JButton("Edit");
		b3.addActionListener(this);
		b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b3.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		b3.setBounds(756, 89, 90, 33);
		contentPane.add(b3);
		
		// new record button -> take to add record window
		b4 = new JButton("Add");
		b4.addActionListener(this);
		b4.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		b4.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b4.setBounds(564, 89, 90, 33);
		contentPane.add(b4);
		
		// all records button
		b5 = new JButton("All");
		b5.addActionListener(this);
		b5.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b5.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		b5.setBounds(468, 89, 90, 33);
		contentPane.add(b5);
	}
	
	public void addTitle() {
		
		// title
		l1 = new JLabel("Contacts Details");
		l1.setForeground(new Color(107, 142, 35));
		l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		l1.setBounds(300, 15, 400, 47);
		contentPane.add(l1);
	}
	
	// define actions of the buttons
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            
            if(ae.getSource() == b1){ // SEARCH BUTTON
		        String sql = "SELECT * "
		        		+ "FROM contable "
		        		+ "WHERE name like '%" + search.getText() + "%'";
		    	PreparedStatement st = con.connection.prepareStatement(sql);
		        ResultSet rs = st.executeQuery();
		
		        table.setModel(DbUtils.resultSetToTableModel(rs));		
		        rs.close();
		        st.close();
            }

            if(ae.getSource() == b2){ // DELETE BUTTON
                int row = table.getSelectedRow();
                if(row != -1) {
	                String phone = table.getModel().getValueAt(row, 2).toString();
	                
				    String sql = "DELETE FROM contable "
				    		+ "WHERE name = '" + search.getText() + "' and phone = '" + phone + "'";
				    PreparedStatement st = con.connection.prepareStatement(sql);
				
				    JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.NO_OPTION) {
				
				    } else if (response == JOptionPane.YES_OPTION) {
				        int rs = st.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Deleted !!");
				        showAll();
	
				    } else if (response == JOptionPane.CLOSED_OPTION) {
				
				    }
				    
				    st.close();
                }
            }

            if(ae.getSource() == b3){ // EDIT BUTTON
                int row = table.getSelectedRow();
                if(row != -1) {
                	setVisible(false);
	            	EditRecordGUI editFrame = new EditRecordGUI(
	            			new Record(
		            			table.getModel().getValueAt(row, 0).toString(),
		            			table.getModel().getValueAt(row, 1).toString(), 
		            			table.getModel().getValueAt(row, 2).toString(),
		            			table.getModel().getValueAt(row, 3).toString(),
		            			table.getModel().getValueAt(row, 4).toString(), 
		            			table.getModel().getValueAt(row, 5).toString(),
		            			table.getModel().getValueAt(row, 6).toString(),
		            			table.getModel().getValueAt(row, 7).toString()
	            			)
	        			);
	            	editFrame.setVisible(true);
                }
            }
            
            if(ae.getSource() == b4){ // ADD BUTTON
				setVisible(false);
				AddRecordGUI addRec = new AddRecordGUI();
				addRec.setVisible(true);
            }
            
            if(ae.getSource() == b5){ // ALL BUTTON
  		        showAll();
              }
            con.connection.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
	
    // show all records function
	public void showAll() {
        try{
        	Conn con = new Conn();
            String sql = "SELECT * "
            		+ "FROM contable";
            PreparedStatement st = con.connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs.close();
            st.close();
            con.connection.close();
        }catch(Exception e) {
            System.out.println(e);
           }
        
	}

	// accessing MainTableExists
	public boolean isMainTableExists() {
		return mainTableExists;
	}

	// setting MainTableExists
	public void setMainTableExists(boolean mainTableExists) {
		this.mainTableExists = mainTableExists;
	}
	


}
