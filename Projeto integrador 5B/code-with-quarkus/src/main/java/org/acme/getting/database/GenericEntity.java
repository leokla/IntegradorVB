package org.acme.getting.database;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class GenericEntity implements Serializable{


    private static final long serialVersionUID = 1L;
    private Long id;
    private int version;
    private Date created = new Date();
    private Date finished = new Date();
    private int lock = 0;
    private String additionalContent = null;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqEntities")
    @SequenceGenerator(name = "seqEntities", sequenceName = "seqEntities", allocationSize = 1, initialValue = 1)
    public Long getId() {
        return this.id;
    }
    protected void setId(Long id) {
        this.id = id;
    }


    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreated() {
        return this.created;
    }
    protected void setCreated(Date created) {
        this.created = created;
    }


    @Version
    public int getVersion() {
        return this.version;
    }
    protected void setVersion(int version) {
        this.version = version;
    }

    @Column(name="entity_lock")
    public int getLock() {
        return this.lock;
    }


    public void setLock(int lock) {
        this.lock = lock;
    }
    @Transient
    public boolean isLocked() {
        return lock != 0;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getFinished() {
        return this.finished;
    }
    protected void setFinished(Date finished) {
        this.finished = finished;
    }

    @PrePersist
    @PreUpdate
    protected void updateModifiedDate() {
        finished = new Date();
    }

    public String getAdditionalContent() {
        return this.additionalContent;
    }
    public void setAdditionalContent(String additionalContent) {
        this.additionalContent = additionalContent;
    }

}
