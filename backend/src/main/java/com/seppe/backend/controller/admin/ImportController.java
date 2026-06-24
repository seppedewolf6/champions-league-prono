package com.seppe.backend.controller.admin;

import com.seppe.backend.dto.imports.ImportResponse;
import com.seppe.backend.service.ImportService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin/import")
public class ImportController {


    private final ImportService importService;


    public ImportController(
           ImportService importService
    ){
        this.importService = importService;
    }


    @PostMapping(
            value="/clubs",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ImportResponse importClubs(
            @RequestParam("file") MultipartFile file
    ){

        return importService.importClubs(file);
    }



    @PostMapping(
            value="/players",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ImportResponse importPlayers(
            @RequestParam("file") MultipartFile file
    ){

        return importService.importPlayers(file);
    }

}