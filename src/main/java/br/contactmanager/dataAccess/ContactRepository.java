package br.contactmanager.dataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.contactmanager.model.Contact;

public class ContactRepository extends DatabaseConnection {

    public ContactRepository() throws SQLException {
        super();
    }

    public List<Contact> selectAll() throws SQLException {
        List<Contact> result = new ArrayList<Contact>();
        String sql = "SELECT * FROM contact ORDER BY name";
        
        Statement stmt = this.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Contact contact = new Contact(rs.getString("name"),
                                          rs.getString("email"),
                                          rs.getString("phone"),
                                          rs.getInt("id"));
            result.add(contact);
        }
        return result;
    }

    public Contact getById(int id) throws SQLException {
        Contact result = null;
        String sql = "SELECT * FROM contact WHERE id = ?";
        
        PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Contact contact = new Contact(rs.getString("name"),
                                          rs.getString("email"),
                                          rs.getString("phone"),
                                          rs.getInt("id"));
            result = contact;
        }
        return result;
    }

    public void insert(Contact contact) throws SQLException {
        String sql = "INSERT INTO contact(name,email,phone) VALUES(?,?,?)";
 
        PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
        pstmt.setString(1, contact.getName());
        pstmt.setString(2, contact.getEmail());
        pstmt.setString(3, contact.getPhone());
        pstmt.executeUpdate();

    }

    public void update(Contact contact) throws SQLException {
        String sql = "UPDATE contact set name=?, email=?, phone=? WHERE id=?";
 
        PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
        pstmt.setString(1, contact.getName());
        pstmt.setString(2, contact.getEmail());
        pstmt.setString(3, contact.getPhone());
        pstmt.setInt(4, contact.getId());
        pstmt.executeUpdate();

    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM contact WHERE id=?";
 
        PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

    }

}