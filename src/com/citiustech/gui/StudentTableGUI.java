package com.citiustech.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.citiustech.model.Student;

public class StudentTableGUI {

	private CustomTableModel model;
	JTable table;
	

	/**
	 * Creating a arrayList which can hold object of studnet type and passing
	 * that studentList to the customTableModel and then model into the JTable.
	 * 
	 * @return tablePanel
	 */
	public JPanel createTableGUI() {

		JPanel tablePanel = new JPanel();

		List<Student> studentList = new ArrayList<>();
				
		Object[][][] nestedTableData = {{{"Maths"},{"Science"},{"English"}}};
		
		model = new CustomTableModel(studentList);

		table = new JTable(model);
//		table.setRowHeight(30);
	
		table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderer());

		JScrollPane MyScrollPane = new JScrollPane(table);

		tablePanel.add(MyScrollPane, BorderLayout.CENTER);

		return tablePanel;
	}
	

	/**
	 * Add the student into the customTableModel
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {
		model.addStudent(student);
	}
	

	public Student addValuesTofields() {

		Student selectedStudentRow = model.getSelectedRecord(table.getSelectedRow());
		return selectedStudentRow;

	}

	/**
	 * adding listener to the table
	 * 
	 * @param sl
	 */
	public void setTableListner(ListSelectionListener sl) {
		table.getSelectionModel().addListSelectionListener(sl);
	}

	/**
	 * To sort the rows in ascending order
	 * 
	 */
	public void sortRows() {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		sorter.setComparator(0, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		sorter.setSortsOnUpdates(true);
		List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		table.setRowSorter(sorter);
	}


}
