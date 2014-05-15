package com.example.model;

import com.example.Constants;
import org.apache.commons.codec.binary.Base64;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dkazakov on 22.04.2014.
 */
@Entity
@Table(name = "clients", schema = "", catalog = "mydb")
@NamedQuery(name = "findUserByLogin",
        query = "select c from Client c where c.login = :login ")
public class Client implements HospitalityEntity {

    private int id;
    private String login;
    private String password;

    @Id
    @Column(name = "id_client")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean checkPassword(String password) {
        return this.password.equals(hashPassword(password));
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(Constants.UTF_8));
            String str = Base64.encodeBase64String(hashBytes);//Base64.encodeAsString(hashBytes);
            return str;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean empty() {
        return login == null;
    }

}
