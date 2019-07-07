package br.contactmanager.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection  {
    private Connection _connection;

    public Connection getConnection() {
        return this._connection;
    }

    public DatabaseConnection() throws SQLException {
        super();
        this._connection = connect();
        this.initDb();
    }

    private void initDb() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS contact (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	phone text NOT NULL\n"
                + ");";
        
        Statement stmt = this._connection.createStatement();
        stmt.execute(sql);
    }

    private static Connection connect() throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:contacts.db";
        conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
        return conn;    
    }

    public void destroy() {
        try {
            if(this._connection!=null && !this._connection.isClosed())
            this._connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}