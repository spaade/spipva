package com.spipva.spipva.services;

import com.spipva.spipva.dtos.IPVAPaymentDTO;

/**
 * Interface IPVAService
 *
 * Esta interface fornece métodos para gerenciar o pagamento do IPVA.
 *
 * Métodos:
 * - payIPVA: Calcula a data de pagamento do IPVA com base no final da placa do veículo.
 */
public interface IPVAService {

    IPVAPaymentDTO payIPVA(String carPlateEnd);
}
