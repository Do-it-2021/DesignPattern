package com.concurrent.medium_mod.dao;

import com.concurrent.medium_mod.po.School;

public interface ISchoolDao {
	
		School querySchoolInfoById(Long id);
}
