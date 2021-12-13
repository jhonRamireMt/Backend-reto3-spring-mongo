package com.proyecto.reto2.controller;

import com.proyecto.reto2.model.Cookware;
import com.proyecto.reto2.service.CookwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cookware")
public class CookwareController {

    @Autowired
    private CookwareService cookwareService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cookware> getAllCookware(){
        return cookwareService.getAllProducts();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware saveCookware( @RequestBody Cookware cookware){
        return cookwareService.saveProduct(cookware);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware updateCookware(@RequestBody Cookware cookware){
        return cookwareService.updateProduct(cookware);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCokkware(@PathVariable String reference){
        cookwareService.deleteProduct(reference);
    }

    @GetMapping("/{reference}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cookware> getByRef(@PathVariable String reference){
        return cookwareService.findByReference(reference);
    }
}
