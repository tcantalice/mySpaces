package br.ucsal.cli;

import br.ucsal.core.models.Laboratory;
import br.ucsal.cli.exceptions.InvalidOptionException;
import br.ucsal.cli.commons.Notify;

public class ComputersView extends View {

    public ComputersView(Laboratory laboratory){
        super(String.format("Laboratório %s (%s)", laboratory.getInitial(), laboratory.getName()));
    }

    public void show(){
        super.show();
        do{
            viewMenu(ReturnOperations.BACK, 
            "Novo computador", "Abrir computador", 
            "Computadores", "Remover Computador");
            try{
                controllerMenu(inputOption());
            }catch(InvalidOptionException e){
                Notify.getInstance().errorMessage(e);
            }
        }while(inExec);
    }

    @Override
    protected void controllerMenu(int option) throws InvalidOptionException {
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