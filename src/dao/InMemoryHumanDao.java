package dao;


import di.Component;
import model.Human;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryHumanDao implements HumanDao {

	private static final List<Human> inMemoryStorage = new ArrayList<>();


	public void save(Human human) {
		inMemoryStorage.add(human);
	}

	public Human get() {
		return inMemoryStorage.get(0);
	}
}
