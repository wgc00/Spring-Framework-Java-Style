package com.wgc.persons.dao;

import com.wgc.persons.entity.Persons;
import java.util.List;


public interface PersonsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Persons record);

    Persons selectByPrimaryKey(Integer id);

    List<Persons> selectAll();

    int updateByPrimaryKey(Persons record);
}