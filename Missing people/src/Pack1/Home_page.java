package Pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.SystemColor;

public class Home_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JPanel panel_9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page frame = new Home_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home_page() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, 0, 310, 708);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(204, 153, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(153, 102, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Records r=new Records();
				r.setVisible(true);
			}
		});
		panel_1.setBounds(0, 151, 310, 60);
		panel_1.setBackground(new Color(153, 102, 204));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_More_50px.png")));
		label.setBounds(0, 0, 59, 60);
		panel_1.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("      Records");
		lblNewLabel_1.setBackground(new Color(102, 0, 204));
		lblNewLabel_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(27, 0, 252, 60);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(new Color(204, 153, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(153, 102, 204));
				
				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MissingPeople p=new MissingPeople();
				p.frame.setVisible(true);
				
				
			}
		});
		panel_5.setBounds(0, 212, 310, 60);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(153, 102, 204));
		panel.add(panel_5);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Contacts_50px.png")));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(0, 0, 59, 60);
		panel_5.add(label_2);
		
		JLabel lblAddNewDetail = new JLabel("  Add New Detail");
		lblAddNewDetail.setForeground(new Color(51, 51, 51));
		lblAddNewDetail.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblAddNewDetail.setBackground(new Color(102, 0, 204));
		lblAddNewDetail.setBounds(43, 0, 252, 60);
		panel_5.add(lblAddNewDetail);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(204, 153, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(153, 102, 204));	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DeleteRecord d=new DeleteRecord();
				d.setVisible(true);
			}
		});
		panel_6.setBounds(0, 273, 310, 60);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(153, 102, 204));
		panel.add(panel_6);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Trash_Can_48px.png")));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(0, 0, 59, 60);
		panel_6.add(label_3);
		
		JLabel lblDeleteRecord = new JLabel("      Delete Record");
		lblDeleteRecord.setForeground(new Color(51, 51, 51));
		lblDeleteRecord.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblDeleteRecord.setBackground(new Color(102, 0, 204));
		lblDeleteRecord.setBounds(15, 0, 252, 60);
		panel_6.add(lblDeleteRecord);
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_7.setBackground(new Color(204, 153, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(new Color(153, 102, 204));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Surveillance.startSurveillance();
			}
		});
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(153, 102, 204));
		panel_7.setBounds(0, 334, 310, 60);
		panel.add(panel_7);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Wall_Mount_Camera_50px.png")));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(0, 0, 79, 60);
		panel_7.add(label_4);
		
		JLabel lblStartSurveill = new JLabel("     Start Surveillance");
		lblStartSurveill.setForeground(new Color(51, 51, 51));
		lblStartSurveill.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblStartSurveill.setBackground(new Color(102, 0, 204));
		lblStartSurveill.setBounds(25, 0, 252, 60);
		panel_7.add(lblStartSurveill);
		
		JPanel panel_8 = new JPanel();
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_8.setBackground(new Color(204, 153, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_8.setBackground(new Color(153, 102, 204));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Surveillance.stopSurveillance();
			}
		});
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(153, 102, 204));
		panel_8.setBounds(0, 395, 310, 60);
		panel.add(panel_8);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Stop_50px.png")));
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(0, 0, 59, 60);
		panel_8.add(label_5);
		
		JLabel lblStopSurveillance = new JLabel("     Stop Surveillance ");
		lblStopSurveillance.setForeground(new Color(51, 51, 51));
		lblStopSurveillance.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblStopSurveillance.setBackground(new Color(102, 0, 204));
		lblStopSurveillance.setBounds(25, 0, 252, 60);
		panel_8.add(lblStopSurveillance);
		
		JLabel lblWe = new JLabel("We  ");
		lblWe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWe.setForeground(new Color(255, 204, 255));
		lblWe.setBounds(26, 55, 205, 20);
		panel.add(lblWe);
		
		JLabel lblNewLabel = new JLabel("your safety");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 204, 255));
		lblNewLabel.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Heart_Health_30px.png")));
		lblNewLabel.setBounds(62, 46, 180, 38);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 204, 255));
		separator.setBounds(15, 91, 267, 10);
		panel.add(separator);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		textField.setBounds(374, 348, 481, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("");
		button.setBackground(new Color(255, 240, 245));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Name;
				Name=textField.getText();
				String driver="com.mysql.cj.jdbc.Driver";
				try {
					Class.forName(driver);
					Connection conn=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/oopmproj","akshay_07cf","@kshayps9");
					PreparedStatement stmt=conn.prepareStatement("SELECT `Name`, `Location`, `Time` FROM `Finds` WHERE `Name` = '"+Name+"'");
					ResultSet rs=stmt.executeQuery();
					
					System.out.println(rs);
					table.setModel(DbUtils.resultSetToTableModel(rs));	
					panel_9.revalidate();
					panel_9.repaint();
					while (rs.next()) {
				        System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				        
				    }
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Hii");
			}
		});
		button.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Search_48px.png")));
		button.setBounds(856, 348, 67, 57);
		contentPane.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 102, 255));
		panel_2.setBounds(306, 84, 745, 181);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblThisIsHow = new JLabel("This is how help looks like !");
		lblThisIsHow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 23));
		lblThisIsHow.setBounds(218, 33, 312, 106);
		panel_2.add(lblThisIsHow);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(306, 0, 745, 87);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblX.setBounds(704, 0, 41, 87);
		panel_3.add(lblX);
		lblX.setForeground(new Color(51, 0, 102));
		lblX.setIcon(null);
		lblX.setFont(new Font("Franklin Gothic Book", Font.BOLD, 51));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(71, 16, 69, 20);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(306, 265, 745, 181);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblCheckYourLoved = new JLabel("Check Status");
		lblCheckYourLoved.setBounds(67, 26, 466, 57);
		panel_4.add(lblCheckYourLoved);
		lblCheckYourLoved.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		//scrollPane.setBounds(0, 0, 1000, 200);
		scrollPane.setPreferredSize(new Dimension(600, 60));
		panel_9 = new JPanel();
		panel_9.setLayout(new BorderLayout());
	    
		panel_9.setBounds(311, 442, 735, 266);
		//panel_9.setPreferredSize(new Dimension(50, 40));
		contentPane.add(panel_9);
		
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel_9.add(scrollPane, BorderLayout.CENTER);
	}
}