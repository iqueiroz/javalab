package br.contactmanager.application;

import java.util.List;

import br.contactmanager.dataAccess.ContactRepository;
import br.contactmanager.model.Contact;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContactApplication implements AutoCloseable {
    private ContactRepository _repository;

    public ContactApplication() throws SQLException {
        super();
        this._repository = new ContactRepository();
    }
    public List<Contact> getContacts() throws SQLException {
        return this._repository.selectAll();
    }

    public void deleteById(int id) throws SQLException {
        this._repository.delete(id);
    }

    public Contact getById(int id) throws SQLException {
        return this._repository.getById(id);
    }

    public void updateById(int id, String name, String email, String phone) throws SQLException {
        Contact contact = new Contact(name, email, phone, id);
        this._repository.update(contact);
    }

    public void add(String name, String email, String phone) throws SQLException {
        Contact contact = new Contact(name, email, phone);
        this._repository.insert(contact);
    }

    @Override
    public void close() throws Exception {
        this._repository.destroy();
    }

}