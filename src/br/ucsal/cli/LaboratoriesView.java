package br.ucsal.cli;

import java.util.Map;

import br.ucsal.core.models.ManagerLabs;
import br.ucsal.core.exceptions.*;
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
                open(ManagerLabs.getInstance());
                break;
            case 3:
                list(ManagerLabs.getInstance());
                break;
            case 4:
                remove(ManagerLabs.getInstance());
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
            code = this.inputData("Sigla");
            name = this.inputData("Nome");
            try{
                data.add(code, name);
                Notify.getInstance().successMessage("Laboratório adicionado com sucesso!");
                again = false;
            }catch(AlreadyExistsException e){
                Notify.getInstance().errorMessage(e);
            }
        }while(again);
    }

    private void list(ManagerLabs data){
        System.out.println();
        for(Laboratory lab : data.avaiableSpaces()){
            System.out.println(lab);
        }
        System.out.println();
    }

    private void open(ManagerLabs data){
        View cView;
        String code = inputData("Sigla do laboratório");
        try{
            cView = new ComputersView(data.enterSpace(code));
            cView.show();
        }catch(NotFoundException e){
            Notify.getInstance().errorMessage(e);
        }
    }

    private void remove(ManagerLabs data){
        boolean again = false;
        String code;
        do{
            code = inputData("Sigla");
            try{
                Laboratory buff = data.enterSpace(code);
                Notify.getInstance().warningMessage(
                    String.format("Deseja remover %s (1-Sim/2-Não)", buff.toString())
                );
                switch(inputOption()){
                    case 1:
                        data.remove(code);
                        Notify.getInstance().successMessage("Laboratório removido com sucesso!");
                        break;
                    case 2:
                        Notify.getInstance().plainMessage("Operação cancelada!");
                        break;
                    default:
                        Notify.getInstance().errorMessage("Opção inválida!");
                        break;
                }
            }catch(NotFoundException e){
                Notify.getInstance().errorMessage(e);
            }
        }while(again);
    }
}