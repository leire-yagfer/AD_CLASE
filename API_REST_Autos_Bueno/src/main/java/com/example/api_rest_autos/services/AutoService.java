package com.example.api_rest_autos.services;

import org.springframework.stereotype.Service;
import com.example.api_rest_autos.dtos.AutoDTO;
import com.example.api_rest_autos.models.Auto;
import com.example.api_rest_autos.repositories.AutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoService{
    private final AutoRepository autoRepository;
    public AutoService(AutoRepository autoRepository){

        this.autoRepository = autoRepository;
    }
    public void saveAuto(AutoDTO autoDTO){
        Auto auto = new Auto(autoDTO.id(), autoDTO.marca(), autoDTO.color());
        autoRepository.save(auto);
    }
    public void saveAutos(List<AutoDTO> autosDTO){
        List<Auto> autos = new ArrayList<>();
        autosDTO.forEach(autoDTO ->
                autos.add(new Auto(autoDTO.id(), autoDTO.marca(), autoDTO.color())));
        autoRepository.saveAll(autos);
    }
    public List<AutoDTO> findAll(){
        List<AutoDTO> autosDto = new ArrayList<>();
        autoRepository.findAll().forEach(auto ->
                autosDto.add(new AutoDTO(auto.getId(), auto.getMarca(), auto.getColor())));
        return autosDto;
    }
    public Optional<AutoDTO> findById(Integer id) {
        Optional<Auto> autoOptional = autoRepository.findById(id);
        return autoOptional.map(auto -> new AutoDTO(auto.getId(), auto.getMarca(), auto.getColor()));
    }
    public void editAuto(AutoDTO autoDTO) {
        Auto auto = new Auto(autoDTO.id(), autoDTO.marca(), autoDTO.color());
        autoRepository.save(auto);
    }
    public void deleteAuto(Integer id) {
        autoRepository.deleteById(id);
    }
    public List<AutoDTO> findByColor(String color) {
        List<AutoDTO> autosDTO = new ArrayList<>();
        autoRepository.findByColor(color).forEach(auto ->
                autosDTO.add(new AutoDTO(auto.getId(), auto.getMarca(), auto.getColor())));
        return autosDTO;
    }
    public List<AutoDTO> findByMarca(String marca){
        List<AutoDTO> autosDTO = new ArrayList<>();
        autoRepository.findByMarca(marca).forEach(auto ->
                autosDTO.add(new AutoDTO(auto.getId(), auto.getMarca(), auto.getColor())));
        return autosDTO;
    }
}
