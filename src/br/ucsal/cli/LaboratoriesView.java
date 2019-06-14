package br.ucsal.cli;

import java.util.Map;

import br.ucsal.core.models.ManagerLabs;
import br.ucsal.core.exceptions.AlreadyExistsException;
import br.ucsal.core.models.Laboratory;
import br.ucsal.cli.commons.Notify;
import br.ucsal.cli.exceptions.InvalidOptionException;

public class LaboratoriesView extends View {


    private static LaboratoriesView instance;

    private LaboratoriesView(){
        super("Laboratórios");
    }

    public static LaboratoriesView getInstance(){
        if(instance == null){
            instance = new LaboratoriesView();
        }
        return instance;
    }
    
    public void show(){
        do{
            super.show();
            viewMenu(ReturnOperations.BACK, "Novo", "Abrir", "Listar", "Remover");
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
                create(ManagerLabs.getInstance());
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

    private void create(ManagerLabs data){
        boolean again = false;
        String code = null;
        String name = null;
        do{
            code = this.inputData("Código");
            name = this.inputData("Nome");
            try{
                data.add(code, name);
                System.out.println("Laboratório adicionado com sucesso!");
                again = false;
            }catch(AlreadyExistsException e){
                Notify.getInstance().errorMessage(e);
            }
        }while(again);

    }
}