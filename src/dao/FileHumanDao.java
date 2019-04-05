package dao;


import di.Component;
import model.Human;

import java.io.*;

@Component
public class FileHumanDao implements HumanDao {

	public void save(Human human) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("storage.dat"))) {
			objectOutputStream.writeObject(human);
		} catch (IOException e) {
			System.out.println("Не удалось записать клиента в базу");
		}
	}

	public Human get() {
		try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream("storage.dat"))) {
			return (Human) inputObjectStream.readObject();
		} catch (Exception e) {
			System.out.println("Клиент не найден в системе");
			return null;
		}
	}
}