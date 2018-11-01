package Pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;

public class Home_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		});
		panel_1.setBounds(0, 147, 310, 60);
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
		lblNewLabel_1.setBounds(25, 0, 252, 60);
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
		panel_5.setBounds(0, 215, 310, 60);
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
		panel_6.setBounds(0, 282, 310, 60);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(153, 102, 204));
		panel.add(panel_6);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Trash_Can_48px.png")));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(0, 0, 59, 60);
		panel_6.add(label_3);
		
		JLabel lblDeleteRecord = new JLabel("      Delete Record");
		lblDeleteRecord.setForeground(new Color(0, 0, 0));
		lblDeleteRecord.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lblDeleteRecord.setBackground(new Color(102, 0, 204));
		lblDeleteRecord.setBounds(15, 0, 252, 60);
		panel_6.add(lblDeleteRecord);
		
		JLabel lblCheckYourLoved = new JLabel("Check Status");
		lblCheckYourLoved.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCheckYourLoved.setBounds(374, 288, 466, 57);
		contentPane.add(lblCheckYourLoved);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		textField.setBounds(374, 348, 481, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		panel_4.setBounds(306, 262, 745, 430);
		contentPane.add(panel_4);
	}
}
