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
    private int is_completed;
    private String star; //중요도
    private String person;//함께하는사
	Connection conn;



    public TodoItem(String title, String desc, String category, String due_date, String star, String person){
  
    	this.title=title;
        this.desc=desc;
        SimpleDateFormat  f = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        this.current_date= f.format(new Date());
        this.category = category;
        SimpleDateFormat s = new SimpleDateFormat ("yyyy/MM/dd ");
        this.due_date= s.format(new Date());
        this.star = star;
        this.person = person;
    }
    
    
    public TodoItem(int is_completed) {
		// TODO Auto-generated constructor stub
    	this.is_completed = is_completed;
	}


	public TodoItem(String title) {
		// TODO Auto-generated constructor stub
    	this.title=title;

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
    	return title + "##" + category + "##" + desc + "## " + current_date + "##" + due_date +  "\n";
    }
    
//  @Override
    public String toString() {
    	if(is_completed == 1) {
        	return Id + "." +"[" + " V "+"]"+"["+ category +"]"  + title + " ( " + star + " ) " + " - " + desc + " - " + due_date + " - " + current_date + " - " + person  +"\n";
    	}else {
    	    return Id + "." + "[" + category +"]"  + title  + " ( " + star + " ) " + " - " + desc + " - " + due_date + " - " + current_date + " - " + person  +"\n";
    	}
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


	public  void setId(int Id) {
		// TODO Auto-generated method stub
        this.Id = Id;

	}
	
	public int getComp() {
		return is_completed;
	}
	
	public void setComp(int is_completed) {
		this.is_completed = is_completed;
	}

	public String getstar() {
        return star;
    }

    public void setstar(String star) {
        this.star = star;
    }
    public String getperson() {
        return person;
    }

    public void setperson(String person) {
        this.person = person;
    }
	
}

