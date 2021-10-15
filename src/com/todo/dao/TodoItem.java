package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private int Id;
	Connection conn;



    public TodoItem(String title, String desc, String category, String due_date){
  
    	this.title=title;
        this.desc=desc;
        SimpleDateFormat  f = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        this.current_date= f.format(new Date());
        this.category = category;
        SimpleDateFormat s = new SimpleDateFormat ("yyyy/MM/dd ");
        this.due_date= s.format(new Date());
    }
    
    
    public String getTitle() {
        return title;
    }
/*	public String getNum() {
        return num;
    }

	public void setNum(String num) {
        this.num = num;
    }*/
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }
    
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getDue_date() {
        return due_date;
    }
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
    
 /*   public String getCurrent_date() {
        SimpleDateFormat  format = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        String str = format.format(current_date);
        return current_date;
    }*/

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
    
  //  @Override
    public String toSaveString() {
    	return title + "##" + category + "##" + desc + "## " + current_date + "##" + due_date + "\n";
    }
    
//  @Override
    public String toString() {
    	return Id + "." + "["+ category +"]" + title + " - " + desc + " - " + due_date + " - " + current_date + "\n";
    }
    
    
    public int getCount() {
    	Statement stmt; 
    	int count = 0;
    	try {
			stmt = conn.createStatement();
    		String sql = "SELECT count(id) FROM list:";
    		ResultSet rs = stmt.executeQuery(sql);
    		rs.next();
    		count = rs.getInt("count(id)");
    		stmt.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return count;
    }


	public int getId() {
		// TODO Auto-generated method stub
		return Id;
	}


	public void setId(int Id) {
		// TODO Auto-generated method stub
        this.Id = Id;

	}



	
}

