package com.id_co_kelompok7.service;

import com.id_co_kelompok7.repository.HewanRepository;
import com.id_co_kelompok7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HewanService {

    @Autowired
    private HewanRepository hewamRepository;

    @Autowired
    private UserRepository userRepository;
}
