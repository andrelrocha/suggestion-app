
package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;


/**
* Classe que representa a tabela COMMENT
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"COMMENT\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Comment")
public class Comment implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @Column(name = "fk_suggestion", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String suggestionId;


    /**
    * @generated
    */
    @Column(name = "fk_userId", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String userId;


    /**
    * @generated
    */
    @Column(name = "text", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String text;


    /**
    * @generated
    */
    @Column(name = "username", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String username;


    /**
    * Construtor
    * @generated
    */
    public Comment(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Comment setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém suggestionId
    * return suggestionId
    * @generated
    */
    public java.lang.String getSuggestionId() {
        return this.suggestionId;
    }

    /**
    * Define suggestionId
    * @param suggestionId suggestionId
    * @generated
    */
    public Comment setSuggestionId(java.lang.String suggestionId) {
        this.suggestionId = suggestionId;
        return this;
    }
    /**
    * Obtém userId
    * return userId
    * @generated
    */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
    * Define userId
    * @param userId userId
    * @generated
    */
    public Comment setUserId(java.lang.String userId) {
        this.userId = userId;
        return this;
    }
    /**
    * Obtém text
    * return text
    * @generated
    */
    public java.lang.String getText() {
        return this.text;
    }

    /**
    * Define text
    * @param text text
    * @generated
    */
    public Comment setText(java.lang.String text) {
        this.text = text;
        return this;
    }
    /**
    * Obtém username
    * return username
    * @generated
    */
    public java.lang.String getUsername() {
        return this.username;
    }

    /**
    * Define username
    * @param username username
    * @generated
    */
    public Comment setUsername(java.lang.String username) {
        this.username = username;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Comment object = (Comment)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}