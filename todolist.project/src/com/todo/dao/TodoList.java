package com.todo.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.todo.service.TodoSortByDate;
import com.todo.service.TodoSortByName;
import com.todo.service.DbConnect;



public class TodoList {
	private List<TodoItem> list;
	Connection conn;
	private String title;

	public TodoList() {
		this.list = new ArrayList<TodoItem>();
		this.conn = DbConnect.getConnection();
	}
	
	public TodoItem getItem(int index) {
		return list.get(index);
	}

	/* public void addItem(TodoItem t) {
		list.add(t);
	} */
/*	private PreparedStatement setString(int i, String current_date) {
		// TODO Auto-generated method stub
		return list.current_date;
;
	}*/
	
/*	private PreparedStatement setInt(int i, int id) {
		// TODO Auto-generated method stub
		return id;
	}*/
	
	public int addItem(TodoItem t) {
		String sql = "insert into list (title, memo, category, current_date, due_date, star, person)" + " values (?,?,?,?,?,?,?);";
		PreparedStatement pstmt;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,t.getTitle());
			pstmt.setString(2,t.getDesc());
			pstmt.setString(3,t.getCategory());
			pstmt.setString(4,t.getCurrent_date());
			pstmt.setString(5,t.getDue_date());
			pstmt.setString(6,t.getstar());
			pstmt.setString(7,t.getperson());

			count = pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}

