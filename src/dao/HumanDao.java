package dao;

import model.Human;

import java.util.List;

public interface HumanDao {
		void saveHuman(Human human);
		Human getHuman();
		List<Human> getAllHumans();
	}

