package com.example.coronavirusexamprojectbackend.restcontrollers;

import com.example.coronavirusexamprojectbackend.models.Parish;
import com.example.coronavirusexamprojectbackend.services.ParishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")
@AllArgsConstructor
public class ParishRESTController {

    private final ParishService parishService;

    @PostMapping(value = "/create-parish", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Parish postInsertParish(@RequestBody Parish parish) {
        return parishService.insertUpdateParish(parish);
    }

    @PutMapping(value = "/update-parish/{parishId}")
    @ResponseStatus(HttpStatus.OK)
    public Parish putUpdateParish(@RequestBody Parish parish) {
        return parishService.insertUpdateParish(parish);
    }

    @DeleteMapping(value = "/delete-parish/{parishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParish(@PathVariable Long parishId) {
        parishService.deleteParish(parishId);
    }

    @GetMapping(value = "/get-all-parishes")
    @ResponseStatus(HttpStatus.OK)
    public List<Parish> getAllParishes() {
        return parishService.getAllParishes();
    }

}
