package dao;

import di.Component;
import model.Human;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileHumanDao implements HumanDao {
	private int numberOfHumans = 0;
	public void saveHuman(Human human) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("storageForHuman.dat"))) {
			objectOutputStream.writeObject(human);
			numberOfHumans++;
		} catch (IOException e) {
			System.out.println("Не удалось записать клиента в базу");
		}
	}

	public Human getHuman() {
		try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream("storageForHuman.dat"))) {
			return (Human) inputObjectStream.readObject();
		} catch (Exception e) {
			System.out.println("Клиент не найден в системе");
		}
		throw new RuntimeException("Wrong object Human");
	}

	@Override
	public List<Human> getAllHumans() {
		List<Human> humanList = new ArrayList<>();
		for (int i = 0; i < numberOfHumans; i++) {
			humanList.add(getHuman());
		}
		return humanList;
	}
}