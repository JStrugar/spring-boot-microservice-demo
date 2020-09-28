package com.example.demo.models;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class DataPojo {
    public DataPojo() {
    }

    @Id
    @Column
    @org.springframework.data.annotation.Id
    private int id;

    @Lob
    @Column
    private byte[] leftData;

    @Lob
    @Column
    private byte[] rightData;

    public DataPojo(int id, byte[] left, byte[] right) {
        this.id = id;
        this.leftData = left;
        this.rightData = right;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getLeftData() {
        return leftData;
    }

    public void setLeftData(byte[] left) {
        this.leftData = left;
    }

    public byte[] getRightData() {
        return rightData;
    }

    public void setRightData(byte[] right) {
        this.rightData = right;
    }
}
