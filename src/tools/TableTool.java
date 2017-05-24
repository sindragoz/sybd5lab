/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entities.IEntity;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Администратор
 */
public class TableTool {
    public static void FillTable(DefaultTableModel tableModel, List<IEntity> entities){
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        
        String[] headers = entities.get(0).getHeader();
        for(int i = 0; i < headers.length; i++){
            tableModel.addColumn(headers[i]);
        }
        
        String[] row = null;
        
        for(IEntity e : entities){
            row = e.getRow();
            tableModel.addRow(e.getRow());
        }
    }
}
