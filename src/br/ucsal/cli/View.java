package br.ucsal.cli;

import java.util.Scanner;

import br.ucsal.cli.exceptions.InvalidOptionException;

public abstract class View {
    
    protected static final String DEFAULT_MARKER = ">>";

    protected static enum ReturnOperations {
        BACK("Voltar"), EXIT("Sair");

        public String tag;

        ReturnOperations(String tag){
            this.tag = tag;
        }
    }
    
    protected String title;
    protected boolean inExec;

    private static Scanner keyboard = new Scanner(System.in);
    
    public View(String title){
        this.title = title;
    }

    /**
     * Exibe o título da tela
     */
    public void show(){
        this.inExec = true;
        System.out.println(String.format("# %s #", this.title));
    }

    /**
     * <p>Exibe o menu de opções enumeradas.</p>
     * <p>Passa por padrão a operação {@code ReturnOperations.EXIT}</p>
     * 
     * @param options Opções do menu.
     */
    public void viewMenu(String... options){
        this.viewMenu(ReturnOperations.EXIT, options);
    }

    /**
     * <p>Exibe o menu de opções enumeradas.
     * 
     * @param operation Operação padrão de retorno. Recebe um {@code ReturnOperations}.
     * @param options Opções do menu.
     */
    public void viewMenu(ReturnOperations operation, String...options){
        for(int i = 0; i < options.length; i++){
            System.out.println(String.format("%2d - %s", i+1, options[i]));
        }
        System.out.println("\n 0 - " + operation.tag);
    }

    protected abstract void controllerMenu(int option) throws InvalidOptionException;

    public int inputOption(){
        int response = Integer.parseInt(inputData(null));
        return response;
    }

    public String inputData(String msg){
        inputMarkMessage(DEFAULT_MARKER, msg);
        String data = keyboard.nextLine();
        return data;
    }

    protected void inputMarkMessage(String marker, String msg){
        if(msg == null || msg.isEmpty())
            System.out.print(String.format("%s ", marker));
        else
            System.out.print(String.format("%s %s ", msg, marker));
    }
}