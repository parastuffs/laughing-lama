package softarch.portal.db.LibrarySearch;

import java.util.Date;
import java.util.List;

import softarch.portal.data.RegularData;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RegularDatabase;

public class RegularDatabaseRemote extends DatabaseRemote implements RegularDatabase {

	public RegularDatabaseRemote(String dbUser, String dbPassword, String dbUrl) {
		super(dbUser, dbPassword, dbUrl);
		// TODO Auto-generated constructor stub
	}

	public List findRecords(String informationType, String queryString)
			throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public List findRecordsFrom(String informationType, Date date)
			throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(RegularData rd) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	public int getNumberOfRegularRecords(String informationType)
			throws DatabaseException {
		// TODO Auto-generated method stub
		return 0;
	}

}
