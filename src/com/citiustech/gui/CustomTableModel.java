package com.citiustech.gui;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import com.citiustech.model.Student;

public class CustomTableModel extends AbstractTableModel {

	private List<Student> studentList;
	private String[] columnNames = { "ID", "NAME", "STANDARD", "DIVISION", "CLUB", "EXAM" };

	public CustomTableModel(List<Student> studentList) {
		this.studentList = studentList;
		this.columnNames = columnNames;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return studentList.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Student student = studentList.get(row);

		switch (column) {
		case 0:
			return student.getId();
		case 1:
			return student.getName();
		case 2:
			return student.getStandard();
		case 3:
			return student.getDivision();
		case 4:
			return student.getClub();
		case 5:
			return student.getExam();
		default:
			return null;
		}

	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public void addStudent(Student student) {
		studentList.add(student);
		fireTableDataChanged();
	}

	// public void modifyStudent(){
	// System.out.println(studentList.get(0));
	// }

	public Student getSelectedRecord(int row) {
		return studentList.get(row);

	}
}
