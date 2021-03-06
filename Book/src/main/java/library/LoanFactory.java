package library;

import java.time.LocalDate;
import java.util.UUID;

public class LoanFactory {
	public static Loan CreateLoan(Book book,Member member){
		Loan loan = new Loan();
		loan.id = UUID.randomUUID().toString();
		loan.book = book;
		loan.member = member;
		loan.loanDate = LocalDate.now();
		loan.dateForReturn = LocalDate.now().plusDays(10);
		book.setLoanTo(member);
		return loan;
	}
}