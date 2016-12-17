package GUI;

import DB.DBConnection;
import DB.*;
import Manufacturers.*;
import Products.*;
import HRPackage.Employee;
import IO.IO;
import Session.Session;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel; 

public class GUI extends JFrame {

    IO errorWriter = new IO();
    // panels
    private JPanel greetingPanel, mainPanel = new JPanel(), employeeTab,
            employeePanel, employeeSearchPanel, hourlyEmpTab, salaryEmpTab,
            commissionEmpTab, productTab, productPanel, manufacturerPanel,
            productSearchPanel, exitPanel;
    // tabs
    private JTabbedPane mainTabs, employeeTypeTab;

    // main labels
    private JLabel helloLbl;

    // labels for employee tab
    private JLabel firstNameLbl, 
            lastNameLbl, 
            addressLbl, 
            phoneNumberLbl,
            yearLbl, 
            monthLbl, 
            dayLbl, 
            weeklySalaryLbl, 
            hoursLbl, 
            hourRateLbl,
            salesLbl, 
            commissionRateLbl, 
            baseSalaryLbl, 
            searchEmpResultsLbl,
            searchProductResultsLbl,
    //added new generic labels for employee creation
            emphireDateYearlbl,
            empHireDateMonthlbl,
            empHireDateDaylbl,
            empSinlbl,
            empPositionlbl,
            empGenderlbl,
            empDepartmentlbl,
            empStatuslbl;

            

    // text boxes for employee tab
    private JTextField 
            firstNameTxt = new JTextField(15),
            lastNameTxt = new JTextField(15),
            addressTxt = new JTextField(15),
            phoneNumberTxt = new JTextField(15),
            yearTxt = new JTextField(15),
            monthTxt = new JTextField(15),
            dayTxt = new JTextField(15),
            searchEmployeeTxt = new JTextField(15),
            weeklySalaryTxt = new JTextField(15),
            hoursTxt = new JTextField(15),
            hourRateTxt = new JTextField(15),
            salesTxt = new JTextField(15),
            commissionRateTxt = new JTextField(15),
            baseSalaryTxt = new JTextField(15),
            //new submission fields added for employee creation
            
            emphireDateYearTxt = new JTextField(15),
            empHireDateMonthTxt = new JTextField(15),
            empHireDateDayTxt = new JTextField(15),
            empSinTxt = new JTextField(15),
            empPositionTxt = new JTextField(15),
            empGenderTxt = new JTextField(15),
            empDepartmentTxt = new JTextField(15),
            empStatusTxt = new JTextField(15);
    


    // textareas for search results
    private JTextArea searchEmpResults, searchProductResults;

    // buttons
    private JButton createHourlyEmployeeBtn, createSalaryEmployeeBtn,
            createCommEmployeeBtn, createProductBtn, searchEmployeeBtn,
            searchProductBtn, exitBtn;
    
    
    //search area panel, removed into sub section for ease of coding.
    
    //required check boxes for building search criteria, Ben Dunn. 
    // <editor-fold>
    private JCheckBox 
            searchEmpIDSelectedCheckBox = new JCheckBox(),
            searchEmpTypeSelectedCheckBo = new JCheckBox(),
            searchFirstNameSelectedCheckBox = new JCheckBox(),
            searchLastNameSelectedCheckBox = new JCheckBox(), 
            searchPositionSelectedCheckBox = new JCheckBox(),
            searchGenderSelectedCheckBox = new JCheckBox(),
            
            searchDepartmentSelectedCheckBox = new JCheckBox(), 
            searchSinSelectedCheckBox = new JCheckBox(), 
            searchBirthdaySelectedCheckBox = new JCheckBox(), 
            searchHiredateSelectedCheckBox = new JCheckBox(),
            searchStatusSelectedCheckBox = new JCheckBox(),
            searchPhoneSelectedCheckBox = new JCheckBox(),
            searchAddressSelectedCheckBox = new JCheckBox();
    
    //Labels
    private JLabel 
            searchEmpIDlbl = new JLabel("Employee ID: "), 
            searchEmpTypelbl = new JLabel("Employee Type: "), 
            searchFirstNamelbl = new JLabel("First Name: "),
            searchLastNamelbl = new JLabel("Last Name: "),
            searchPositionlbl= new JLabel("Position: "),
            searchGenderlbl = new JLabel("Gender: "),
            searchDepartmentlbl = new JLabel("Department: "), 
            searchSinlbl = new JLabel("Sin Number: "),
            searchBirthdaylbl = new JLabel("Birthday: "),
            searchHiredatelbl = new JLabel("Hire Date: "),
            searchStatuslbl = new JLabel("Status: "),
            searchPhonelbl = new JLabel("Phone Number: "),
            searchAddresslbl = new JLabel("Address: ");
    
    //Search areas based on user input
    private JTextArea 
            searchEmpIDTextBox = new JTextArea(1, 20),//emptype is dropdown
            searchFirstNameTextBox = new JTextArea(1, 20), 
            searchLastNameTextBox= new JTextArea(1, 20), 
            searchPositionTextBox= new JTextArea(1, 20),
            searchGenderTextBox= new JTextArea(1, 20), 
            searchDepartmentTextBox= new JTextArea(1, 20), 
            searchSinTextBox= new JTextArea(1, 20),
            searchbirthDayTextBox= new JTextArea(1, 20), 
            searchHireDateTextBox= new JTextArea(1, 20), 
            searchStatusTextBox= new JTextArea(1, 20),
            searchPhoneTextBox= new JTextArea(1, 20), 
            searchAddressTextBox= new JTextArea(1, 20),
    
