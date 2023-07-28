package com.citiustech.main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.citiustech.gui.CourseCellEditor;
import com.citiustech.gui.CoursesComponent;
import com.citiustech.gui.StudentForm;
import com.citiustech.gui.StudentTableGUI;
import com.citiustech.model.Student;

public class StudentMain extends JFrame {
	StudentTableGUI tableGUI;

	public StudentMain() {
		setTitle("Student Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 500);
		setLayout(new BorderLayout());

		StudentForm form = new StudentForm();

		StudentTableGUI tableGUI = new StudentTableGUI();
		

		JPanel containerPanel = new JPanel();

		// containerPanel.setLayout(new BoxLayout(containerPanel,
		// BoxLayout.Y_AXIS));
		GridBagConstraints gbagUP = new GridBagConstraints();
		gbagUP.fill = GridBagConstraints.VERTICAL;
		gbagUP.gridx = 1;
		gbagUP.gridy = 0;
		containerPanel.add(form.createFormGUI(), gbagUP);

		GridBagConstraints gbagDown = new GridBagConstraints();
		gbagDown.fill = GridBagConstraints.VERTICAL;
		gbagDown.gridx = 0;
		gbagDown.gridy = 1;
		containerPanel.add(tableGUI.createTableGUI(), gbagDown);
//		List<String> courses = new ArrayList<String>();
//		courses.add("Maths");
//		courses.add("Science");
//		Student student = new Student(1, "Purva", 5, "B", "Dance", courses);
//
//		tableGUI.addStudent(student);
		// add(form.createFormGUI());
		// add(tableGUI.createTableGUI());

		form.setAddButtonListner(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = form.getStudent();

				if (student != null) {
					tableGUI.addStudent(student);
					tableGUI.sortRows();
				}
				form.clearFields();
			}
		});
		
//		component  -> 
	
		tableGUI.setTableListner(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(!tableGUI.selectedRow()){
				Student student = tableGUI.addValuesTofields();
//				tableGUI.trytoSetValues();
				if (student != null) {
					form.addValuesTofields(student);
				}
				}else{
					form.clearFields();
				}
			}
		});		
		
		add(containerPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String args[]) {
		StudentMain main = new StudentMain();
	}
}
//delete -. selection on similar row which is modify
//check if seletcedrow and if  