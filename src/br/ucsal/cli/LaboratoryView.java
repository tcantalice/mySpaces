package br.ucsal.cli;

import br.ucsal.core.exceptions.*;
import br.ucsal.core.models.Laboratory;
import br.ucsal.core.models.Computer;
import br.ucsal.cli.exceptions.InvalidOptionException;
import br.ucsal.cli.commons.Notify;

public class LaboratoryView extends View {

    private Laboratory current;

    public LaboratoryView(Laboratory laboratory){
        super(String.format("%s (%s)", laboratory.getInitial(), laboratory.getName()));
        this.current = laboratory;
    }

    public void show(){
        do{
            super.show();
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
                create(current);
                break;
            case 2:
                open(current);
                break;
            case 3:
                list(current);
                break;
            case 4:
                remove(current);
                break;
            case 0:
                inExec = false;
                break;
            default:
                throw new InvalidOptionException(option);
        }
    }

    private void create(Laboratory data){
        boolean again = false;
        String code, ip;
        do{
            code = inputData("Código");
            ip = inputData("IP");
            try{
                data.add(new Computer(code, ip));
                Notify.getInstance().successMessage("Computador adicionado com sucesso!");
            }catch(AlreadyExistsException e){
                Notify.getInstance().errorMessage(e);
            }
        }while(again);
    }

    private void list(Laboratory data){
        System.out.println();
        for(Computer computer : data.avaiableComputers()){
            System.out.println(computer);
        }
        System.out.println();
    }

    private void remove(Laboratory data){
        boolean again = false;
        String code;
        do {
            code = inputData("Código");
            try {
                Computer buff = data.getComputer(code);
                Notify.getInstance().warningMessage(String.format("Deseja remover %s (1-Sim/2-Não)", buff.toString()));
                switch (inputOption()) {
                case 1:
                    data.remove(code);
                    Notify.getInstance().successMessage("Computador removido com sucesso!");
                    break;
                case 2:
                    Notify.getInstance().plainMessage("Operação cancelada!");
                    break;
                default:
                    Notify.getInstance().errorMessage("Opção inválida!");
                    break;
                }
            } catch (NotFoundException e) {
                Notify.getInstance().errorMessage(e);
            }
        } while (again);
    }

    private void open(Laboratory data){
        View cView;
        String code = inputData("Código do computador");
        try {
            cView = new ComputerView(data.getComputer(code));
            cView.show();
        } catch (NotFoundException e) {
            Notify.getInstance().errorMessage(e);
        }
    }
    
}