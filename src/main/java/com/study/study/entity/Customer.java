package com.study.study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private Gender gender;

  @NotNull
  private String phone;

  @NotNull
  private String address;

  private String visitPath;

  private String photoUrl;

  private String memo;

  @NotNull
  private LocalDate birthDate;

  @NotNull
  private CustomerStatus status;

  @Builder
  public Customer(String name, Gender gender, String phone, String address, String visitPath,
      String photoUrl, String memo, LocalDate birthDate) {
    this.name = name;
    this.gender = gender;
    this.phone = phone;
    this.address = address;
    this.visitPath = visitPath;
    this.photoUrl = photoUrl;
    this.memo = memo;
    this.birthDate = birthDate;
    this.status = CustomerStatus.ACTIVE;
  }


}
