import java.util.ArrayList;

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


public class Homework16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Book> bookList = new ArrayList<>();


		bookList.add(new FictionBook("Himu-r Rupali Ratri", "Humayun Ahmed", "Fiction/Mystery"));

		bookList.add(new FictionBook("Feluda: Darjeeling Jomjomat", "Satyajit Ray", "Detective"));

		bookList.add(new FictionBook("Chokher Bali", "Rabindranath Tagore", "Classic Drama"));




		bookList.add(new NonFictionBook("Oshomapto Attojiboni", "Sheikh Mujibur Rahman", "Autobiography"));

		bookList.add(new NonFictionBook("Ekattorer Dinguli", "Jahanara Imam", "History/War Memoir"));

		bookList.add(new NonFictionBook("Lalsalu", "Syed Waliullah", "Social Subject/Novel"));



		System.out.println("Iterating through Books (Checking for Age 16)\n");



		for (Book b : bookList) {

		        b.displayInfo();

		boolean result = b.isRecommendedForAge(16);


		           if (result) {

		          System.out.println("This book is recommended for a 16-year-old.");

		} 
		
		           else {

		            System.out.println("This book is NOT recommended for a 16-year-old.");

		                 }
		                       }
	                                  }
                                              }
