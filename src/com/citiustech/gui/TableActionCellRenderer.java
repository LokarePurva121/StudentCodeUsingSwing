package com.citiustech.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableActionCellRenderer extends DefaultTableCellRenderer {
	private int minHeight = -1;
    private int currHeight = -1;


	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		  if(value instanceof List<?>){
    		  value = ((List) value).toArray();
    	  }
				
		if(!value.getClass().isArray()){
	        return table.getDefaultRenderer(value.getClass())
	            .getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
	      } else{
	    	
	    	  final Object[] passed = (Object[])value;
	    	  if(minHeight == -1){
	              minHeight = table.getRowHeight();
	            }
	            if(currHeight != passed.length*minHeight){
	              currHeight = passed.length * minHeight;
	              table.setRowHeight(row,currHeight);
	            }
	            return new JTable(new AbstractTableModel() {
	                public int getColumnCount() {
	                  return 1;
	                }
	                public int getRowCount() {
	                  return passed.length;
	                }
	                public Object getValueAt(int rowIndex, int columnIndex) {
	                  return passed[rowIndex];
	                }
	                public boolean isCellEditable(int row, int col){
	                  return true;
	                }
	              });
	      }
	
		
	}
	

}
