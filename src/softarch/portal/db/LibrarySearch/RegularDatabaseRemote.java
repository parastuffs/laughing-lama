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
		List<Book> books = new ArrayList<Book>();

		try {
			url = new URL("http://localhost:8080/ode/processes/LibrarySearchService?wsdl");//'?wsdl' required?
		
			LibrarySearchSOAPBindingStub service = new LibrarySearchSOAPBindingStub(url, loc);
			LibrarySearchResponse res = service.process(req);
			BookList bookList = res.getBooks();
			librarysearch.soft.Book[] bookList2 = bookList.getBook();
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
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
