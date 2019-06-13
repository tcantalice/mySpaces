package br.ucsal.cli;

import br.ucsal.cli.commons.Notify;
import br.ucsal.cli.exceptions.InvalidOptionException;

public class LaboratoriesView extends View {

    public LaboratoriesView(){
        super("Laboratórios");
    }
    
    public void show(){
        do{
            super.show();
            viewMenu(ReturnOperations.BACK, "Novo", "Abrir", "Editar", "Remover");
            try{
                controllerMenu(inputOption());
            }catch(InvalidOptionException e){
                Notify.getInstance().errorMessage(e);;
            }
        }while(inExec);
    }

    protected void controllerMenu(int option) throws InvalidOptionException{
        switch(option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                inExec = false;
                break;
            default:
                throw new InvalidOptionException(option);
        }
    }
}