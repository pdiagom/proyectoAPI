package com.eviden.pablo.api.clubNautico.Club.Nautico.service;

import com.eviden.pablo.api.clubNautico.Club.Nautico.entity.Barco;
import com.eviden.pablo.api.clubNautico.Club.Nautico.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BarcoServiceImpl implements BarcoService{
    @Autowired
    BarcoRepository barcoRepository;

    @Override
    public List<Barco> findAllBarcos(){

        return barcoRepository.findAll();
    }
}
