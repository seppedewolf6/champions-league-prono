package com.seppe.backend.service;


import com.seppe.backend.domain.Club;
import com.seppe.backend.domain.player.Player;
import com.seppe.backend.domain.player.PlayerPosition;
import com.seppe.backend.dto.imports.ImportResponse;
import com.seppe.backend.repository.ClubRepository;
import com.seppe.backend.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class ImportService {


    private final ClubRepository clubRepository;
    private final PlayerRepository playerRepository;


    public ImportService(
            ClubRepository clubRepository,
            PlayerRepository playerRepository
    ) {
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
    }


    public ImportResponse importClubs(
            MultipartFile file
    ) {


        try {


            clubRepository.deleteAll();


            Workbook workbook =
                    WorkbookFactory.create(
                            file.getInputStream()
                    );


            Sheet sheet =
                    workbook.getSheetAt(0);


            int count = 0;


            for (Row row : sheet) {


                if (row.getRowNum() == 0)
                    continue;


                Club club = new Club();


                club.setName(
                        row.getCell(0)
                                .getStringCellValue()
                );


                club.setPot(
                        (int)
                                row.getCell(1)
                                        .getNumericCellValue()
                );


                club.setCoefficient(
                        row.getCell(2)
                                .getNumericCellValue()
                );


                clubRepository.save(club);


                count++;

            }


            workbook.close();


            return new ImportResponse(
                    "Clubs succesvol geïmporteerd",
                    count
            );


        } catch (Exception e) {

            throw new RuntimeException(
                    "Club import mislukt: "
                            + e.getMessage()
            );
        }

    }


    public ImportResponse importPlayers(
            MultipartFile file
    ) {

        try {


            playerRepository.deleteAll();


            Map<String, Club> clubs =
                    new HashMap<>();


            clubRepository.findAll()
                    .forEach(c ->
                            clubs.put(
                                    c.getName(),
                                    c
                            )
                    );


            Workbook workbook =
                    WorkbookFactory.create(
                            file.getInputStream()
                    );


            Sheet sheet =
                    workbook.getSheetAt(0);


            int count = 0;


            for (Row row : sheet) {


                if (row.getRowNum() == 0)
                    continue;


                String clubName =
                        row.getCell(0)
                                .getStringCellValue();


                Club club =
                        clubs.get(clubName);


                if (club == null) {

                    throw new RuntimeException(
                            "Club bestaat niet: "
                                    + clubName
                    );
                }


                Player player =
                        new Player();


                player.setClub(club);


                player.setName(
                        row.getCell(2)
                                .getStringCellValue()
                );


                player.setPlayerPosition(
                        PlayerPosition.valueOf(
                                row.getCell(3)
                                        .getStringCellValue()
                                        .toUpperCase()
                        )
                );


                playerRepository.save(player);


                count++;

            }

            workbook.close();

            return new ImportResponse(
                    "Spelers succesvol geïmporteerd",
                    count
            );


        } catch (Exception e) {

            throw new RuntimeException(
                    "Player import mislukt: "
                            + e.getMessage()
            );
        }

    }

}