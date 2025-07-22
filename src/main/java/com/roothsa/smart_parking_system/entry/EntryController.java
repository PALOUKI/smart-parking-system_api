package com.roothsa.smart_parking_system.entry;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/parking")
public class EntryController {

    private EntryService entryService;
    private ExitService exitService;

    public EntryController(EntryService entryService, ExitService exitService) {
        this.entryService = entryService;
        this.exitService = exitService;
    }


    @PostMapping(path = "/entry")
    public ResponseEntity<String> vehiculeEntry(@RequestParam String vehiculeNumber){
        entryService.vehiculeEntry(vehiculeNumber);
        return ResponseEntity.ok("Vehicule entered : " + vehiculeNumber);
    }


    @PostMapping(path = "/exit")
    public ResponseEntity<String> VehiculeExit(@RequestParam String vehiculeNumber){
        exitService.vehiculeExit(vehiculeNumber);
        return ResponseEntity.ok("Vehicule exited : " + vehiculeNumber);
    }


}
