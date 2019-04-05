package di;

import dao.*;
import factory.ClientDaoFactory;
import factory.HumanDaoFactory;
import handler.ConsoleHandler;

import java.lang.reflect.Field;

public class Injector {

	public static void injectDependency() throws IllegalAccessException {
		Class consoleHandlerClass = ConsoleHandler.class;
		Class fileClientDaoClass = FileClientDao.class;
		Class inMemoryClientDaoClass = InMemoryClientDao.class;
		Class fileHumanDaoClass = FileHumanDao.class;
		Class inMemoryHumanDaoClass = InMemoryHumanDao.class;

		Field[] fields = consoleHandlerClass.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
				field.setAccessible(true);
				if (field.getName() == "clientDao") {
					boolean fileDao = fileClientDaoClass.isAnnotationPresent(Component.class);
					if (fileDao) {
						System.out.println("Работа с файлами разрешена");
					}
					boolean inMemoryDao = inMemoryClientDaoClass.isAnnotationPresent(Component.class);
					if (inMemoryDao) {
						System.out.println("Работа с ОЗУ разрешена");
					}
					ClientDao clientDao = ClientDaoFactory.getClientDao(fileDao, inMemoryDao);
					field.set(null, clientDao);
				} else if (field.getName() == "humanDao") {
					boolean fileDao = fileHumanDaoClass.isAnnotationPresent(Component.class);
					if (fileDao) {
						System.out.println("Работа с файлами разрешена");
					}
					boolean inMemoryDao = inMemoryHumanDaoClass.isAnnotationPresent(Component.class);
					if (inMemoryDao) {
						System.out.println("Работа с ОЗУ разрешена");
					}
					HumanDao humanDao = HumanDaoFactory.getHumanDao(fileDao, inMemoryDao);
					field.set(null, humanDao);
				}
			}
		}
	}
}
