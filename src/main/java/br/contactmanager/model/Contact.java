package br.contactmanager.model;

public class Contact {
    private int _id;
    private String _name;
    private String _email;
    private String _phone;
    public Contact(String name, String email, String phone, int id) {
        this._id = id;
        this._name = name;
        this._email = email;
        this._phone = phone;
    }
    public Contact(String name, String email, String phone) {
        this(name, email, phone, 0);
    }
    public int getId() {
        return this._id;
    }
    public String getName() {
        return this._name;
    }
    public String getEmail() {
        return this._email;
    }
    public String getPhone() {
        return this._phone;
    }

}