            //text fields for editing an employee. 
            searchEDITEmpIDTextBox = new JTextArea(1, 20),//emptype is dropdown
            searchEDITFirstNameTextBox = new JTextArea(1, 20), 
            searchEDITLastNameTextBox= new JTextArea(1, 20), 
            searchEDITPositionTextBox= new JTextArea(1, 20),
            searchEDITGenderTextBox= new JTextArea(1, 20), 
            searchEDITDepartmentTextBox= new JTextArea(1, 20), 
            searchEDITSinTextBox= new JTextArea(1, 20),
            searchEDITbirthDayTextBox= new JTextArea(1, 20), 
            searchEDITHireDateTextBox= new JTextArea(1, 20), 
            searchEDITStatusTextBox= new JTextArea(1, 20),
            searchEDITPhoneTextBox= new JTextArea(1, 20), 
            searchEDITAddressTextBox= new JTextArea(1, 20);
    private JPanel 
            searchEditUpperPanel = new JPanel(), 
            searchEditLowerPanel = new JPanel(), 
            searchEditMainMain = new JPanel();
    
    
    
    private JButton
            searchEmpEditButton = new JButton("Edit"),
            searchEmpDeleteButton = new JButton("Delete"),
            searchEmpSubmitEditButton = new JButton("Submit Changes");
            
    
    // </editor-fold>
    
    //table layout for view, is overriding hte cell editable to
    //prevent a user from changing data from the table model
    JTable searchResultsTable = new JTable() {
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };;
    
    private ListSelectionModel searchEmployeeListSelectionModel;
    private Employee[] employeeStorage;
    private Employee selectedEmployee; 
    JScrollPane searchResultsScrollTable; //accessor. 
    DefaultTableModel searchResultsDefaultTableModel; 
    
    private ManufacturerIdentity manuIdenity; 
    private Manufacturer[] manuStorage;
    private Manufacturer selectedManu;
    
    private ProductIdentity prodIdentity;
    private Product[] proArray;
    private Product selectedProduct;
    
    //JPanel panel = new JPanel();
    
    //layouts for search
    private JPanel 
            searchMainPanel, //divided in half 
            searchResultsPanel, //right side
            searchCriteriaPanel, //upper lower divided in half (no center)
            searchCriteriaButtonsPanel, //holds the search button for a gridlayout. 
            searchCriteriaEntryPanel; //holds the areas. 
    
    
    //created by reference to classes. 
    private JComboBox searchEmpTypeComboBox = new JComboBox (new String[] 
    {"Commission Employee",
    "Hourly Employee",
    "Salary Employee"} );
    
    
    private int empCreateGetIndexofTabPane;
    
    //buttons
    private JButton searchEmployees; //activates the search for the database. 
    //SimpleVectorTable SearchResultsVectors = new SimpleVectorTable(); //results holder object
    //listeners
    SearchButtonListener searchBtnListener;
    
    //end of ben search initalization 

    // form font
    private Font mainFont = new Font("Verdana", Font.PLAIN, 14);

    // form border
    private Border mainBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

