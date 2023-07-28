package com.citiustech.gui;

import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CourseCellRenderer extends DefaultTableCellRenderer{
	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Object[] courses = {};
		if (value instanceof List<?>) {
			courses = ((List) value).toArray();
		}

		if (!courses.getClass().isArray()) {
			return table.getDefaultRenderer(value.getClass()).getTableCellRendererComponent(table, value, isSelected,
					hasFocus, row, column);
		} else {
			
			CoursesComponent cc = new CoursesComponent(table,courses);
			cc.setRow(row);
			return cc.createUI();
		}
	}

}
