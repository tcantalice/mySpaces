package br.ucsal.core.interfaces;

import br.ucsal.core.exceptions.AlreadyExistsException;
import br.ucsal.core.exceptions.NotFoundException;
import br.ucsal.core.models.Software;

public interface IComputer {
    public Software[] installedSoftwares();
    public void install(Software sw) throws AlreadyExistsException;
    public void uninstall(String swName) throws NotFoundException;
}