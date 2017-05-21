package com.jersey.representations;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @Column(name = "address")
    @NotNull
    private String address;

//    @Column(name = "photo_path")
//    @NotNull
//    private String photoPath;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "is_photo_public")
    @NotNull
    private boolean isPhotoPublic;

    @JoinColumn(name = "login_id")
    @NotNull
    private Long login_id;

    @JoinColumn(name = "cook_id")
    private Long cook_id;

    @JoinColumn(name = "customer_id")
    private Long customer_id;

    public Person() {
    }

    public Person(Long id, String email, String firstName, String lastName,
                String phoneNumber, String address, String description,
                boolean isPhotoPublic) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
//        this.photoPath = photoPath;
        this.description = description;
        this.isPhotoPublic = isPhotoPublic;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public String getPhotoPath() {
//        return photoPath;
//    }
//
//    public void setPhotoPath(String photoPath) {
//        this.photoPath = photoPath;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsPhotoPublic() {
        return isPhotoPublic;
    }

    public void setIsPhotoPublic(boolean isPhotoPublic) {
        this.isPhotoPublic = isPhotoPublic;
    }

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public Long getCook_id() {
        return cook_id;
    }

    public void setCook_id(Long cook_id) {
        this.cook_id = cook_id;
    }

    public boolean isPhotoPublic() {
        return isPhotoPublic;
    }

    public void setPhotoPublic(boolean photoPublic) {
        isPhotoPublic = photoPublic;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
