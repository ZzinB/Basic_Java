package com.todo.menu;
public class Menu {
	
	public static void prompt() {
        System.out.println("\n명령어를 입력하세요  >");

	}
	
    public static void displaymenu()
    {
        System.out.println();
        System.out.println("1. 일정추가  ( add )");
        System.out.println("2. 일정삭제  ( del <1:이름 2:번호 3:카테고리>)");
        System.out.println("3. 일정수정  ( edit )");
        System.out.println("4. 일정목록확인  ( ls )");
        System.out.println("5. 이름순서대로정렬  ( ls_name )");
        System.out.println("6. 이름역순으로정렬  ( ls_name_desc )");
        System.out.println("7. 추가시간별정렬  ( ls_date )");
        System.out.println("8. 추가시간역순으로정렬  ( ls_date_desc )");
        System.out.println("9. 종료  (Or press escape key to exit)");
        System.out.println("10. 찾기 (find <단어>) ");
        System.out.println("11. 카테고리목록확인 (ls_cate <단어>) ");
        System.out.println("12. 카테고리찾기 (find_cate <단어>) ");
        System.out.println("13. 중요도찾기 (find_star <1~5>) ");
        System.out.println("14. 같은사람과하는목록정렬 (ls_person <사람>) ");
        System.out.println("15. JSON파일형식으로 저장하기 (save) ");
        System.out.println("16. 완료항목표시하기 (comp <번호>) ");



//        System.out.println("명령어를 입력하세요  >");
        System.out.println();

    }
}