/*	public void deleteItem(TodoItem t) {
		list.remove(t);
	}*/
	


	public int deleteItem(int index) {
		String sql = "delete from list where id=?;";
		PreparedStatement pstmt;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			count = pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int deleteItem(String index) {
		String sql = "delete from list where title=?;";
		PreparedStatement pstmt;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, index);
			count = pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int deleteItem2(String index) {
		String sql = "delete from list where category=?;";
		PreparedStatement pstmt;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, index);
			count = pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

/*	void editItem(TodoItem t, TodoItem updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}*/
	
	public int updateItem(TodoItem t) {
		String sql = "update list set title=?, memo=?, category=?, current_date=?, due_date=?, star=?" + " where id = ?;";
		PreparedStatement pstmt;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,t.getTitle());
			pstmt.setString(2,t.getDesc());
			pstmt.setString(3,t.getCategory());
			pstmt.setString(4,t.getCurrent_date());
			pstmt.setString(5,t.getDue_date());
			pstmt.setString(6,t.getstar());
			pstmt.setString(7,t.getperson());
			pstmt.setInt(8,t.getId());
			count = pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
/*	public int updateItem2(TodoItem t) {
		String sql = "update list set title=?;";
		PreparedStatement pstmt;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,t.getTitle());
			pstmt.setInt(8,t.getId());
			count = pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}*/
	
/*	public ArrayList<TodoItem> getList() {
		return new ArrayList<TodoItem>(list);
	} */
	
	
	public ArrayList<TodoItem> getList() {
		ArrayList<TodoItem> list = new ArrayList<TodoItem>();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM list";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String category = rs.getString("category");
				String title = rs.getString("title");
				String description = rs.getString("memo");
				String due_date = rs.getString("due_date");
				String current_date = rs.getString("current_date");
				String star = rs.getString("star");
				String person = rs.getString("person");
				
				TodoItem t = new TodoItem(title, description, category, due_date, star, person);
				t.setId(id);
				t.setCurrent_date(current_date);
				
				list.add(t);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<TodoItem> getList(String keyword) {
		ArrayList<TodoItem> list = new ArrayList<TodoItem>();
		PreparedStatement pstmt;
		keyword = "%"+keyword+"%";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM list WHERE title like ? or memo like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,keyword);
			pstmt.setString(2,keyword);
			ResultSet rs = pstmt.executeQuery();
		//	ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String category = rs.getString("category");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String due_date = rs.getString("due_date");
				String current_date = rs.getString("current_date");
				String star = rs.getString("star");
				String person = rs.getString("person");
				
				int is_completed = rs.getInt("is_completed");
				TodoItem t = new TodoItem(title, description, category, due_date, star, person);
				t.setId(id);
				t.setCurrent_date(current_date);
				list.add(t);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	
	
	
	public void sortByName() {
		Collections.sort(list, new TodoSortByName());

	}

	public void listAll() {
		System.out.println("\n"
				+ "inside list_All method\n");
		for (TodoItem myitem : list) {
		//	System.out.println( "["+ myitem.getCategory() +"]" + myitem.getTitle() + myitem.getDesc() + myitem.getDue_date());
			System.out.println( myitem.getCategory() + myitem.getTitle() + myitem.getDesc() + myitem.getCurrent_date() + myitem.getDue_date() +  myitem.getstar() + myitem.getperson());
		}
	}
	
	public void reverseList() {
		Collections.reverse(list);
	}

	public void sortByDate() {
		Collections.sort(list, new TodoSortByDate());
	}

	public int indexOf(TodoItem t) {
		return list.indexOf(t);
	}

	public Boolean isDuplicate(String title) {
		for (TodoItem item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}


	public int getCount() {
		Statement stmt;
		int count = 0;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT count(id) FROM list;";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(id)");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void importData(String filename) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line;
				String sql = "insert into list (title, memo, category, current_date, due_date)" + " values (?,?,?,?,?);";
				int records = 0;
				while((line = br.readLine())!=null) {
					StringTokenizer st = new StringTokenizer(line, "##");
					String category = st.nextToken();
					String title = st.nextToken();
					String description = st.nextToken();
					String due_date = st.nextToken();
					String current_date = st.nextToken();
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,title);
					pstmt.setString(2,description);
					pstmt.setString(3,category);
					pstmt.setString(4,current_date);
					pstmt.setString(5,due_date);
					int count = pstmt.executeUpdate();
					if(count > 0) records++;
					pstmt.close();
				}
				System.out.println(records + "records read!");
				br.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		public ArrayList<String> getCategories() {
			// TODO Auto-generated method stub
			ArrayList<String> list = new ArrayList<String>();
			Statement stmt;
			try {
				stmt = conn.createStatement();
				String sql = "SELECT DISTINCT category FROM list";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					
					String category = rs.getString("category");
					list.add(category);
				}
				stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		public ArrayList<TodoItem> getListperson(String keyword) {
			ArrayList<TodoItem> list = new ArrayList<TodoItem>();
			PreparedStatement pstmt;
			try {
				String sql = "SELECT * FROM list WHERE person = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, keyword);
				ResultSet rs =pstmt.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String category = rs.getString("category");
					String title = rs.getString("title");
					String description = rs.getString("memo");
					String due_date = rs.getString("due_date");
					String current_date = rs.getString("current_date");
					String star = rs.getString("star");
					String person = rs.getString("person");

					
					TodoItem t = new TodoItem(title, description, category, due_date, star, person);
					t.setId(id);
					t.setCurrent_date(current_date);
					
					list.add(t);
				}
				pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		
		public ArrayList<TodoItem> getListCategory(String keyword) {
			ArrayList<TodoItem> list = new ArrayList<TodoItem>();
			PreparedStatement pstmt;
			try {
				String sql = "SELECT * FROM list WHERE category = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, keyword);
				ResultSet rs =pstmt.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String category = rs.getString("category");
					String title = rs.getString("title");
					String description = rs.getString("memo");
					String due_date = rs.getString("due_date");
					String current_date = rs.getString("current_date");
					String star = rs.getString("star");
					String person = rs.getString("person");

					
					TodoItem t = new TodoItem(title, description, category, due_date, star, person);
					t.setId(id);
					t.setCurrent_date(current_date);
					
					list.add(t);
				}
				pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public ArrayList<TodoItem> getListStar(String num) {
			ArrayList<TodoItem> list = new ArrayList<TodoItem>();
			PreparedStatement pstmt;
			try {
				String sql = "SELECT * FROM list WHERE star = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				ResultSet rs =pstmt.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String category = rs.getString("category");
					String title = rs.getString("title");
					String description = rs.getString("memo");
					String due_date = rs.getString("due_date");
					String current_date = rs.getString("current_date");
					String star = rs.getString("star");
					String person = rs.getString("person");

					
					TodoItem t = new TodoItem(title, description, category, due_date, star, person);
					t.setId(id);
					t.setCurrent_date(current_date);
					
					list.add(t);
				}
				pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		public ArrayList<TodoItem> getOrderedList(String orderby, int ordering) {
			ArrayList<TodoItem> list = new ArrayList<TodoItem>();
			Statement stmt;
			try {
				stmt = conn.createStatement();
				String sql = "SELECT *FROM list ORDER BY " + orderby;
				if(ordering == 0) sql += " desc";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt("id");
					String category = rs.getString("category");
					String title = rs.getString("title");
					String description = rs.getString("memo");
					String due_date = rs.getString("due_date");
					String current_date = rs.getString("current_date");
					String star = rs.getString("star");
					String person = rs.getString("person");

					
					TodoItem t = new TodoItem(title, description, category, due_date, star, person);
					t.setId(id);
					t.setCurrent_date(current_date);
					
					list.add(t);
				}
				stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public ArrayList<TodoItem> getListComp(int comp){
			ArrayList<TodoItem> list = new ArrayList<TodoItem>();
			Statement stmt;
			try {
				stmt = conn.createStatement();
				String sql = "SELECT * FROM list WHERE is_completed = 1 ";
				if(comp == 0) sql += "0";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt("id");
					String category = rs.getString("category");
					String title = rs.getString("title");
					String description = rs.getString("memo");
					String due_date = rs.getString("due_date");
					String current_date = rs.getString("current_date");
					String star = rs.getString("star");
					String person = rs.getString("person");

					int is_completed = rs.getInt("is_completed");
					
					TodoItem t = new TodoItem(title, description, category, due_date, star, person);
					t.setId(id);
					t.setCurrent_date(current_date);
					t.setComp(is_completed);
					
					list.add(t);
				}
				stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		


		public int completeItem(int comp) {
			String sql = "update list set is_completed = 1 where id = ?;";
			PreparedStatement pstmt;
			TodoItem t;
			int count = 0;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, comp);
				count = pstmt.executeUpdate();
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}
}

	
	
	
	