    // interface constructor
    public GUI(Session session) {

        // set title layout and 
        super("Assignment 3.");
        setLayout(new FlowLayout());

        
        // create tabs
        mainTabs = new JTabbedPane();

        // create main panels
        buildGreetingsPanel("Welcome to Assignment 3.");
        buildEmployeeTab();
        buildProductTab();
        buildExitPanel();
        this.buildSearchPanel();

        // add tabs
        mainTabs.addTab("Create an Employee", null, employeeTab, "Employee");
        mainTabs.addTab("Products", null, productTab, "Products");
        mainTabs.addTab("Search and Edit Employees", null, this.searchMainPanel, "Search Employees");

        // add subpanels to main panel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(greetingPanel, BorderLayout.NORTH);
        mainPanel.add(mainTabs, BorderLayout.CENTER);
        mainPanel.add(exitPanel, BorderLayout.SOUTH);

        add(mainPanel);
        
        // prevent resize. 
        this.pack();
        this.setResizable(false);
    }
    
        
    private void buildSearchPanel () {
        //init panels
        this.searchMainPanel = new JPanel();
        this.searchResultsPanel = new JPanel();
        this.searchCriteriaPanel = new JPanel();
        this.searchCriteriaButtonsPanel = new JPanel();
        this.searchCriteriaEntryPanel = new JPanel(); 
        
        
        //System.out.println(this.SearchResultsVectors.getColumnNames().toString());
        searchResultsTable = new JTable(this.searchResultsDefaultTableModel);
        //searchResultsTable.add
        //        empJTableListSelectionListener
        
        //set all important layouts. 
        this.searchMainPanel.setLayout(new BorderLayout());
        this.searchCriteriaPanel.setLayout(new BorderLayout());
        this.searchCriteriaEntryPanel.setLayout(new GridLayout(0,3));
        this.searchCriteriaButtonsPanel.setLayout(new GridLayout(0,1));
        this.searchResultsPanel.setLayout(new BorderLayout());
        
        //add searchButton for executing Queries. 
        this.searchEmployees = new JButton("Search DataBase for Employee");
        this.searchBtnListener = new SearchButtonListener(); 
        this.searchEmployees.addActionListener(this.searchBtnListener);
        this.searchEmployees.doClick(); //force a click
        this.searchResultsDefaultTableModel = searchBtnListener.returnMyTable();
        //this.searchBtnListener.actionPerformed(new ActionEvent());
        this.searchCriteriaButtonsPanel.add(this.searchEmployees);
        
        
        
        
        //add the components to the criteria entry panel;
       
        // <editor-fold>
        this.searchCriteriaEntryPanel.add(this.searchEmpIDlbl);
        this.searchCriteriaEntryPanel.add(this.searchEmpIDSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchEmpIDTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchEmpTypelbl);
        this.searchCriteriaEntryPanel.add(this.searchEmpTypeSelectedCheckBo);
        this.searchCriteriaEntryPanel.add(this.searchEmpTypeComboBox); // combo box
        
        
        this.searchCriteriaEntryPanel.add(this.searchFirstNamelbl);
        this.searchCriteriaEntryPanel.add(this.searchFirstNameSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchFirstNameTextBox);
        
      
        this.searchCriteriaEntryPanel.add(this.searchLastNamelbl);
        this.searchCriteriaEntryPanel.add(this.searchLastNameSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchLastNameTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchPositionlbl);
        this.searchCriteriaEntryPanel.add(this.searchPositionSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchPositionTextBox);
       
        
        
        this.searchCriteriaEntryPanel.add(this.searchGenderlbl);
        this.searchCriteriaEntryPanel.add(this.searchGenderSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchGenderTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchDepartmentlbl);
        this.searchCriteriaEntryPanel.add(this.searchDepartmentSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchDepartmentTextBox);
        
        
        
        this.searchCriteriaEntryPanel.add(this.searchSinlbl);
        this.searchCriteriaEntryPanel.add(this.searchSinSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchSinTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchBirthdaylbl);
        this.searchCriteriaEntryPanel.add(this.searchBirthdaySelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchbirthDayTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchHiredatelbl);
        this.searchCriteriaEntryPanel.add(this.searchHiredateSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchHireDateTextBox);
        
        
        this.searchCriteriaEntryPanel.add(this.searchStatuslbl);
        this.searchCriteriaEntryPanel.add(this.searchStatusSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchStatusTextBox);
        
        
        this.searchCriteriaEntryPanel.add(this.searchPhonelbl);
        this.searchCriteriaEntryPanel.add(this.searchPhoneSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchPhoneTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchAddresslbl);
        this.searchCriteriaEntryPanel.add(this.searchAddressSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchAddressTextBox);
        // </editor-fold>
        
        //empJTableListSelectionListener
        searchEmpEditButton.setEnabled(false);
        searchResultsTable.setModel(this.searchResultsDefaultTableModel);
            searchEmployeeListSelectionModel = searchResultsTable.getSelectionModel();
        searchEmployeeListSelectionModel.addListSelectionListener(new empJTableListSelectionListener());
        searchResultsTable.setSelectionModel(searchEmployeeListSelectionModel);
                
                
        //this.searchResultsTable = new JTable(this.searchResultsDefaultTableModel);
        this.searchResultsTable.setSize(300, 800);
        
            try {
            //placed inline as this is merely setup. 
                for (int i = 1; i <= (searchResultsTable.getColumnCount()); i++) 
                {
                    searchResultsTable.getColumn(i).setPreferredWidth(150);
                } 
            }
            catch (Exception e ) {
                System.out.println(e.getMessage());
                errorWriter.appendToFile("Packing issue: " + e.getMessage());
                //errorWriter.writeError(e);
            }
            
            //searchEmpEditButton.addActionListener();
            searchEmpDeleteButton.addActionListener(new DeleteButtonListener());
            this.searchEmpEditButton.addActionListener(new SelectForEditListener());
            JPanel searchEditDeletePanel = new JPanel(); 
            searchEditDeletePanel.setLayout(new GridLayout(0,2));
            searchEditDeletePanel.add(searchEmpDeleteButton);
            searchEditDeletePanel.add(this.searchEmpEditButton);
            
            
        this.searchResultsTable.doLayout(); //auto adusts the table. 
        
        System.out.println(this.searchResultsDefaultTableModel.getDataVector().size());
        this.buildSearchPanelSelection();
        //add the components to the results set panel
        this.searchResultsScrollTable = new JScrollPane(this.searchResultsTable); 
        
        
        this.searchResultsPanel.add(this.searchResultsScrollTable, BorderLayout.NORTH);
        //this.searchResultsPanel.add(this.searchEditMainMain, BorderLayout.CENTER);
        this.searchResultsPanel.add(searchEditDeletePanel, BorderLayout.SOUTH);
        
        this.searchCriteriaPanel.add(this.searchCriteriaEntryPanel,BorderLayout.NORTH);
        this.searchCriteriaPanel.add(this.searchCriteriaButtonsPanel, BorderLayout.SOUTH);
        this.searchMainPanel.add(this.searchCriteriaPanel, BorderLayout.WEST); //searchResultsPanel
        this.searchMainPanel.add(this.searchResultsPanel, BorderLayout.EAST);
        
    }
    
    private void buildSearchPanelSelection() {
            searchEditUpperPanel.setLayout(new GridLayout(0,2));
            searchEditLowerPanel.setLayout(new GridLayout(0,1));
            searchEditMainMain = new JPanel(new BorderLayout());
            
            //searchEditUpperPanel.add(searchEDITEmpIDTextBox);
            searchEditUpperPanel.add(new JLabel("First Name"));
            searchEditUpperPanel.add(searchEDITFirstNameTextBox);
            searchEditUpperPanel.add(new JLabel("Last Name"));
            searchEditUpperPanel.add(searchEDITLastNameTextBox);
            searchEditUpperPanel.add(new JLabel("Position"));
            searchEditUpperPanel.add(searchEDITPositionTextBox);
            searchEditUpperPanel.add(new JLabel("Gender"));
            searchEditUpperPanel.add(searchEDITGenderTextBox );
            searchEditUpperPanel.add(new JLabel("Department"));
            searchEditUpperPanel.add(searchEDITDepartmentTextBox );
            searchEditUpperPanel.add(new JLabel("Sin Number"));
            searchEditUpperPanel.add(searchEDITSinTextBox);
            searchEditUpperPanel.add(new JLabel("Status"));
            searchEditUpperPanel.add(searchEDITStatusTextBox);
            searchEditUpperPanel.add(new JLabel("Phone"));
            searchEditUpperPanel.add(searchEDITPhoneTextBox );
            searchEditUpperPanel.add(new JLabel("Address"));
            searchEditUpperPanel.add(searchEDITAddressTextBox);
            searchEmpSubmitEditButton.addActionListener(new UpdateButtonListener());
            this.searchEditLowerPanel.add(this.searchEmpSubmitEditButton);
            searchEditMainMain.add(this.searchEditUpperPanel, BorderLayout.NORTH);
            searchEditMainMain.add(this.searchEditLowerPanel, BorderLayout.SOUTH);
    }
    
