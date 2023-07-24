package com.citiustech.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.citiustech.gui.StudentForm;
import com.citiustech.gui.StudentTableGUI;
import com.citiustech.model.Student;

public class StudentMain extends JFrame {
	StudentTableGUI tableGUI;

	public StudentMain() {
		setTitle("Student Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		setLayout(new BorderLayout());

		StudentForm form = new StudentForm();
		StudentTableGUI tableGUI = new StudentTableGUI();
		
		
		JPanel contentPanel = new JPanel(new GridLayout(2, 1));

		contentPanel.add(form.createFormGUI());
		contentPanel.add(tableGUI.createTableGUI());

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

		tableGUI.setTableListner(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				Student student = tableGUI.addValuesTofields();

				if (student != null) {
					form.addValuesTofields(student);
				}

			}
		});

		add(contentPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String args[]) {
		StudentMain main = new StudentMain();
	}
}
