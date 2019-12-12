/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import Backend.*;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class Supplier {

    private int idsupplier;
    private String nama, alamat, telp;
    

    public Supplier() {
    }

    public Supplier(String nama, String alamat, String telp) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
    }

    public int getIdsupplier() {
        return idsupplier;
    }

    public void setIdsupplier(int idsupplier) {
        this.idsupplier = idsupplier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }



    public Supplier getById(int id) {
        Supplier supplier = new Supplier();
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM supplier WHERE idsupplier = '" + id + "'");
        try {
            while (resultSet.next()) {
                supplier = new Supplier();
                supplier.setIdsupplier(resultSet.getInt("idsupplier"));
                supplier.setNama(resultSet.getString("nama"));
                supplier.setAlamat(resultSet.getString("alamat"));
                supplier.setTelp(resultSet.getString("telp"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplier;
    }

    public ArrayList<Supplier> getAll() {
        ArrayList<Supplier> ListSuppliers = new ArrayList();
        ResultSet resultSet;
        resultSet = DBHelper.selectQuery("SELECT * FROM supplier");

        try {
            while (resultSet.next()) {
                Supplier supplier = new Supplier();
                supplier.setIdsupplier(resultSet.getInt("idsupplier"));
                supplier.setNama(resultSet.getString("nama"));
                supplier.setAlamat(resultSet.getString("alamat"));
                supplier.setTelp(resultSet.getString("telp"));

                ListSuppliers.add(supplier);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListSuppliers;
    }

    public ArrayList<Supplier> search(String keyboard) {
        ArrayList<Supplier> ListSuppliers = new ArrayList();
        String sql = "SELECT * FROM supplier WHERE "
                + " nama LIKE '%" + keyboard + "%'"
                + "OR telp LIKE '%" + keyboard + "%'"
                + "OR alamat LIKE '%" + keyboard + "%'";

        ResultSet resultSet = DBHelper.selectQuery(sql);

        try {
            while (resultSet.next()) {
                Supplier supplier = new Supplier();
                supplier.setIdsupplier(resultSet.getInt("idsupplier"));
                supplier.setNama(resultSet.getString("nama"));
                supplier.setAlamat(resultSet.getString("alamat"));
                supplier.setTelp(resultSet.getString("telp"));

                ListSuppliers.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListSuppliers;
    }

    public void save() {
        if (getById(idsupplier).getIdsupplier()== 0) {
            String SQL = "INSERT INTO supplier (nama, alamat, telp) VALUES("
                    + " '" + this.nama + "', "
                    + " '" + this.alamat + "', "
                    + " '" + this.telp + "' "
                    + " )";
            this.idsupplier = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE supplier SET"
                    + " nama = '" + this.nama + "',"
                    + " alamat = '" + this.alamat + "',"
                    + " telp = '" + this.telp + "'"
                    + " WHERE idsupplier = '" + this.idsupplier + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM supplier WHERE idsupplier = '" + this.idsupplier + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String toString(){
        return nama;
    }
}
