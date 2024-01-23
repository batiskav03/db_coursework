package com.senechka.course_back.services;

import com.senechka.course_back.DAO.OrgDAO;
import org.springframework.stereotype.Service;

@Service
public class OrgService {
    private final OrgDAO orgDAO;


    public OrgService(OrgDAO orgDAO) {
        this.orgDAO = orgDAO;
    }

    public void addOrg(String name, String disc){
        orgDAO.callAddOrg(name, disc);
        System.out.println("name:"+name);
    }
}
