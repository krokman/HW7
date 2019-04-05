package dao;

import model.Human;

public interface HumanDao {
		void save(Human human);
		Human get();
	}

