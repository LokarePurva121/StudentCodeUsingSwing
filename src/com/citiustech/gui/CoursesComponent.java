package com.citiustech.gui;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.citiustech.model.Student;

public class CoursesComponent extends JPanel {

	private Object[] courses;
	public JTable parentTable;
	private int minHeight = -1;
	private int currHeight = -1;
	private int row = -1;
	private JCheckBox checkbox;
	// private JCheckBox[] checkbox;

	public CoursesComponent() {

	}

	public CoursesComponent(JTable table, Object[] courses) {

		this.courses = courses;
		this.parentTable = table;

	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
		repaint();
	}

	public Component createUI() {
		setLayout(new GridLayout(courses.length, 1));

		if (row != -1) {
			if (minHeight == -1) {
				minHeight = parentTable.getRowHeight();
			}
			if (currHeight != courses.length * minHeight) {
				currHeight = courses.length * minHeight;
				parentTable.setRowHeight(row, currHeight);
			}

		}
		for (int i = 0; i < courses.length; i++) {
			checkbox = new JCheckBox((String) courses[i]);
			checkbox.setSelected(true);
			checkbox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// 1 : Selected & 2 : Deselect
					if (e.getStateChange() == 2) {
						String text = ((JCheckBox) e.getSource()).getText();
						System.out.println(text);
						deleteCourse(text);
					}
				}
			});
			add(checkbox);
		}

		return this;
	}

	public void deleteCourse(String courseName) {

		if (parentTable != null) {
			TableModel model = parentTable.getModel();
			if (model instanceof CustomTableModel) {
				CustomTableModel cModel = (CustomTableModel) model;
				Student selectedStudentRow = cModel.getSelectedRecord(parentTable.getSelectedRow());

				if (selectedStudentRow.getExam().size() > 1) {

					int result = JOptionPane.showConfirmDialog(this, "Sure? You want to delete course.", "Course",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						selectedStudentRow.getExam().remove(courseName); // remove
						System.out.println(selectedStudentRow.getExam());
						cModel.fireTableDataChanged();
					} else if (result == JOptionPane.YES_NO_OPTION) {

					}

				} else {

					JOptionPane.showMessageDialog(this, "You have to appeare for at least 1 Exam.");

				}

			}

		}

	}
}
