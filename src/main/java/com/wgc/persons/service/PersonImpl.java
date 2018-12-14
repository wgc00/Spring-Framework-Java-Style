package com.wgc.persons.service;

import com.wgc.persons.dao.PersonsMapper;
import com.wgc.persons.entity.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonImpl implements PersonService {

    @Autowired
    private PersonsMapper personsMapper;

    @Override
    public List<Persons> selectAll() {
        List<Persons> persons = personsMapper.selectAll();
        return persons;
    }
}
