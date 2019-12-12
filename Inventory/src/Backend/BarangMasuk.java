/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class BarangMasuk {

    private int idOrder;
    private Barang barang = new Barang();
    private Supplier supplier = new Supplier();
    private int qty;
    private String date;

    public BarangMasuk() {
    }

    public BarangMasuk(int qty, String date) {
        this.qty = qty;
        this.date = date;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BarangMasuk getById(int id) {
        BarangMasuk barangMasuk = new BarangMasuk();
        ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_order AS id_order, "
                + "b.qty AS qty, "
                + "b.tanggal AS tanggal, "
                + "a.id_item AS id_item, "
                + "a.item_name AS item_name, "
                + "c.idsupplier AS idsupplier, "
                + "c.nama AS nama "
                + "FROM (barang a INNER JOIN orderin b ON a.id_item = b.id_item) "
                + "INNER JOIN supplier c ON c.idsupplier = b.id_supplier "
                + "WHERE b.id_order= '" + id + "'");
        try {
            while (resultSet.next()) {
                barangMasuk = new BarangMasuk();
                barangMasuk.setIdOrder(resultSet.getInt("id_order"));
                barangMasuk.getBarang().setIdBarang(resultSet.getInt("id_item"));
                barangMasuk.getBarang().setItem_name(resultSet.getString("item_name"));
                barangMasuk.getSupplier().setIdsupplier(resultSet.getInt("idsupplier"));
                barangMasuk.getSupplier().setNama(resultSet.getString("nama"));
                barangMasuk.setQty(resultSet.getInt("qty"));
                barangMasuk.setDate(resultSet.getString("tanggal"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barangMasuk;
    }

    public ArrayList<BarangMasuk> getAll() {
        ArrayList<BarangMasuk> listBarangs = new ArrayList();
        ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_order AS id_order, "
                + "b.qty AS qty, "
                + "b.tanggal AS tanggal, "
                + "a.id_item AS id_item, "
                + "a.item_name AS item_name, "
                + "c.idsupplier AS idsupplier, "
                + "c.nama AS nama "
                + "FROM (barang a INNER JOIN orderin b ON a.id_item = b.id_item) "
                + "INNER JOIN supplier c ON c.idsupplier = b.id_supplier ");
        try {
            while (resultSet.next()) {
                BarangMasuk barangMasuk = new BarangMasuk();
                barangMasuk.setIdOrder(resultSet.getInt("id_order"));
                barangMasuk.getBarang().setIdBarang(resultSet.getInt("id_item"));
                barangMasuk.getBarang().setItem_name(resultSet.getString("item_name"));
                barangMasuk.getSupplier().setIdsupplier(resultSet.getInt("idsupplier"));
                barangMasuk.getSupplier().setNama(resultSet.getString("nama"));
                barangMasuk.setQty(resultSet.getInt("qty"));
                barangMasuk.setDate(resultSet.getString("tanggal"));

                listBarangs.add(barangMasuk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBarangs;
    }

    public ArrayList<BarangMasuk> search(String keyword) {
        ArrayList<BarangMasuk> listBarangs = new ArrayList();
        ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_order AS id_order, "
                + "b.qty AS qty, "
                + "b.tanggal AS tanggal, "
                + "a.id_item AS id_item, "
                + "a.item_name AS item_name, "
                + "c.idsupplier AS idsupplier, "
                + "c.nama AS nama "
                + "FROM (barang a LEFT JOIN orderin b ON a.id_item = b.id_item) "
                + "LEFT JOIN supplier c ON c.idsupplier = b.id_supplier "
                + "WHERE b.qty LIKE '%" + keyword + "%' "
                + "OR b.tanggal LIKE '%" + keyword + "%' "
        );
        try {
            while (resultSet.next()) {
                BarangMasuk barangMasuk = new BarangMasuk();
                barangMasuk.setIdOrder(resultSet.getInt("id_order"));
                barangMasuk.getBarang().setIdBarang(resultSet.getInt("id_item"));
                barangMasuk.getBarang().setItem_name(resultSet.getString("item_name"));
                barangMasuk.getSupplier().setIdsupplier(resultSet.getInt("idsupplier"));
                barangMasuk.getSupplier().setNama(resultSet.getString("nama"));
                barangMasuk.setQty(resultSet.getInt("qty"));
                barangMasuk.setDate(resultSet.getString("tanggal"));

                listBarangs.add(barangMasuk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBarangs;
    }
    
    public ArrayList<BarangMasuk> searchBarang(String keyword) {
        ArrayList<BarangMasuk> ListBarangMasuks = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "b.id_item as id_item, "
                + "b.item_name as item_name  "
                + "FROM barang b "
                + "WHERE b.id_item LIKE '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                BarangMasuk pem = new BarangMasuk();
                pem.getBarang().setIdBarang(rs.getInt("id_item"));
                pem.getBarang().setItem_name(rs.getString("item_name"));
                ListBarangMasuks.add(pem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBarangMasuks;
    }

    public void save() {
        if (getById(idOrder).getIdOrder() == 0) {
            String SQL = "INSERT INTO orderin (id_item,id_supplier,qty,tanggal) VALUES( "
                    + " '" + this.getBarang().getIdBarang() + "', "
                    + " '" + this.getSupplier().getIdsupplier() + "', "
                    + " '" + this.qty + "', "
                    + " '" + this.date + "'"
                    + " )";
            this.idOrder = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE orderin SET"
                    + " id_item = '" + this.getBarang().getIdBarang() + "',"
                    + " id_supplier = '" + this.getSupplier().getIdsupplier() + "',"
                    + " qty = '" + this.qty + "',"
                    + " tanggal = '" + this.date + "'"
                    + " WHERE id_order = '" + this.idOrder + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM orderin WHERE id_order = '" + this.idOrder + "'";
        DBHelper.executeQuery(SQL);
    }

    
}
