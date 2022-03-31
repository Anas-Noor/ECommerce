package com.ecommerce.EcommerceBackend.Controller;

import com.ecommerce.EcommerceBackend.Dto.VarientDto;
import com.ecommerce.EcommerceBackend.Model.Varient;
import com.ecommerce.EcommerceBackend.Service.VarientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/varient")
public class VarientController {

    @Autowired
    private VarientService varientService;

    @PostMapping()
    public void addVarient(@RequestBody VarientDto varientDto) {
        varientService.addVarient(varientDto);
    }
        @DeleteMapping("/{id}")
    public void deleteVarientById(@PathVariable Long id){
        varientService.deleteVarientById(id);
    }
    @PutMapping("/{id}")
    public void updateVarient(@PathVariable Long id,@RequestBody VarientDto varientdto) {
        varientService.updateVarient(id,varientdto);
    }
    @GetMapping("")
    public List<Varient> getAllVarient() {
        return varientService.getAllVarient();
    }
    @GetMapping("/{id}")
    public Varient findVarientByIdById(@PathVariable Long id){
        return varientService.findVarientById(id);
    }
}
