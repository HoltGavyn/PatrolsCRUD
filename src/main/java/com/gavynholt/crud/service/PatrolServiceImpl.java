package com.gavynholt.crud.service;

import com.gavynholt.crud.dao.PatrolDAO;
import com.gavynholt.crud.entity.Patrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatrolServiceImpl implements PatrolService{

    @Autowired
    private PatrolDAO patrolDAO;

    @Override
    @Transactional
    public List<Patrol> getScheduledPatrols() {

        return patrolDAO.getScheduledPatrols();
    }

    @Override
    @Transactional
    public Patrol getPatrolById(int patrolId) {

        return patrolDAO.getPatrolById(patrolId);
    }

    @Override
    @Transactional
    public void addNewPatrols(List<Patrol> patrolsToAdd) {

        patrolDAO.addNewPatrols(patrolsToAdd);
    }

    @Override
    @Transactional
    public void deletePatrol(int patrolId) {

        patrolDAO.deletePatrol(patrolId);
    }
}
