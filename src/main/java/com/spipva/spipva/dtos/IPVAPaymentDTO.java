package com.spipva.spipva.dtos;

import java.time.LocalDate;

/**
 * DTO IPVAPaymentDTO
 *
 * Este DTO representa o pagamento do IPVA.
 *
 * Atributos:
 * - carPlateEnd: Final da placa do veículo
 * - paymentDate: Data de pagamento
 */
public class IPVAPaymentDTO {

    private String carPlateEnd;
    private LocalDate paymentDate;

    public IPVAPaymentDTO() {
    }

    public IPVAPaymentDTO(String carPlateEnd, LocalDate paymentDate) {
        this.carPlateEnd = carPlateEnd;
        this.paymentDate = paymentDate;
    }

    public String getCarPlateEnd() {
        return carPlateEnd;
    }

    public void setCarPlateEnd(String carPlateEnd) {
        this.carPlateEnd = carPlateEnd;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
