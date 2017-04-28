package Manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.DropMode;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import javax.swing.event.ChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ContactGui extends JFrame 
{


	public static ArrayList<String> rList = new ArrayList<String>();
	
	private JLayeredPane famTab;
	private JLayeredPane frndTab;
	private JLayeredPane busnsTab;
	
	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtST;
	private JTextField txtZip;
	private JTextField txtHPhone;
	private JTextField txtMobile;
	private JTextField txtBDay;
	private JTextField txtNotes;
	private JTextField txtWPhone;
	private JTextField txtComp;
	private JTextField txtEmail;

	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmExit;
	
	private JMenuItem mntmJavadoc;
	private JMenuItem mntmAbout;
	
	private Button bttnNew;
	private Button bttnAdd;
	private Button bttnDelete;
	private Button bttnUpdate;
	private Button bttnSave;
	private JTabbedPane tabbedPane;
	private JComboBox<String> comboBox_Relationship;
	private JComboBox<String> comboBox;
	
	public static String bFile = "bContact.ser";
	private static String frFile = "frContact.ser";
	private static String famFile = "famContact.ser";
	private static String currentFile = "default.ser";
	
	private int cType;

	
	protected boolean testActionListenerActive = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ContactGui frame = new ContactGui();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public ContactGui()
	{
		initialize();
		
		JOptionPane.showMessageDialog(null, "Info: Please Load Lists","Action", JOptionPane.INFORMATION_MESSAGE);
		setOriginalButtonState();
		filRCombo();

		
//		ContactsList.deserializeBusiness(defaultFile);
		
	}// end MainGUI()
	/**
	 * Create the frame.
	 */
	public void initialize() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 339);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		mnFile.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save as");
		mntmSaveAs.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		mnFile.add(mntmSaveAs);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Your BFF Contacts were Saved","Notice",JOptionPane.INFORMATION_MESSAGE);
				ContactsList.writeBusinessFile();