    //build query tab for general searching of the employees 

    // build panels 
    // build greeting panel
    private void buildGreetingsPanel(String greetMessage) {
        greetingPanel = new JPanel();
        helloLbl = new JLabel(greetMessage);
        helloLbl.setFont(mainFont);
        greetingPanel.add(helloLbl);
        greetingPanel.setBorder(mainBorder);
    }

    // build employee tab and subpanels
    private void buildEmployeeTab() {
        // create tab
        employeeTab = new JPanel();
        buildEmployeePanel();
        buildEmployeeTypeTab();
        //buildEmployeeSearchPanel();

        // set layout and add all subpanels to employee tab
        employeeTab.setLayout(new BorderLayout());
        employeeTab.add(employeePanel, BorderLayout.NORTH);
        employeeTab.add(employeeTypeTab, BorderLayout.SOUTH);
        //employeeTab.add(employeeSearchPanel, BorderLayout.SOUTH);
    }

    private void buildEmployeePanel() {
        // create new panel
        employeePanel = new JPanel();
        // set grid
        employeePanel.setLayout(new GridLayout(0, 2));
        // set border
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee info"));
        // set labels
        firstNameLbl = new JLabel("First Name");
        lastNameLbl = new JLabel("Last Name");
        addressLbl = new JLabel("Address");
        phoneNumberLbl = new JLabel("Phone Number");
        yearLbl = new JLabel("Year of birth");
        monthLbl = new JLabel("Month of birth");
        dayLbl = new JLabel("Day of birth");
        
        //added code
        emphireDateYearlbl = new JLabel("Year of Hire");
        empHireDateMonthlbl = new JLabel("Month of Hire");
        empHireDateDaylbl = new JLabel("Day of Hire");
        empSinlbl = new JLabel("Sin Number");
        empPositionlbl = new JLabel("Position");
        empGenderlbl = new JLabel("Gender");
        empDepartmentlbl = new JLabel("Deparment");
        empStatuslbl =  new JLabel("Status");
        
        

        // add everything to panel
        employeePanel.add(firstNameLbl);
        employeePanel.add(firstNameTxt);
        employeePanel.add(lastNameLbl);
        employeePanel.add(lastNameTxt);
        employeePanel.add(addressLbl);
        employeePanel.add(addressTxt);
        employeePanel.add(phoneNumberLbl);
        employeePanel.add(phoneNumberTxt);
        employeePanel.add(yearLbl); 
        employeePanel.add(yearTxt);
        employeePanel.add(monthLbl);
        employeePanel.add(monthTxt);
        employeePanel.add(dayLbl);
        employeePanel.add(dayTxt);
        //added code new inputs
        employeePanel.add(emphireDateYearlbl); // needs handle
        employeePanel.add(emphireDateYearTxt); // needs handle
        employeePanel.add(empHireDateMonthlbl); // needs handle
        employeePanel.add(empHireDateMonthTxt); // needs handle
        employeePanel.add(empHireDateDaylbl); // needs handle
        employeePanel.add(empHireDateDayTxt); // needs handle
        employeePanel.add(empSinlbl); // needs handle
        employeePanel.add(empSinTxt); // needs handle
        employeePanel.add(empPositionlbl); 
        employeePanel.add(empPositionTxt);
        employeePanel.add(empGenderlbl);
        employeePanel.add(empGenderTxt);
        employeePanel.add(empDepartmentlbl); 
        employeePanel.add(empDepartmentTxt);
        employeePanel.add(empStatuslbl);
        employeePanel.add(empStatusTxt);
        
        
        
    }

