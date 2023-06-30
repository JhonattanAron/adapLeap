package com.adaptleap.adapleapv1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "paragraph_one",updatable = false)
    private String paragraphOne;
    @Column(name = "paragraph_two",updatable = false )
    private String paragraphTwo;
    @Column(name = "footer")
    private String footer;
    @Column(name = "tittle")
    private String tittle;

    public Articles(){}

    public Articles(int id, String imgUrl, String paragraphOne, String paragraphTwo, String footer, String tittle) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.paragraphOne = paragraphOne;
        this.paragraphTwo = paragraphTwo;
        this.footer = footer;
        this.tittle = tittle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getParagraphOne() {
        return paragraphOne;
    }

    public void setParagraphOne(String paragraphOne) {
        this.paragraphOne = paragraphOne;
    }

    public String getParagraphTwo() {
        return paragraphTwo;
    }

    public void setParagraphTwo(String paragraphTwo) {
        this.paragraphTwo = paragraphTwo;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
