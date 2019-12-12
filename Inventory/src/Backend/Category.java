/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class Category {

    private int idkategori;
    private String nama;
    private String keterangan;

    public Category() {
    }

    public Category( String nama, String keterangan) {
        this.nama = nama;
        this.keterangan = keterangan;
    }

    public int getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(int idkategori) {
        this.idkategori = idkategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Category getById(int id) {
        Category kategori = new Category();
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM kategory WHERE idkategori = '" + id + "'");
        try {
            while (resultSet.next()) {
                kategori = new Category();
                kategori.setIdkategori(resultSet.getInt("idkategori"));
                kategori.setNama(resultSet.getString("nama"));
                kategori.setKeterangan(resultSet.getString("keterangan"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kategori;
    }

    public ArrayList<Category> getAll() {
        ArrayList<Category> ListKategori = new ArrayList();
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM kategory");

        try {
            while (resultSet.next()) {
                Category kategori = new Category();
                kategori.setIdkategori(resultSet.getInt("idkategori"));
                kategori.setNama(resultSet.getString("nama"));
                kategori.setKeterangan(resultSet.getString("keterangan"));

                ListKategori.add(kategori);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }

    public ArrayList<Category> search(String keyboard) {
        ArrayList<Category> ListKategori = new ArrayList();
        String sql = "SELECT * FROM kategory WHERE "
                + " nama LIKE '%" + keyboard + "%'"
                + "OR keterangan LIKE '%" + keyboard + "%'";

        ResultSet resultSet = DBHelper.selectQuery(sql);

        try {
            while (resultSet.next()) {
                Category kategori = new Category();
                kategori.setIdkategori(resultSet.getInt("idkategori"));
                kategori.setNama(resultSet.getString("nama"));
                kategori.setKeterangan(resultSet.getString("keterangan"));

                ListKategori.add(kategori);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }

    public void save() {
        if (getById(idkategori).getIdkategori() == 0) {
            String SQL = "INSERT INTO kategory (nama, keterangan) VALUES("
                    + " '" + this.nama + "', "
                    + " '" + this.keterangan + "' "
                    + " )";
            this.idkategori = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE kategory SET"
                    + " nama = '" + this.nama + "',"
                    + " keterangan= '" + this.keterangan + "'"
                    + " WHERE idkategori = '" + this.idkategori + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM kategory WHERE idkategori = '" + this.idkategori + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String toString(){
        return nama;
    }
}
