package com.spipva.spipva.services.impl;

import com.spipva.spipva.dtos.IPVAPaymentDTO;
import com.spipva.spipva.exceptions.CarEndPlateException;
import com.spipva.spipva.services.IPVAService;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Implementação do serviço de pagamento do IPVA.
 * Esta implementação utiliza a interface IPVAService para calcular a data de pagamento do IPVA.
 * A data de pagamento é calculada com base no final da placa do veículo.
 *  - Final da placa 1: 30 de abril
 *  - Final da placa 2: 31 de maio
 *  - Final da placa 3: 30 de junho
 *  - Final da placa 4: 31 de julho
 *  - Final da placa 5: 31 de agosto
 *  - Final da placa 6: 30 de setembro
 *  - Final da placa 7: 31 de outubro
 *  - Final da placa 8: 30 de novembro
 *  - Final da placa 9 ou 0: 31 de dezembro
 *  - Final da placa inválido: exceção CarEndPlateException
 *  */
public class IPVAServiceImpl implements IPVAService {

    @Override
    public IPVAPaymentDTO payIPVA(String carPlateEnd) {
        return new IPVAPaymentDTO(carPlateEnd, getIPVAPaymentDate(carPlateEnd));
    }

    private LocalDate getIPVAPaymentDate(String carPlateEnd) {
        return switch (carPlateEnd) {
            case "1" -> LocalDate.of(LocalDateTime.now().getYear(), 4, 30);
            case "2" -> LocalDate.of(LocalDateTime.now().getYear(), 5, 31);
            case "3" -> LocalDate.of(LocalDateTime.now().getYear(), 6, 30);
            case "4" -> LocalDate.of(LocalDateTime.now().getYear(), 7, 31);
            case "5" -> LocalDate.of(LocalDateTime.now().getYear(), 8, 31);
            case "6" -> LocalDate.of(LocalDateTime.now().getYear(), 9, 30);
            case "7" -> LocalDate.of(LocalDateTime.now().getYear(), 10, 31);
            case "8" -> LocalDate.of(LocalDateTime.now().getYear(), 11, 30);
            case "9", "0" -> LocalDate.of(LocalDateTime.now().getYear(), 12, 31);
            default -> throw new CarEndPlateException("Invalid car plate end.");
        };
    }
}
