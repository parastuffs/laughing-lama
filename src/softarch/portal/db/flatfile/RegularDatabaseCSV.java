package softarch.portal.db.flatfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import softarch.portal.data.Article;
import softarch.portal.data.Book;
import softarch.portal.data.Conference;
import softarch.portal.data.InterestingWebsite;
import softarch.portal.data.RegularData;
import softarch.portal.data.Report;
import softarch.portal.data.SoftwareRepository;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;

import java.text.ParseException;
import java.sql.SQLException;

/**
 * This class encapsulates the regular database.
 * @author Niels Joncheere
 */
public class RegularDatabaseCSV extends DatabaseCSV implements RegularDatabase{
	/**
	 * Creates a new regular database.
	 */
	public RegularDatabaseCSV(String dbUser, String dbPassword, String dbUrl)throws DatabaseException {
		super(dbUser, dbPassword, dbUrl);

	}

	/**
	 * Returns a list containing all records of the given information type
	 * that match the given query string.
	 */
	public List findRecords(String informationType, String queryString)throws DatabaseException{
		//throw new DatabaseException("Not implemented");
		return new ArrayList();
	}

	
	/**
	 * Returns a list containing all records of the given information type
	 * that were added after the given date.
	 */
	public List findRecordsFrom(String informationType, Date date)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}
	/**
	 * Adds a new regular data object to the regular database.
	 */
	public void add(RegularData rd)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	/**
	 * Returns the number of records of the given information type in the
	 * regular database.
	 */
	public int getNumberOfRegularRecords(String informationType)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}
}
