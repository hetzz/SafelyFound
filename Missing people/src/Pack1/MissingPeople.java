package Pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import javax.swing.JRadioButton;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.print.attribute.standard.Compression;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Iterator;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MissingPeople  extends JFrame{

	public JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void compress(File f, double compressionRatio) 
	{
		try {
			File input = f;
		    BufferedImage image = ImageIO.read(input);
	
		    File compressedImageFile = new File("compressed_image.jpg");
		    OutputStream os = new FileOutputStream(compressedImageFile);
	
		    Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
		    ImageWriter writer = (ImageWriter) writers.next();
	
		    ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		    writer.setOutput(ios);
	
		    ImageWriteParam param = writer.getDefaultWriteParam();
	
		    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		    param.setCompressionQuality(0.4f);  // Change the quality value you prefer
		    writer.write(null, new IIOImage(image, null, null), param);
	
		    os.close();
		    ios.close();
		    writer.dispose();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	  }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MissingPeople window = new MissingPeople();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MissingPeople() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 650, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLastSceneOn = new JLabel("Last Scene on");
		lblLastSceneOn.setForeground(new Color(0, 0, 0));
		lblLastSceneOn.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblLastSceneOn.setBounds(29, 253, 171, 39);
		frame.getContentPane().add(lblLastSceneOn);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 0, 0));
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblGender.setBounds(29, 308, 123, 39);
		frame.getContentPane().add(lblGender);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(215, 266, 241, 29);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblComplainersName = new JLabel("Name");
		lblComplainersName.setForeground(new Color(0, 0, 0));
		lblComplainersName.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblComplainersName.setBounds(29, 484, 241, 39);
		frame.getContentPane().add(lblComplainersName);
		
		JLabel lblMobileNo = new JLabel("Email ID");
		lblMobileNo.setForeground(new Color(0, 0, 0));
		lblMobileNo.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblMobileNo.setBounds(29, 539, 149, 39);
		frame.getContentPane().add(lblMobileNo);
		
		JLabel lblRelation = new JLabel("Relation");
		lblRelation.setForeground(new Color(0, 0, 0));
		lblRelation.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblRelation.setBounds(29, 594, 149, 39);
		frame.getContentPane().add(lblRelation);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 650, 110);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("");
		lblX.setBounds(600, 0, 50, 110);
		panel.add(lblX);
		lblX.setIcon(new ImageIcon(MissingPeople.class.getResource("/Pack1/Images/icons8_Delete_50px_1.png")));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame frex = (JFrame) SwingUtilities.getRoot(arg0.getComponent());
				frex.setVisible(false);
				frex.dispose();
			}
		});
		lblX.setFont(new Font("Franklin Gothic Book", Font.BOLD, 27));
		
		JLabel lblAddTheFollowing = new JLabel("Please Fill the Details");
		lblAddTheFollowing.setForeground(new Color(0, 0, 0));
		lblAddTheFollowing.setBounds(99, 0, 383, 78);
		panel.add(lblAddTheFollowing);
		lblAddTheFollowing.setBackground(new Color(255, 153, 51));
		lblAddTheFollowing.setFont(new Font("Segoe UI Semilight", Font.BOLD, 27));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MissingPeople.class.getResource("/Pack1/Images/icons8_Edit_50px.png")));
		lblNewLabel.setBounds(15, 16, 79, 78);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 0, 102));
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(0, 419, 650, 53);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblComplainersDetails = new JLabel("Complainer's Details");
		lblComplainersDetails.setForeground(new Color(0, 0, 0));
		lblComplainersDetails.setBounds(68, 0, 383, 53);
		panel_1.add(lblComplainersDetails);
		lblComplainersDetails.setFont(new Font("Segoe UI Semilight", Font.BOLD, 25));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MissingPeople.class.getResource("/Pack1/Images/icons8_Contacts_50px.png")));
		label.setBounds(15, 0, 62, 63);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 107, 650, 313);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(212, 44, 241, 31);
		panel_2.add(textField);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setBounds(74, 36, 133, 39);
		panel_2.add(lblName);
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 23));
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(84, 100, 74, 39);
		panel_2.add(lblAge);
		lblAge.setForeground(new Color(0, 0, 0));
		lblAge.setFont(new Font("Segoe UI", Font.BOLD, 23));
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(354, 210, 115, 29);
		panel_2.add(rdbtnMale);
		rdbtnMale.setBackground(new Color(255, 255, 255));
		rdbtnMale.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Segoe UI", Font.BOLD, 23));
		
		JRadioButton rdbtnFemal = new JRadioButton("Female");
		rdbtnFemal.setBounds(212, 210, 115, 29);
		panel_2.add(rdbtnFemal);
		rdbtnFemal.setBackground(new Color(255, 255, 255));
		rdbtnFemal.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rdbtnFemal);
		rdbtnFemal.setFont(new Font("Segoe UI", Font.BOLD, 23));
		

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MissingPeople.class.getResource("/Pack1/Images/icons8_Checkmark_23px.png")));
		label_2.setBounds(330, 266, 29, 31);
		panel_2.add(label_2);
		label_2.setVisible(false);
		
		
		int result=0;
		JFileChooser jFile=new JFileChooser();
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBackground(new Color(255, 255, 204));
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				jFile.setDialogTitle("Choose an Image to upload" );
				int result =jFile.showSaveDialog(null);

				
			}
		});
		btnUpload.setBounds(212, 266, 115, 31);
		panel_2.add(btnUpload);
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpload.setForeground(new Color(0, 0, 0));
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(26, 261, 123, 39);
		panel_2.add(lblImage);
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setFont(new Font("Segoe UI", Font.BOLD, 23));
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(212, 106, 241, 31);
		panel_2.add(textField_4);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 472, 650, 313);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		label_1.setBounds(39, 212, 357, 56);
		panel_3.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(213, 130, 338, 26);
		panel_3.add(textField_3);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 75, 338, 26);
		panel_3.add(textField_2);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 16, 338, 26);
		panel_3.add(textField_1);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		
		JButton btnAddRecord = new JButton("Add Record");
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					String filenameRet="";
					if(result== JFileChooser.APPROVE_OPTION)
					{
						String encodedfile = null;
						//Get this file path using JFileChooser instead
						String filePath = jFile.getSelectedFile().getAbsolutePath();
						File file = new File(filePath);
						
						
						String extension = "";
						int i = filePath.lastIndexOf('.');
						if (i > 0) {
						    extension = filePath.substring(i+1);
						}
						
						if (file.length() > 500000)
						{
							double compressionRatio=(0.85/file.length())*500000;
							compress(file, compressionRatio);
							file = new File("compressed_image.jpg");
							extension = "jpg";
						}
						
						
						Base64.Encoder encoder = Base64.getEncoder();
					    try {
					        FileInputStream fileInputStreamReader = new FileInputStream(file);
					        byte[] bytes = new byte[(int)file.length()];
					        fileInputStreamReader.read(bytes);
					        encodedfile = encoder.encodeToString(bytes).toString();
					        
					    } catch (FileNotFoundException e) {
					        // TODO Auto-generated catch block
					        e.printStackTrace();
					    } catch (IOException e) {
					        // TODO Auto-generated catch block
					        e.printStackTrace();
					    }
					    //System.out.println(encodedfile);
					    
						String name = textField.getText();
						try {
							HttpResponse<JsonNode> fileUpR = Unirest.post(Surveillance.urlc+"/gpr")
									.header("Content-Type", "application/json")
							        .header("accept", "application/json")
							        .body("{\"key\":\"!!MyKey@123eOOPM\", \"file\":\""+encodedfile+"\", \"name\":\""+name+"\", \"extension\":\""+extension+"\"}")
									.asJson();
							if((fileUpR.getBody().getObject().getString("uploaded")).equals("true"))
							{
								label_2.setVisible(true);
								filenameRet = fileUpR.getBody().getObject().getString("filename");
							}
								
						} catch (UnirestException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if(filenameRet.equals("")) return;
					String nameM,nameC,date,gender,relation,emailId;
					int age;
					nameC=textField_1.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					date = sdf.format(dateChooser.getDate());
					relation=textField_3.getText();
					emailId=textField_2.getText();
					age=Integer.parseInt(textField_4.getText());
					nameM=textField.getText();
					gender="Male";
					if(rdbtnFemal.isSelected())
						gender="Female";
					
					String driver="com.mysql.cj.jdbc.Driver";
					Class.forName(driver);
					Connection conn=DriverManager.getConnection("jdbc:mysql://"+Home_page.dbn+":3306/oopmproj",Home_page.dbun,Home_page.dbps);
					PreparedStatement strt=conn.prepareStatement("insert into records_missingppl values(?,?,?,?,?)");
		            strt.setString(1, nameM);
		            strt.setInt(2, age);
		            strt.setString(3, gender);
		            strt.setString(4,date);
		            strt.setString(5,  filenameRet);
		            strt.execute();
		            PreparedStatement str=conn.prepareStatement("insert into records_complainer values(?,?,?,?)");
		            str.setString(1, nameM);
		            str.setString(2, nameC);
		            str.setString(3, emailId);
		            str.setString(4,relation);
		            
		            
		            str.execute();
		            
					conn.close();
					
					
					
					Surveillance.stopSurveillance();
					Surveillance.startSurveillance();
					}catch(Exception e) {System.out.println(e);}
				label_1.setText("Record added Successfully");
			}
			
		});
		btnAddRecord.setBackground(new Color(255, 255, 204));
		btnAddRecord.setBounds(436, 194, 199, 83);
		panel_3.add(btnAddRecord);
		btnAddRecord.setFont(new Font("Franklin Gothic Book", Font.BOLD, 24));
		
	}
}