    private void buildEmployeeTypeTab() {
        // create new tabs
        employeeTypeTab = new JTabbedPane();
        buildHourlyEmployeePanel();
        buildSalaryEmployeePanel();
        buildCommissionEmployeePanel();
 
        //controls what type of employee will be created for the idenity 
        // to the DB by listening to changes to the emp tab. 
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                employeeTypeTab = (JTabbedPane) changeEvent.getSource();
                empCreateGetIndexofTabPane = employeeTypeTab.getSelectedIndex();
                System.out.println("Emp creation Tab changed to: " + 
                        employeeTypeTab.getTitleAt(empCreateGetIndexofTabPane)+
                        " \n Index of: " + empCreateGetIndexofTabPane);
        }
        };
        employeeTypeTab.addChangeListener(changeListener); //adds the 

        
        // add panels to tabs
        employeeTypeTab.addTab("Hourly Emp", null, hourlyEmpTab, "Hourly Emp");
        employeeTypeTab.addTab("Salary Emp", null, salaryEmpTab, "Salary Emp");
        employeeTypeTab.addTab("Commission Emp", null, commissionEmpTab, "Commission Emp");
    }

    
    
    // build three subpanels for each employee type
    private void buildHourlyEmployeePanel() {
        // create new panel
        hourlyEmpTab = new JPanel();
        // set grid
        hourlyEmpTab.setLayout(new GridLayout(3, 2));
        // set border
        hourlyEmpTab.setBorder(BorderFactory.createTitledBorder("Create Hourly Employee"));
        // set labels
        hoursLbl = new JLabel("Hours");
        hourRateLbl = new JLabel("Hour Rate");
        // create button
        createHourlyEmployeeBtn = new JButton("Create Hourly Employee");
        createHourlyEmployeeBtn.addActionListener(new NewEmployeeButtonLisenter()); //ExitButtonListener
        // add everything to panel
        hourlyEmpTab.add(hoursLbl);
        hourlyEmpTab.add(hoursTxt);
        hourlyEmpTab.add(hourRateLbl);
        hourlyEmpTab.add(hourRateTxt);
        hourlyEmpTab.add(createHourlyEmployeeBtn);

    }
    
    

    private void buildSalaryEmployeePanel() {
        // create new panel
        salaryEmpTab = new JPanel();
        // set grid
        salaryEmpTab.setLayout(new GridLayout(2, 2));
        // set border
        salaryEmpTab.setBorder(BorderFactory.createTitledBorder("Create Salary Employee"));
        // set labels
        weeklySalaryLbl = new JLabel("Weekly salary");
        // create button
        createSalaryEmployeeBtn = new JButton("Create Salary Employee");
        createSalaryEmployeeBtn.addActionListener(new NewEmployeeButtonLisenter());
        // add everything to panel
        salaryEmpTab.add(weeklySalaryLbl);
        salaryEmpTab.add(weeklySalaryTxt);
        salaryEmpTab.add(createSalaryEmployeeBtn);
    }

    private void buildCommissionEmployeePanel() {
        // create new panel
        commissionEmpTab = new JPanel();
        // set grid
        commissionEmpTab.setLayout(new GridLayout(4, 2));
        // set border
        commissionEmpTab.setBorder(BorderFactory.createTitledBorder("Create Commission Employee"));
        // set labels
        salesLbl = new JLabel("Sales");
        commissionRateLbl = new JLabel("Commission Rate");
        baseSalaryLbl = new JLabel("Base salary");
        // create button
        createCommEmployeeBtn = new JButton("Create Commission Employee");
        createCommEmployeeBtn.addActionListener(new NewEmployeeButtonLisenter());
        
        // add everything to panel
        commissionEmpTab.add(salesLbl);
        commissionEmpTab.add(salesTxt);
        commissionEmpTab.add(commissionRateLbl);
        commissionEmpTab.add(commissionRateTxt);
        commissionEmpTab.add(baseSalaryLbl);
        commissionEmpTab.add(baseSalaryTxt);
        commissionEmpTab.add(createCommEmployeeBtn);
    }





    //builds the product search panel
    private void buildProductSearchPanel() {
        // create new panel
        productSearchPanel = new JPanel();
        // set grid
        productSearchPanel.setLayout(new GridLayout(4, 1));
        // set border
        productSearchPanel.setBorder(BorderFactory.createTitledBorder("Search product by name"));
        // set labels
        searchProductResultsLbl = new JLabel("Search results:");
        // create search button
        searchProductBtn = new JButton("Search");
        // create text area for search results
        searchProductResults = new JTextArea(3, 20);

        // add everything to panel
        productSearchPanel.add(searchProductTxt);
        productSearchPanel.add(searchProductBtn);
        productSearchPanel.add(searchProductResultsLbl);
        productSearchPanel.add(searchProductResults);
    }

    // build bottom panel with exit button
    private void buildExitPanel() {
        exitPanel = new JPanel();
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ExitButtonListener());
        exitPanel.add(exitBtn);
    }

    
    
    
    
    /**
     * Sets up either a search criteria of values (1), or sections (2) 
     * @param setupFlag
     * @return 
     */
    private String[] createEmpSearchCriteria (int setupFlag)  {
        ArrayList<String> temp = new ArrayList<String>();
        
        if (this.searchEmpIDSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add(this.searchEmpIDTextBox.getText());
            } 
            else if (setupFlag == 2) {
                temp.add("EmpID");
            }
            
        }
        //comboBox.getSelectedItem().toString()
        if (this.searchEmpTypeSelectedCheckBo.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add(this.searchEmpTypeComboBox.toString());
            } 
            else if (setupFlag == 2) {
                temp.add("EmpType");
            }
            
        }
        if (this.searchFirstNameSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchFirstNameTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("firstName");
            }
            
        }
        if (this.searchLastNameSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchLastNameTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("lastName");
            }
        }
        
        if (this.searchPositionSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchPositionTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("position");
            }
            
        }
        if (this.searchGenderSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchGenderTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("gender");
            }
        }
        if (this.searchDepartmentSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchDepartmentTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("department");
            }
            
        }
        if (this.searchSinSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchSinTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("sin");
            }
        }
        if (this.searchBirthdaySelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchbirthDayTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("birthDate");
            }
            
        }
        if (this.searchHiredateSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchHireDateTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("hireDate");
            }
        }
        
        if (this.searchStatusSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchStatusTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("status");
            }
        }
        if (this.searchPhoneSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchPhoneTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("phone");
            }
        }
        if (this.searchAddressSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'" + this.searchAddressTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("address");
            }
        }
        
        // String [] stockArr = stockList.toArray(new String[stockList.size()]);
        //could probably do this in a statement, but brain fried. 
        
        String[] returnValue = temp.toArray(new String[temp.size()]);
        
        return returnValue;
        
    }

