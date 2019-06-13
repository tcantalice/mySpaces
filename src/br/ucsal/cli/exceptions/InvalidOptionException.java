package br.ucsal.cli.exceptions;

public class InvalidOptionException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidOptionException(int option){
        super(String.format("Opção '%d' inválida!", option));
    }
}