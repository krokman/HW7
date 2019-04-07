package dao;

import di.Component;
import model.Human;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryHumanDao implements HumanDao {
	private static final List<Human> inMemoryStorage = new ArrayList<>();

	public void saveHuman(Human human) {
		inMemoryStorage.add(human);
	}

	public Human getHuman() {
		return inMemoryStorage.get(0);
	}

	@Override
	public List<Human> getAllHumans() {
		return inMemoryStorage;
	}
}
