/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author itsch
 */
public class Export {
    
    
    public static List<String> fetchDataFromDatabase(String selectQuery,Connection connection) throws  Exception{
        List<String> resultSetArray=new ArrayList<>();    
       
        
        try{


                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(selectQuery);
                int numCols = rs.getMetaData().getColumnCount();

                while(rs.next()) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 1; i <= numCols; i++) {
                        sb.append(String.format(String.valueOf(rs.getString(i))) + '\t');

                    }
                    resultSetArray.add(sb.toString());

                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Sql exception " + e.getMessage());
            }
            return resultSetArray;

        }
    
    public static void printToCsv(List<String> resultArray, String filename) throws Exception{

        File csvOutputFile = new File(filename);
        FileWriter fileWriter = new FileWriter(csvOutputFile, false);


        for(String mapping : resultArray) {
            fileWriter.write(mapping + "\n");
         }

        fileWriter.close();

    }
}
