package Pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Records extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Records frame = new Records();
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
	public Records() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 952, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTheFindHistory = new JLabel("Records of all the lost people");
		lblTheFindHistory.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblTheFindHistory.setBounds(66, 29, 572, 44);
		panel.add(lblTheFindHistory);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Records.class.getResource("/Pack1/Images/icons8_Marker_52px_1.png")));
		label.setBounds(15, 16, 57, 57);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame frex = (JFrame) SwingUtilities.getRoot(arg0.getComponent());
				frex.setVisible(false);
				frex.dispose();
			}
		});
		label_1.setIcon(new ImageIcon(Records.class.getResource("/Pack1/Images/icons8_Delete_50px_1.png")));
		label_1.setBounds(894, 0, 56, 89);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 88, 952, 449);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnClick = new JButton("Click here to view Records");
		btnClick.setBackground(new Color(255, 255, 204));
		btnClick.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnClick.setBounds(15, 376, 345, 57);
		panel_1.add(btnClick);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 88, 952, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(24);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		scrollPane.setViewportView(table);
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String driver="com.mysql.cj.jdbc.Driver";
				try {
					Class.forName(driver);
					Connection conn=DriverManager.getConnection("jdbc:mysql://"+Home_page.dbn+":3306/oopmproj",Home_page.dbun,Home_page.dbps);
					PreparedStatement stmt=conn.prepareStatement("select * from records_missingppl");
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
	}
}
