package LibraryTest;


import org.junit.Test;

import library.Book;
import library.Member;

public class LibraryTest {
	
	private Book book1,book2,book3,book4;
	private Member member1;	
	
	
	//添加用户
	public void addMember(){
		member1 = new Member();
		member1.setId("0001");
		member1.setName("二哈");
	}
	
	
	//添加图书
	public void addBook(){
		book1 = new Book();
		book2 = new Book();
		book3 = new Book();
		book4 = new Book();
		book1.setId("0001");
		book1.setISBN("CT001");
		book1.setTitle("格列佛游记");
		book1.setLoanTo(null);
		book2.setId("0002");
		book2.setISBN("CT002");
		book2.setTitle("徐霞客游记");
		book2.setLoanTo(null);
		book3.setId("0003");
		book3.setISBN("CT003");
		book3.setTitle("许三观卖血记");
		book3.setLoanTo(null);
		book4.setId("0004");
		book4.setISBN("CT004");
		book4.setTitle("名人传");
		book4.setLoanTo(null);
	}
	
	
	// 借书成功
	@Test
	public void loanSuccess(){
		this.addMember(); 
		this.addBook();
		member1.Loan(book1);
		member1.Loan(book2);
		member1.Loan(book3);
		System.out.println("***********借书记录***************");
		System.out.println("姓名：" + member1.getName());
		System.out.println("书名：" + book1.getTitle() + "、" + book2.getTitle() + "、" + book3.getTitle());
		System.out.println("借书时间：" + member1.getLoans().get(0).getLoanDate());
		
	}
	
	
	//借书失败
	@Test
	public void loanFail(){
		this.loanSuccess();
		member1.Loan(book1);
		if(member1.validate(book1)==false){
			System.out.println("借书失败");
		}
	}
	
	
	//还书
	@Test
	public void returnBook(){
		this.loanSuccess();
		member1.Return(book1);
		System.out.println("***********还书记录***************");
		System.out.println("姓名：" + member1.getName());
		System.out.println("书名：" + book1.getTitle());
	}
}