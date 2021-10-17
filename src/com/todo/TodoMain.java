package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		//l.importData("todolist.txt");
		boolean isList = false;
		boolean quit = false;
		
			Menu.displaymenu();
		//	TodoUtil.loadList(l, "todolist.txt");
		do {
			//Menu.displaymenu();
			isList = false;
			String choice = sc.next().trim();
		
			switch (choice) {
			case "menu":
				Menu.prompt();
				break;
				
			case "help":
				Menu.displaymenu();
				break;
			
			case "find":
				String keyword = sc.nextLine().trim();
				TodoUtil.findList(l, keyword);
				break;
				
			case "comp":
				int comp = sc.nextInt();
				TodoUtil.completeItem(l, comp);
				break;
				
			case "ls_comp":
				System.out.println("완료된 항목을 출력하였습니다.");
				TodoUtil.complistAll(l, 1);
				break;
				
			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				int num = sc.nextInt();
				TodoUtil.deleteItem(l, num);
				break;
				
			case "edit":
				int num2 = sc.nextInt();
				TodoUtil.updateItem(l, num2);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name":
				System.out.println("제목순으로 정렬하였습니다.");
				TodoUtil.listAll(l, "title", 1);
				
			//	l.sortByName();
			//	isList = true;
				break;

			case "ls_name_desc":
				System.out.println("제목역순으로 정렬하였습니다.");
				TodoUtil.listAll(l, "title", 0);

				//l.sortByName();
				//l.reverseList();
				//isList = true;
				break;
				
			case "ls_date":
				System.out.println("날짜순으로 정렬하였습니다.");
				TodoUtil.listAll(l, "due_date", 1);

			//	l.sortByDate();
			//	isList = true;
				break;
				
			case "ls_date_desc":
				System.out.println("날짜역순으로 정렬하였습니다.");
				TodoUtil.listAll(l, "due_date", 0);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;

			case "find_cate":
				String cate = sc.next().trim();
				TodoUtil.findCateList(l, cate);
				break;
				
			case "find_star":
				String star = sc.next().trim();
				TodoUtil.findStarList(l, star);
				break;
				
			case "ls_person":
				String person = sc.next().trim();
				TodoUtil.listPersonAll(l, person);
				break;
				
			case "save":
				TodoUtil.GSONsaveList(l, "data.txt");
			
			case "exit":
				quit = true;
			//	TodoUtil.saveList(l, "todolist.txt");
				break;

			default:
				System.out.println("명령어를 입력하세요  >");
				break;
			}
			
			if(isList) l.listAll();
		} while (!quit);
		
	}
}
