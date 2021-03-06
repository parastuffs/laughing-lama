package softarch.portal.db;

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

import java.text.ParseException;
import java.sql.SQLException;

/**
 * This class encapsulates the regular database.
 * @author Niels Joncheere
 */
public interface RegularDatabase{


	/**
	 * Returns a list containing all records of the given information type
	 * that match the given query string.
	 */
	public List findRecords(String informationType, String queryString)throws DatabaseException;

	
	/**
	 * Returns a list containing all records of the given information type
	 * that were added after the given date.
	 */
	public List findRecordsFrom(String informationType, Date date)throws DatabaseException;
	/**
	 * Adds a new regular data object to the regular database.
	 */
	public void add(RegularData rd)throws DatabaseException;

	/**
	 * Returns the number of records of the given information type in the
	 * regular database.
	 */
	public int getNumberOfRegularRecords(String informationType)throws DatabaseException;
}
