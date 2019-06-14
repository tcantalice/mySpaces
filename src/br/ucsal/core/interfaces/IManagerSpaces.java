package br.ucsal.core.interfaces;

import br.ucsal.core.exceptions.*;

public interface IManagerSpaces<E> {
    public void add(E space) throws AlreadyExistsException;
    public E enterSpace(Object k) throws NotFoundException;
    public void remove(Object k) throws NotFoundException;
    public E[] avaiableSpaces();
}