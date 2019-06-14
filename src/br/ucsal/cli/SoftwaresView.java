package br.ucsal.cli;

import br.ucsal.cli.commons.Notify;
import br.ucsal.cli.exceptions.InvalidOptionException;
import br.ucsal.core.models.Computer;

public class SoftwaresView extends View {

    private Computer current;

    public SoftwaresView(Computer computer){
        super(String.format("%s (IP: %s)", computer.getCode(), computer.getIp()));
        this.current = computer;
    }

    public void show(){
        do{
            super.show();
            viewMenu(ReturnOperations.BACK, 
            "Instalar software", "Softwares instalados",
            "Desinstalar software","Informações do computador");
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