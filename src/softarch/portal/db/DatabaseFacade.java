package softarch.portal.db;

import softarch.portal.data.RawData;
import softarch.portal.data.RegularData;
import softarch.portal.data.UserProfile;
import softarch.portal.db.sql.RawDatabaseSQL;
import softarch.portal.db.sql.RegularDatabaseSQL;
import softarch.portal.db.sql.UserDatabaseSQL;
import softarch.portal.db.LibrarySearch.RegularDatabaseRemote;
import softarch.portal.db.flatfile.RawDatabaseCSV;
import softarch.portal.db.flatfile.RegularDatabaseCSV;
import softarch.portal.db.flatfile.UserDatabaseCSV;

import java.util.List;
import java.util.Date;

/**
 * This class implements a facade for all of the database layer's functionality.
 * @author Niels Joncheere
 */
public class DatabaseFacade {
	private UserDatabase	userDb;
	private RegularDatabase	regularDb;
	private RegularDatabase remoteDb;
	private RawDatabase	rawDb;

	/**
	 * Creates a new database facade.
	 */
	public DatabaseFacade(String dbUser, String dbPassword, String dbUrl, String dbFormat){

		try{
			if(dbFormat.equals("csv")){
				userDb		= new UserDatabaseCSV(	dbUser,
						dbPassword,
						dbUrl.split(";")[0]);
				regularDb	= new RegularDatabaseCSV(	dbUser,
						dbPassword,
						dbUrl.split(";")[0]);
				rawDb		= new RawDatabaseCSV(	dbUser,
						dbPassword,
						dbUrl.split(";")[0]);
			}
			else if(dbFormat.equals("sql")){
				userDb		= new UserDatabaseSQL(	dbUser,
						dbPassword,
						dbUrl);
				regularDb	= new RegularDatabaseSQL(	dbUser,
						dbPassword,
						dbUrl);
				rawDb		= new RawDatabaseSQL(	dbUser,
						dbPassword,
						dbUrl);
			}
			else{
				throw new DatabaseException("Database format not implemented");
			}
			
			this.remoteDb = new RegularDatabaseRemote(dbUser, dbPassword, dbUrl);
		}
		catch(DatabaseException e){
			e.printStackTrace();
		}
	}

	/**
	 * Inserts a new user profile into the user database.
	 */
	public void insert(UserProfile profile)
			throws DatabaseException {

		userDb.insert(profile);
	}

	/**
	 * Updates an existing user profile in the user database.
	 */
	public void update(UserProfile profile)
			throws DatabaseException {

		userDb.update(profile);
	}

	/**
	 * Returns the user with the specified username.
	 */
	public UserProfile findUser(String username)
			throws DatabaseException {

		return userDb.findUser(username);
	}

	/**
	 * Checks whether a user with the specified username exists.
	 */
	public boolean userExists(String username)
			throws DatabaseException {

		return userDb.userExists(username);
	}

	/**
	 * Returns a list containing all records of the given information type
	 * that match the given query string.
	 */
	public List findRecords(String informationType, String queryString)
			throws DatabaseException {

		return regularDb.findRecords(informationType, queryString);
	}

	/**
	 * Returns a list containing all records of the given information type
	 * that were added after the given date.
	 */
	public List findRecordsFrom(String informationType, Date date)
			throws DatabaseException {

		return regularDb.findRecordsFrom(informationType, date);
	}

	/**
	 * Adds a new regular data object to the regular database.
	 */
	public void add(RegularData rd)
			throws DatabaseException {

		regularDb.add(rd);
	}

	/**
	 * Returns the number of records of the given information type in the
	 * regular database.
	 */
	public int getNumberOfRegularRecords(String informationType)
			throws DatabaseException {

		return regularDb.getNumberOfRegularRecords(informationType);
	}

	/**
	 * Returns a list of all raw data.
	 */
	public List getRawData()
			throws DatabaseException {

		return rawDb.getRawData();
	}

	/**
	 * Returns a specific raw data object.
	 */
	public RawData getRawData(int id)
			throws DatabaseException {

		return rawDb.getRawData(id);
	}

	public void addRawData(RegularData rd)
			throws DatabaseException {

		rawDb.addRawData(rd);
	}

	/**
	 * Deletes a raw data object.
	 */
	public void deleteRawData(RawData rd)
			throws DatabaseException {

		rawDb.deleteRawData(rd);
	}

	/**
	 * Updates a raw data object.
	 */
	public void updateRawData(RawData rd)
			throws DatabaseException {

		rawDb.updateRawData(rd);
	}

	/**
	 * Returns the number of records in the raw database.
	 */
	public int getNumberOfRawRecords()
			throws DatabaseException {

		return rawDb.getNumberOfRawRecords();
	}
}
