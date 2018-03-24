package Database.InputDataBase;

import java.sql.Connection;

import Database.DatabaseSettings;

public interface InputDB {

	public static void input() throws Exception {
		try {
			Connection database = DatabaseSettings.connect();

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseSettings.close();
		}
	}
	
}
