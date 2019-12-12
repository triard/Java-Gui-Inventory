/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author USER
 */
public class BiodataPegawai {

    String idPegawai, nama, Jabatan, gender, alamat;

    public BiodataPegawai() {
    }

    public BiodataPegawai(String idPegawai, String nama, String Jabatan, String gender, String alamat) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.Jabatan = Jabatan;
        this.gender = gender;
        this.alamat = alamat;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    @Override
    public String toString() {
        return String.format(
                "idPegawai :" + this.idPegawai + "\n"
                + "Nama :" + this.nama + "\n"
                + "Jabatan :" + this.Jabatan + "\n"
                + "Gender :" + this.gender + "\n"
                + "Alamat :" + this.alamat + "\n"
        );
    }

}
