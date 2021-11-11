package dao;

import metier.Abonnement;

import java.util.ArrayList;

public interface DAO<T> {
	T getById(int id) throws Exception;
	boolean create(T objet) throws Exception;
	boolean update(T objet) throws Exception;
	boolean delete(T objet) throws Exception;
	ArrayList<T> findAll();
}
