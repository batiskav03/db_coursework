package com.senechka.course_back.services;

import com.senechka.course_back.DAO.OrgDAO;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void remOrg(String name){
        orgDAO.callRemOrg(name);
    }

    public List<String> viewOrgs(){
        return orgDAO.callViewOrgs();
    }
}
