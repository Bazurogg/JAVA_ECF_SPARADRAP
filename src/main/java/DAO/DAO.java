package DAO;

import fr.pompey.dev.afpa.controller.BDDConnectionManager;
import fr.pompey.dev.afpa.exceptions.EmailAlreadyExistException;
import fr.pompey.dev.afpa.exceptions.EmptyFieldException;
import fr.pompey.dev.afpa.exceptions.InvalidEmailFormatException;
import fr.pompey.dev.afpa.exceptions.InvalidPhoneNumberException;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * The type Dao.
 *
 * @param <T> the type parameter
 */
public abstract class DAO<T> {

    /**
     * The Connection.
     */
    protected Connection connection = BDDConnectionManager.getInstanceDB();

    /**
     * Creation method of an object T
     *
     * @param obj the type parameter
     * @return validation of the creation
     */
    public abstract int create(T obj) throws EmailAlreadyExistException, InvalidPhoneNumberException, EmptyFieldException, InvalidEmailFormatException;


    /**
     * Delete boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Update boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public abstract boolean update(T obj) throws EmailAlreadyExistException, InvalidPhoneNumberException, EmptyFieldException, InvalidEmailFormatException;

    /**
     * Find t.
     *
     * @param id the id
     * @return the t
     */
    public abstract T find(int id);

    /**
     * Find all array list.
     *
     * @return the array list
     */
    public abstract ArrayList<T> findAll();

}

