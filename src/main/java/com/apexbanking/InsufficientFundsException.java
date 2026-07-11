package com.apexbanking;

/**
 * Exceção disparada quando uma operação de saque falha por falta de fundos
 * (saldo real e limite de cheque especial insuficientes).
 */
public class InsufficientFundsException extends Exception{
    /**
     * Construtor que recebe a mensagem de erro detalhada.
     * Passamos essa mensagem para a classe mãe Exception usando o super().
     */

    public InsufficientFundsException(String message){
        super(message);
    }

}
