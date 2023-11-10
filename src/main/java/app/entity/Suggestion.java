
package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;
    import cronapi.CronapiSearchable;


/**
* Classe que representa a tabela SUGGESTION
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"SUGGESTION\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Suggestion")
public class Suggestion implements Serializable {
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
    @Column(name = "suggestionName", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String suggestionName;


    /**
    * @generated
    */
    @Column(name = "text", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String text;


    /**
    * @generated
    */
    @Column(name = "genre", nullable = false, unique = false, insertable=true, updatable=true)
    @CronapiSearchable
        
        private java.lang.String genre;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateTime", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.util.Date dateTime = Calendar.getInstance().getTime();


    /**
    * @generated
    */
    @Column(name = "fk_user", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String userId;


    /**
    * @generated
    */
    @Column(name = "username", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String username;


    /**
    * Construtor
    * @generated
    */
    public Suggestion(){
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
    public Suggestion setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém suggestionName
    * return suggestionName
    * @generated
    */
    public java.lang.String getSuggestionName() {
        return this.suggestionName;
    }

    /**
    * Define suggestionName
    * @param suggestionName suggestionName
    * @generated
    */
    public Suggestion setSuggestionName(java.lang.String suggestionName) {
        this.suggestionName = suggestionName;
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
    public Suggestion setText(java.lang.String text) {
        this.text = text;
        return this;
    }
    /**
    * Obtém genre
    * return genre
    * @generated
    */
    public java.lang.String getGenre() {
        return this.genre;
    }

    /**
    * Define genre
    * @param genre genre
    * @generated
    */
    public Suggestion setGenre(java.lang.String genre) {
        this.genre = genre;
        return this;
    }
    /**
    * Obtém dateTime
    * return dateTime
    * @generated
    */
    public java.util.Date getDateTime() {
        return this.dateTime;
    }

    /**
    * Define dateTime
    * @param dateTime dateTime
    * @generated
    */
    public Suggestion setDateTime(java.util.Date dateTime) {
        this.dateTime = dateTime;
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
    public Suggestion setUserId(java.lang.String userId) {
        this.userId = userId;
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
    public Suggestion setUsername(java.lang.String username) {
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
Suggestion object = (Suggestion)obj;
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