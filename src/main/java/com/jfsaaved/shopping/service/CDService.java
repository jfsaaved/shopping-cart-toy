package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.repository.CDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CDService {

    private CDRepository cdRepository;

    @Autowired
    public CDService(CDRepository cdRepository){
        this.cdRepository = cdRepository;
    }

    public ArrayList<CD> filterByTitleAndArtist(String filter){
        if(filter == null) filter = "";
        ArrayList<CD> result = new ArrayList<>();
        for(CD cd : cdRepository.findAll()){
            if(cd.getName().toLowerCase().contains(filter.toLowerCase())
                || cd.getArtist().toLowerCase().contains(filter.toLowerCase())){
                result.add(cd);
            }
        }
        return result;
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
