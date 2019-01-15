package main;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Podaci implements Serializable {

    private int id;
    private String ime;
    private int broj_godina;
    private String adresa;
    private int visina_dohotka;

    public Podaci(String ime, int broj_godina, String adresa, int visina_dohotka) {
        this.ime = ime;
        this.broj_godina = broj_godina;
        this.adresa = adresa;
        this.visina_dohotka = visina_dohotka;
    }

    Podaci() {
        }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public int getBrojGodina() {
        return broj_godina;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getVisinaDohotka() {
        return visina_dohotka;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setBrojGodina(int broj_godina) {
        this.broj_godina = broj_godina;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setVisinaDohotka(int visina_dohotka) {
        this.visina_dohotka = visina_dohotka;
    }

    @Override
    public String toString() {
        return id + ";" + ime + ";" + broj_godina + ";" + adresa + ";" + visina_dohotka;
    }
     public static List<Podaci> List() throws SQLException {
        Connection conn = DbConnector.getConnection();
        List<Podaci> ls = new ArrayList<Podaci>();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select * from podaci");
        while (rs.next()) {
            Podaci p = new Podaci();
            p.setId(rs.getInt(1));
            p.ime = rs.getString(2);
            p.broj_godina = rs.getInt(3);
            p.adresa = rs.getString(4);
            p.visina_dohotka = rs.getInt(5);
            ls.add(p);
        }
        return ls;
    }
 public void Add() throws SQLException {
        Connection conn = DbConnector.getConnection();
        PreparedStatement st = conn.prepareStatement("insert into podaci (ime,broj_godina,adresa,visina_dohotka) values(?,?,?,?)");
        st.setString(1, getIme());
        st.setInt(2, getBrojGodina());
        st.setString(3, getAdresa());
        st.setInt(4, getVisinaDohotka());
        st.executeUpdate();
    }
 public static List<Podaci> Search(String query) throws SQLException {
        Connection conn = DbConnector.getConnection();
        List<Podaci> ls = new ArrayList<Podaci>();
        PreparedStatement st = conn.prepareStatement("select * from podaci where ime =?");
        st.setString(1, query);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Podaci p = new Podaci();
            p.setId(rs.getInt(1));
            p.ime = rs.getString(2);
            p.broj_godina = rs.getInt(3);
            p.adresa = rs.getString(4);
            p.visina_dohotka= rs.getInt(5);
            ls.add(p);
        }
        return ls;
    }
 public void UpdateAdresa() throws SQLException {
        Connection conn = DbConnector.getConnection();
        PreparedStatement st = conn.prepareStatement("update podaci set adresa=? where  podaci_id=?");
        st.setString(1, getAdresa());
        st.setInt(2, id);
        st.executeUpdate();
    }
 public void UpdateVisinaDohotka() throws SQLException {
        Connection conn = DbConnector.getConnection();
        PreparedStatement st = conn.prepareStatement("update podaci set visina_dohotka=? where  podaci_id=?");
        st.setInt(1, getVisinaDohotka());
        st.setInt(2, id);
        st.executeUpdate();
    }
 public void Delete() throws SQLException {
        Connection conn = DbConnector.getConnection();
        PreparedStatement st = conn.prepareStatement("delete from podaci where podaci_id=?");
        st.setInt(1, id);
        st.executeUpdate();
    }
}