/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class BiodataTabelModel extends AbstractTableModel {

    private BiodataPegawai[] data;
    private String[] namaKolom;

    public BiodataTabelModel(BiodataPegawai[] data) {
        this.data = data;
        this.namaKolom = new String[]{
            "Id Pekerja",
            "Nama",
            "Jabatan",
            "Gender",
            "Alamat",
        };
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data[rowIndex].getIdPegawai();
            case 1:
                return data[rowIndex].getNama();
            case 2:
                return data[rowIndex].getJabatan();
            case 3:
                return data[rowIndex].getGender();
            case 4:
                return data[rowIndex].getAlamat();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex <= 5) {
            return String.class;
        } else {
            return Boolean.class;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return namaKolom[column];
    }
}
