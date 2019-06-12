package br.ucsal.core.interfaces;

import br.ucsal.core.models.Software;

public interface IComputer {
    public String installedSoftwares();
    public void install(Software sw);
    public void uninstall(String swName);
}