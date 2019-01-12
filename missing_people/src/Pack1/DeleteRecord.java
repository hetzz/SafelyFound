package Pack1;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class DeleteRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox chckbxSendAnEmail;
	JLabel label_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteRecord frame = new DeleteRecord();
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
	public DeleteRecord() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 650, 85);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JFrame frex = (JFrame) SwingUtilities.getRoot(e.getComponent());
				frex.setVisible(false);
				frex.dispose();
			}
		});
		label.setIcon(new ImageIcon(DeleteRecord.class.getResource("/Pack1/Images/icons8_Delete_50px_1.png")));
		label.setFont(new Font("Franklin Gothic Book", Font.BOLD, 27));
		label.setBounds(589, 0, 61, 110);
		panel.add(label);

		JLabel label_1 = new JLabel("Please Fill the Details");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 27));
		label_1.setBackground(new Color(255, 153, 51));
		label_1.setBounds(99, 0, 383, 78);
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(DeleteRecord.class.getResource("/Pack1/Images/icons8_Edit_50px.png")));
		label_2.setBounds(15, 16, 69, 78);
		panel.add(label_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 83, 650, 417);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblComplainersName = new JLabel("Complainer's Name");
		lblComplainersName.setBounds(51, 163, 260, 30);
		panel_1.add(lblComplainersName);
		lblComplainersName.setForeground(Color.BLACK);
		lblComplainersName.setFont(new Font("Segoe UI", Font.BOLD, 23));

		JLabel lblMissingPersonsName = new JLabel("Missing Person's Name");
		lblMissingPersonsName.setBounds(51, 34, 260, 39);
		panel_1.add(lblMissingPersonsName);
		lblMissingPersonsName.setForeground(Color.BLACK);
		lblMissingPersonsName.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblMissingPersonsName.setBackground(Color.BLACK);

		JLabel label_5 = new JLabel("Age");
		label_5.setBounds(51, 96, 74, 39);
		panel_1.add(label_5);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 23));

		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(325, 41, 241, 31);
		panel_1.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(325, 106, 241, 31);
		panel_1.add(textField_2);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(326, 168, 241, 31);
		panel_1.add(textField_1);

		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		label_3.setBounds(107, 351, 314, 50);
		panel_1.add(label_3);
		
		chckbxSendAnEmail = new JCheckBox("Send an email");
		chckbxSendAnEmail.setBackground(Color.WHITE);
		chckbxSendAnEmail.setSelected(true);
		chckbxSendAnEmail.setFont(new Font("Dialog", Font.BOLD, 17));
		chckbxSendAnEmail.setBounds(436, 286, 199, 23);
		panel_1.add(chckbxSendAnEmail);


		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String driver = "com.mysql.cj.jdbc.Driver";
					Class.forName(driver);
					Connection conn = DriverManager.getConnection("jdbc:mysql://"+Home_page.dbn+":3306/oopmproj",
							Home_page.dbun, Home_page.dbps);
					PreparedStatement strt = conn.prepareStatement(
							"SELECT * FROM records_missingppl WHERE Name = ?");
					strt.setString(1,textField.getText());
					ResultSet rs = strt.executeQuery();
					rs.next();
					String filename =rs.getString(5);
					PreparedStatement str = conn.prepareStatement(
							"SELECT * FROM records_complainer WHERE NameM = ?");
					str.setString(1,textField.getText());
					ResultSet r = str.executeQuery();
					r.next();
					if (chckbxSendAnEmail.isSelected()) {
						SentEmail s = new SentEmail(r.getString(3), "Some good news",
								"Your kid has been found!!!! WE LOVED TO HELP YOU FIND YOUR LOVED ONE");

						label_4.setText("Email Sent Successfully");
					}
					try {
						String nameM, nameC;
						int age;
						long mobile_no = Long.parseLong(textField_2.getText());
						nameM = textField.getText();
						age = Integer.parseInt(textField_2.getText());
						nameC = textField_1.getText();
						String query1 = "delete from records_complainer where NameC = ?";
						PreparedStatement Strt = conn.prepareStatement(query1);
						Strt.setString(1, nameC);
						Strt.execute();
						String query = "delete from records_missingppl where Name = ?";
						PreparedStatement Stmt = conn.prepareStatement(query);
						Stmt.setString(1, nameM);
						Stmt.execute();

						conn.close();
						try {
							HttpResponse<JsonNode> deleteR = Unirest.post(Surveillance.urlc+"/delete")
							        .header("Content-Type", "application/json")
							        .header("accept", "application/json")
							        .body("{\"key\":\"!!MyKey@123eOOPM\", \"filename\":\""+filename+"\"}")
							        .asJson();
						} catch (UnirestException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Surveillance.stopSurveillance();
						Surveillance.startSurveillance();
						label_3.setText("The record has been deleted");
					} catch (Exception e) {
						System.out.println(e);
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDeleteRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label_3.setText("Record Deleted");
			}
		});
		btnDeleteRecord.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		btnDeleteRecord.setBackground(new Color(255, 255, 204));
		btnDeleteRecord.setBounds(436, 318, 199, 83);
		panel_1.add(btnDeleteRecord);

		label_4 = new JLabel("");
		label_4.setBounds(298, 263, 123, 39);
		panel_1.add(label_4);

		
	}
}
