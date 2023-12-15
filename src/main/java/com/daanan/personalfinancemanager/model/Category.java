package com.daanan.personalfinancemanager.model;


import com.daanan.personalfinancemanager.util.CategoryType;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CategoryType type;

    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "icon")
    private String icon;

    // CONSTRUCTORS

    public Category( ) {

    }
    public Category(User user, String name, CategoryType type) {
        this.user = user;
        this.name = name;
        this.type = type;
    }

    public Category(User user, String name, CategoryType type, String colorCode, String icon) {
        this.user = user;
        this.name = name;
        this.type = type;
        this.colorCode = colorCode;
        this.icon = icon;
    }




    // GETTERS AND SETTERS

    public Long getCategoryId( ) {

        return categoryId;
    }

    public void setCategoryId(Long categoryId) {

        this.categoryId = categoryId;
    }

    public User getUser( ) {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public String getName( ) {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public CategoryType getType( ) {

        return type;
    }

    public void setType(CategoryType type) {

        this.type = type;
    }

    public String getColorCode( ) {

        return colorCode;
    }

    public void setColorCode(String colorCode) {

        this.colorCode = colorCode;
    }

    public String getIcon( ) {

        return icon;
    }

    public void setIcon(String icon) {

        this.icon = icon;
    }
}

