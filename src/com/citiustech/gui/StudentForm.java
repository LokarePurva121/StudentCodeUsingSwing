package com.citiustech.gui;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import com.citiustech.model.Student;

public class StudentForm{

	private JLabel title, idLabel, nameLabel, standardLabel, divisionLabel, clubLabel, examLabel;
	private JTextField name, id, standard, division;
	private JCheckBox mathsExam, scienceExam, englishExam;
	private JComboBox club;

	private JButton addButton;

	private List<String> getSatusExam;;

	/**
	 * In JPanel all the input fields are there and button
	 * 
	 * @return formPanel
	 */
	public JPanel createFormGUI() {

		JPanel formPanel = new JPanel();

		idLabel = new JLabel("ID : ");
		nameLabel = new JLabel("Name : ");
		standardLabel = new JLabel("Standard : ");
		divisionLabel = new JLabel("Division : ");
		clubLabel = new JLabel("Club : ");
		examLabel = new JLabel("Exam : ");

		id = new JTextField(10);
		name = new JTextField(10);
		standard = new JTextField(10);
		division = new JTextField(10);

		String clubList[] = { "Dance", "Music", "Reader", "Arts", "Drawing" };
		club = new JComboBox(clubList);

		mathsExam = new JCheckBox("Maths");
		scienceExam = new JCheckBox("Science");
		englishExam = new JCheckBox("English");

		addButton = new JButton("   Add  ");

		JPanel panelId = new JPanel();
		formPanel.add(panelId);

		panelId.add(idLabel);
		panelId.add(id);

		JPanel panelName = new JPanel();
		formPanel.add(panelName);
		panelName.add(nameLabel);
		panelName.add(name);

		JPanel panelStandard = new JPanel();
		formPanel.add(panelStandard);
		panelStandard.add(standardLabel);
		panelStandard.add(standard);

		JPanel panelDivision = new JPanel();
		formPanel.add(panelDivision);
		panelDivision.add(divisionLabel);
		panelDivision.add(division);

		JPanel panelClub = new JPanel();
		formPanel.add(panelClub);
		panelClub.add(clubLabel);
		panelClub.add(club);

		JPanel panelExam = new JPanel();
		formPanel.add(panelExam);
		panelExam.add(examLabel);
		panelExam.add(mathsExam);
		panelExam.add(scienceExam);
		panelExam.add(englishExam);

		JPanel panelButton = new JPanel();
		formPanel.add(panelButton);
		panelButton.add(addButton);

		return formPanel;
	}

	/**
	 * get student data from student fields and set it to the student
	 * 
	 * @return student
	 */
	public Student getStudent() {

		Student st = new Student();

		String studentName = name.getText();
		int studentId = Integer.parseInt(id.getText());
		int studentStandard = Integer.parseInt(standard.getText());
		String studentDivision = division.getText();
		String studentClub = club.getItemAt(club.getSelectedIndex()).toString();
		getSatusExam = new ArrayList<>();

		if (mathsExam.isSelected()) {
			
			getSatusExam.add(mathsExam.getText());
		}
		if (scienceExam.isSelected()) {
			getSatusExam.add(scienceExam.getText());
		}
		if (englishExam.isSelected()) {
			getSatusExam.add(englishExam.getText());
		}

		System.out.println(getSatusExam);
		
		st.setId(studentId);
		st.setName(studentName);
		st.setStandard(studentStandard);
		st.setDivision(studentDivision);
		st.setClub(studentClub);
		st.setExam(getSatusExam);

		return st;

	}
//	
//	public List<String> sentDataToTableGUI(){
//		return getSatusExam;
//	}

	/**
	 * clear the all input fields
	 */
	public void clearFields() {
		id.setText("");
		name.setText("");
		standard.setText("");
		division.setText("");
		club.setSelectedIndex(0);
		mathsExam.setSelected(false);
		scienceExam.setSelected(false);
		englishExam.setSelected(false);
	}

	/**
	 * On addButton set the ActionListner to perform some action
	 * 
	 * @param ActionListener
	 *            al
	 */
	public void setAddButtonListner(ActionListener al) {
		addButton.addActionListener(al);
	}

	public void addValuesTofields(Student student) {

		// table.getValueAt(selectedrow,0);

		String studentId = Integer.toString(student.getId());
		String studentName = student.getName();
		String studentStandard = Integer.toString(student.getStandard());
		String studentDivision = student.getDivision();
		String studentClub = student.getClub();
//		List<String> studentCourses = student.getExam();
	

		id.setText(studentId);
		name.setText(studentName);
		standard.setText(studentStandard);
		division.setText(studentDivision);
		club.setSelectedItem(studentClub);
		
		

	}

}
