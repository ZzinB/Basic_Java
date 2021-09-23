package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n"
				+ "========== Create item Section\n"
				+ "일정제목을 입력하세요. \n");
		
		title = sc.nextLine();
		if (list.isDuplicate(title)) {
			System.out.printf("중복된 일정입니다.");
			return;
		}
		
		System.out.println("일정내용을 입력하세요");
		desc = sc.nextLine();
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		
		System.out.println("\n"
				+ "========== Delete Item Section\n"
				+ "삭제할 일정제목을 입력하세요. \n"
				+ "\n");
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n"
				+ "========== Edit Item Section\n"
				+ "변경하고 싶은 일정제목을 입력하세요. \n"
				+ "\n");
		String title = sc.nextLine().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("이름이 존재하지 않습니다. ");
			return;
		}

		System.out.println("새로운 일정제목을 입력하세요.");
		String new_title = sc.nextLine().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("중복된 일정입니다. ");
			return;
		}
		
		System.out.println("새로운 일정내용을 입력하세요. ");
		String new_description = sc.nextLine().trim();
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("수정되었습니다. ");
			}
		}

	}

	public static void listAll(TodoList l) {
		for (TodoItem item : l.getList()) {
			System.out.println("일정제목 : " + item.getTitle() + "  일정내용 :  " + item.getDesc() + " " + item.getCurrent_date());
		}
	}
	
	public static void saveList(TodoList l, String todolist) {
		try {
			Writer w = new FileWriter("todolist.txt");
			
		//	String title, desc, current_date = null;
		//	TodoItem t = new TodoItem (title, desc, current_date);
		//	TodoItem t = new TodoItem ("ㅂ", "ㅈ", "ㄷ" );
			for (TodoItem item : l.getList()) {
				w.write(item.toSaveString());			
				}
		//	w.write(t.toSaveString());
			w.close();
			System.out.println("\n 정보 저장 완료 ");

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void loadList(TodoList l, String todolist) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader("todolist.txt"));
		String oneline;
		while((oneline = reader.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(oneline, "##");
			String title = st.nextToken();
			String desc = st.nextToken();
			String current_date = st.nextToken();
			
	//		TodoItem t = new TodoItem(title, desc, cuttren_date );
			TodoItem t = new TodoItem(title, desc );
			System.out.println(t.toSaveString());
		} reader.close();
		
		System.out.println("\n 정보 가져오기 완료 ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
