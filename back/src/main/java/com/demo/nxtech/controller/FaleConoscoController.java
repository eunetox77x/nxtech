package com.demo.nxtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.nxtech.application.FaleConoscoApplication;
import com.demo.nxtech.entities.FaleConosco;

@RestController
@RequestMapping("/faleconosco")
@CrossOrigin(origins = "*")
public class FaleConoscoController {
    
    @Autowired
    FaleConoscoApplication faleConoscoApplication;

    @PostMapping("/cadastrar")
    public FaleConosco cadastrar(@RequestBody FaleConosco faleConosco){
        return faleConoscoApplication.cadastrar(faleConosco);
    }

    @GetMapping
    public List listar(){
        return faleConoscoApplication.listar();
    }

}
