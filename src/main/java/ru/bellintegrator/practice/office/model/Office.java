package ru.bellintegrator.practice.office.model;

import org.hibernate.annotations.Type;
import ru.bellintegrator.practice.employee.model.Employee;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Оффис
 */
@Entity
@Table(name = "Office")
public class Office {
    /**
     * Идентификатор оффиса
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Адрес оффиса
     */
    @Column(name = "address", length = 50)
    private String address;

    /**
     * Наименование оффиса
     */
    @Column(name = "name")
    private String name;

    /**
     * Телефон оффиса
     */
    @Column(name = "phone", length = 16)
    private String phone;

    /**
     * Статус активности оффиса
     */
    @Type(type = "true_false")
    @NotNull(message = "NOT_NULL")
    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    /**
     * Идентификатор организации
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * Список пользователей оффиса
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    /**
     * Конструктор для hibernate
     */
    public Office() {
    }

    public Office(String address, String name, String phone, Boolean isActive) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Employee> getOffices() {
        return employees;
    }

    public void setOffices(Set<Employee> offices) {
        this.employees = offices;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
