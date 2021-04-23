package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.HostRepository;
import com.talentpath.airTNB.exceptions.InvalidIdException;
import com.talentpath.airTNB.models.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostService {
    @Autowired
    HostRepository hostRepository;

    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    public Host getHostById(Integer id) throws InvalidIdException {
        Optional<Host> ans = hostRepository.findById(id);
        if(ans.isPresent()) return ans.get();
        else throw new InvalidIdException("No Host with id: " + id);
    }

    public Host addHost(Host toAdd) {
        return hostRepository.saveAndFlush(toAdd);
    }
}
