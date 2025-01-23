package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.OrgAddRequest;
import com.senechka.course_back.Requests.RemOrgRequest;
import com.senechka.course_back.services.OrgService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrgControllerTest {

    @InjectMocks
    private OrgController orgController;

    @Mock
    private OrgService orgService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addOrg() {
        OrgAddRequest orgAddRequest = new OrgAddRequest();
        orgAddRequest.setName("New Org");
        orgAddRequest.setDisc("Description");

        ResponseEntity<Void> response = orgController.addOrg(orgAddRequest);
        verify(orgService, times(1)).addOrg("New Org", "Description");
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void remOrg() {
        RemOrgRequest remOrgRequest = new RemOrgRequest();
        remOrgRequest.setName("Org to Remove");

        ResponseEntity<Void> response = orgController.remOrg(remOrgRequest);
        verify(orgService, times(1)).remOrg("Org to Remove");
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void viewOrgs() {
        when(orgService.viewOrgs()).thenReturn(List.of("Org1", "Org2"));

        List<String> orgs = orgController.viewOrg();
        verify(orgService, times(1)).viewOrgs();
        assertEquals(List.of("Org1", "Org2"), orgs);
    }
} 