/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class BarangOut {
    private int idBarangout;
    private Barang barang = new Barang();
    private String tanggal;
    private int qty;

    public BarangOut() {
    }

    public BarangOut(String tanggal, int qty) {
        this.tanggal = tanggal;
        this.qty = qty;
    }

    public int getIdBarangout() {
        return idBarangout;
    }

    public void setIdBarangout(int idBarangout) {
        this.idBarangout = idBarangout;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }



  
    
    public BarangOut getById(int id){
        BarangOut barangOut = new BarangOut();
        ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_barangout AS id_barangout, "
                + "b.qty AS qty, "
                + "b.tanggal AS tanggal, "
                + "k.id_item AS id_item, "
                + "k.item_name AS item_name "
                + "FROM barangout b "
                + "LEFT JOIN barang k ON b.id_item = k.id_item "
                + "WHERE b.id_barangout= '"+id+"'");
        try {
            while (resultSet.next()) {
                barangOut = new BarangOut();
                barangOut.setIdBarangout(resultSet.getInt("id_barangout"));
                barangOut.getBarang().setIdBarang(resultSet.getInt("id_item"));
                barangOut.getBarang().setItem_name(resultSet.getString("item_name"));
                barangOut.setQty(resultSet.getInt("qty"));
                barangOut.setTanggal(resultSet.getString("tanggal"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  barangOut;
    }
    public ArrayList<BarangOut> getAll(){
        ArrayList<BarangOut> listBarangs = new ArrayList();
        ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_barangout AS id_barangout, "
                + "b.qty AS qty, "
                + "b.tanggal AS tanggal, "
                + "k.id_item AS id_item, "
                + "k.item_name AS item_name "
                + "FROM barangout b "
                + "LEFT JOIN barang k ON b.id_item = k.id_item ");
        try {
            while (resultSet.next()) {
                BarangOut barangOut = new BarangOut();
                 barangOut.setIdBarangout(resultSet.getInt("id_barangout"));
                barangOut.getBarang().setIdBarang(resultSet.getInt("id_item"));
                barangOut.getBarang().setItem_name(resultSet.getString("item_name"));
                barangOut.setQty(resultSet.getInt("qty"));
                barangOut.setTanggal(resultSet.getString("tanggal"));
                
                listBarangs.add(barangOut);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  listBarangs;
    }
public ArrayList<BarangOut> search(String keyword){
    ArrayList<BarangOut> listBarangs = new ArrayList();
    ResultSet resultSet = DBHelper.selectQuery("SELECT "
                + "b.id_barangout AS id_barangout, "
                + "b.qty AS qty, "
                + "b.tanggal AS tanggal, "
                + "k.id_item AS id_item, "
                + "k.item_name AS item_name "
                + "FROM barangout b "
                + "LEFT JOIN barang k ON b.id_item = k.id_item "
                + "WHERE b.qty LIKE '%"+keyword+"%' "
            + "OR b.tanggal LIKE '%" +keyword+"%' "
    );
    try {
            while (resultSet.next()) {
                BarangOut barangOut = new BarangOut();
                 barangOut.setIdBarangout(resultSet.getInt("id_barangout"));
                barangOut.getBarang().setIdBarang(resultSet.getInt("id_item"));
                barangOut.getBarang().setItem_name(resultSet.getString("item_name"));
                barangOut.setQty(resultSet.getInt("qty"));
                barangOut.setTanggal(resultSet.getString("tanggal"));
                
                listBarangs.add(barangOut);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  listBarangs;
}

 public ArrayList<BarangOut> searchBarang(String keyword) {
        ArrayList<BarangOut> ListBarangOuts = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "b.id_item as id_item, "
                + "b.item_name as item_name  "
                + "FROM barang b "
                + "WHERE b.id_item LIKE '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                BarangOut pem = new BarangOut();
                pem.getBarang().setIdBarang(rs.getInt("id_item"));
                pem.getBarang().setItem_name(rs.getString("item_name"));
                ListBarangOuts.add(pem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBarangOuts;
    }

    public void save() {
        if (getById(idBarangout).getIdBarangout()== 0) {
            String SQL = "INSERT INTO barangout (id_item,qty,tanggal) VALUES( "
                    + " '" + this.getBarang().getIdBarang()+ "', "
                    + " '" + this.qty + "', "
                    + " '" + this.tanggal + "'"
                    + " )";
            this.idBarangout = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE barangout SET"
                    + " id_item= '" + this.getBarang().getIdBarang()+ "',"
                    + " qty = '" + this.qty + "',"
                    + " tanggal = '" + this.tanggal + "'"
                    + " WHERE id_barangout = '" + this.idBarangout + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM barangout WHERE id_barangout = '" + this.idBarangout + "'";
        DBHelper.executeQuery(SQL);
    }
}
