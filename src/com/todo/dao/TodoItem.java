package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;



    public TodoItem(String title, String desc, String category){
  
    	this.title=title;
        this.desc=desc;
        SimpleDateFormat  f = new SimpleDateFormat ("yyyy/MM/dd");
        this.current_date= f.format(new Date());
        this.category = category;
        SimpleDateFormat s = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
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
    	return title + "##" + desc + "## " + current_date + "\n";
    }


	
}