//				ContactsList.writeFamilyFile();
//				ContactsList.writeFriendFile();
				System.exit(0);
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmJavadoc = new JMenuItem("JavaDoc");
		mntmJavadoc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			}
		});
		mnHelp.add(mntmJavadoc);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFName = new JTextField();
		txtFName.setBounds(200, 28, 86, 20);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		txtLName = new JTextField();
		txtLName.setBounds(297, 28, 128, 20);
		txtLName.setColumns(10);
		contentPane.add(txtLName);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(200, 77, 225, 20);
		txtAddress.setColumns(10);
		contentPane.add(txtAddress);
		
		txtCity = new JTextField();
		txtCity.setBounds(199, 118, 111, 20);
		txtCity.setColumns(10);
		contentPane.add(txtCity);
		
		txtST = new JTextField();
		txtST.setBounds(320, 118, 26, 20);
		txtST.setColumns(10);
		contentPane.add(txtST);
		
		txtZip = new JTextField();
		txtZip.setBounds(357, 118, 68, 20);
		txtZip.setColumns(10);
		contentPane.add(txtZip);
		
		txtHPhone = new JTextField();
		txtHPhone.setBounds(200, 158, 111, 20);
		txtHPhone.setColumns(10);
		contentPane.add(txtHPhone);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(320, 158, 104, 20);
		txtMobile.setColumns(10);
		contentPane.add(txtMobile);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(200, 11, 74, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(297, 11, 74, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(200, 55, 74, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(200, 99, 74, 14);
		contentPane.add(lblCity);
		
		JLabel lblSt = new JLabel("ST");
		lblSt.setBounds(320, 99, 26, 14);
		contentPane.add(lblSt);
		
		JLabel lblZipcode = new JLabel("Zipcode");
		lblZipcode.setBounds(356, 99, 59, 14);
		contentPane.add(lblZipcode);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		lblHomePhone.setBounds(200, 143, 74, 14);
		contentPane.add(lblHomePhone);
		
		JLabel lblMobilePhone = new JLabel("Mobile Phone");
		lblMobilePhone.setBounds(321, 143, 104, 14);
		contentPane.add(lblMobilePhone);
		
		bttnNew = new Button("New");
		bttnNew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				clearTextFields();
				enableAdd();
				
				
				
			}
		});
		bttnNew.setBounds(200, 184, 70, 22);
		contentPane.add(bttnNew);
		
		bttnAdd = new Button("Add");
		bttnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(reqInfo() && noDuplicate())
				{
					
					if(cType == 3)
					{
						BusinessContacts contact = new BusinessContacts(txtFName.getText(), txtLName.getText() , 
																   txtAddress.getText(), txtCity.getText(), 
																   txtST.getText(), txtZip.getText(), 
																   txtMobile.getText(), txtHPhone.getText(), 
																   txtComp.getText(), txtWPhone.getText(),
																   txtEmail.getText());
						ContactsList.businessList.add(contact);
						comboBox.addItem(contact.getFLName()+ contact.getCompany());
						
					}
					else if(cType == 2)
					{
						FriendContacts fC = new FriendContacts(txtFName.getText(), txtLName.getText() , 
								   							txtAddress.getText(), txtCity.getText(), 
								   							txtST.getText(), txtZip.getText(), 
								   							txtMobile.getText(), txtHPhone.getText(), txtNotes.getText());
						ContactsList.friendList.add(fC);
						comboBox.addItem(fC.getFLName());
					}
					else if(cType == 1)
					{
//						String relationship = comboBox_Relationship.getSelectedIndex();
						
						FamilyContacts famC = new FamilyContacts(txtFName.getText(), txtLName.getText() , 
	   															 txtAddress.getText(), txtCity.getText(), 
	   															 txtST.getText(), txtZip.getText(), 
	   															 txtMobile.getText(), txtHPhone.getText(), 
	   															 comboBox_Relationship.getSelectedIndex(), txtBDay.getText());
						ContactsList.familyList.add(famC);
						comboBox.addItem(famC.getFLName());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error: unknown","WARNING", JOptionPane.ERROR_MESSAGE);
					}
					
					enableSUD();
					
				}
				else
					JOptionPane.showMessageDialog(null, "Error: Enter minimum info (First/Last Name & mobil Number)","WARNING", JOptionPane.ERROR_MESSAGE);
			}
				
				
		});
		bttnAdd.setBounds(276, 184, 70, 22);
		contentPane.add(bttnAdd);
		
		bttnDelete = new Button("Delete");
		bttnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(comboBox.getItemCount() == 1)
				{
					comboBox.addItem(" ");
					comboBox.remove(0);
					comboBox.setSelectedIndex(0);
					clearTextFields();
				}
				else if(comboBox.getSelectedIndex() == 0)
				{
					comboBox.setSelectedIndex(1);
					updateTextFields(comboBox.getSelectedIndex());
					comboBox.removeItemAt(0);
//					businessContact.remove(0);
					if(cType == 1)
					{
						ContactsList.familyList.remove(0);
					}
					else if(cType == 2)
					{
						ContactsList.friendList.remove(0);
					}
					else if(cType == 3)
					{
						ContactsList.businessList.remove(0);
					}
				}
				else if(comboBox.getSelectedIndex() == comboBox.getItemCount()-1)
				{
					comboBox.setSelectedIndex(0);
					updateTextFields(comboBox.getSelectedIndex());
					comboBox.removeItemAt(comboBox.getItemCount()-1);
					if(cType == 1)
					{
						ContactsList.familyList.remove(comboBox.getItemCount()-1);
					}
					else if(cType == 2)
					{
						ContactsList.friendList.remove(comboBox.getItemCount()-1);
					}
					else if(cType == 3)
					{
						ContactsList.businessList.remove(comboBox.getItemCount()-1);
					}

				}
				else
				{
					int delete = comboBox.getSelectedIndex();
					comboBox.setSelectedIndex(0);
					comboBox.removeItemAt(delete);
					if(cType == 1)
					{
						ContactsList.familyList.remove(delete);
					}
					else if(cType == 2)
					{
						ContactsList.friendList.remove(delete);
					}
					else if(cType == 3)
					{
						ContactsList.businessList.remove(delete);
					}
					updateTextFields(0);
				}
			}
		});
		bttnDelete.setBounds(352, 184, 73, 22);
		contentPane.add(bttnDelete);
		
		bttnUpdate = new Button("Update");
		bttnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		bttnUpdate.setBounds(320, 209, 70, 22);
		contentPane.add(bttnUpdate);
		
		bttnSave = new Button("Save");
		bttnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		bttnSave.setBounds(240, 209, 70, 22);
		contentPane.add(bttnSave);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(testActionListenerActive)
				{
					updateTextFields(comboBox.getSelectedIndex());
				}
			}
		});
		comboBox.setBounds(10, 28, 180, 20);
		contentPane.add(comboBox);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
			}
		});
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(10, 55, 180, 174);
		contentPane.add(tabbedPane);
		
		famTab = new JLayeredPane();
		famTab.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentShown(ComponentEvent e) 
			{
				reactToTab(1, ContactsList.familyList);
//				comboBox_Relationship.setSelectedIndex(anIndex);
				System.out.println("Family Tab is choosen");
			}
		});
		tabbedPane.addTab("Family", null, famTab, null);
		
		comboBox_Relationship = new JComboBox();
		comboBox_Relationship.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//needs to set relationship of the current family contact list
				FamilyContacts fC = ContactsList.familyList.get(comboBox.getSelectedIndex());
				fC.setRelationship(comboBox_Relationship.getSelectedIndex());
			}
		});
		comboBox_Relationship.setBounds(10, 22, 154, 20);
		famTab.add(comboBox_Relationship);
		
		JLabel lblRelationship = new JLabel("Relationship");
		lblRelationship.setBounds(10, 0, 100, 20);
		famTab.add(lblRelationship);
		
		txtBDay = new JTextField();
		txtBDay.setBounds(10, 73, 154, 20);
		famTab.add(txtBDay);
		txtBDay.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday (mm/dd/yyyy)");
		lblBirthday.setBounds(10, 53, 129, 20);
		famTab.add(lblBirthday);
		
		frndTab = new JLayeredPane();
		frndTab.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentShown(ComponentEvent arg0) 
			{
				reactToTab(2, ContactsList.friendList);
				System.out.println("friend tab is choosen");
			}
		});
		tabbedPane.addTab("Friends", null, frndTab, null);
		
		txtNotes = new JTextField();
		txtNotes.setBounds(0, 28, 174, 76);
		frndTab.add(txtNotes);
		txtNotes.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(10, 11, 46, 14);
		frndTab.add(lblNotes);
		
		busnsTab = new JLayeredPane();
		busnsTab.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentShown(ComponentEvent e) 
			{
				reactToTab(3, ContactsList.businessList);
				System.out.println("Business tab is choosen");
			}
		});
		tabbedPane.addTab("Business", null, busnsTab, null);
		
		txtWPhone = new JTextField();
		txtWPhone.setBounds(10, 63, 154, 20);
		busnsTab.add(txtWPhone);
		txtWPhone.setColumns(10);
		
		txtComp = new JTextField();
		txtComp.setColumns(10);
		txtComp.setBounds(10, 25, 155, 20);
		busnsTab.add(txtComp);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 97, 154, 20);
		busnsTab.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 84, 46, 14);
		busnsTab.add(lblEmail);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBounds(10, 11, 74, 14);
		busnsTab.add(lblCompany);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		lblWorkPhone.setBounds(10, 50, 74, 14);
		busnsTab.add(lblWorkPhone);
	}


	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public boolean reqInfo()
	{
		if(txtFName.getText() != null && txtMobile.getText() != null)
		{
			return true;
		}
		else
		return false;
	}
	
	protected boolean noDuplicate() 
	{
		
		return true;
	}

	private void setOriginalButtonState()
	{
		bttnNew.setEnabled(true);
		bttnSave.setEnabled(false);
		bttnDelete.setEnabled(true);
		bttnUpdate.setEnabled(true);
		bttnAdd.setEnabled(false);
	}
	private void enableAdd()
	{
		bttnNew.setEnabled(false);
		bttnSave.setEnabled(false);
		bttnDelete.setEnabled(false);
		bttnUpdate.setEnabled(false);
		bttnAdd.setEnabled(true);
	}
	private void enableSUD()
	{
		bttnNew.setEnabled(true);
		bttnSave.setEnabled(true);
		bttnDelete.setEnabled(true);
		bttnUpdate.setEnabled(true);
		bttnAdd.setEnabled(false);
	}

	private void clearTextFields()
	{
		txtFName.setText("");
		txtLName.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtZip.setText("");
		txtHPhone.setText("");
		txtMobile.setText("");
		txtBDay.setText("");
		txtNotes.setText("");
		txtWPhone.setText("");
		txtComp.setText("");
		txtEmail.setText("");
	}
	
	private void updateTextFields(int idx)
	{
		if(cType == 1)
		{
			FamilyContacts fC = ContactsList.familyList.get(idx);
			txtFName.setText(fC.getFirstName());
			txtLName.setText(fC.getLastName());
			txtAddress.setText(fC.getStreetAddress());
			txtCity.setText(fC.getCity());
			txtST.setText(fC.getState());
			txtZip.setText(fC.getZip());
			txtHPhone.setText(fC.getHomeNumber());
			txtMobile.setText(fC.getMobileNumber());
			txtBDay.setText(fC.getBirthDay());
			comboBox_Relationship.setSelectedIndex(fC.getRelationship());
			
		}
		else if(cType == 2)
		{
			FriendContacts frC = ContactsList.friendList.get(idx);
			txtFName.setText(frC.getFirstName());
			txtLName.setText(frC.getLastName());
			txtAddress.setText(frC.getStreetAddress());
			txtCity.setText(frC.getCity());
			txtST.setText(frC.getState());
			txtZip.setText(frC.getZip());
			txtHPhone.setText(frC.getHomeNumber());
			txtMobile.setText(frC.getMobileNumber());
			txtNotes.setText(frC.getNotes());
			
		}
		else if(cType == 3)
		{
			BusinessContacts bC = ContactsList.businessList.get(idx);
			txtFName.setText(bC.getFirstName());
			txtLName.setText(bC.getLastName());
			txtAddress.setText(bC.getStreetAddress());
			txtCity.setText(bC.getCity());
			txtST.setText(bC.getState());
			txtZip.setText(bC.getZip());
			txtHPhone.setText(bC.getHomeNumber());
			txtMobile.setText(bC.getMobileNumber());
			txtComp.setText(bC.getCompany());
			txtWPhone.setText(bC.getWorkPhone());
			txtEmail.setText(bC.geteMail());
		}  
		
	}
	public void setCType(int type)
	{
		cType = type;
	}
	public void filRCombo()
	{
		rList.add("Dad");
		rList.add("Mom");
		rList.add("Brother");
		rList.add("Sister");
		rList.add("Cousin");
		rList.add("Aunt");
		rList.add("Uncle");
		rList.add("Grandpa");
		rList.add("Grandma");
		
		for(String index: rList)
		{
			comboBox_Relationship.addItem(index);
		}
	}
	public <E> void loadComboBox(ArrayList<E> list)
	{
		for(E index: list)
		{
			comboBox.addItem(((Contacts) index).getFLName());
		}
		
	}
	public void turnOnListener()
	{
		SwingUtilities.invokeLater(() -> testActionListenerActive = true);
	}
	public <E> void reactToTab(int cType, ArrayList<E> list)
	{
		setCType(cType);
		testActionListenerActive = false;
		comboBox.removeAllItems();
		loadComboBox(list);
		updateTextFields(0);
		turnOnListener();
		comboBox.setSelectedIndex(0);
	}
	
}
