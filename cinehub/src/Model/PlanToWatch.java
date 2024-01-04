/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class PlanToWatch implements Display{
    private String filmid;
    private String title; 
    private String genre; 
    private String duration; 
    private String watchplan;
    
    @Override
    public void displayFilm(JTable TableName, String queryTable) {
        try {
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinehub", "root", "");
            Statement St = Con.createStatement();
            ResultSet Rs = St.executeQuery("select * from "+queryTable);

            // Assume filmTable is a member variable in your class
            // Set the model using the result set
            TableName.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFilmid() {
        return filmid;
    }

    public void setFilmid(String filmid) {
        this.filmid = filmid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getWatchplan() {
        return watchplan;
    }

    public void setWatchplan(String watchplan) {
        this.watchplan = watchplan;
    }
    
    
}