/**
 * Creates an SQL string statement to pull from a database. Created by Ben
 * Dunn. 
 * @param SearchCriteria
 * @param searchKey
 * @param TableName
 * @return a string representing the SQL query that will need to be run on
 * the datadbase. 
 * @throws IndexOutOfBoundsException 
 */
    private String searchSetup (String[] SearchCriteria, String[] searchKey, String TableName) 
    throws IndexOutOfBoundsException
    {
        System.out.println("Reached Creation of statement");
        //throw the exception if the searchKeys.legnth =! SearchCriteria
        if (SearchCriteria.length!=searchKey.length) {
            throw new IndexOutOfBoundsException("Array sizes are not equal in search criteria"); 
        } //no issues. 
        
        
        String searchString = "SELECT * FROM " + TableName + " ";
        //System.out.println(searchString);
        try {
        for (int k =0; k<= SearchCriteria.length-1; k++) 
        {
            
            //flip the switch for and/where queries. 
            if (k == 0) {
                searchString += "WHERE ";
            }
            else {
                searchString += "AND ";
            }
            searchString += SearchCriteria[k] + " = " + searchKey[k]; //add the value to the end. 
            
        }} catch (IndexOutOfBoundsException e) {
            //errorWriter.writeError(e);
            errorWriter.appendToFile("index of the legnth was out of bounds" + e.getMessage());
            System.out.println("index of the legnth was out of bounds");
        }
        
        
        searchString += ";";
        //debug system out for checking
        System.out.println("Query = " + searchString);
        
        return searchString; 
        
    }
    
    
    
    
    /**
     * deletes the instance of the employee at the index selected
     * by the user. 
     */
    private void deleteEmployee() {
        int Delete = this.employeeStorage[this.searchResultsTable.getSelectedRow()].getEmpId();
        //this.employeeStorage[0];
        DBConnection conn = new DBConnection(); 
        try {
            conn.deleteSQLDataBase("Employee","EmpID", Delete);
            this.searchEmployees.doClick(); //force and update through an event click
            
        } catch(Exception e)
        {
            errorWriter.appendToFile("Delete Error" + e.getMessage());
            System.out.println("Delete Error" + e.getMessage());
        };
        this.searchEmployees.doClick();//and do it again to prevent errors. 
    }    
    
    /**
     * Isolated return for values. 
     * @return 
     */
    private EmployeesIdentity searchEmployee() {
        EmployeesIdentity empIden;
        try {
                    //System.out.println("Hey I did fucking shit!");
                    DBConnection Conn = new DBConnection(); 
                    empIden = Conn.getEmployeeInformation(searchSetup(createEmpSearchCriteria(2), 
                            createEmpSearchCriteria(1), "gc200325005.Employee"));

                    searchResultsTable.setModel(empIden.getEmpTable());
                    employeeStorage = empIden.getEmpArrayReturn();
                    System.out.println("Size of Current employeeStorage array: "+ employeeStorage.length);

            }catch (Exception e) {
                //errorWriter.writeError(e);
                errorWriter.appendToFile("ERROR: " + e.getMessage());
                System.out.println("Error!");
                System.out.println(e.getMessage());
                empIden = new EmployeesIdentity(); //return empty empIdenity. 
                
            }
        return empIden;
    }
    /**
     * Updates the values in the held object
     */
    private void updateEmployee() {
        try {
        selectedEmployee.setSinNumber(Integer.getInteger(searchEDITSinTextBox.getText()));
        } catch (Exception e) {} //does not need to be thrown, but required for code
        selectedEmployee.setFirstName(searchEDITFirstNameTextBox.getText());
        selectedEmployee.setLastName(searchEDITLastNameTextBox.getText());
        selectedEmployee.setPosition(searchEDITPositionTextBox.getText());
        selectedEmployee.setGender(searchEDITGenderTextBox.getText());
        selectedEmployee.setStatus(searchEDITStatusTextBox.getText());
        selectedEmployee.setPhoneNumber(searchEDITPhoneTextBox.getText());
        selectedEmployee.setAddress(searchEDITAddressTextBox.getText());
        DBUpdateEmployee();
    }
    /**
     * Simply way of updating the DB, puts the stored values into the array for update.
     */
    public void DBUpdateEmployee() {
        DBConnection conn = new DBConnection();
        //
        
        
        conn.updateSQLDataBase("Employee", "firstName", "'"+selectedEmployee.getFirstName()+"'", "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "lastName",  "'"+selectedEmployee.getLastName()+"'", "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "position",  "'"+selectedEmployee.getPosition()+"'", "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "gender",  "'"+selectedEmployee.getGender()+"'", "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "status",  "'"+selectedEmployee.getStatus()+"'", "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "Phone",  "'"+selectedEmployee.getPhoneNumber()+"'", "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "address",  "'"+selectedEmployee.getAddress()+"'", "EmpID", selectedEmployee.getEmpId());
        this.searchEmployeeBtn.doClick();
    }
    
    
    private class NewEmployeeButtonLisenter implements ActionListener 
        {

        @Override
        public void actionPerformed(ActionEvent event) 
        {
            createEmployeeAndSubmitToDB();

        }
    }


    /***
     * Listens for changes in the selection of the rows of the Jtable and allows
     * the editing of the information.
     */
    private class empJTableListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            System.out.println("This is Done: " + searchResultsTable.getSelectedRow());
            selectedEmployee = employeeStorage[searchResultsTable.getSelectedRow()];
            System.out.println(selectedEmployee.getStatus());
            searchEmpEditButton.setEnabled(true);

        }
    }
    
    /**
     * for space saving on the main pannel, calls a pip u 
     */
    private class SelectForEditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
             EditWindow editWindow = new EditWindow();
             editWindow.setVisible(true);
        }
    }
    /**
     * Creates a temp pop up for editing, non blocking. 
     */
    private class EditWindow extends JFrame {
        
        public EditWindow() {
            //searchEDITEmpIDTextBox.setText(selectedEmployee.get
            searchEDITFirstNameTextBox.setText(selectedEmployee.getFirstName());
            searchEDITLastNameTextBox .setText(selectedEmployee.getLastName());
            searchEDITPositionTextBox.setText(selectedEmployee.getPosition());
            searchEDITGenderTextBox.setText(selectedEmployee.getGender());
            //searchEDITDepartmentTextBox.setText(selectedEmployee);
            searchEDITSinTextBox.setText(String.valueOf(selectedEmployee.getSinNumber()));
            //searchEDITbirthDayTextBox.setText(selectedEmployee.get
            //searchEDITHireDateTextBox.setText(selectedEmployee
            searchEDITStatusTextBox.setText(selectedEmployee.getStatus());
            searchEDITPhoneTextBox .setText(selectedEmployee.getPhoneNumber());
            searchEDITAddressTextBox.setText(selectedEmployee.getAddress());
            this.add(searchEditMainMain);
            this.pack();
        }
    }
    
    /**
     * listens for calls on the update button. 
     */
    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            updateEmployee(); 
        }
    } 
    
    /**
     * listens for call on the delete button. 
     */
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
           if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION) == 0) {
                deleteEmployee();
           }
        }
    }
    
    
    
    

   

    /**
     * Action listener for updating and searching the tables. 
     */
    public class SearchButtonListener implements ActionListener {
        /***
         * private inner class with overwritten table to prevent editing.
         */

        private EmployeesIdentity empIden;
 //action listener's table
        @Override
        public void actionPerformed(ActionEvent event) {
            //call and execute the query 
            
                try {
                    //System.out.println("Hey I did fucking shit!");
                    DBConnection Conn = new DBConnection(); 
                    empIden = Conn.getEmployeeInformation(searchSetup(createEmpSearchCriteria(2), 
                            createEmpSearchCriteria(1), "gc200325005.Employee"));

                    searchResultsTable.setModel(empIden.getEmpTable());
                    employeeStorage = empIden.getEmpArrayReturn();
                    System.out.println("Size of Current employeeStorage array: "+ employeeStorage.length);

            }catch (Exception e) {
                //errorWriter.writeError(e);
                System.out.println("Error!");
                System.out.println(e.getMessage());
                errorWriter.appendToFile("Error! " + e.getMessage());
            }
            searchEmpEditButton.setEnabled(false);
            
        }
        /**
         * 
         * @return the table model for the search results if needed. 
         */
        public DefaultTableModel returnMyTable() {
            return this.empIden.getEmpTable();
        }        
    }

    // event handlers
    // close form
    private class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // are you sure box
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }
    }
    

        //validates date inputes 
        public boolean checkValidDate (String Date) 
        {
            //Error on date Conversion: Unparseable date: "1988-10-10"

            try {
                DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
                df.setLenient(true);
                df.parse(Date);
                return false;
            }
            catch (ParseException e) {
                System.out.println("Error on date Conversion: " + e.getMessage());
                errorWriter.appendToFile("Error on date Conversion: " + e.getMessage());
                return true;
            }
        }
        //as the C# try parse int method. 
        private boolean tryParseInt(String value) 
        {
            try {  
                Integer.parseInt(value);  
            return true;  
        
            } catch (NumberFormatException e) {  
            return false;  
            }  
        }
                //as the C# try parse int method. 
        private boolean tryDoubleInt(String value) 
        {
            try {  
                Double.parseDouble(value);  
            return true;  
        
            } catch (NumberFormatException e) {
                
            return false;  
            }  
        }

        
        //validates for date format, not if the date is 
        //valid for DB insert however (different format)
        //"dd-MM-yyyy" is format. 
        public boolean validateCreateEmployeeRequiredFieldsFilled()
        {
         if (
                    firstNameTxt.getText().equals("") ||  
                    lastNameTxt.getText().equals("") ||
                    empGenderTxt.getText().equals("") ||
                    empSinTxt.getText().equals("") ||
                    yearTxt.getText().equals("") ||
                    monthTxt.getText().equals("") ||
                    dayTxt.getText().equals("") ||
                    this.empPositionTxt.getText().equals("")
                 )
                    
            {
                JOptionPane.showMessageDialog(null,"You Cannot Submit to the database a new employee "
                        + "without hte folloing fields, First Name, Last Name, Gender, Sin Number, "
                        + "year of birth, month of birth, day of birth, and position","Submission Error",JOptionPane.WARNING_MESSAGE);
                return false; 
            }
         
         //field validations that are REQUIRED for all types. 
         if (this.checkValidDate(yearTxt.getText()+"-"+monthTxt.getText()+"-"+dayTxt.getText())){
             JOptionPane.showMessageDialog(null,"You must enter a valid date for employee birth format is YYYY, MM, DD in the seperate fields","Submission Error",JOptionPane.WARNING_MESSAGE);
                return false; 
         }
         if (empSinTxt.getText().length()!=9 && !tryParseInt(empSinTxt.getText())) {
             JOptionPane.showMessageDialog(null,"Sin number must be 9 digits long with no spaces, and contain no letter characters","Submission Error",JOptionPane.WARNING_MESSAGE);
                return false; 
         }
         //
         if (this.checkValidDate(emphireDateYearTxt.getText()+"-"+empHireDateMonthTxt.getText()+"-"+empHireDateDayTxt.getText())){
             JOptionPane.showMessageDialog(null,"You must enter a valid date for employee hire format is YYYY, MM, DD in the seperate fields, keep in mind this is not a required "
                     + "field","Submission Error",JOptionPane.WARNING_MESSAGE);
                return false; 
         }

         return true; 
         
        }
        

        /*
        validates the input for the create employee. 
        */
        public boolean validateInputTabe (int Tab) {
            if (empCreateGetIndexofTabPane == 0)
            {
                if(     this.tryDoubleInt(this.hourRateTxt.getText())
                        &&
                        this.tryDoubleInt(this.hoursTxt.getText())) {
                    return true;
                    
                }
                else {
                    JOptionPane.showConfirmDialog(null, "One of the fields in the pay field is entered incorrectly?", "OK", JOptionPane.OK_OPTION);
                    return false;
                }
            } else if (empCreateGetIndexofTabPane == 1)
            {
                if(     this.tryDoubleInt(this.baseSalaryTxt.getText())){
                    return true;
                    
                }
                else {
                    JOptionPane.showConfirmDialog(null, "One of the fields in the pay field is entered incorrectly?", "OK", JOptionPane.OK_OPTION);
                    return false;
                }
            } else if (empCreateGetIndexofTabPane == 2)
            {
                if(     this.tryDoubleInt(this.salesTxt.getText())
                        &&
                        this.tryDoubleInt(this.commissionRateTxt.getText())
                        &&
                        this.tryDoubleInt(this.baseSalaryTxt.getText())
                        ) {
                    return true;
                }
                else {
                    JOptionPane.showConfirmDialog(null, "One of the fields in the pay field is entered incorrectly?", "OK", JOptionPane.OK_OPTION);
                    return false;
                }
            }
            JOptionPane.showConfirmDialog(null, "Did you fill in the require fields?", "OK", JOptionPane.OK_OPTION);            return false ;
            
        }
        
        /**
         * Creates a new employee and submits it to the DB. 
         */
        public void createEmployeeAndSubmitToDB(){
            
            
            
            if ((validateCreateEmployeeRequiredFieldsFilled())&&(validateInputTabe(empCreateGetIndexofTabPane))) {
            
                double PayRate = 0;
                double hours = 0;
                double salary = 0;
                double sales = 0;
                double comrate = 0;
                double totalSalary = 0; //odd name, but used for naming variables
                
                if (empCreateGetIndexofTabPane==0) {
                    hours = Double.parseDouble(hourRateTxt.getText());
                    PayRate = Double.parseDouble(this.hourRateTxt.getText());
                } else if (empCreateGetIndexofTabPane==1) {
                    salary = Double.parseDouble(this.baseSalaryTxt.getText());
                }else if (empCreateGetIndexofTabPane==2) {
                    sales = Double.parseDouble(this.salesTxt.getText());
                    comrate = Double.parseDouble(this.commissionRateTxt.getText());
                    totalSalary = Double.parseDouble(this.baseSalaryTxt.getText());
                }
                
                        
                EmployeesIdentity empIden;
                DBConnection conn = new DBConnection();
                //prepInsertIntoEmployee
                //turnIntDataFieldsIntoSQLData
                //insertSQLDataBase
                conn.insertSQLDataBase("gc200325005.Employee", conn.prepInsertIntoEmployee(
                        this.empCreateGetIndexofTabPane, 
                        firstNameTxt.getText(), 
                        lastNameTxt.getText(), 
                        empGenderTxt.getText(), 
                        Integer.parseInt(empSinTxt.getText()), 
                        conn.turnIntDataFieldsIntoSQLDate(
                                Integer.parseInt(yearTxt.getText()), 
                                Integer.parseInt(monthTxt.getText()),
                                Integer.parseInt(dayTxt.getText())),
                        conn.turnIntDataFieldsIntoSQLDate(
                                Integer.parseInt(this.emphireDateYearTxt.getText()), 
                                Integer.parseInt(this.empHireDateMonthTxt.getText()),
                                Integer.parseInt(this.empHireDateDayTxt.getText())),
                        this.empPositionTxt.getText(),
                        this.empDepartmentTxt.getText(),
                        this.empStatusTxt.getText(),
                        this.addressTxt.getText(),
                        this.phoneNumberTxt.getText(),
                       0.00,
                       hours,
                       PayRate,
                       salary,
                       sales,
                       comrate,
                       totalSalary
                )
                      
                     

                );
                conn.getEmployeeInformation("SELECT * FROM gc200325005.Employee");
                empIden = conn.getEmployeeInformation(searchSetup(createEmpSearchCriteria(2), 
                            createEmpSearchCriteria(1), "gc200325005.Employee"));

                    searchResultsTable.setModel(empIden.getEmpTable());
                    employeeStorage = empIden.getEmpArrayReturn();
                    System.out.println("Size of Current employeeStorage array: "+ employeeStorage.length);
            
            }
        }
        
