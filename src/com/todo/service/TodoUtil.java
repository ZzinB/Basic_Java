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
		
		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목추가]\n" + "제목 > ");
		
		title = sc.nextLine();
		if (list.isDuplicate(title)) {
			System.out.printf("중복된 일정입니다.");
			return;
		}
		
		System.out.println("카테고리 > ");
		category = sc.nextLine();
		
		System.out.println("일정내용 > ");
		desc = sc.nextLine().trim();
		
		
		System.out.println("마감일자 > ");
		due_date = sc.nextLine();
		
		TodoItem t = new TodoItem(title, desc, category);
		list.addItem(t);
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
	//	String title = sc.nextLine();
		int num = sc.nextInt();
		System.out.println("\n"
				+ "========== Delete Item Section\n"
				+ "삭제할 항목의 번호  >  \n"
				+ "\n");
		
		for (TodoItem item : l.getList()) {
			/*	if (title.equals ( item.getTitle())) */
			if(num == listAll(l)){
				l.deleteItem(item);
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		/*System.out.println("\n"
				+ "========== Edit Item Section\n"
				+ "변경 일정제목 >  \n"
				+ "\n");
		String title = sc.nextLine().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("이름이 존재하지 않습니다. ");
			return;
		}*/
		
		System.out.println("\n"
				+ "========== Edit Item Section\n"
				+ "수정 할 항목 번호 >  \n"
				+ "\n");
	//	int num = sc.nextInt();
		String title = sc.nextLine().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("이름이 존재하지 않습니다. ");
			return;
		}

		System.out.println("새로운 일정제목 > ");
		String new_title = sc.nextLine().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("중복된 일정입니다. ");
			return;
		}
		
		System.out.println("새로운 카테고리 > ");
		String new_category = sc.nextLine().trim();

		System.out.println("새로운 일정내용 > ");
		String new_description = sc.nextLine().trim();
		
		System.out.println("새로운 마감일 > ");
		String new_dueDate = sc.nextLine().trim();
	
		
		
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title))
//	if(num == listAll(l))
			{
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, new_category);
				l.addItem(t);
				System.out.println("수정되었습니다. ");
			}
		}

	}

	public static void find(TodoList l) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
	}
	
	public static int listAll(TodoList l) {
		int count = 0;
		int i = 1;
		
		for (TodoItem item : l.getList()) {
			//System.out.println( "["+ item.getCategory() +"]" + item.getTitle() + " - " +  item.getDesc() + " - " + item.getCurrent_date() + " ~ " + item.getDue_date());
			System.out.println(i + ". "+ "[" +item.getCategory() + "] "+item.getTitle() + " - " +  item.getDesc() +" - " + item.getCurrent_date() + " - " + item.getDue_date());
			i++;
			count ++;
		}
		System.out.println("[전체 목록, 총 " + count +"개 ]");
		return i;

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
		int count = 0;
		while((oneline = reader.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(oneline, "##");
			String title = st.nextToken();
			String desc = st.nextToken();
			String current_date = st.nextToken();
			String category = st.nextToken();
			String due_date = st.nextToken();
			
	//		TodoItem t = new TodoItem(title, desc, cuttren_date );
			TodoItem t = new TodoItem(title, desc, category);
			t.setCurrent_date(current_date);
			l.addItem(t);
			count++;
			System.out.println(count + "개의 항목 \n" +t.toSaveString());
		} reader.close();
		
		System.out.println("\n 정보 가져오기 완료 ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
