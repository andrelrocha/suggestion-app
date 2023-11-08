
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
    @ManyToOne
    @JoinColumn(name="fk_suggestion", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Suggestion suggestion;


    /**
    * @generated
    */
    @OneToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private User user;


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
    * Obtém suggestion
    * return suggestion
    * @generated
    */
    public Suggestion getSuggestion() {
        return this.suggestion;
    }

    /**
    * Define suggestion
    * @param suggestion suggestion
    * @generated
    */
    public Comment setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
        return this;
    }
    /**
    * Obtém user
    * return user
    * @generated
    */
    public User getUser() {
        return this.user;
    }

    /**
    * Define user
    * @param user user
    * @generated
    */
    public Comment setUser(User user) {
        this.user = user;
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