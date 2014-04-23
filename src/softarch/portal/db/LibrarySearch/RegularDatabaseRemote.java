package softarch.portal.db.LibrarySearch;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.axis.AxisFault;

import librarysearch.soft.BookList;
import librarysearch.soft.LibrarySearchRequest;
import librarysearch.soft.LibrarySearchResponse;
import librarysearch.soft.LibrarySearchSOAPBindingStub;
import librarysearch.soft.LibrarySearchServiceLocator;
import softarch.portal.data.Book;
import softarch.portal.data.RegularData;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;

public class RegularDatabaseRemote extends DatabaseRemote implements RegularDatabase {

	public RegularDatabaseRemote(String dbUser, String dbPassword, String dbUrl) {
		super(dbUser, dbPassword, dbUrl);
	}

	public List findRecords(String informationType, String queryString)
			throws DatabaseException {
		LibrarySearchServiceLocator loc = new LibrarySearchServiceLocator();
		URL url = null;
		LibrarySearchRequest req = new LibrarySearchRequest(queryString);
		List<Book> books = new ArrayList<Book>();//List of books containing the results parsed.

		try {
			url = new URL("http://localhost:8080/ode/processes/LibrarySearchService?wsdl");//'?wsdl' required?
		
			LibrarySearchSOAPBindingStub service = new LibrarySearchSOAPBindingStub(url, loc);
			LibrarySearchResponse res = service.process(req);//Process the request
			BookList bookList = res.getBooks();//Get the results
			librarysearch.soft.Book[] bookListToParse = bookList.getBook();
			
			// Parse and convert the result -->
			for(int i = 0; i < bookListToParse.length; ++i) {
				
				String author = bookListToParse[i].getAuthor();
				long isbn = bookListToParse[i].getIsbn().longValue();
				int pages = bookListToParse[i].getPages();
				Date date = bookListToParse[i].getPublicationDate().getTime();
				String publisher = bookListToParse[i].getPublisher();
				String review = bookListToParse[i].getReview();
				String summary = bookListToParse[i].getSummary();
				String title = bookListToParse[i].getTitle();
				
				books.add(new Book(null, author, isbn, pages, date, publisher, review, summary, title));
			}
			// <--
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return books;
		
	}

	public List findRecordsFrom(String informationType, Date date)
			throws DatabaseException {
		throw new DatabaseException("Not implemented");
	}

	public void add(RegularData rd) throws DatabaseException {
		throw new DatabaseException("Not implemented");
	}

	public int getNumberOfRegularRecords(String informationType)
			throws DatabaseException {
		throw new DatabaseException("Not implemented");
	}

}
