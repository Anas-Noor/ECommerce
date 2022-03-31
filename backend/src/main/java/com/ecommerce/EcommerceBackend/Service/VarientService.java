package com.ecommerce.EcommerceBackend.Service;

import com.ecommerce.EcommerceBackend.Dto.VarientDto;
import com.ecommerce.EcommerceBackend.Model.Varient;
import com.ecommerce.EcommerceBackend.Repository.VarientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VarientService {

    @Autowired
    private VarientRepository varientRepository;

    public void addVarient(VarientDto varientDto) {
        Varient varient = new Varient();
        varient.setId(varientDto.getId());
        varient.setVarientName(varientDto.getVarientName());
        varientRepository.save(varient);
    }

    public void deleteVarientById(Long id) {
        varientRepository.delete(varientRepository.findAll().stream().filter(c -> Long.valueOf(c.getId()) == id).findAny().get());
    }

    public void updateVarient(Long id, VarientDto varient) {
        Varient varient1 = this.findVarientById(id);
        varient1.setVarientName(varient.getVarientName());
        varientRepository.save(varient1);
    }

    public List<Varient> getAllVarient() {
         return varientRepository.findAll();
    }

//    public VarientfindVarientById(Long id) {
//        return varientRepository.findById(id).orElseThrow(null);
//    }

    public Varient findVarientById(Long id) {
        return varientRepository.findById(id).orElseThrow(null);
    }
}
