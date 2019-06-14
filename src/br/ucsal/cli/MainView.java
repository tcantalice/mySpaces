package br.ucsal.cli;

import br.ucsal.cli.commons.Notify;
import br.ucsal.cli.exceptions.InvalidOptionException;

public class MainView extends View {



    public MainView() {
        super("Menu Principal");
    }

    @Override
    public void show() {
        do{
            super.show();
            viewMenu("Laboratórios", "Gerenciador de Softwares");
            try{
                controllerMenu(inputOption());
            }catch(InvalidOptionException e){
                Notify.getInstance().errorMessage(e);
            }
        }while(this.inExec);
    }

    @Override
    protected void controllerMenu(int option) throws InvalidOptionException {
        switch(option){
            case 0:
                this.inExec = false;
                break;
            case 1:
                LaboratoriesView.getInstance().show();
                break;
            case 2:
                break;
            default:
                throw new InvalidOptionException(option);
        }
    }
}