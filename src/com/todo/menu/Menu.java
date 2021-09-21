package com.todo.menu;
public class Menu {
	
	public static void prompt() {
        System.out.println("메뉴를 확인하려면 도움을 요청하세요 (help) ");

	}
    public static void displaymenu()
    {
        System.out.println();
        System.out.println("1. 일정추가  ( add )");
        System.out.println("2. 일정삭제  ( del )");
        System.out.println("3. 일정수정  ( edit )");
        System.out.println("4. 일정목록확인  ( ls )");
        System.out.println("5. 이름순서대로정렬  ( ls_name_asc )");
        System.out.println("6. 이름역순으로정렬  ( ls_name_desc )");
        System.out.println("7. 추가시간별정렬  ( ls_date )");
        System.out.println("8. 종료  (Or press escape key to exit)");
        System.out.println("명령어를 입력하세요  >");
        System.out.println();

    }
}
