package com.demo.nxtech.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.nxtech.entities.FaleConosco;
import com.demo.nxtech.repository.FaleConoscoRepository;


@Component
public class FaleConoscoApplication {

    @Autowired
    FaleConoscoRepository faleConoscoRepository;

    public FaleConosco cadastrar(FaleConosco faleConosco){
        return faleConoscoRepository.save(faleConosco);
    }

    public List listar(){
        return faleConoscoRepository.findAll();
    }


}
