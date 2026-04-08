import java.util.Scanner;

abstract class Book {
    private String name;
    private String author;

    public Book() {
    	}
    
    
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    
    
    public void setName(String name) { 
    	this.name = name;
    	    }
    public String getName() {
    	return name;
    	      }

    public void setAuthor(String author) { 
    	
    	this.author = author;
    	      }
    public String getAuthor() {
    	
    	return author;
    	      }

    public abstract void displayInfo();
    
    public abstract boolean isRecommendedForAge(int age);
                }


class FictionBook extends Book {
    private String genre;

    public FictionBook() {
    	}
    
    
    public FictionBook(String name, String author, String genre) {
        super(name, author);
        this.genre = genre;
    }
    
    public void setGenre(String genre) { 
    	this.genre = genre; 
    	      }
    
    public String getGenre() { 
    	return genre; 
    	         }
    @Override
    public void displayInfo() {
    	             System.out.println(getName());
    	             System.out.println(getAuthor());
    	             System.out.println(getGenre());
    	         }
    
    
    @Override
    public boolean isRecommendedForAge(int age) {
        return age >= 14;
    }
}

    
     class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook() {
    	}
    
    public NonFictionBook(String name, String author, String subject) {
    	
        super(name, author);
        this.subject = subject;
    }
    
    
    public void setSubject(String subject) {
    	
    	this.subject = subject;
    	          }
    
    public String getSubject() { 
    	return subject; 
    	}
    
    
    @Override
    public void displayInfo() {
        System.out.println(getName());
        System.out.println(getAuthor());
        System.out.println(getSubject());
    }
    
    
    @Override
    public boolean isRecommendedForAge(int age) {
        return age >= 18;
    }
}
     
     
     
public class classwork16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
Scanner input = new Scanner(System.in);
        
        System.out.print("Enter age to check: ");
        int age = input.nextInt();

        FictionBook f = new FictionBook("Pather Panchali", "Bibhutibhushan Bandyopadhyay", "Classic Fiction");
        NonFictionBook nf = new NonFictionBook("Amar Dekha Rajnitir Panchash Bochor", "Abul Mansur Ahmed", "History/Politics");

        System.out.println("\nFiction Test");
        f.displayInfo();
        System.out.println("Recommended: " + f.isRecommendedForAge(age));

        System.out.println("\nNon-Fiction Test");
        nf.displayInfo();
        System.out.println("Recommended: " + nf.isRecommendedForAge(age));
        
        input.close();
		
	}

}
