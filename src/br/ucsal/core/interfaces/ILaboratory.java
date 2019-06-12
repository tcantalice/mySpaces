package br.ucsal.core.interfaces;

import br.ucsal.core.exceptions.AlreadyExistsException;
import br.ucsal.core.exceptions.NotFoundException;
import br.ucsal.core.models.Computer;

public interface ILaboratory {
    public Computer[] avaiableComputers();
    public void add(Computer pc) throws AlreadyExistsException;
    public void remove(String pcCode) throws NotFoundException;
    public Computer getComputer(String pcCode) throws NotFoundException;
}