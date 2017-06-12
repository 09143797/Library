package library;

import java.util.List;

public class LoanOnlySpecification implements ISpecification<Member> {
	private Book wantBook;

	public LoanOnlySpecification(Book wantBook){
		this.wantBook = wantBook;
	}
	public boolean isSatisfiedBy(Member member) {
		boolean m = false;
		List<Loan> list = member.getLoans();
		if(list == null){
			m=true; 
		}else{
			for(Loan loan:list){
				if(loan.getBook().getISBN()!=wantBook.getISBN()){
					m=true;
				}
			}
		}
		
		return m;
	}
	
}