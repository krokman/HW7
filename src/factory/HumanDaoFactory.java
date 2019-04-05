package factory;

import dao.FileHumanDao;
import dao.HumanDao;
import dao.InMemoryHumanDao;
import service.PropertyLoader;

import java.io.IOException;

public class HumanDaoFactory {
	private static final HumanDao inMemoryDao = new InMemoryHumanDao();
	private static final HumanDao fileDao = new FileHumanDao();

	public static HumanDao getHumanDao(boolean isFileDao, boolean isInMemoryDao) {
		try {
			String dbName = PropertyLoader.getProperty("db.name");
			if (dbName.equals("memory") && isInMemoryDao) {
				return inMemoryDao;
			}
		} catch (IOException e) {
			System.out.println("Нет доступа к файлу");
		}
		if (isFileDao) {
			return fileDao;
		} else {
			throw new ComponentNotFoundException();
		}
	}
}
