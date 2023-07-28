package com.citiustech.gui;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellRenderer;

import com.citiustech.model.Student;

public class CourseCellEditor extends AbstractCellEditor implements TableCellEditor {

	List<String> courseList = new ArrayList<String>();
	CoursesComponent cc;

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		Object[] courses = {};
		if (value instanceof List<?>) {
			courses = ((List) value).toArray();
		}

		if (!courses.getClass().isArray()) {
			return null;
		} else {

			cc = new CoursesComponent(table, courses);
			cc.setRow(row);

			return cc.createUI();
		}
	}

	@Override
	public Object getCellEditorValue() {
		return courseList;
	}

}
