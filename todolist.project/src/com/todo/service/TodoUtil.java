package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import com.google.gson.Gson;
import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc, category, due_date, star, person;
		Scanner sc = new Scanner(System.in);
//		Gson gson = new Gson();
		
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
		
		System.out.print("중요도 > (1~5) ");
		star = sc.nextLine().trim();
		
		System.out.print("함께하는 사람 > ");
		person = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date, star, person);
/*		String jsonstr = gson.toJson(list.getList());
		
		try {
			FileWriter writer = new FileWriter("data.txt");
			writer.write(jsonstr);
			writer.close();
			System.out.println("파일에 저장되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		
		if(list.addItem(t)>0)
			System.out.println("추가되었습니다.");

	}

	public static void deleteItem(TodoList l, int num) {
		Scanner sc = new Scanner(System.in);
		if(num == 1) {
			System.out.print("\n"
					+ "========== Delete Item Section\n"
					+ "삭제할 항목의 제목  >  \n"
					+ "\n");
			String title = sc.nextLine();
			for (TodoItem item : l.getList()) {
					if (title.equals ( item.getTitle())) {
						l.deleteItem(title);
						System.out.println("삭제되었습니다.");				
						break;
					}
			}
		}
		else if(num == 2) {
			System.out.print("\n"
					+ "========== Delete Item Section\n"
					+ "삭제할 항목의 번호  >  \n"
					+ "\n");
			int index = sc.nextInt();
			if(l.deleteItem(index) > 0) System.out.println("삭제되었습니다.");
		}
		else if(num ==3) {
			System.out.print("\n"
					+ "========== Delete Item Section\n"
					+ "삭제할 항목의 카테고리  >  \n"
					+ "\n");
			String cate = sc.nextLine();
			for (TodoItem item : l.getList()) {
					if (cate.equals ( item.getCategory())) {
						l.deleteItem2(cate);
						System.out.println("삭제되었습니다.");				
						break;
					}
			}
		}
			}
		
	


	public static void updateItem(TodoList l, int num) {
		String new_title, new_desc, new_category, new_due_date, new_star, new_person;
		Scanner sc = new Scanner(System.in);

		System.out.println("\n"
				+ "========== Edit Item Section\n"
				+ "수정 할 항목 번호 >  \n"
				+ "\n");
		int index = sc.nextInt();
//		if(num == 1) {
		
		/*System.out.println("\n"
				+ "========== Edit Item Section\n"
				+ "변경 일정제목 >  \n"
				+ "\n");
		String title = sc.nextLine().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("이름이 존재하지 않습니다. ");
			return;
		}*/
	//	int num = sc.nextInt();
	//	title = sc.nextLine().trim();
	/*	if (!l.isDuplicate(title)) {
			System.out.println("이름이 존재하지 않습니다. ");
			return;
		}*/

		System.out.println("새로운 일정제목 > ");
		new_title = sc.next().trim();
		sc.nextLine();
		if (l.isDuplicate(new_title)) {
			System.out.println("중복된 일정입니다. ");
			return;
		}
		
		System.out.println("새로운 카테고리 > ");
		new_category = sc.next().trim();
		
		System.out.println("새로운 일정내용 > ");
		new_desc = sc.nextLine().trim();
		
		System.out.println("새로운 마감일 > ");
		new_due_date = sc.nextLine().trim();
		
		System.out.print("새로운 중요도 > (1~5) ");
		new_star = sc.nextLine().trim();
		
		System.out.print("새로운 함께하는사람 > ");
		new_person= sc.nextLine().trim();
	
		TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date, new_star, new_person);
		t.setId(index);
		if(l.updateItem(t) > 0) System.out.println("수정되었습니다.");
		//}
	/*	else if(num == 2) {
			System.out.println("새로운 일정제목 > ");
			new_title = sc.next().trim();
			sc.nextLine();
			if (l.isDuplicate(new_title)) {
				System.out.println("중복된 일정입니다. ");
				return;}
			TodoItem t = new TodoItem(new_title);
			if(l.updateItem2(t) > 0) System.out.println("수정되었습니다.");
			}*/
		
		}
		
		
	/*	for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title))
//	if(num == listAll(l))
			{
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, new_category, new_due_Date);
//l.addItem(t);
				System.out.println("수정되었습니다. ");
			}
		}*/
		

	public static void findList(TodoList l, String keyword) {
		int count = 0;
		for(TodoItem item : l.getList(keyword)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n", count);
		
	}
	
public static void listAll(TodoList l) {

		
		System.out.println("[전체 목록], 총 "+l.getCount()+"개");
		
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
		
	}
	
	
	public static void listAll(TodoList l, String orderby, int ordering) {
	//	int i = 1;
		
		
		System.out.printf("[전체 목록, 총 %d 개 ]\n", l.getCount());
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		//	System.out.println( "["+ item.getCategory() +"]" + item.getTitle() + " - " +  item.getDesc() + " - " + item.getCurrent_date() + " ~ " + item.getDue_date());
		//	System.out.println("[" +item.getCategory() + "] "+item.getTitle() + " - " +  item.getDesc() +" - " + item.getCurrent_date() + " - " + item.getDue_date());
			
		}
	/*	for (TodoItem item : l.getList(orderby)) {
			//System.out.println( "["+ item.getCategory() +"]" + item.getTitle() + " - " +  item.getDesc() + " - " + item.getCurrent_date() + " ~ " + item.getDue_date());
			System.out.println(i + ". "+ "[" +item.getCategory() + "] "+item.getTitle() + " - " +  item.getDesc() +" - " + item.getCurrent_date() + " - " + item.getDue_date());
			i++;
		} 
		//	return i;*/

	}
	
	public static void listPersonAll(TodoList l,String keyword) {
		// TODO Auto-generated method stub
		int count = 0;
		for(TodoItem item : l.getListperson(keyword)) {
			System.out.print(item.toString());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n", count);

	}
	
	
	
	public static void GSONsaveList(TodoList l, String todolist) {
		Gson gson = new Gson();
		
//		String title, desc, current_date = null;
//		TodoItem t = new TodoItem (title, desc, current_date);
		
		
//		for (TodoItem item : l.getList(todolist)) {
				String jsonstr = gson.toJson(l.getList());
				System.out.println(jsonstr);	
//				}
		try {
			Writer w = new FileWriter("data.txt");
			w.write (jsonstr);
			w.close();
			System.out.println("\n 정보 저장 완료 ");
			}catch (IOException e) {
			e.printStackTrace();
		}
	}
			
			
			
			
			
	/*	//	String title, desc, current_date = null;
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
*/
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
		for(TodoItem item : l.getListCategory(cate)){
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목을 찾았습니다.\n",count);
	}

	public static void findStarList(TodoList l, String num) {
		int count = 0;
		for(TodoItem item : l.getListStar(num)){
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목을 찾았습니다.\n",count);
	}
	

		
	
	
	
	
	public static void completeItem(TodoList l, int comp) {
		int is_completed = 1;
		TodoItem t = new TodoItem(is_completed);
		t.setId(comp);
		if(l.completeItem(comp) > 0)
		System.out.printf("\n완료 체크하였습니다.\n");
		
	}
	
	
	public static void complistAll(TodoList l,int comp) {
		// TODO Auto-generated method stub
		int count = 0;
		for(TodoItem item : l.getListComp(comp)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목이 체크되어 있습니다.\n", count);
	}


}