private JLabel manufacturerNameLbl,manufacturerCountryLbl, searchProductLbl,manuID,manuName,manuDesc,
            manuCountry,prodID,prodShowID,prodName,prodCost,prodProductionCost,prodManu,prodSpacer;
    // text boxes for product tab
    private JTextField productNameTxt = new JTextField(15),
            productIDTxt = new JTextField(15),
            productPriceTxt = new JTextField(15),
            productPoductionCostTxt = new JTextField(15),
            productManufacturerTxt = new JTextField(15),
            manufacturerNameTxt = new JTextField(15),
            manufacturerDescTxt = new JTextField(15),
            manufacturerCountryTxt = new JTextField(15),
            searchProductTxt = new JTextField(15);
        // build product tab and subpanels
    private void buildProductTab() {
        // create new tab
        productTab = new JPanel();
        buildProductPanel();
        buildManufacturerPanel();
        buildProductSearchPanel();
        // set layout and add all subpanels to product tab
        productTab.setLayout(new BorderLayout());
        productTab.add(manufacturerPanel, BorderLayout.NORTH);
        productTab.add(productPanel, BorderLayout.CENTER);
        productTab.add(productSearchPanel, BorderLayout.SOUTH);
    }

    private void buildProductPanel() {
        // create new panel
        productPanel = new JPanel();
        // set grid
        productPanel.setLayout(new GridLayout(3, 2));
        // set border
        productPanel.setBorder(BorderFactory.createTitledBorder("Product basic info"));
        // set labels
        prodID = new JLabel("Product ID:");
        prodName = new JLabel("Product name:");
        prodCost = new JLabel("Cost:");
        prodProductionCost = new JLabel("Production Cost:");
        prodManu = new JLabel("Product Manufacturer:");
        prodSpacer = new JLabel(" ");

        // add everything to panel
        productPanel.add(prodID);
        productPanel.add(productIDTxt);
        productPanel.add(prodCost);
        productPanel.add(productPriceTxt);
        productPanel.add(prodName);
        productPanel.add(productNameTxt);
        productPanel.add(prodProductionCost);
        productPanel.add(productPoductionCostTxt);
        productPanel.add(prodManu);
        productPanel.add(productManufacturerTxt);

    }

    private void buildManufacturerPanel() {
        
        //ManufacturerIdentity manuIden;
        // create new panel
        manufacturerPanel = new JPanel();
        // set grid
        manufacturerPanel.setLayout(new GridLayout(4, 2));
        // set border
        manufacturerPanel.setBorder(BorderFactory.createTitledBorder("Manufacturer info"));
        // set labels
        manuName = new JLabel("Select a Manufacturer");
        //setup manufacturer list
        DBConnection conn = new DBConnection();
        this.manuIdenity = 
                conn.getManufacturerInformation("SELECT * FROM gc200325005.Manufacturers;");
        
        // create product button
        createProductBtn = new JButton("Create product");

        // add everything to panel
        manufacturerPanel.add(manuName);
        manufacturerPanel.add(manuComboBox);
        manufacturerPanel.add(createProductBtn);

    }

       


    
}
