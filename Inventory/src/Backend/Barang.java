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
public class Barang{
    private int idBarang;
    private Category category = new Category();
    private String item_name;
    private int qty, price;

    public Barang() {
    }

    public Barang(int idBarang, String item_name, int qty, int price) {
        this.idBarang = idBarang;
        this.item_name = item_name;
        this.qty = qty;
        this.price = price;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBuku) {
        this.idBarang = idBuku;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @param id
     * @return
     */
    public Barang getById(int id){
        Barang barang = new Barang();
        ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_item AS id_item, "
                + "b.item_name AS item_name, "
                + "b.qty AS qty, "
                + "b.price AS price, "
                + "k.idkategori AS idkategori, "
                + "k.nama AS nama, "
                + "k.keterangan AS keterangan "
                + "FROM barang b "
                + "LEFT JOIN kategory k ON b.idkategori = k.idkategori "
                + "WHERE b.id_item= '"+id+"'");
        try {
            while (resultSet.next()) {
                barang = new Barang();
                barang.setIdBarang(resultSet.getInt("id_item"));
                barang.getCategory().setIdkategori(resultSet.getInt("idkategori"));
                barang.getCategory().setNama(resultSet.getString("nama"));
                barang.getCategory().setKeterangan(resultSet.getString("keterangan"));
                barang.setItem_name(resultSet.getString("item_name"));
                barang.setQty(resultSet.getInt("qty"));
                barang.setPrice(resultSet.getInt("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  barang;
    }
    public ArrayList<Barang> getAll(){
        ArrayList<Barang> listBarangs = new ArrayList();
        ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_item AS id_item, "
                + "b.item_name AS item_name, "
                + "b.qty AS qty, "
                + "b.price AS price, "
                + "k.idkategori AS idkategori, "
                + "k.nama AS nama, "
                + "k.keterangan AS keterangan "
                + "FROM barang b "
                + "LEFT JOIN kategory k ON b.idkategori = k.idkategori ");
        try {
            while (resultSet.next()) {
                Barang barang = new Barang();
                barang.setIdBarang(resultSet.getInt("id_item"));
                barang.getCategory().setIdkategori(resultSet.getInt("idkategori"));
                barang.getCategory().setNama(resultSet.getString("nama"));
                barang.getCategory().setKeterangan(resultSet.getString("keterangan"));
                barang.setItem_name(resultSet.getString("item_name"));
                barang.setQty(resultSet.getInt("qty"));
                barang.setPrice(resultSet.getInt("price"));
                
                listBarangs.add(barang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  listBarangs;
    }
public ArrayList<Barang> search(String keyword){
    ArrayList<Barang> listBarangs = new ArrayList();
    ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_item AS id_item, "
                + "b.item_name AS item_name, "
                + "b.qty AS qty, "
                + "b.price AS price, "                
                + "k.idkategori AS idkategori, "
                + "k.nama AS nama, "
                + "k.keterangan AS keterangan "
                + "FROM barang b "
                + "LEFT JOIN kategory k ON b.idkategori = k.idkategori "
                + "WHERE b.item_name LIKE '%"+keyword+"%' "
                + "OR b.qty LIKE '%" +keyword+"%' "
                +" OR b.price LIKE '%"+keyword+"%' "
    );
    try {
            while (resultSet.next()) {
                Barang barang = new Barang();
                barang.setIdBarang(resultSet.getInt("id_item"));
                barang.getCategory().setIdkategori(resultSet.getInt("idkategori"));
                barang.getCategory().setNama(resultSet.getString("nama"));
                barang.getCategory().setKeterangan(resultSet.getString("keterangan"));
                barang.setItem_name(resultSet.getString("item_name"));
                barang.setQty(resultSet.getInt("qty"));
                barang.setPrice(resultSet.getInt("price"));                
                listBarangs.add(barang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  listBarangs;
}

    public void save() {
        if (getById(idBarang).getIdBarang()== 0) {
            String SQL = "INSERT INTO barang (idkategori,item_name,qty,price) VALUES( "
                    + " '" + this.getCategory().getIdkategori() + "', "
                    + " '" + this.item_name + "', "
                    + " '" + this.qty + "', "
                    + " '" + this.price + "'"
                    + " )";
            this.idBarang = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE barang SET"
                    + " idkategori= '" + this.getCategory().getIdkategori() + "',"
                     + " item_name = '" + this.item_name + "',"
                    + " qty = '" + this.qty + "',"
                    + " price = '" + this.price + "'"
                    + " WHERE id_item = '" + this.idBarang + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM barang WHERE id_item = '" + this.idBarang + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String toString(){
        return item_name;
    }
    

}
