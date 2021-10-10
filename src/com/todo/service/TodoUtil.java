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
		
		System.out.print("[항목추가]\n" + "제목 > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.println("제목이 중복됩니다.");
			return;
		} 
		
		System.out.print("카테고리 > ");
		category = sc.next();
		sc.nextLine();
		
		System.out.print("일정내용 > ");
		desc = sc.nextLine().trim();
		
		
		System.out.print("마감일자 > ");
		due_date = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date);
		if(list.addItem(t)>0)
			System.out.println("추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
	//	String title = sc.nextLine();
	//	int num = sc.nextInt();
		System.out.print("\n"
				+ "========== Delete Item Section\n"
				+ "삭제할 항목의 번호  >  \n"
				+ "\n");
		int index = sc.nextInt();
		if(l.deleteItem(index) > 0) System.out.println("삭제되었습니다.");
	//	for (TodoItem item : l.getList()) {
			/*	if (title.equals ( item.getTitle())) */
		/*	if(num == listAll(l)){
				l.deleteItem(item);
				break;*/
			}
		
	


	public static void updateItem(TodoList l) {
		String new_title, new_desc, new_category, new_due_date;
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
		int index = sc.nextInt();
	//	int num = sc.nextInt();
	//	title = sc.nextLine().trim();
	/*	if (!l.isDuplicate(title)) {
			System.out.println("이름이 존재하지 않습니다. ");
			return;
		}*/

		System.out.println("새로운 일정제목 > ");
		new_title = sc.next().trim();
		/*if (l.isDuplicate(new_title)) {
			System.out.println("중복된 일정입니다. ");
			return;
		}*/
		
		System.out.println("새로운 카테고리 > ");
		new_category = sc.next();

		System.out.println("새로운 일정내용 > ");
		new_desc = sc.nextLine().trim();
		
		System.out.println("새로운 마감일 > ");
		new_due_date = sc.nextLine().trim();
	
		TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date);
		t.setId(index);
		if(l.updateItem(t) > 0) System.out.println("수정되었습니다.");
		
		
	/*	for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title))
//	if(num == listAll(l))
			{
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, new_category, new_due_Date);
				l.addItem(t);
				System.out.println("수정되었습니다. ");
			}
		}*/
		

	}

	public static void findList(TodoList l, String keyword) {
		int count = 0;
		for(TodoItem item : l.getList(keyword)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n", count);
		
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		int i = 1;
		
		
		System.out.printf("[전체 목록, 총 %d 개 ]\n", l.getCount());
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
			
		}
		for (TodoItem item : l.getList(orderby)) {
			//System.out.println( "["+ item.getCategory() +"]" + item.getTitle() + " - " +  item.getDesc() + " - " + item.getCurrent_date() + " ~ " + item.getDue_date());
			System.out.println(i + ". "+ "[" +item.getCategory() + "] "+item.getTitle() + " - " +  item.getDesc() +" - " + item.getCurrent_date() + " - " + item.getDue_date());
			i++;
		} 
		//	return i;

	}
	
	public static void saveList(TodoList l, String todolist) {
		try {
			Writer w = new FileWriter("todolist.txt");
			
		//	String title, desc, current_date = null;
		//	TodoItem t = new TodoItem (title, desc, current_date);
		//	TodoItem t = new TodoItem ("ㅂ", "ㅈ", "ㄷ" );
			for (TodoItem item : l.getList(todolist)) {
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
			TodoItem t = new TodoItem(title, desc, category,due_date);
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

	public static void listCateAll(TodoList l) {
		// TODO Auto-generated method stub
		int count = 0;
		for(String item : l.getCategories()) {
			System.out.print(item + " ");
			count++;
		}
		System.out.printf("\n총 %d개의 카테고리가 등록되어 있습니다.\n", count);
	}
	
	public static void findCateList(TodoList l, String cate) {
		int count = 0;
		for(TodoItem item : l.getListCategory(cate));{
			System.out.println(l.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목을 찾았습니다.\n",count);
	}

	
}
