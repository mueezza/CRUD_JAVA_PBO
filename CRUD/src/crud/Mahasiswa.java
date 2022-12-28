/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author abida
 */

import java.sql.*;
import static crud.DatabaseUtil.*;


public class Mahasiswa {

    
      
    String nim;
    String nama;
    String jenis_kelamin;
    String jurusan;
        
    Mahasiswa(String paramNim , String paramNama, String paramJenisKelamin , String paramJurusan){
        this.nim = paramNim;
        this.nama = paramNama;
        this.jenis_kelamin = paramJenisKelamin;
        this.jurusan = paramJurusan;
    }
    public static ResultSet getData(){
     try {
       String sql = "SELECT * FROM mahasiswa";
       ResultSet rs = stmt.executeQuery(sql);
       return rs;
     } catch (SQLException e) {
       System.out.println("Gagal get data: "+e.getMessage());
     }
     return null;
}
    
    
    public static void showData(){
      try {
          ResultSet rs = getData();
              while(rs.next()) {
              System.out.println("NIM: " + rs.getString("nim"));
              System.out.println("Nama: " + rs.getString("nama"));
              System.out.println("Jenis Kelamin: " + rs.getString("jenis_kelamin"));
              System.out.println("Jurusan: " + rs.getString("jurusan"));
              System.out.println("----------------------------");
          }
      } catch (SQLException e) {
         System.out.println("Eror show data: "+e.getMessage());
      }
}
    
    public static void insertData(Mahasiswa object){
    try {
        String sql = "INSERT INTO mahasiswa VALUE('%s', '%s','%s', '%s')";
        sql = String.format (sql, object.nim, object.nama, object.jenis_kelamin ,object.jurusan);
        stmt.execute(sql);
        System.out.println("Sukses insert data");
    } catch (SQLException e) {
        System.out.println("Eror insert data: "+e.getMessage());
    }
}
 
    public static void updateData(String selected_nim, Mahasiswa object){
    try {
        String sql = "UPDATE mahasiswa SET nim = '%s', nama = '%s', jenis_kelamin = '%s', jurusan = '%s' WHERE nim = '%s'";
        sql = String.format(sql, object.nim, object.nama, object.jenis_kelamin, object.jurusan, selected_nim);
        stmt.execute(sql);
        System.out.println("Sukses update data");
    } catch (SQLException e) {
        System.out.println("Eror update data: "+e.getMessage());
    }
}
    public static void deleteData(String selected_nim){
    try {
        String sql = "DELETE FROM mahasiswa WHERE nim = '%s'";
        sql = String.format(sql, selected_nim);
        stmt.execute(sql);
        System.out.println("Sukses delete data");
    } catch (SQLException e) {
        System.out.println("Eror insert data: "+e.getMessage());
    }
}
}
