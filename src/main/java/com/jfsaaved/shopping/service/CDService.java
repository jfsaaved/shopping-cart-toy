package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.repository.CDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDService {

    private CDRepository cdRepository;

    @Autowired
    public CDService(CDRepository cdRepository){
        this.cdRepository = cdRepository;
    }

    public void save(CD cd){
        cdRepository.save(cd);
    }

    public CD get(Long id){
        return cdRepository.findById(id).orElse(null);
    }

    public void delete(CD cd){
        cdRepository.delete(cd);
    }

    public Iterable<CD> list(){
        return cdRepository.findAll();
    }

}
