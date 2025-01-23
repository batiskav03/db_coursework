package com.senechka.course_back.services;

import com.senechka.course_back.DAO.OrgDAO;
import com.senechka.course_back.Requests.OrgAddRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class OrgServiceTest {

    @InjectMocks
    private OrgService orgService;

    @Mock
    private OrgDAO orgDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addOrg() {
        String name = "New Org";
        String disc = "Description";

        orgService.addOrg(name, disc);
        verify(orgDAO, times(1)).callAddOrg(name, disc);
    }

    @Test
    void remOrg() {
        String name = "Org to Remove";

        orgService.remOrg(name);
        verify(orgDAO, times(1)).callRemOrg(name);
    }

    @Test
    void viewOrgs() {
        orgService.viewOrgs();
        verify(orgDAO, times(1)).callViewOrgs();
    }
} 