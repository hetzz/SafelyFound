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
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
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
	public static String dbun = "akshay_07cf";
	//public static String dbun = "root";
	public static String dbps = "@kshayps9";
	public static String dbn = "db4free.net";
	//public static String dbn = "192.168.15.151";
	//public static String dbn = "localhost";
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(306, 265, 745, 181);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
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
				r.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
				d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		
		JButton btnMaps = new JButton("Maps");
		btnMaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name;
				Name=textField.getText();
				String driver="com.mysql.cj.jdbc.Driver";
				try {
					Class.forName(driver);
					Connection conn=DriverManager.getConnection("jdbc:mysql://"+Home_page.dbn+":3306/oopmproj",Home_page.dbun,Home_page.dbps);
					PreparedStatement stmt=conn.prepareStatement("SELECT `Location` FROM `finds` WHERE `Name` = '"+Name+"'");
					ResultSet rs=stmt.executeQuery();
			boolean larr[] =new boolean[5];
					String stns[] = {"Matunga", "Mulund", "Mumbai Central", "Vidyavihar", "Thane"};
					Vector<Integer> stnord = new Vector<>();
					while(rs.next())
					{
						larr[java.util.Arrays.asList(stns).indexOf(rs.getString(1))] = true;
						if(!stnord.contains(java.util.Arrays.asList(stns).indexOf(rs.getString(1)))) stnord.add(java.util.Arrays.asList(stns).indexOf(rs.getString(1)));
					}
					
					String jslarr = "";
					for(int i = 0; i<stns.length; i++) 
						{
							jslarr = jslarr.concat(larr[i]? "true":"false");
							if(i < stns.length - 1) jslarr = jslarr.concat(",");
						}
					
					String jsstnord = stnord.toString();					
						
					
					//String location=rs.getString(1);
					//System.out.println(location);
					/*String lat="19.1720";
					String lng="72.9564";*/
					String html =
							"    src=\"https://maps.googleapis.com/maps/api/js?key&callback=initMap\">\n" + "<!DOCTYPE html>\n" + 
							"<html>\n" + 
							"  <head>\n" + 
							"    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" + 
							"    <meta charset=\"utf-8\">\n" + 
							"    <title>"+Name+"</title>\n" + 
							"    <style>\n" + 
							"      /* Always set the map height explicitly to define the size of the div\n" + 
							"       * element that contains the map. */\n" + 
							"      #map {\n" + 
							"        height: 100%;\n" + 
							"      }\n" + 
							"      /* Optional: Makes the sample page fill the window. */\n" + 
							"      html, body {\n" + 
							"        height: 100%;\n" + 
							"        margin: 0;\n" + 
							"        padding: 0;\n" + 
							"      }\n" + 
							"    </style>\n" + 
							"  </head>\n" + 
							"  <body>\n" + 
							"    <div id=\"map\"></div>\n" + 
							"    <script>\n" + 
							"\n" + 
							"      function initMap() {\n" + 
							"        var myLatLng = [{lat: 19.027633, lng: 72.850260}, {lat: 19.171848, lng: 72.956290}, { lat:18.969742, lng: 72.819414}, {lat: 19.079135, lng: 72.897205}, { lat: 19.186217, lng: 72.975462}];\n" + 
							"        var jslarr = ["+jslarr+"];\n" + 
							"var path = [];\n" + 
							"        var stnord = "+jsstnord+";\n" + 
							"        for(var i = 0; i<stnord.length; i++) \n" + 
							"        {\n" + 
							"          path.push(myLatLng[stnord[i]]);\n" + 
							"        } console.log(path);"+
							"		 var stnn = ['Matunga', 'Mulund', 'Mumbai Central', 'Vidyavihar', 'Thane'];\n" + 
							"        var map = new google.maps.Map(document.getElementById('map'), {\n" + 
							"          zoom: 12,\n" + 
							"          center: myLatLng[3]\n" + 
							"        });\n" + 
							"        \n" + 
							"        for(var i = 0; i<myLatLng.length; i++) if(jslarr[i]){ \n" + 
							"            var marker = new google.maps.Marker({\n" + 
							"            position: myLatLng[i],\n" + 
							"            map: map,\n" + 
							"            title: stnn[i]\n" + 
							"            }); } \n" + 
							"var missingPath = new google.maps.Polyline({\n" + 
							"          path: path,\n" + 
							"          geodesic: true,\n" + 
							"          strokeColor: '#FF0000',\n" + 
							"          strokeOpacity: 1.0,\n" + 
							"          strokeWeight: 2\n" + 
							"        });\n" + 
							"\n" + 
							"        missingPath.setMap(map);"+
							"      }\n" + 
							"    </script>\n" + 
							"    <script async defer\n" + 
							"    src=\"https://maps.googleapis.com/maps/api/js?key=&callback=initMap\">\n" + 
							"    </script>\n" + 
							"  </body>\n" + 
							"</html>";

					File file=new File("C:\\Users\\Hetal\\Desktop\\OOPM_Java\\OOPM-Project\\Missing people\\Maps\\"+Name+".html");
					FileOutputStream f=new FileOutputStream(file);
					byte b[]=html.getBytes();   
		             f.write(b); 
		             f.close();
		             Desktop.getDesktop().browse(file.toURI());
		        
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnMaps.setForeground(new Color(255, 255, 255));
		btnMaps.setBackground(new Color(0, 51, 153));
		btnMaps.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnMaps.setBounds(630, 136, 115, 35);
		panel_4.add(btnMaps);
		btnMaps.setVisible(false);
		
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
		
		
		
		JLabel lblCheckYourLoved = new JLabel("Check Status");
		lblCheckYourLoved.setBounds(67, 26, 466, 57);
		panel_4.add(lblCheckYourLoved);
		lblCheckYourLoved.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		textField = new JTextField();
		textField.setBounds(67, 78, 481, 57);
		panel_4.add(textField);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NameSearch();
				btnMaps.setVisible(true);
			}
		});
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		textField.setColumns(10);
		
		JButton button = new JButton("");
		button.setBounds(548, 78, 67, 57);
		panel_4.add(button);
		button.setBackground(new Color(255, 240, 245));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NameSearch();
				btnMaps.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(Home_page.class.getResource("/Pack1/Images/icons8_Search_48px.png")));
		
		
		
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
		table.setRowHeight(22);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		panel_9.add(scrollPane, BorderLayout.CENTER);
		
		
	}

	protected void NameSearch() {
		// TODO Auto-generated method stub
		String Name;
		Name=textField.getText();
		String driver="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection("jdbc:mysql://"+Home_page.dbn+":3306/oopmproj",Home_page.dbun,Home_page.dbps);
			PreparedStatement stmt=conn.prepareStatement("SELECT `Name`, `Location`, `Time` FROM `finds` WHERE `Name` = '"+Name+"'");
			ResultSet rs=stmt.executeQuery();
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
		
		
	}
}
