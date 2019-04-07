package dao;

import di.Component;
import model.Client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileClientDao implements ClientDao {
	private int numberOfClients = 0;

	public void saveClient(Client client) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("storageForClient.dat"))) {
			objectOutputStream.writeObject(client);
			numberOfClients++;
		} catch (IOException e) {
			System.out.println("Не удалось записать клиента в базу");
		}
	}

	public Client getClient() {
		try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream("storageForClient.dat"))) {
			return (Client) inputObjectStream.readObject();
		} catch (Exception e) {
			System.out.println("Клиент не найден в системе");

		}
		throw new RuntimeException("Wrong object Client");
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clientList = new ArrayList<>();
		for (int i = 0; i < numberOfClients; i++) {
			clientList.add(getClient());
		}
		return clientList;
	}
}
