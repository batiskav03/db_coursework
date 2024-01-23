package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.OrgAddRequest;
import com.senechka.course_back.Requests.RemOrgRequest;
import com.senechka.course_back.services.OrgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class OrgController {

    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @PostMapping("/addOrg")
    public void addOrg(@RequestBody OrgAddRequest request) {
        System.out.println("name:"+ request.getName());
        orgService.addOrg(request.getName(), request.getDisc());
    }
    @PostMapping("/remOrg")
    public void remOrg(@RequestBody RemOrgRequest request) {
        orgService. remOrg(request.getName());
    }

    @PostMapping("/viewOrgs")
    public List<String> viewOrg(){
        System.out.println("xyu");
        return orgService.viewOrgs();
    }
}


