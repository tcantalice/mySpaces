package br.ucsal.core.interfaces;

import br.ucsal.core.models.Computer;

public interface ILaboratory {
    public void add(Computer pc);
    public void remove(String pcCode);
    public Computer[] avaiableComputers();
}