package com.example.tracker.controller;

import com.example.tracker.domain.DepStatus;
import com.example.tracker.domain.DepType;
import com.example.tracker.domain.Departure;
import com.example.tracker.dto.CreateDepartureDto;
import com.example.tracker.service.DepartureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "DepartureController", description = "Основной контроллер для работы с отправлениями")
@RestController
@RequestMapping("/api/v1/departure/")
public class DepartureController {

    DepartureService departureService;

    public DepartureController(DepartureService departureService) {
        this.departureService = departureService;
    }

    //Регистрация отправления
    @Operation(summary = "Зарегистрировать почтовое отправление", description = "Для регистрации отправления ввести данные. " +
            "Предварительно нужно создать отделение почты с индексом отправителя и получателя" +
            "виды отправления " +
            "LETTER(\"письмо\"),\n" +
            "PARCEL(\"посылка\"),\n" +
            "SMALLPARCEL(\"бандероль\"),\n" +
            "POSTCARD(\"открытка\");")
    @PostMapping("/create")
    public ResponseEntity<Departure> create(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "информация для регистрации отправления" +
            "тип отправления, информация о получателе, индекс почтового отделения оправителя (куда регистрируется отправление)") CreateDepartureDto createDto) {
        Departure departure = departureService.create(DepType.valueOf(createDto.getType().toUpperCase()),
                createDto.getRecipientIndex(),
                createDto.getRecipientAddress(),
                createDto.getRecipientName(),
                createDto.getPostOfficeIndex());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(departure);
    }

    //Проверка текущего статуса отправления
    @Operation(summary = "Статус отпрвления", description = "Получить текущий статус отправления." +
            "Время посткпления в почтовое отделение, информация о почтовом отделении, статус доставлено true, в проежуточном - false")
    @GetMapping( "/getstatus/{id}")
    public ResponseEntity<DepStatus> getCurrentStatus(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departureService.getCurrentStatus(id));
    }

    @Operation(summary = "Переместить отправление из одного отделения в другое", description = "Переводит оправление из текущего почтового отделения" +
            "в другое. В качестве идентификатора отделения выступает его почтовый индекс. Идентификатор отправления - Id")
    @PostMapping("/move/{id}")
    public  ResponseEntity<Departure> moveTo(@PathVariable Long id, @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "" +
            "индекс почтового отделения, куда переводится отправление") String postOfficeIndex) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departureService.moveTo(id,postOfficeIndex));
    }

    //Получение всех статусов данного отпраавления
    @Operation(summary = "История всех статусов", description = "Возвращает историю всех статусов посылки включая информацию о промежуточных почтовых отделениях")
    @GetMapping("/getstatushistory/{id}")
    public ResponseEntity<List<DepStatus>> getStatusHistory(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departureService.getStatusHistory(id));
    }
}
